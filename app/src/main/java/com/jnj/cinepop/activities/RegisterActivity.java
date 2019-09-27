package com.jnj.cinepop.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jnj.cinepop.DBAcess.DBUserManager;
import com.jnj.cinepop.DBAcess.DatabaseHelper;
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
    }

    public void registrarUsuario(){
        boolean isInserted = dbUserManager.insertUsuario(this, txtNombre.getText().toString(), txtApellido.getText().toString(),
                txtEmail.getText().toString(), txtPassword.getText().toString());
        if(isInserted){
            Toast.makeText(getApplicationContext(),"Registro exitoso", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(),"Error al registrarse", Toast.LENGTH_LONG).show();
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
                   Toast.makeText(getApplicationContext(),"El mail ya se encuentra registrado", Toast.LENGTH_LONG).show();
               }
            }
            else {
                Toast.makeText(getApplicationContext(),"Las contraseñas ingresadas no coinciden", Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(getApplicationContext(),"Faltan completar algunos datos", Toast.LENGTH_LONG).show();
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
