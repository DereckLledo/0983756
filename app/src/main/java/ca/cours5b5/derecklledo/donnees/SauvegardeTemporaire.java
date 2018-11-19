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

        String cheminCle = getCle(cheminSauvegarde);
        Log.d("atelier12+", "SauvegardeTemp::chargerModele::cheminSauvegarde =  " + cheminCle);

        if(bundle != null && bundle.containsKey(cheminCle)){

            String json = bundle.getString(cheminCle);

            Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);

            Log.d("atelier12+", "SauvegardeTemp::chargerModele = SUCCESS");
            listenerChargement.reagirSuccess(objetJson);

        }else{

            Log.d("atelier12+", "SauvegardeTemp::chargerModele = ERREUR");
            listenerChargement.reagirErreur(new ErreurModele("Pas de donnees"));

        }
    }

    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objetJson) {
        //TODO: Utiliser getCle pour obtenir la clé de sauvegarde



        cheminSauvegarde = getCle(cheminSauvegarde);
        Log.d("atelier12+", "SauvegardeTemp::sauvegarderModele:(cle=nomModele):" + cheminSauvegarde);

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

        String cle = "";

        //substring avant le '/'
        int couperChemin = cheminSauvegarde.indexOf('/');

        if (couperChemin > 0){
            cle = cheminSauvegarde.substring(0,couperChemin);

        } else {
            cle = cheminSauvegarde;
        }


        return cle;
    }

}