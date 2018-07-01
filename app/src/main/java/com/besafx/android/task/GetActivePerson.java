package com.besafx.android.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.besafx.android.LoginActivity;
import com.besafx.android.R;
import com.besafx.android.entity.Person;

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

public class GetActivePerson extends AsyncTask<Void, Void, Person> {

    private static final String TAG = LoginActivity.class.getSimpleName();

    private ProgressDialog progressDialog = null;

    private Context context;

    private String email, password;

    private OnAction onAction;

    public GetActivePerson(Context context, String email, String password, OnAction onAction) {
        this.context = context;
        this.email = email;
        this.password = password;
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
    protected Person doInBackground(Void... voids) {
        final String url = context.getString(R.string.rest_url) + "/api/person/findActivePerson";

        // Populate the HTTP Basic Authentication header with the username and password
        HttpAuthentication authHeader = new HttpBasicAuthentication(email, password);
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAuthorization(authHeader);
        requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // Create a new RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        try {
            // Make the network request
            ResponseEntity<Person> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(requestHeaders), Person.class);
            return response.getBody();
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage(), e);
            return null;
        }
    }

    @Override
    protected void onPostExecute(Person person) {
        if (person == null) {
            onAction.onGetFailed();
        } else {
            onAction.onGetSuccess(person, email, password);
        }
        progressDialog.dismiss();
    }

    public interface OnAction {
        void onGetSuccess(Person person, String email, String password);

        void onGetFailed();
    }
}
