package com.jnj.cinepop.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jnj.cinepop.DBAccess.DBSeatManager;
import com.jnj.cinepop.R;

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
    private DBSeatManager seatManagerDB;

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


        idPelicula = getIntent().getExtras().getInt("idPelicula");
        txtPelicula.setText(pelicula = getIntent().getExtras().getString("pelicula"));
        txtFecha.setText(getIntent().getExtras().getString("fecha"));
        txtHora.setText(getIntent().getExtras().getString("hora"));
        idTipoFuncion = getIntent().getExtras().getInt("idTipoFuncion");
        txtTipoFuncion.setText(getIntent().getExtras().getString("tipoFuncion"));
        txtIdioma.setText(getIntent().getExtras().getString("idioma"));
        idSucursal = getIntent().getExtras().getInt("idSucursal");
        txtSucursal.setText(getIntent().getExtras().getString("sucursal"));
        txtCantAsientos.setText(getString(R.string.txtCantAsientosDisponibles) + " "
                + seatManagerDB.getCantAsientos(getApplicationContext(), getIntent().getExtras().getInt("idFuncion")));
    }
}
