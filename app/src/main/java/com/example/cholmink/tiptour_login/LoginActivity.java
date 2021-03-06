package com.example.cholmink.tiptour_login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cholmink.tiptour_login.data.Content;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by sukyami on 16. 1. 12..
 */
public class LoginActivity extends AppCompatActivity {


    private EditText inputEmail;
    private Button btnLogin;
    private Button btnLinkfacebook;
    private Button btnLinkToRegisterScreen;
    private EditText inputPassword;
    private ProgressDialog pDialog;
    private TextView inputEmail_temp;
    private TextView inputPassword_temp;
    String emailaddress;
    String password;
    private NetworkService networkService;

    ApplicationController app;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        networkService = ApplicationController.getInstance().getNetworkService();

        app= (ApplicationController)getApplicationContext();

        inputEmail = (EditText) findViewById(R.id.email_input);
        inputPassword = (EditText) findViewById(R.id.password_input);
        btnLogin = (Button) findViewById(R.id.login_join_member_btn);
        btnLinkfacebook = (Button) findViewById(R.id.fackbook_btn);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);




        sendData();




//        btnLinkfacebook.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View view) {
//                Intent i = new Intent(getApplicationContext(),
//                        FacebookActivity.class);
//                startActivity(i);
//                finish();
//            }
//        });

    }


    /**
     * function to verify login details in mysql db
     * */




    private void sendData() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                emailaddress = inputEmail.getText().toString();
                password = inputPassword.getText().toString().trim();

                Content loggingin = new Content();
                Log.e("sangik", emailaddress + "  " + password);
                loggingin.setName(emailaddress);
                loggingin.setPassword(password);



                Call<Content> loginCall = networkService.newThumbnail(loggingin);
                loginCall.enqueue(new Callback<Content>() {
                    @Override
                    public void onResponse(Call<Content> call, Response<Content> response) {
                        if (response.isSuccessful()) {

                            Toast.makeText(LoginActivity.this, "로그인 성공!", Toast.LENGTH_SHORT).show();
                            Content tempContent = response.body();

                            app.user_id = tempContent.user_idx;


                            Log.i("MyTag", "유저아이디 제데로 넘어왓나요: " + app.user_id + "  ");
                            Intent i = new Intent(getApplicationContext(),
                                    MainActivity.class);
                            startActivity(i);
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "로그인 실패.. 아이디와 비밀번호를 다시 확인해 주세요", Toast.LENGTH_SHORT).show();
                            int statusCode = response.code();
                            Log.i("MyTag", "응답코드 : " + statusCode);

                        }
                    }

                    @Override
                    public void onFailure(Call<Content> call, Throwable t) {

                    }
                });
            }

        });


    }
}
