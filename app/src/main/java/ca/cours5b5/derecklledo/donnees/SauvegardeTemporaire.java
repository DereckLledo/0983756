package ca.cours5b5.derecklledo.donnees;

import android.os.Bundle;
import android.util.Log;

import java.util.Map;


import ca.cours5b5.derecklledo.exceptions.ErreurModele;
import ca.cours5b5.derecklledo.serialisation.Jsonification;

public class SauvegardeTemporaire extends SourceDeDonnees {

    private Bundle bundle;

    public SauvegardeTemporaire(Bundle bundle){
        this.bundle = bundle;
    }

    @Override
    public void chargerModele(String cheminSauvegarde, ListenerChargement listenerChargement) {

        //TODO: Utiliser getCle pour obtenir la clé de sauvegarde
        //TODO: il y a eu modification dans la signature!!

        if(bundle != null && bundle.containsKey(cheminSauvegarde)){

            String json = bundle.getString(cheminSauvegarde);

            Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);

            Log.d("atelier12+", "SauvegardeTemp::chargerModele = SUCCESS");
            listenerChargement.reagirSuccess(objetJson);

        }else{

            Log.d("atelier12+", "SauvegardeTemp::chargerModele = ERREUR");
            listenerChargement.reagirErreur(new ErreurModele("Pas de modele"));

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