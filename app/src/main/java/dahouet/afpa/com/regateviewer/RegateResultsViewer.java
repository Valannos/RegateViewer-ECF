package dahouet.afpa.com.regateviewer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import com.afpa.dahouet.adapter.ListResultatsAdapter;
import com.afpa.dahouet.model.Participation;
import com.afpa.dahouet.model.Regate;
import com.afpa.dahouet.provider.ParticipationProvider;
import com.google.gson.Gson;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Afpa on 02/03/2017.
 */

public class RegateResultsViewer extends Activity {

    GridView results_grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        List<Participation> participations = null;
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regate_results);

        String jsonRegate = intent.getExtras().getString("REGATE_JSON");
        Regate regate = new Gson().fromJson(jsonRegate, Regate.class);

        ParticipationProvider provider = new ParticipationProvider();
        provider.execute(jsonRegate, "WITH_RESULT");
        try {
            participations = provider.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        for (Participation p : participations) {

            System.out.println(p.getTpsReel());
            System.out.println(p.getRank());

        }
        results_grid = (GridView) findViewById(R.id.results_grid);
        ListResultatsAdapter adapter = new ListResultatsAdapter(this, participations);
        results_grid.setAdapter(adapter);


    }
}
