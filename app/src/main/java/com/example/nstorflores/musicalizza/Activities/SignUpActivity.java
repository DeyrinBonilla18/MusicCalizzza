package com.example.nstorflores.musicalizza.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nstorflores.musicalizza.Api.Api;
import com.example.nstorflores.musicalizza.MainActivity;
import com.example.nstorflores.musicalizza.R;
import com.example.nstorflores.musicalizza.models.AccessToken;
import com.example.nstorflores.musicalizza.models.User;
import com.tumblr.remember.Remember;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initViews();
    }

    private EditText email;
    private EditText password;
    private Button signUp;



    private void initViews() {
        email =  findViewById(R.id.email);
        password =  findViewById(R.id.password);
        signUp =  findViewById(R.id.sign_up);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
            }
        });

    }



    /**
     * Esto sirve para iniar sesion.
     */

    /**
     * To make http request
     * @param email
     * @param password
     */
    private void loginRequest(String email, String password) {
        // instance a user
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        // create call
        Call<AccessToken> call = Api.instance().login(user);
        call.enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                if (response.body() != null) {
                    Log.i("access_token", response.body().getId());
                    Remember.putString("access_token", response.body().getId(), new Remember.Callback() {
                        @Override
                        public void apply(Boolean success) {
                            if (success) {
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {

            }
        });
    }


    private void signUp() {

        if (email.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Necesito un email", Toast.LENGTH_LONG).show();
        } else if(password.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Necesito la contraseña chatel", Toast.LENGTH_LONG).show();
        } else {
            // instance a user
            User user = new User();
            user.setEmail(email.getText().toString());
            user.setPassword(password.getText().toString());

            // create call
            Call<User> call = Api.instance().signUp(user);
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if (response.body() != null) {
                        loginRequest(email.getText().toString(), password.getText().toString());
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {

                }
            });
        }
    }

}
