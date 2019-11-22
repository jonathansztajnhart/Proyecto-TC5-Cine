package com.jnj.cinepop.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.jnj.cinepop.DBAccess.DBSeatManager;
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
    private Spinner dropdownCantDias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);
        seatManagerDB = new DBSeatManager();

        txtPelicula = findViewById(R.id.txtNombrePelicula);
        txtFecha = findViewById(R.id.txtFechaFuncion);
        txtHora = findViewById(R.id.txtHoraFuncion);
        txtTipoFuncion = findViewById(R.id.txtTipoFuncion);
        txtIdioma = findViewById(R.id.txtIdioma);
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
                Intent intent = new Intent(getApplicationContext(), PaymentActivity.class);
                intent.putExtra("idFuncion", getIntent().getExtras().getInt("idFuncion"));
                intent.putExtra("cantAsientos", Integer.parseInt(dropdownCantDias.getSelectedItem().toString()));
                intent.putExtra("idTipoFuncion", getIntent().getExtras().getInt("idTipoFuncion"));
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
