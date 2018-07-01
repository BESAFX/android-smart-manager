package com.besafx.android.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import com.besafx.android.LoginActivity;
import com.besafx.android.R;
import com.besafx.android.entity.Team;

import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class GetTeams extends AsyncTask<Void, Void, Team[]> {

    private static final String TAG = LoginActivity.class.getSimpleName();

    private ProgressDialog progressDialog = null;

    private Context context;

    private OnAction onAction;

    public GetTeams(Context context, OnAction onAction) {
        this.context = context;
        this.onAction = onAction;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setIndeterminate(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("انتظر قليلا...");
        progressDialog.show();
    }

    @Override
    protected Team[] doInBackground(Void... voids) {
        final String url = context.getString(R.string.rest_url) + "/api/team/findAll";

        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", Context.MODE_PRIVATE);

        // Populate the HTTP Basic Authentication header with the username and password
        HttpAuthentication authHeader = new HttpBasicAuthentication(sharedPreferences.getString("email", null), sharedPreferences.getString("password", null));
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAuthorization(authHeader);
        requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // Create a new RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        try {
            // Make the network request
            ResponseEntity<Team[]> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(requestHeaders), Team[].class);
            return response.getBody();
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage(), e);
            return null;
        }
    }

    @Override
    protected void onPostExecute(Team[] teams) {
        if (teams == null) {
            onAction.onGetFailed();
        } else {
            onAction.onGetSuccess(teams);
        }
        progressDialog.dismiss();
    }

    public interface OnAction {
        void onGetSuccess(Team[] teams);

        void onGetFailed();
    }
}
