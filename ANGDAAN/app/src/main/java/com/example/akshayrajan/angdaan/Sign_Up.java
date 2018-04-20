package com.example.akshayrajan.angdaan;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Sign_Up extends Activity implements View.OnClickListener {

    private Button mbutton = null;
    private EditText email;
    private EditText password;
    private TextView placement;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);



            firebaseAuth = FirebaseAuth.getInstance();
            mbutton = (Button) findViewById(R.id.signup);
            email = (EditText) findViewById(R.id.editTextEmail);
            password = (EditText) findViewById(R.id.pass_edit_text);

            progressDialog = new ProgressDialog(this);

            mbutton.setOnClickListener(this);
        }

    private void userlogin() {
        String Email = email.getText().toString().trim();
        String Password = password.getText().toString().trim();

        if (TextUtils.isEmpty(Email)) {
            //email is empty
            Toast.makeText(this, "Please enter Email", Toast.LENGTH_SHORT).show();
            //stop the function from executing further
            return;
        }

        if (TextUtils.isEmpty(Password)) {
            //password is empty
            Toast.makeText(this, "Please enter Password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Signing In....");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(Email, Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            //start timelneActivity
                            finish();
                            startActivity(new Intent(getApplicationContext(), screen3.class));
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if (view == mbutton) {
            userlogin();
        }
    }
}

