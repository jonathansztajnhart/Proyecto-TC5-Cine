package com.jnj.cinepop.utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jnj.cinepop.R;


public class MovieDetailFragment extends Fragment {
    private static final String TAG = "MovieDetailFragment";

    private TextView txtEdad, txtSinopsis;
    String edad, sinopsis;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        edad = getArguments().getString("edad");
        sinopsis = getArguments().getString("sinopsis");
        View view = inflater.inflate(R.layout.activity_movie_detail,container,false);

        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        txtEdad = (TextView) getActivity().findViewById(R.id.txtEdad);
        txtSinopsis = (TextView) getActivity().findViewById(R.id.txtSinopsis);
        txtEdad.setText(this.edad);
        txtSinopsis.setText(this.sinopsis);
    }
}