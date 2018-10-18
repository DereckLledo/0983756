package ca.cours5b5.dereckLledo.activites;


import android.os.Bundle;
import android.util.Log;

import java.util.Map;

import ca.cours5b5.dereckLledo.R;
import ca.cours5b5.dereckLledo.modeles.MParametres;
import ca.cours5b5.dereckLledo.serialisation.Jsonification;


public class AParametres extends Activite {

    static{
        Log.d("MonEtiquette", AParametres.class.getSimpleName() + "::static");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

        if(savedInstanceState != null){
            restaurerParametres(savedInstanceState);
        }
    }

    private void restaurerParametres(Bundle savedInstanceState){

        String cle = MParametres.class.getSimpleName();
        String json = savedInstanceState.getString(cle);

        Log.d("MonEtiquette", AParametres.class.getSimpleName() + "::restaurerParametres, clé: " + cle);
        Log.d("MonEtiquette", AParametres.class.getSimpleName() + "::restaurerParametres, json:\n" + json);

        Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);



    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("MonEtiquette", AParametres.class.getSimpleName() + "::onSaveInstanceState");
        sauvegarderParametres(outState);

    }

    private void sauvegarderParametres(Bundle outState){

        String cle = MParametres.class.getSimpleName();
        Map<String, Object> objetJson = MParametres.instance.enObjetJson();

        String json = Jsonification.enChaineJson(objetJson);

        Log.d("MonEtiquette", AParametres.class.getSimpleName() + "::sauvegarderParametres, clé: " + cle);
        Log.d("MonEtiquette", AParametres.class.getSimpleName() + "::sauvegarderParametres, json: \n" + json);

        outState.putString(cle, json);
    }
}
