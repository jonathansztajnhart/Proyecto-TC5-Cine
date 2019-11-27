package com.jnj.cinepop.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.Toast;

import com.jnj.cinepop.DBAccess.DBFunctionManager;
import com.jnj.cinepop.DBAccess.DBMovieManager;
import com.jnj.cinepop.DBAccess.DatabaseHelper;
import com.jnj.cinepop.R;
import com.jnj.cinepop.activities.ReservaActivity;

import java.util.ArrayList;

public class MovieFunctionFragment extends Fragment {
    private static final String TAG = "MovieFunctionFragment";
    private DBFunctionManager functionManagerDB;
    private DBMovieManager movieManagerDB;
    SharedPreferences sharedPref;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        functionManagerDB = new DBFunctionManager();
        movieManagerDB = new DBMovieManager();
        final int id = getArguments().getInt("id");
        View view = inflater.inflate(R.layout.activity_movie_function,container,false);

        sharedPref = this.getActivity().getSharedPreferences("session_login", Context.MODE_PRIVATE);

        final Spinner dropdownFecha = view.findViewById(R.id.dropdownFecha);
        final Spinner dropdownHora = view.findViewById(R.id.dropdownHora);
        final Spinner dropdownTipo = view.findViewById(R.id.dropdownTipo);
        final Spinner dropdownIdioma = view.findViewById(R.id.dropdownIdioma);
        final Spinner dropdownSucursal = view.findViewById(R.id.dropdownSucursal);
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

        btnReservaFuncion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = sharedPref.getString("email",null);

                if(isLogged(email)) {
                    String pelicula = movieManagerDB.getNameMovie(getContext(), id);
                    String fecha = dropdownFecha.getSelectedItem().toString();
                    String hora = dropdownHora.getSelectedItem().toString();
                    int idTipoFuncion = functionManagerDB.getIdTipoFuncion(getContext(), dropdownTipo.getSelectedItem().toString());
                    String tipoFuncion = dropdownTipo.getSelectedItem().toString();
                    String idioma = dropdownIdioma.getSelectedItem().toString();
                    int idSucursal = functionManagerDB.getIdSucursal(getContext(), dropdownSucursal.getSelectedItem().toString());
                    String sucursal = dropdownSucursal.getSelectedItem().toString();
                    int idFuncion = functionManagerDB.getIdFuncion(getContext(), id, fecha, hora, idTipoFuncion, idioma, idSucursal);

                    Intent intent = new Intent(getContext(), ReservaActivity.class);
                    intent.putExtra("idPelicula", id);
                    intent.putExtra("pelicula", pelicula);
                    intent.putExtra("fecha", fecha);
                    intent.putExtra("hora", hora);
                    intent.putExtra("idTipoFuncion", idTipoFuncion);
                    intent.putExtra("tipoFuncion", tipoFuncion);
                    intent.putExtra("idioma", idioma);
                    intent.putExtra("idSucursal", idSucursal);
                    intent.putExtra("sucursal", sucursal);
                    intent.putExtra("idFuncion", idFuncion);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getActivity().getApplicationContext(), R.string.not_logged,
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }

    private boolean isLogged(String email){
        return email != null && !email.equals("");
    }
}
