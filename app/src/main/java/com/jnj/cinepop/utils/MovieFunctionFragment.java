package com.jnj.cinepop.utils;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.jnj.cinepop.DBAccess.DBFunctionManager;
import com.jnj.cinepop.DBAccess.DatabaseHelper;
import com.jnj.cinepop.R;

import java.util.ArrayList;

public class MovieFunctionFragment extends Fragment {
    private static final String TAG = "MovieFunctionFragment";
    private DBFunctionManager functionManagerDB;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        functionManagerDB = new DBFunctionManager();
        int id = getArguments().getInt("id");
        View view = inflater.inflate(R.layout.activity_movie_function,container,false);

        Spinner dropdownFecha = view.findViewById(R.id.dropdownFecha);
        Spinner dropdownHora = view.findViewById(R.id.dropdownHora);
        Spinner dropdownTipo = view.findViewById(R.id.dropdownTipo);
        Spinner dropdownIdioma = view.findViewById(R.id.dropdownIdioma);
        Spinner dropdownSucursal = view.findViewById(R.id.dropdownSucursal);

        ArrayList<String> options = functionManagerDB.getFunctionDates(this.getContext(), id);
        options.add(0, "Seleccione Fecha");

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(),
                android.R.layout.simple_spinner_dropdown_item,
                options);

        dropdownFecha.setAdapter(adapter);
        dropdownHora.setAdapter(adapter);
        dropdownTipo.setAdapter(adapter);
        dropdownIdioma.setAdapter(adapter);
        dropdownSucursal.setAdapter(adapter);


        dropdownFecha.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(adapterView.getItemAtPosition(i).equals("Seleccione Fecha")) {

                }
                else {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }
}
