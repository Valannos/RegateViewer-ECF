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
 * Created by Afpa on 02/03/2017.
 */

public class ListResultatsAdapter extends ArrayAdapter<Participation> {

   private final String UNAVAILABLE = getContext().getResources().getString(R.string.UNAVAILABLE);

    public ListResultatsAdapter(Context context, List<Participation> participations) {
        super(context, 0, participations);


    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Participation participation = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_results, parent, false);
        }

        TextView textView_value_name_voilier = (TextView) convertView.findViewById(R.id.textView_value_name_voilier);
        TextView textView_value_classe = (TextView) convertView.findViewById(R.id.textView_value_classe);
        TextView textView_value_tpsReel = (TextView) convertView.findViewById(R.id.textView_value_tpsReel);
        TextView textView_value_tpsCom = (TextView) convertView.findViewById(R.id.textView_value_tpsCom);
        TextView textView_value_rank = (TextView) convertView.findViewById(R.id.textView_value_rank);


        if (participation.getTpsReel() == null) {

            textView_value_name_voilier.setText(participation.getVoilier().getNom());
            textView_value_classe.setText(participation.getVoilier().getClasse().getName());
            textView_value_tpsReel.setText(UNAVAILABLE);
            textView_value_tpsCom.setText(UNAVAILABLE);
            textView_value_rank.setText(UNAVAILABLE);


        } else {

            textView_value_name_voilier.setText(participation.getVoilier().getNom());
            textView_value_classe.setText(participation.getVoilier().getClasse().getName() + "\n(Coef.: " + participation.getVoilier().getClasse().getCoef() + ")");
            textView_value_tpsReel.setText(participation.getTpsReel().toString());
            textView_value_tpsCom.setText(participation.getTpsReg().toString());
            textView_value_rank.setText(""+participation.getRank());

        }
        return convertView;
    }


}
