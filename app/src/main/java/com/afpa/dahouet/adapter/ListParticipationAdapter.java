package com.afpa.dahouet.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.afpa.dahouet.model.Participation;

import java.util.List;

import dahouet.afpa.com.regateviewer.R;

/**
 * Created by Afpa on 01/03/2017.
 */

public class ListParticipationAdapter extends ArrayAdapter<Participation> {


    public ListParticipationAdapter(Context context, List<Participation> participations) {
        super(context, 0, participations);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        final Participation participation = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_participation, parent, false);
        }
        TextView textView_part_number = (TextView) convertView.findViewById(R.id.textView_part_number);
        TextView textView_listPart_voilier_value = (TextView) convertView.findViewById(R.id.textView_listPart_voilier_value);
        TextView textView_listPart_class_value = (TextView) convertView.findViewById(R.id.textView_listPart_class_value);
        TextView textView_listPart_skipper_value = (TextView) convertView.findViewById(R.id.textView_listPart_skipper_value);

        textView_listPart_voilier_value.setText(participation.getVoilier().getNom() + " (" + participation.getVoilier().getPro().getName() + ")");
        textView_listPart_class_value.setText(participation.getVoilier().getClasse().getName() + " (Coef.:" + participation.getVoilier().getClasse().getCoef() + ")");
        textView_listPart_skipper_value.setText(participation.getSkipper().getName());
        textView_part_number.setText(textView_part_number.getText() + " " + (position + 1) );
        return convertView;
    }
}


