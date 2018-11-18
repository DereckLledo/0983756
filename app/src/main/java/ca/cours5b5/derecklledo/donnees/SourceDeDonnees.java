package ca.cours5b5.derecklledo.donnees;

import android.util.Log;

import java.util.Map;


public abstract class SourceDeDonnees {

    public abstract void chargerModele(final String cheminSauvegarde, final ListenerChargement listenerChargement);

    public abstract void sauvegarderModele(final String cheminSauvegarde, final Map<String, Object> objetJson);

    protected String getNomModele(String cheminSauvegarde) {
        /*
            Pour un chemin de sauvegarde de la forme nomModele/ID

            retourner le nomModele
         */
        //TODO: MODIFIER CETTE METHODE

        String modele = "";


        int couperNomchemin = cheminSauvegarde.indexOf('/');

        if (couperNomchemin > 0){

            modele = cheminSauvegarde.substring(0,couperNomchemin);


        } else {
            modele = cheminSauvegarde;
        }

        Log.d("atelier11+", "SourceDeDonnes: getFichier :" + modele);

        return modele;
    }

    public abstract void detruireSauvegarde(final String cheminSauvegarde);

}
