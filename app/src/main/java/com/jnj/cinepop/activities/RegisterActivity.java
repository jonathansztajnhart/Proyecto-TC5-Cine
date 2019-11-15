package com.jnj.cinepop.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jnj.cinepop.DBAccess.DBUserManager;
import com.jnj.cinepop.R;

public class RegisterActivity extends AppCompatActivity {

    Button btnRegister;
    EditText txtNombre, txtApellido, txtEmail, txtPassword, txtConfirmPassword;
    private DBUserManager dbUserManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbUserManager = new DBUserManager();
        setContentView(R.layout.activity_register);

        /*probando*/
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(getString(R.string.title_activity_register));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        /*hasta aca*/

        btnRegister = findViewById(R.id.btnRegister);
        txtNombre = findViewById(R.id.firstname_register);
        txtApellido = findViewById(R.id.lastname_register);
        txtEmail = findViewById(R.id.username_register);
        txtPassword = findViewById(R.id.password_register);
        txtConfirmPassword = findViewById(R.id.password_confirm_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isValid = validarUsuario();
                if(isValid) {
                    registrarUsuario();
                }


            }
        });

        //le aplico al campo el tema de esconder teclado al tocar fuera del campo
        txtNombre.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    hideKeyboard(v);
                }
            }
        });

        //le aplico al campo el tema de esconder teclado al tocar fuera del campo
        txtApellido.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    hideKeyboard(v);
                }
            }
        });

        //le aplico al campo el tema de esconder teclado al tocar fuera del campo
        txtEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    hideKeyboard(v);
                }
            }
        });

        //le aplico al campo el tema de esconder teclado al tocar fuera del campo
        txtPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    hideKeyboard(v);
                }
            }
        });

        //le aplico al campo el tema de esconder teclado al tocar fuera del campo
        txtConfirmPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    hideKeyboard(v);
                }
            }
        });

    }

    //funcion para esconder teclado al tocar fuera del campo enfocado
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void registrarUsuario(){
        boolean isInserted = dbUserManager.insertUsuario(this, txtNombre.getText().toString(), txtApellido.getText().toString(),
                txtEmail.getText().toString(), txtPassword.getText().toString());
        if(isInserted){
            Toast.makeText(getApplicationContext(),R.string.successful_register, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(),R.string.failed_register, Toast.LENGTH_LONG).show();
        }
    }

    private boolean validarUsuario() {
        boolean isValid = false;
        boolean isEmpty = validarDatosCompletos();
        if(!isEmpty){
            if(validarPassword()){
                boolean isExistUser = dbUserManager.findUser(this, txtEmail.getText().toString());
               if(!isExistUser){
                   isValid = true;
               }
               else {
                   Toast.makeText(getApplicationContext(),R.string.existing_user_register, Toast.LENGTH_LONG).show();
               }
            }
            else {
                Toast.makeText(getApplicationContext(),R.string.does_not_pass_match_register, Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(getApplicationContext(), R.string.incomplete_form_register, Toast.LENGTH_LONG).show();
        }
        return isValid;
    }

    private boolean validarDatosCompletos(){
        boolean isEmpty = false;
        if(txtNombre.getText().toString().equals("")
           || txtApellido.getText().toString().equals("")
           || txtEmail.getText().toString().equals("")
           || txtPassword.getText().toString().equals("")
           || txtConfirmPassword.getText().toString().equals("")) {
            isEmpty = true;
        }
        return isEmpty;
    }

    private boolean validarPassword(){
        boolean isValidPass = false;
        if(txtPassword.getText().toString().equals(txtConfirmPassword.getText().toString())){
            isValidPass = true;
        }
        return isValidPass;
    }



}
