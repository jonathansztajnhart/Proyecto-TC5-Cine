package com.jnj.cinepop.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.jnj.cinepop.DBAccess.DBSeatManager;
import com.jnj.cinepop.DBAccess.DBTicketsManager;
import com.jnj.cinepop.DBAccess.DBUserManager;
import com.jnj.cinepop.R;

import java.util.ArrayList;

public class ReservaActivity extends AppCompatActivity {

    int idPelicula, idTipoFuncion;
    String pelicula;
    String fecha;
    String hora;
    String tipoFuncion;
    String idioma;
    int idSucursal;
    String sucursal;
    int idFuncion;
    private TextView txtPelicula, txtFecha, txtHora, txtTipoFuncion,
            txtIdioma, txtSucursal, txtCantAsientos;
    private Button btnConfirmarReserva;
    private DBSeatManager seatManagerDB;
    private DBUserManager userManagerDB;
    private DBTicketsManager ticketsManagerDB;
    private Spinner dropdownCantDias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        Toolbar mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle(getString(R.string.title_activity_reserva));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        seatManagerDB = new DBSeatManager();
        userManagerDB = new DBUserManager();
        ticketsManagerDB = new DBTicketsManager();

        txtPelicula = findViewById(R.id.guidFirstRow);
        txtFecha = findViewById(R.id.txtFechaFuncion);
        txtHora = findViewById(R.id.guidForthRow);
        txtTipoFuncion = findViewById(R.id.guidThirdRow);
        txtIdioma = findViewById(R.id.txtIdiomaFuncion);
        txtSucursal = findViewById(R.id.txtSucursal);
        txtCantAsientos = findViewById(R.id.txtCantAsientos);
        btnConfirmarReserva = findViewById(R.id.btnConfirmarReserva);

        idPelicula = getIntent().getExtras().getInt("idPelicula");
        txtPelicula.setText(pelicula = getIntent().getExtras().getString("pelicula"));
        txtFecha.setText(getIntent().getExtras().getString("fecha"));
        txtHora.setText(getIntent().getExtras().getString("hora"));
        idTipoFuncion = getIntent().getExtras().getInt("idTipoFuncion");
        txtTipoFuncion.setText(getIntent().getExtras().getString("tipoFuncion"));
        txtIdioma.setText(getIntent().getExtras().getString("idioma"));
        idSucursal = getIntent().getExtras().getInt("idSucursal");
        txtSucursal.setText(getIntent().getExtras().getString("sucursal"));

        int cantAsientos = seatManagerDB.getCantAsientos(getApplicationContext(), getIntent().getExtras().getInt("idFuncion"));

        txtCantAsientos.setText(getString(R.string.cant_asientos_disponibles) + " " + cantAsientos);

        cargarListaAsientosDisponibles(cantAsientos);

        dropdownCantDias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(!adapterView.getItemAtPosition(i).equals("Seleccione cantidad de asientos")) {
                    btnConfirmarReserva.setVisibility(View.VISIBLE);
                }
                else {
                    btnConfirmarReserva.setVisibility(view.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnConfirmarReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = getSharedPreferences("session_login", Context.MODE_PRIVATE).getString("email",null);
                int idFuncion = getIntent().getExtras().getInt("idFuncion");
                int idUsuario = userManagerDB.getIdUser(getApplicationContext(), email);
                int cantAsientos = Integer.parseInt(dropdownCantDias.getSelectedItem().toString());
                ticketsManagerDB.insertTicket(getApplicationContext(), idUsuario, idFuncion, cantAsientos);
                seatManagerDB.disminuirCantAsientos(getApplicationContext(), idFuncion, cantAsientos);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void cargarListaAsientosDisponibles(int cantAsientos) {
        dropdownCantDias = findViewById(R.id.dropdownCantDias);

        ArrayList<String> cantDias = new ArrayList<>();
        cantDias.add(0, "Seleccione cantidad de asientos");

        for (int i = 1; i <= cantAsientos; i++ ){
            cantDias.add(String.valueOf(i));
        }

        final ArrayAdapter<String> adapterCantDias = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                cantDias);

        dropdownCantDias.setAdapter(adapterCantDias);
    }
}
