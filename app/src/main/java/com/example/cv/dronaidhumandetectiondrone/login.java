package com.example.cv.dronaidhumandetectiondrone;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity implements View.OnClickListener {

    private Button login;
    private Button pro;
    private EditText edtemail,edtpassword;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, homeepage.class));
        finish();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

     /* pro = (Button) findViewById(R.id.test);
        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(login.this,profile.class);
                startActivity(i);
            }
        });*/

        android.support.v7.widget.Toolbar toolbar= (android.support.v7.widget.Toolbar) findViewById(R.id.toolbarlogin);
        toolbar.setTitle("DronAID");
        toolbar.setTitleTextColor(Color.WHITE);

        firebaseAuth=FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(), admin.class));
        }

        login=(Button)findViewById(R.id.login);
        edtemail=(EditText)findViewById(R.id.email);
        edtpassword=(EditText)findViewById(R.id.password);

        progressDialog=new ProgressDialog(this);

        login.setOnClickListener(this);

    }
    private void userlogin(){
        final String email=edtemail.getText().toString().trim();
        final String password=edtpassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please Enter Email", Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(password) || password.length() < 6){
            Toast.makeText(this, "Please Enter Password of minimum 6 characters", Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage("User Logging In");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(), admin.class));

                        }
                        else if( email.equals("systemmanager@yahoo.com") && password.equals("123456")) {
                            Intent i = new Intent(login.this, systemmanager.class);
                            startActivity(i);
                        }

                        else {

                            Toast.makeText(login.this, "Invaild Email or Password.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if (v == login) {
            userlogin();
        }

    }

}
