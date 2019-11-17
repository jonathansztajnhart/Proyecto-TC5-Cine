package com.jnj.cinepop.DBAccess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jnj.cinepop.models.LoginModel;

public class DBUserManager {
    public boolean insertUsuario(Context context, String nombre, String apellido, String email, String password) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.getColNombre(), nombre);
        contentValues.put(DatabaseHelper.getColApellido(), apellido);
        contentValues.put(DatabaseHelper.getColEmail(), email);
        contentValues.put(DatabaseHelper.getColPassword(), password);
        long result = db.insert(DatabaseHelper.getDatabaseTableUsers(), null, contentValues);
        return (result != -1);
    }

    public boolean findUser(Context context, String email) {
        boolean isFoundUser = false;
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor res = db.rawQuery( "select " + DatabaseHelper.getColEmail() + " from "+ DatabaseHelper.getDatabaseTableUsers() + " where "
                    + DatabaseHelper.getColEmail() + " = '" + email + "'", null );
        if(res.getCount() > 0){
            isFoundUser = true;
        }
        res.close();
        return isFoundUser;
    }

    public LoginModel getUser(Context context, String email, String pass) {
        LoginModel loginModel = null;
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor res = db.rawQuery( "select " + DatabaseHelper.getColNombre() + "," +
                DatabaseHelper.getColApellido() + "," + DatabaseHelper.getColEmail() +
                " from "+ DatabaseHelper.getDatabaseTableUsers() + " where "
                + DatabaseHelper.getColEmail() + " = '" + email + "' AND " +
                DatabaseHelper.getColPassword() + " = '" + pass + "'" , null );
        if(res.getCount() > 0){
            res.moveToFirst();
            loginModel = new LoginModel(res.getString(0),res.getString(1),res.getString(2));
        }
        res.close();
        return loginModel;
    }
}
