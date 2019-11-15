package com.jnj.cinepop.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jnj.cinepop.DBAccess.DBUserManager;
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

        /*probando*/
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(getString(R.string.title_activity_login));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        /*hasta aca*/

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

        //le aplico al campo el tema de esconder teclado al tocar fuera del campo
        usernameEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    hideKeyboard(v);
                }
            }
        });

        //le aplico al campo el tema de esconder teclado al tocar fuera del campo
        passwordEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    hideKeyboard(v);
                }
            }
        });

        loginButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginModel loginModel = getLoginModel();
                if(loginModel != null){
                    saveLoginSharedPreferences(loginModel.getEmail() ,loginModel.getNombre(), loginModel.getApellido());
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), R.string.invalid_user_pass_login,
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    //guardo los datos del login para mantener la sesión hasta el el logout
    private void saveLoginSharedPreferences(String email, String nombre, String apellido) {
        SharedPreferences sharedPref = getSharedPreferences("session_login", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("nombre", nombre);
        editor.putString("apellido", apellido);
        editor.putString("email", email);
        editor.apply();
    }

    //funcion para esconder teclado al tocar fuera del campo enfocado
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private LoginModel getLoginModel() {
        return dbUserManager.getUser(this, usernameEditText.getText().toString(),
                passwordEditText.getText().toString());
    }

    private void checkFieldsForEmptyValues(){
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
