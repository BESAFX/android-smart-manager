package com.besafx.android.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import com.besafx.android.LoginActivity;
import com.besafx.android.R;
import com.besafx.android.entity.Region;

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

public class PostRegion extends AsyncTask<Void, Void, Region> {

    private static final String TAG = LoginActivity.class.getSimpleName();

    private ProgressDialog progressDialog = null;

    private Context context;

    private Region region;

    private OnAction onAction;

    public PostRegion(Context context, Region region, OnAction onAction) {
        this.context = context;
        this.region = region;
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
    protected Region doInBackground(Void... voids) {
        final String url = context.getString(R.string.rest_url) + "/api/region/create";

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
            ResponseEntity<Region> response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(this.region, requestHeaders), Region.class);
            return response.getBody();
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage(), e);
            return null;
        }
    }

    @Override
    protected void onPostExecute(Region region) {
        if (region == null) {
            onAction.onGetFailed();
        } else {
            onAction.onGetSuccess(region);
        }
        progressDialog.dismiss();
    }

    public interface OnAction {
        void onGetSuccess(Region region);

        void onGetFailed();
    }
}
