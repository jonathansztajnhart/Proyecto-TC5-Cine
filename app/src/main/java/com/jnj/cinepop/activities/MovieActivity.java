package com.jnj.cinepop.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.jnj.cinepop.R;

public class MovieActivity extends AppCompatActivity {

    private TextView txtTitulo, txtEdad, txtSinopsis;
    private ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        txtTitulo = (TextView) findViewById(R.id.txttitle);
        txtEdad = (TextView) findViewById(R.id.txtEdad);
        txtSinopsis = (TextView) findViewById(R.id.txtSinopsis);
        ivImage = (ImageView) findViewById(R.id.movieImg);

        Intent intent = getIntent();
        String titulo = intent.getExtras().getString("Titulo");
        String edad = intent.getExtras().getString("Edad");
        String sinopsis = intent.getExtras().getString("Sinopsis");
        int image = intent.getExtras().getInt("Imagen");

        txtTitulo.setText(titulo);
        txtEdad.setText(edad);
        txtSinopsis.setText(sinopsis);
        ivImage.setImageResource(image);

    }
}