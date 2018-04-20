package com.example.akshayrajan.angdaan;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mtextView = null;
    private Button mbutton,sosbutton = null;
    private EditText mEmail = null;
    private EditText mPassword = null;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        mEmail = (EditText) findViewById(R.id.emailenter);
        mPassword = (EditText) findViewById(R.id.editTextpassword);

        mtextView = (TextView) findViewById(R.id.alreadyhaveanaccount);
        mbutton = (Button) findViewById(R.id.Registerbutton);
        sosbutton = (Button) findViewById(R.id.sos);
        mEmail = (EditText) findViewById(R.id.emailenter);
        mPassword = (EditText) findViewById(R.id.editTextpassword);


        mtextView.setOnClickListener(this);
        mbutton.setOnClickListener(this);
        sosbutton.setOnClickListener(this);

    }

    private void registerUser(){
        String EmailId = mEmail.getText().toString().trim();
        String PasswordId = mPassword.getText().toString().trim();

        if (TextUtils.isEmpty(EmailId)){
            //email is empty
            Toast.makeText(this,"Please enter Email",Toast.LENGTH_SHORT).show();
            //stop the function from executing further
            return;
        }

        if (TextUtils.isEmpty(PasswordId)){
            //password is empty
            Toast.makeText(this,"Please enter Password",Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registering User....");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(EmailId,PasswordId)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();


                        if (task.isSuccessful()){
                            //user is succesfully registered
                            Toast.makeText(MainActivity.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(getApplicationContext(), screen3.class));


                        }else{
                            Toast.makeText(MainActivity.this,"Could't register!Please try again ",Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }


    @Override
    public void onClick(View view) {
        if(view == mtextView){
            startActivity(new Intent(this, Sign_Up.class));
        }

        if(view == mbutton){
            //will open loginActivity
            registerUser();
        }

        if(view == sosbutton){
            startActivity(new Intent(getApplicationContext(), immediateSearch.class));
        }
    }
}

