package com.jnj.cinepop.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
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

    }
}
