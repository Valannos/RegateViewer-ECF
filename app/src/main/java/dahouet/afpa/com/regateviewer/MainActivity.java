package dahouet.afpa.com.regateviewer;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.afpa.dahouet.adapter.ListRegateAdapter;
import com.afpa.dahouet.model.Challenge;
import com.afpa.dahouet.model.Regate;
import com.afpa.dahouet.provider.ChallengeProvider;
import com.afpa.dahouet.provider.RegateProvider;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;



public class MainActivity extends AppCompatActivity {

    private TextView textView_currentChallenge;
    private ListView listView_currentRegate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_currentChallenge = (TextView) findViewById(R.id.textView_currentChallenge);
        Challenge currentChallenge = null;

        ChallengeProvider challengeProvider = new ChallengeProvider();
        challengeProvider.execute();

        try {

            currentChallenge = challengeProvider.get();


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        if (currentChallenge.getId().charAt(0) == 'H')
            textView_currentChallenge.setText(textView_currentChallenge.getText() + getString(R.string.winter) + " " + currentChallenge.getId().substring(1));
        else
            textView_currentChallenge.setText(textView_currentChallenge.getText() + getString(R.string.summer) + " " + currentChallenge.getId().substring(1));


        RegateProvider regateProvider = new RegateProvider();
        regateProvider.execute();
        List<Regate> regates = new ArrayList<>();

        try {
            regates = regateProvider.get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        listView_currentRegate = (ListView) findViewById(R.id.ListView_Regates);
        ListRegateAdapter listRegateAdapter = new ListRegateAdapter(this, regates);
        listView_currentRegate.setAdapter(listRegateAdapter);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        deleteCache(this);
    }

    public static void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            deleteDir(dir);
        } catch (Exception e) {}
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if(dir!= null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }


}


