package ca.cours5b5.dereckLledo.activites;

import android.os.Bundle;
import android.util.Log;

import java.util.Map;

import ca.cours5b5.dereckLledo.R;
import ca.cours5b5.dereckLledo.controleurs.ControleurObservation;
import ca.cours5b5.dereckLledo.modeles.MParametres;
import ca.cours5b5.dereckLledo.serialisation.Jsonification;
import ca.cours5b5.dereckLledo.modeles.MPartie;

public class APartie extends Activite{

    static{
        Log.d("MonEtiquette", APartie.class.getSimpleName() + "::static");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MonEtiquette", APartie.class.getSimpleName() + "::onCreate");


        if(savedInstanceState != null){
            Log.d("MonEtiquette",APartie.class.getSimpleName() + "::savedInstance" );
            restaurerParametres(savedInstanceState);
        }

        setContentView(R.layout.activity_apartie);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        this.sauvegarderParametres(outState);
    }


    private void restaurerParametres(Bundle savedInstanceState){

        String cle = MPartie.class.getSimpleName();
        String json = savedInstanceState.getString(cle);

        Log.d("MonEtiquette", APartie.class.getSimpleName() + "::restaurerParametres, clé: " + cle);
        Log.d("MonEtiquette", APartie.class.getSimpleName() + "::restaurerParametres, json:\n" + json);

        Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);
        Log.d("MonEtiquette",objetJson.toString() );

        MParametres.instance.aPartirObjetJson(objetJson);


    }

    private void sauvegarderParametres(Bundle outState){

        String cle = MPartie.class.getSimpleName();

        Map<String, Object> objetJson = ControleurObservation.getPartie().enObjetJson();

        String json = Jsonification.enChaineJson(objetJson);


        outState.putString(cle, json);
        Log.d("MonEtiquette", APartie.class.getSimpleName() +  "::sauvegarderParametres, clé: " + cle);


    }



}
