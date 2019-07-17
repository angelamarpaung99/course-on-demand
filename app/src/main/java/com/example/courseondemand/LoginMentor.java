package com.example.courseondemand;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.courseondemand.home_fragment_list.ListScheduleModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.makeText;


public class LoginMentor extends AppCompatActivity implements View.OnClickListener {

    //defining firebase object
    private FirebaseAuth firebaseAuth;

    private EditText txtEmail;
    private EditText txtPassword;
    private Button btnLogin;

    private ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mentor_login);

        firebaseAuth = FirebaseAuth.getInstance();


        if (firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(), HomeNotActive.class));
        }

//        final EditText txtEmail = findViewById(R.id.txtEmail);
//        final EditText txtPassword = findViewById(R.id.txtPassword);
//        final Button btnLogin = findViewById(R.id.btnLogin);
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final String email = txtEmail.getText().toString();
//                final String password = txtPassword.getText().toString();
//                if (v == btnLogin){
//                    userLogin(email,password);
//
//                }
//            }
//
//
//    });
//
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        btnLogin.setOnClickListener(this);

}

    private void userLogin() {
        String email = txtEmail.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();

        if (email.isEmpty()){
            txtEmail.setError("Email is required");
            txtEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            txtEmail.setError("Please enter a valid Email Address");
            txtEmail.requestFocus();
            return;
        }
        if (password.isEmpty()){
            txtPassword.setError("Password is required");
            txtPassword.requestFocus();
            return;
        }
        if (password.length() < 6){
            txtPassword.setError("Minimum length of password should be 6");
            txtPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Intent intent = new Intent(LoginMentor.this, HomeNotActive.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(),task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });



//        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if (task.isSuccessful()){
//                    finish();
//                    Intent intent = new Intent(LoginMentor.this, HomeNotActive.class);
//                    startActivity(intent);
//                }
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        if (view == btnLogin){
            userLogin();
        }
    }
}