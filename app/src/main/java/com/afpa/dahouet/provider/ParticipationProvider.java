package com.afpa.dahouet.provider;

import android.os.AsyncTask;

import com.afpa.dahouet.model.Participation;
import com.afpa.dahouet.model.Regate;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import dahouet.afpa.com.APISettings;

/**
 * Created by Afpa on 01/03/2017.
 */

public class ParticipationProvider extends AsyncTask<String, Void, List<Participation>> {


    @Override
    protected List<Participation> doInBackground(String... params) {

        Regate regate = new Gson().fromJson(params[0], Regate.class);
        List<Participation> participations = null;

        if (params[1] == "NO_RESULT") {

            StringBuilder builder = null;
            HttpURLConnection urlConnection;
            String line;

            try {

                URL url = new URL(APISettings.getURI(APISettings.URI.GET_PARTICIPATION_FROM_REGATE_WITHOUT_RESULT) + "/" + regate.getId());

                System.out.println(url);
                urlConnection = (HttpURLConnection) url.openConnection();


                urlConnection.setReadTimeout(15000);
                urlConnection.setConnectTimeout(15000);
                urlConnection.setRequestMethod("GET");
                urlConnection.setRequestProperty("Accept", "application/json");
                urlConnection.connect();

                builder = new StringBuilder();
                System.out.println(urlConnection.getResponseCode());
                if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {

                    System.out.println("Connection established, retrieving Challenge data");
                    InputStream stream = new BufferedInputStream(urlConnection.getInputStream());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

                    while ((line = reader.readLine()) != null) {

                        builder.append(line);

                    }
                    reader.close();


                } else {

                    System.out.println("Error connecting server");

                }
                urlConnection.disconnect();
                Gson gson = new Gson();
                String partJSON = builder.toString();
                Type type = new TypeToken<List<Participation>>() {
                }.getType();
                participations = gson.fromJson(partJSON, type);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } else if (params[1] == "WITH_RESULT") {

            StringBuilder builder = null;
            HttpURLConnection urlConnection;
            String line;

            try {

                URL url = new URL(APISettings.getURI(APISettings.URI.GET_PARTICIPATION_FROM_REGATE_WITH_RESULTS) + "/" + regate.getId());

                System.out.println(url);
                urlConnection = (HttpURLConnection) url.openConnection();


                urlConnection.setReadTimeout(15000);
                urlConnection.setConnectTimeout(15000);
                urlConnection.setRequestMethod("GET");
                urlConnection.setRequestProperty("Accept", "application/json");
                urlConnection.connect();

                builder = new StringBuilder();
                System.out.println(urlConnection.getResponseCode());
                if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {

                    System.out.println("Connection established, retrieving Challenge data");
                    InputStream stream = new BufferedInputStream(urlConnection.getInputStream());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

                    while ((line = reader.readLine()) != null) {

                        builder.append(line);

                    }
                    reader.close();


                } else {

                    System.out.println("Error connecting server");

                }
                urlConnection.disconnect();
                Gson gson = new Gson();
                String partJSON = builder.toString();
                Type type = new TypeToken<List<Participation>>() {
                }.getType();
                participations = gson.fromJson(partJSON, type);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        for (int i = 0; i < participations.size(); i++) {
            System.out.println(participations.get(i).getVoilier().getNom());

        }
        return participations;
    }
}
