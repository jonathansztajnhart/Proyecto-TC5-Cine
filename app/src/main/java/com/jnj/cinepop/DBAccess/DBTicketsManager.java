package com.jnj.cinepop.DBAccess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.jnj.cinepop.models.TicketModel;

import java.util.ArrayList;

public class DBTicketsManager {
    public boolean insertTicket(Context context, int idUsuario, int idFuncion, int cantAsientos) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.getColIdUsuario(), String.valueOf(idUsuario));
        contentValues.put(DatabaseHelper.getColIdFuncion(), String.valueOf(idFuncion));
        contentValues.put(DatabaseHelper.getColCantAsientos(), String.valueOf(cantAsientos));
        //contentValues.put(DatabaseHelper.getColFechaReserva(), "SELECT date('now')");
        long result = db.insert(DatabaseHelper.getDatabaseTableTickets(), null, contentValues);
        return (result != -1);
    }

    public ArrayList<TicketModel> getAllTicketByUser(Context context, int idUsuario) {
        ArrayList<TicketModel> listTickets = null;
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor res = db.rawQuery( "select " + " T." + DatabaseHelper.getColId() + ", " + "M." + DatabaseHelper.getColTitulo()
                + ", " + "F." + DatabaseHelper.getColFecha()  + ", " + "F." + DatabaseHelper.getColHora()
                + ", " + "TF." + DatabaseHelper.getColTipoFuncion() + ", " + "F." + DatabaseHelper.getColIdioma()
                + ", " + "S." + DatabaseHelper.getColNombreSuc() + ", " + "T." + DatabaseHelper.getColCantAsientos()
                + ", " + "TF." + DatabaseHelper.getColPrecio() + "*" + DatabaseHelper.getColCantAsientos()
                + " from "+ DatabaseHelper.getDatabaseTableTickets() + " as T"
                + " inner join " + DatabaseHelper.getDatabaseTableFunctions() + " as F on F." + DatabaseHelper.getColId() + " = T." + DatabaseHelper.getColIdFuncion()
                + " inner join " + DatabaseHelper.getDatabaseTableMovies() + " as M on M." + DatabaseHelper.getColId() + " = F." + DatabaseHelper.getColIdPelicula()
                + " inner join " + DatabaseHelper.getDatabaseTableFunctionsType() + " as TF on TF." + DatabaseHelper.getColIdTipo() + " = F." + DatabaseHelper.getColIdTipo()
                + " inner join " + DatabaseHelper.getDatabaseTableSubsidiary() + " as S on S." + DatabaseHelper.getColIdSucursal() + " = F." + DatabaseHelper.getColIdSucursal()
                + " where " + " T." + DatabaseHelper.getColIdUsuario() + " = '" + idUsuario + "'"
                + " order by T." + DatabaseHelper.getColIdFechaReserva() + " desc"
                , null );
        if(res.getCount() > 0){
            listTickets = new ArrayList<>();
            while(res.moveToNext()){
                TicketModel ticketModel = new TicketModel(Integer.parseInt(res.getString(0)),res.getString(1),res.getString(2),res.getString(3), res.getString(4),
                res.getString(5), res.getString(6), Integer.parseInt(res.getString(7)), Double.parseDouble(res.getString(8)));
                listTickets.add(ticketModel);
            }
        }
        res.close();
        return listTickets;
    }
}
