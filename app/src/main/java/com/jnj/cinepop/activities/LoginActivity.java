package com.jnj.cinepop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jnj.cinepop.DBAcess.DBUserManager;
import com.jnj.cinepop.DBAcess.DatabaseHelper;
import com.jnj.cinepop.R;
import com.jnj.cinepop.models.LoginModel;

public class LoginActivity extends AppCompatActivity {

    private DBUserManager dbUserManager;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            checkFieldsForEmptyValues();
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbUserManager = new DBUserManager();
        setContentView(R.layout.activity_login);
        usernameEditText = findViewById(R.id.username_login);
        passwordEditText = findViewById(R.id.password_login);
        loginButton = findViewById(R.id.btnLogin);
        final Button registerButton = findViewById(R.id.btnRegister);

        usernameEditText.addTextChangedListener(mTextWatcher);
        passwordEditText.addTextChangedListener(mTextWatcher);

        checkFieldsForEmptyValues();

        registerButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToRegisterActivity();
            }
        });

        loginButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginModel loginModel = getLoginModel();
                if(loginModel != null){
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"El usuario y/o la contraseña no válidos",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private LoginModel getLoginModel() {
        return dbUserManager.getUser(this, usernameEditText.getText().toString(),
                passwordEditText.getText().toString());
    }

    void checkFieldsForEmptyValues(){
        Button btnLogin = (Button) findViewById(R.id.btnLogin);

        String user = usernameEditText.getText().toString();
        String pass = passwordEditText.getText().toString();

        if(user.equals("")|| pass.equals("")){
            btnLogin.setEnabled(false);
        } else {
            btnLogin.setEnabled(true);
        }
    }

    private void navigateToRegisterActivity() {
        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(intent);
    }

}
