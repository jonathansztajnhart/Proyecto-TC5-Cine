package com.jnj.cinepop.DBAcess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jnj.cinepop.activities.RegisterActivity;
import com.jnj.cinepop.models.LoginModel;

public class DBUserManager {
    public boolean insertUsuario(Context context, String nombre, String apellido, String email, String password) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.getColNombre(), nombre);
        contentValues.put(dbHelper.getColApellido(), apellido);
        contentValues.put(dbHelper.getColEmail(), email);
        contentValues.put(dbHelper.getColPassword(), password);
        long result = db.insert(dbHelper.getDatabaseTableUsers(), null, contentValues);
        return (result != -1);
    }

    public boolean findUser(Context context, String email) {
        boolean isFoundUser = false;
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor res = db.rawQuery( "select " + dbHelper.getColEmail() + " from "+ dbHelper.getDatabaseTableUsers() + " where "
                    + dbHelper.getColEmail() + " = '" + email + "'", null );
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
        Cursor res = db.rawQuery( "select " + dbHelper.getColNombre() + "," +
                dbHelper.getColApellido() + "," + dbHelper.getColEmail() +
                " from "+ dbHelper.getDatabaseTableUsers() + " where "
                + dbHelper.getColEmail() + " = '" + email + "' AND " +
                dbHelper.getColPassword() + " = '" + pass + "'" , null );
        if(res.getCount() > 0){
            res.moveToFirst();
            loginModel = new LoginModel(res.getString(0),res.getString(1),res.getString(2));
        }
        res.close();
        return loginModel;
    }
}
