package com.jnj.cinepop.utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.jnj.cinepop.R;

import java.util.ArrayList;

public class MovieFunctionFragment extends Fragment {
    private static final String TAG = "MovieFunctionFragment";

    private Button btnTEST;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int id = getArguments().getInt("id");
        View view = inflater.inflate(R.layout.activity_movie_function,container,false);

        Spinner dropdownFecha = view.findViewById(R.id.dropdownFecha);
        Spinner dropdownHora = view.findViewById(R.id.dropdownHora);
        Spinner dropdownTipo = view.findViewById(R.id.dropdownTipo);
        Spinner dropdownIdioma = view.findViewById(R.id.dropdownIdioma);
        Spinner dropdownSucursal = view.findViewById(R.id.dropdownSucursal);

        ArrayList<String> options=new ArrayList<String>();

        options.add("12/11/2019");
        options.add("13/11/2019");
        options.add("14/11/2019");
        options.add("12/11/2019");
        options.add("13/11/2019");
        options.add("14/11/2019");
        options.add("12/11/2019");
        options.add("13/11/2019");
        options.add("14/11/2019");
        options.add("12/11/2019");
        options.add("13/11/2019");
        options.add("14/11/2019");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(),
                android.R.layout.simple_spinner_dropdown_item,
                options);
        dropdownFecha.setAdapter(adapter);
        dropdownHora.setAdapter(adapter);
        dropdownTipo.setAdapter(adapter);
        dropdownIdioma.setAdapter(adapter);
        dropdownSucursal.setAdapter(adapter);



        return view;
    }
}
