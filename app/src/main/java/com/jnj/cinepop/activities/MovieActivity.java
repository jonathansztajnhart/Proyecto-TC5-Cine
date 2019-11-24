package com.jnj.cinepop.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jnj.cinepop.R;
import com.jnj.cinepop.utils.MovieDetailFragment;
import com.jnj.cinepop.utils.MovieFunctionFragment;
import com.jnj.cinepop.utils.SectionsPageAdapter;

public class MovieActivity extends AppCompatActivity {

    private TextView txtTitulo;
    private ImageView ivImage;
    private SectionsPageAdapter mSectionsPageAdapter;
    String edad, sinopsis, titulo;
    int id, image;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        Toolbar mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle(getString(R.string.title_activity_movie));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        txtTitulo = findViewById(R.id.txttitle);
        ivImage = findViewById(R.id.movieImg);

        Intent intent = getIntent();
        id = intent.getExtras().getInt("Id");
        titulo = intent.getExtras().getString("Titulo");
        edad = intent.getExtras().getString("Edad");
        sinopsis = intent.getExtras().getString("Sinopsis");
        image = intent.getExtras().getInt("Imagen");

        txtTitulo.setText(titulo);
        ivImage.setImageResource(image);

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());

        //Bundle para el detalle
        Bundle bundleDetail = new Bundle();
        bundleDetail.putString("edad", this.edad);
        bundleDetail.putString("sinopsis", this.sinopsis);
        MovieDetailFragment movieDetail = new MovieDetailFragment();
        movieDetail.setArguments(bundleDetail);

        //Bundle para las funciones
        Bundle bundleFunction = new Bundle();
        bundleFunction.putInt("id", this.id);
        MovieFunctionFragment movieFunction = new MovieFunctionFragment();
        movieFunction.setArguments(bundleFunction);

        adapter.addFragment(movieDetail, "Detalle");
        adapter.addFragment(movieFunction, "Funciones");
        viewPager.setAdapter(adapter);
    }
}