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
import android.widget.Button;
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
        final int id = getArguments().getInt("id");
        View view = inflater.inflate(R.layout.activity_movie_function,container,false);

        final Spinner dropdownFecha = view.findViewById(R.id.dropdownFecha);
        final Spinner dropdownHora = view.findViewById(R.id.dropdownHora);
        final Spinner dropdownTipo = view.findViewById(R.id.dropdownTipo);
        final Spinner dropdownIdioma = view.findViewById(R.id.dropdownIdioma);
        Spinner dropdownSucursal = view.findViewById(R.id.dropdownSucursal);
        final Button btnReservaFuncion = view.findViewById(R.id.btnReservarFunction);

        ArrayList<String> fechas = functionManagerDB.getFunctionDates(this.getContext(), id);
        fechas.add(0, "Seleccione Fecha");

        ArrayList<String> horas = new ArrayList<>();
        horas.add(0, "Seleccione Hora");

        ArrayList<String> tipos = new ArrayList<>();
        tipos.add(0, "Seleccione Tipo");

        ArrayList<String> idiomas = new ArrayList<>();
        idiomas.add(0, "Seleccione Idioma");

        final ArrayList<String> sucursales = new ArrayList<>();
        sucursales.add(0, "Seleccione Sucursal");

        final ArrayAdapter<String> adapterFecha = new ArrayAdapter<String>(this.getContext(),
                android.R.layout.simple_spinner_dropdown_item,
                fechas);

        final ArrayAdapter<String> adapterHora = new ArrayAdapter<String>(this.getContext(),
                android.R.layout.simple_spinner_dropdown_item,
                horas);

        final ArrayAdapter<String> adapterTipo = new ArrayAdapter<String>(this.getContext(),
                android.R.layout.simple_spinner_dropdown_item,
                tipos);

        final ArrayAdapter<String> adapterIdioma = new ArrayAdapter<String>(this.getContext(),
                android.R.layout.simple_spinner_dropdown_item,
                idiomas);

        final ArrayAdapter<String> adapterSucursal = new ArrayAdapter<String>(this.getContext(),
                android.R.layout.simple_spinner_dropdown_item,
                sucursales);

        dropdownFecha.setAdapter(adapterFecha);
        dropdownHora.setAdapter(adapterHora);
        dropdownTipo.setAdapter(adapterTipo);
        dropdownIdioma.setAdapter(adapterIdioma);
        dropdownSucursal.setAdapter(adapterSucursal);


        dropdownFecha.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                adapterHora.clear();
                adapterTipo.clear();
                adapterIdioma.clear();
                adapterSucursal.clear();
                adapterHora.add("Seleccione Hora");
                adapterTipo.add("Seleccione Tipo");
                adapterIdioma.add("Seleccione Idioma");
                adapterSucursal.add("Seleccione Sucursal");
                if(!adapterView.getItemAtPosition(i).equals("Seleccione Fecha")) {
                        ArrayList<String> horas = functionManagerDB.getFunctionHours(getContext(), id, dropdownFecha.getSelectedItem().toString());
                    adapterHora.addAll(horas);
                }
                else {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        dropdownHora.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                adapterTipo.clear();
                adapterIdioma.clear();
                adapterSucursal.clear();
                adapterTipo.add("Seleccione Tipo");
                adapterIdioma.add("Seleccione Idioma");
                adapterSucursal.add("Seleccione Sucursal");
                if(!adapterView.getItemAtPosition(i).equals("Seleccione Hora")) {
                    ArrayList<String> tipos = functionManagerDB.getFunctionTipos(getContext(), id,
                            dropdownFecha.getSelectedItem().toString(), dropdownHora.getSelectedItem().toString());
                    adapterTipo.addAll(tipos);
                }
                else {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        dropdownTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                adapterIdioma.clear();
                adapterSucursal.clear();
                adapterIdioma.add("Seleccione Idioma");
                adapterSucursal.add("Seleccione Sucursal");
                if(!adapterView.getItemAtPosition(i).equals("Seleccione Tipo")) {
                    ArrayList<String> idiomas = functionManagerDB.getFunctionLanguages(getContext(), id,
                            dropdownFecha.getSelectedItem().toString(), dropdownHora.getSelectedItem().toString(),
                            dropdownTipo.getSelectedItem().toString());
                    adapterIdioma.addAll(idiomas);
                }
                else {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        dropdownIdioma.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                adapterSucursal.clear();
                adapterSucursal.add("Seleccione Sucursal");
                if(!adapterView.getItemAtPosition(i).equals("Seleccione Idioma")) {
                    ArrayList<String> sucursales = functionManagerDB.getFunctionSucursales(getContext(), id,
                            dropdownFecha.getSelectedItem().toString(), dropdownHora.getSelectedItem().toString(),
                            dropdownTipo.getSelectedItem().toString(), dropdownIdioma.getSelectedItem().toString());
                    adapterSucursal.addAll(sucursales);
                }
                else {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        dropdownSucursal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(!adapterView.getItemAtPosition(i).equals("Seleccione Sucursal")) {
                    btnReservaFuncion.setVisibility(View.VISIBLE);
                }
                else {
                    btnReservaFuncion.setVisibility(view.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }
}
