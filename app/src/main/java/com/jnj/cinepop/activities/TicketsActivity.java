package com.jnj.cinepop.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListView;

import com.jnj.cinepop.DBAccess.DBTicketsManager;
import com.jnj.cinepop.R;
import com.jnj.cinepop.models.TicketModel;
import com.jnj.cinepop.utils.AdapterTickets;

import java.util.ArrayList;

public class TicketsActivity extends AppCompatActivity {

    DBTicketsManager managerTicketsDB;
    ListView lstViewTickets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);

        managerTicketsDB = new DBTicketsManager();
        Toolbar mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle(getString(R.string.title_activity_tickets));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        lstViewTickets = findViewById(R.id.lstViewTickets);
        ArrayList<TicketModel> lstTickets = managerTicketsDB.getAllTicketByUser(getApplicationContext(),3);//modificar  por id real

        lstViewTickets.setAdapter(new AdapterTickets(getApplicationContext(),lstTickets));
    }
}
