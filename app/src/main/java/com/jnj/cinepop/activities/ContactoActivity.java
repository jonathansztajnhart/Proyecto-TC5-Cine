package com.jnj.cinepop.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.jnj.cinepop.R;

public class ContactoActivity extends AppCompatActivity {

    Button btnSendComentario;
    EditText txtComentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        /*barra con nombre y flechita*/
        Toolbar mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle(getString(R.string.title_activity_contacto));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        /*hasta aca*/

        txtComentario = findViewById(R.id.txtComentarios);
        btnSendComentario = findViewById(R.id.btnSendComment);

        btnSendComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarMail();
            }
        });

        //le aplico al campo el tema de esconder teclado al tocar fuera del campo
        txtComentario.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    hideKeyboard(v);
                }
            }
        });

    }

    private void enviarMail() {

        String mensaje = txtComentario.getText().toString();
        String mailcontacto = "contacto@cinepop.com";

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, mailcontacto);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Comentario para Cine Pop");
        intent.putExtra(Intent.EXTRA_TEXT, mensaje);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Seleccione la app para enviar el mail"));

    }

    //funcion para esconder teclado al tocar fuera del campo enfocado
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
