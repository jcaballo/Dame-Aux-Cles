package dac.univ_smb.dame_aux_cles;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import dac.univ_smb.dame_aux_cles.model.Personne;

public class AlertActivity extends ActionBarActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        listView.findViewById(R.id.listViewAlerts);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Click ListItem Number " + position, Toast.LENGTH_LONG)
                        .show();
            }
        });
    }

    public class AlertsTask extends AsyncTask<Void, Void, Personne> {

        private final Activity mActivity;

        AlertsTask(Activity activity) {
            mActivity = activity;
        }

        @Override
        protected Personne doInBackground(Void... params) {
            try {
                final String url = "http://10.7.244.21:8081/alerts";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Personne personne = restTemplate.getForObject(url, Personne.class);
                return personne;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(final Personne personne) {

        }

        @Override
        protected void onCancelled() {

        }
    }




}
