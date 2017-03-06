package dahouet.afpa.com.regateviewer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.afpa.dahouet.adapter.ListParticipationAdapter;
import com.afpa.dahouet.model.Participation;
import com.afpa.dahouet.model.Regate;
import com.afpa.dahouet.provider.ParticipationProvider;
import com.google.gson.Gson;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Afpa on 01/03/2017.
 */

public class RegateDetailsViewer extends Activity {

    private TextView textView_RegateDetails_Title;
    private TextView textView_Distance;
    private TextView textView_comite_value;
    ListView list_participations;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        List<Participation> participations = null;
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regate_details);
        String jsonRegate = intent.getExtras().getString("REGATE_JSON");
        Regate regate = new Gson().fromJson(jsonRegate, Regate.class);

        textView_RegateDetails_Title = (TextView) findViewById(R.id.textView_Regate_id);
        textView_RegateDetails_Title.setText(textView_RegateDetails_Title.getText() + " " + regate.getId());

        textView_Distance = (TextView) findViewById(R.id.textView_Distance);
        textView_Distance.setText(textView_Distance.getText() + " : " + regate.getDistance());

        textView_comite_value = (TextView) findViewById(R.id.textView_comite_value);
        String comite = "";
        for (int i = 0; i < regate.getCommissaires().size(); i++) {

            if (i != 0) comite += "\n";
            comite += regate.getCommissaires().get(i).getFirstname() + " " + regate.getCommissaires().get(i).getName() + " (" + regate.getCommissaires().get(i).getNameComite() + ")";
            if (i == regate.getCommissaires().size() - 1) comite += ".";


        }
        textView_comite_value.setText(comite);
        list_participations = (ListView) findViewById(R.id.list_participations);

        ParticipationProvider provider = new ParticipationProvider();

        provider.execute(jsonRegate, "NO_RESULT");
        try {


           participations = provider.get();


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        ListParticipationAdapter listParticipationAdapter = new ListParticipationAdapter(this, participations);
        list_participations.setAdapter(listParticipationAdapter);


    }
}
