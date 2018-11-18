package ca.cours5b5.derecklledo.donnees;

import android.os.Bundle;

import java.util.Map;


import ca.cours5b5.derecklledo.serialisation.Jsonification;

public class SauvegardeTemporaire extends SourceDeDonnees {

    private Bundle bundle;

    public SauvegardeTemporaire(Bundle bundle){
        this.bundle = bundle;
    }

    @Override
    public Map<String, Object> chargerModele(String cheminSauvegarde) {

        //TODO: Utiliser getCle pour obtenir la clé de sauvegarde


        if(bundle != null && bundle.containsKey(cheminSauvegarde)){

            String json = bundle.getString(cheminSauvegarde);

            Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);

            return objetJson;

        }else{

            return null;

        }
    }

    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objetJson) {
        //TODO: Utiliser getCle pour obtenir la clé de sauvegarde

        if(bundle != null){

            String json = Jsonification.enChaineJson(objetJson);
            bundle.putString(cheminSauvegarde, json);

        }
    }

    @Override
    public void detruireSauvegarde(String cheminSauvegarde){
        //todo: Peut-etre a modifier
    }

    private String getCle(String cheminSauvegarde){
        /*
            Utiliser le nomModele comme clé de sauvegarde

            ex: MPartie/Timrietmeriterjuin2390128 => MPartie
         */
        //TODO: Utiliser getCle pour obtenir la clé de sauvegarde
        return null;
    }

}