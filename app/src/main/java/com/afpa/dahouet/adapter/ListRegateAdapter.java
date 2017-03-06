package com.afpa.dahouet.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.afpa.dahouet.model.Regate;
import com.google.gson.Gson;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import dahouet.afpa.com.regateviewer.R;
import dahouet.afpa.com.regateviewer.RegateDetailsViewer;
import dahouet.afpa.com.regateviewer.RegateResultsViewer;


/**
 * Created by Afpa on 01/03/2017.
 */

public class ListRegateAdapter extends ArrayAdapter<Regate> {


    public ListRegateAdapter(Context context, List<Regate> regates) {
        super(context, 0, regates);




    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Regate regate = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_eregate, parent, false);
        }
        TextView id = (TextView) convertView.findViewById(R.id.regateId);
        TextView date = (TextView) convertView.findViewById(R.id.regateDate);

        date.setText(regate.getDate().toString());
        id.setText(regate.getId().toString());

        Button buttonDetails = (Button) convertView.findViewById(R.id.btn_datails);

        buttonDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), RegateDetailsViewer.class);
                Gson gson = new Gson();
                String regJSON = gson.toJson(regate);
                intent.putExtra("REGATE_JSON", regJSON);
                getContext().startActivity(intent);




            }
        });

        Button btn_result = (Button) convertView.findViewById(R.id.btn_result);
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Date date =  new java.sql.Date(Calendar.getInstance().getTime().getTime());
                System.out.println(date);

                if (regate.getDate().after(date)) {

                    Toast.makeText(getContext(), "La régate n'a pas encore eu lieu", Toast.LENGTH_SHORT).show();

                } else {

                    Intent intent = new Intent(getContext(), RegateResultsViewer.class);
                    Gson gson = new Gson();
                    String regJSON = gson.toJson(regate);
                    intent.putExtra("REGATE_JSON", regJSON);
                    getContext().startActivity(intent);


                }


            }
        });




        return convertView;
    }
}
