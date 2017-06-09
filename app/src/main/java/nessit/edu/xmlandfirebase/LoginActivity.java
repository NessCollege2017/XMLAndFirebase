package nessit.edu.xmlandfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    //Properties:
    private FirebaseAuth mAuth;

    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.etPassword)
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();
    }


    private String getEmail(){
        return etEmail.getText().toString();
    }

    private String getPassword(){
        return etPassword.getText().toString();
    }

    private boolean isEmailValid(){
        String email = getEmail();
        boolean isEmailValid = email.contains("@") && email.length() > 5;
        //Pattern emailAddress = Patterns.EMAIL_ADDRESS;
        //return emailAddress.matcher(email).matches();
        if (!isEmailValid)
            etEmail.setError("Invalid Email Address");
        else
            etEmail.setError(null);
        return isEmailValid;
    }

    private boolean isPasswordValid(){
        String password = getPassword();
        boolean isPasswordValid = password.length() > 5;

        if (!isPasswordValid)
            etPassword.setError("Password Must contain At least 6 Characters");
        else
            etPassword.setError(null);
        return isPasswordValid;
    }



    @OnClick(R.id.btnReigster)
    public void register() {
        //get the email
        String email = getEmail();
        //get the password
        String password = getPassword();
        //isEmail valid
        //isPassword valid
        if (!isEmailValid() | !isPasswordValid())
            return;
/*
        Task<AuthResult> registerTask = mAuth.createUserWithEmailAndPassword(email, password);
        registerTask.addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {

            }
        });
        registerTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });*/
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        showError(e);
                    }
                }).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        gotoMain();
                    }
        });
    }

    private void gotoMain() {
        Intent intent = new Intent(this, MainActivity.class);
        //TODO: Add some flags...
        startActivity(intent);
    }

    private void showError(Exception e) {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {}
        };

        Snackbar.make(etEmail, e.getMessage(), Snackbar.LENGTH_INDEFINITE)
                .setAction("OK", listener).show();
    }

    @OnClick(R.id.btnLogin)
    public void login() {

    }
}
