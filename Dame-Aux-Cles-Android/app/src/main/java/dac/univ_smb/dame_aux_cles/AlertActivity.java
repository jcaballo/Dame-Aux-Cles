package dac.univ_smb.dame_aux_cles;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dac.univ_smb.dame_aux_cles.model.Alerte;
import dac.univ_smb.dame_aux_cles.model.Personne;

public class AlertActivity extends ActionBarActivity {

    ListView listView;
    String login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_alert);
        listView = (ListView) findViewById(R.id.listViewAlerts);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                login= null;
            } else {
                login= extras.getString("login");
            }
        } else {
            login= (String) savedInstanceState.getSerializable("login");
        }
        AlertsTask alertsTask = new AlertsTask(login, this);

        alertsTask.execute((Void) null);
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

    public class AlertsTask extends AsyncTask<Void, Void, ResponseEntity<Alerte[]>> {

        private final String login;
        private final Activity mActivity;

        AlertsTask(String login, Activity activity) {
            mActivity = activity;
            this.login = login;
        }

        @Override
        protected ResponseEntity<Alerte[]> doInBackground(Void... params) {
            try {

                final String url = getString(R.string.serveur)+"/alerts/user?loginPersonne="+login;
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                ResponseEntity<Alerte[]> alertes = restTemplate.getForEntity(url, Alerte[].class);
                return alertes;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(final ResponseEntity<Alerte[]> alertes) {
            System.out.println(" -------------------------------------------- --- ");
            AlerteAdapter adapter = new AlerteAdapter(AlertActivity.this, new ArrayList<Alerte>(Arrays.asList(alertes.getBody())));
            listView.setAdapter(adapter);
        }

        @Override
        protected void onCancelled() {

        }
    }




}
