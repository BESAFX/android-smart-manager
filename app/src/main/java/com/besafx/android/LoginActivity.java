package com.besafx.android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.besafx.android.entity.Company;
import com.besafx.android.entity.Person;
import com.besafx.android.entity.Task;
import com.besafx.android.task.GetActivePerson;
import com.besafx.android.task.GetCompany;
import com.besafx.android.util.Helpers;
import com.besafx.android.util.ThemeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();

    public static Person me;

    public static Company company;

    @Nullable
    @BindView(R.id.input_email)
    TextView input_email;

    @Nullable
    @BindView(R.id.input_password)
    TextView input_password;

    @Nullable
    @BindView(R.id.btn_login)
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeUtils.applyTheme(this);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        //Skip opening login screen and go to directly to home screen.
        if (sessionSaved()) {
            return;
        }
    }

    @OnClick(R.id.btn_login)
    public void login() {

        //Check connection is a live
        if (!Helpers.isInternetAvailable(getApplicationContext())) {
            Toast.makeText(this, "تأكد من اتصالك بالانترنت", Toast.LENGTH_LONG).show();
            return;
        }

        if (!validate()) {
            onLoginFailed();
            return;
        }

        btn_login.setEnabled(false);

        final String email = input_email.getText().toString();
        final String password = input_password.getText().toString();

        //Call login from web services with user data
        new GetActivePerson(this, email, password,
                new GetActivePerson.OnAction() {
                    @Override
                    public void onGetSuccess(Person person, String email, String password) {
                        onLoginSuccess(person, email, password);
                    }

                    @Override
                    public void onGetFailed() {
                        onLoginFailed();
                        Toast.makeText(getApplicationContext(), "فشلت عملية الدخول، حاول مرة أخرى", Toast.LENGTH_SHORT).show();
                    }
                }
        ).execute();
    }

    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess(Person person, String email, String password) {
        me = person;
        //Save login data
        SharedPreferences sp = getSharedPreferences("Data", MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString("email", email);
        ed.putString("password", password);
        ed.commit();

        btn_login.setEnabled(true);
        finish();

        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);

        //Get company data
        new GetCompany(LoginActivity.this, new GetCompany.OnAction() {
            @Override
            public void onGetSuccess(Company companyResponse) {
                company = companyResponse;
            }

            @Override
            public void onGetFailed() {

            }
        }).execute();

        Toast.makeText(getApplicationContext(), "تم تسجيل الدخول بنجاح", Toast.LENGTH_SHORT).show();
    }

    public void onLoginFailed() {
        btn_login.setEnabled(true);
    }

    private boolean sessionSaved() {
        //Check if login data already stored
        SharedPreferences sharedPreferences = getSharedPreferences("Data", MODE_PRIVATE);
        final String email = sharedPreferences.getString("email", null);
        final String password = sharedPreferences.getString("password", null);
        Log.d(TAG, "Check if session saved...");
        Log.d(TAG, "Email: " + sharedPreferences.getString("email", null));
        Log.d(TAG, "Password: " + sharedPreferences.getString("password", null));
        if (email != null && password != null) {
            //Call login from web services with user data
            new GetActivePerson(this, email, password,
                    new GetActivePerson.OnAction() {
                        @Override
                        public void onGetSuccess(Person person, String email, String password) {
                            onLoginSuccess(person, email, password);
                        }

                        @Override
                        public void onGetFailed() {
                            onLoginFailed();
                        }
                    }
            ).execute();
            return true;
        } else {
            return false;
        }
    }

    public boolean validate() {
        boolean valid = true;

        String email = input_email.getText().toString();
        String password = input_password.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            input_email.setError("تأكد من كتابة البريد الإلكتروني بشكل صحيح");
            valid = false;
        } else {
            input_email.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            input_password.setError("يجب أن تكون كلمة المرور من 4 إلى 10 حروف");
            valid = false;
        } else {
            input_password.setError(null);
        }

        return valid;
    }

    public void setTheme1() {
        Log.d(TAG, "Applying Theme1...");
        //Save theme to shared data
        SharedPreferences sp = getSharedPreferences("Data", MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString("theme", String.valueOf(R.style.Theme1));
        ed.commit();
        Log.d(TAG, "Applying Theme1 Done.");
    }

    public void setTheme2() {
        Log.d(TAG, "Applying Theme2...");
        //Save theme to shared data
        SharedPreferences sp = getSharedPreferences("Data", MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString("theme", String.valueOf(R.style.Theme2));
        ed.commit();
        Log.d(TAG, "Applying Theme2 Done.");
    }

    public void setTheme3() {
        Log.d(TAG, "Applying Theme3...");
        //Save theme to shared data
        SharedPreferences sp = getSharedPreferences("Data", MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString("theme", String.valueOf(R.style.Theme3));
        ed.commit();
        Log.d(TAG, "Applying Theme3 Done.");
    }
}
