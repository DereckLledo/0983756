package ca.cours5b5.dereckLledo.activites;

import android.os.Bundle;
import android.util.Log;

import java.util.Map;

import ca.cours5b5.dereckLledo.R;
import ca.cours5b5.dereckLledo.modeles.MParametres;
import ca.cours5b5.dereckLledo.serialisation.Jsonification;

public class APartie extends Activite{
    static{
        Log.d("Atelier06", AParametres.class.getSimpleName() + "::static");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartie);

//        if(savedInstanceState != null){
//            restaurerParametres(savedInstanceState);
//        }
    }

//    private void restaurerParametres(Bundle savedInstanceState){
//
//        String cle = MParametres.class.getSimpleName();
//        String json = savedInstanceState.getString(cle);
//
//        Log.d("Atelier06", AParametres.class.getSimpleName() + "::restaurerParametres, clé: " + cle);
//        Log.d("Atelier06", AParametres.class.getSimpleName() + "::restaurerParametres, json:\n" + json);
//
//        Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);
//
//        MParametresPartie.instance = new MParametresPartie();
//
//        MParametresPartie.instance.aPartirObjetJson(objetJson);
//
//    }


}
