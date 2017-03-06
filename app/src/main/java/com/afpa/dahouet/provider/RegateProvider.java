package com.afpa.dahouet.provider;

import android.os.AsyncTask;

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
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import dahouet.afpa.com.APISettings;

/**
 * Created by Afpa on 01/03/2017.
 */

public class RegateProvider extends AsyncTask<Void, Void, List<Regate>> {


    @Override
    protected List<Regate> doInBackground(Void... params) {

        List<Regate> regates = null;

        StringBuilder builder = null;
        HttpURLConnection urlConnection;
        String line;

        try {

            URL url = new URL(APISettings.getURI(APISettings.URI.GET_REGATES_FROM_CHALLENGE));
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
            String regJSON = builder.toString();
            Type type = new TypeToken<List<Regate>>() {
            }.getType();
            regates = gson.fromJson(regJSON, type);

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return regates;
    }

}
