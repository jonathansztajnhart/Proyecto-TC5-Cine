package com.jnj.cinepop.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jnj.cinepop.DBAcess.DatabaseHelper;
import com.jnj.cinepop.R;

public class RegisterActivity extends AppCompatActivity {

    Button btnRegister;
    EditText txtNombre, txtApellido, txtEmail, txtPassword, txtConfirmPassword;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DatabaseHelper(this);
        setContentView(R.layout.activity_register);
        btnRegister = findViewById(R.id.btnRegister);
        txtNombre = findViewById(R.id.firstname_register);
        txtApellido = findViewById(R.id.lastname_register);
        txtEmail = findViewById(R.id.username_register);
        txtPassword = findViewById(R.id.password_register);
        txtConfirmPassword = findViewById(R.id.password_confirm_register);
        registrarUsuario();
    }

    public void registrarUsuario(){
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = db.insertUsuario(txtNombre.getText().toString(), txtApellido.getText().toString(),
                        txtEmail.getText().toString(), txtPassword.getText().toString());
                if(isInserted){
                    Toast.makeText(getApplicationContext(),"Registro exitoso", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error al registrarse", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
