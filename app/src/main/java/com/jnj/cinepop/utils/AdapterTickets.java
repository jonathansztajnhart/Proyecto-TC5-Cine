package com.jnj.cinepop.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jnj.cinepop.R;
import com.jnj.cinepop.models.TicketModel;

import java.util.ArrayList;

public class AdapterTickets extends BaseAdapter {

    private static LayoutInflater inflater;
    private Context context;
    private ArrayList<TicketModel> ticketModels;

    public AdapterTickets(Context context, ArrayList<TicketModel> ticketModels) {
        this.ticketModels = ticketModels;
        this.context = context;
        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override


    public int getCount() {
        if (ticketModels != null){
            return ticketModels.size();
        }
        else {
            return 0;
        }
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final View vista = inflater.inflate(R.layout.ticket_lista, null);
        TextView txtNombrePelicula = vista.findViewById(R.id.txtNombrePelicula);
        TextView txtFechaFuncion = vista.findViewById(R.id.txtFechaFuncion);
        TextView txtHoraFuncion = vista.findViewById(R.id.txtHoraFuncion);
        TextView txtTipoFuncion = vista.findViewById(R.id.txtTipoFuncion);
        TextView txtIdiomaFuncion = vista.findViewById(R.id.txtIdiomaFuncion);
        TextView txtCantAsientos = vista.findViewById(R.id.txtCantAsientos);
        TextView txtPrecio = vista.findViewById(R.id.txtPrecio);

        txtNombrePelicula.setText(ticketModels.get(i).getTituloPelicula());
        txtFechaFuncion.setText(ticketModels.get(i).getFechaFuncion());
        txtHoraFuncion.setText(ticketModels.get(i).getHoraFuncion());
        txtTipoFuncion.setText(ticketModels.get(i).getTipoFuncion());
        txtIdiomaFuncion.setText(ticketModels.get(i).getIdioma());
        txtCantAsientos.setText(context.getString(R.string.cant_asientos) + "   " + String.valueOf(ticketModels.get(i).getCantAsientos()));
        txtPrecio.setText(String.valueOf("$" + ticketModels.get(i).getPrecioFuncion()));

        return vista;
    }
}
