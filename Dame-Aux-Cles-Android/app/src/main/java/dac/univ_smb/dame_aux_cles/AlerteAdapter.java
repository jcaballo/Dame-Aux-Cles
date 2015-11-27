package dac.univ_smb.dame_aux_cles;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import dac.univ_smb.dame_aux_cles.model.Alerte;

/**
 * Created by jujulejaffa on 23/11/15.
 */
public class AlerteAdapter extends ArrayAdapter<Alerte> {

    //alertes est la liste des alertes à afficher
    public AlerteAdapter(Context context, List<Alerte> alertes) {
        super(context, 0, alertes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_alerte,parent, false);
        }

        AlerteViewHolder viewHolder = (AlerteViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new AlerteViewHolder();
            viewHolder.destinatairealerte = (TextView) convertView.findViewById(R.id.textViewCol1);
            viewHolder.delaisalertes = (TextView) convertView.findViewById(R.id.textViewCol2);
            viewHolder.messagealerte = (TextView) convertView.findViewById(R.id.textViewCol3);
            viewHolder.pjalerte = (TextView) convertView.findViewById(R.id.textViewCol4);

            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Alerte alerte = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.destinatairealerte.setText(alerte.getDestinatairealerte());
        viewHolder.delaisalertes.setText(alerte.getDelaisalertes().toString());
        viewHolder.messagealerte.setText(alerte.getMessagealerte().toString());
        viewHolder.pjalerte.setText(alerte.getPjalerte().toString());


        return convertView;
    }

    private class AlerteViewHolder{
        public TextView destinatairealerte;
        public TextView delaisalertes;
        public TextView messagealerte;
        public TextView pjalerte;
    }
}
