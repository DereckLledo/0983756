package ca.cours5b5.derecklledo.activites;

import android.os.Bundle;
import android.util.Log;

import java.util.ResourceBundle;

import ca.cours5b5.derecklledo.R;
import ca.cours5b5.derecklledo.controleurs.ControleurAction;
import ca.cours5b5.derecklledo.controleurs.ControleurModeles;
import ca.cours5b5.derecklledo.controleurs.interfaces.Fournisseur;
import ca.cours5b5.derecklledo.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.derecklledo.donnees.Disque;
import ca.cours5b5.derecklledo.donnees.Serveur;
import ca.cours5b5.derecklledo.global.GCommande;
import ca.cours5b5.derecklledo.modeles.MParametres;
import ca.cours5b5.derecklledo.modeles.MPartie;

public class AParametres extends Activite implements Fournisseur{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);
        fournirActions();

    }
    private void fournirActions() {

        fournirActionEffacer();
    }

    private void fournirActionEffacer(){
        ControleurAction.fournirAction(this, GCommande.EFFACER, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {

                ControleurModeles.detruireSauvegarde(MParametres.class.getSimpleName());
                ControleurModeles.detruireSauvegarde(MPartie.class.getSimpleName());

                ControleurModeles.detruireModele(MParametres.class.getSimpleName());
                ControleurModeles.detruireModele(MPartie.class.getSimpleName());



            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("atelier11+", "AParametres.onPause:");
        ControleurModeles.sauvegarderModele(MParametres.class.getSimpleName());

    }

}
