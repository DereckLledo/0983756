package ca.cours5b5.derecklledo.activites;

import android.os.Bundle;

import ca.cours5b5.derecklledo.R;
import ca.cours5b5.derecklledo.controleurs.ControleurAction;
import ca.cours5b5.derecklledo.controleurs.ControleurModeles;
import ca.cours5b5.derecklledo.controleurs.interfaces.Fournisseur;
import ca.cours5b5.derecklledo.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.derecklledo.global.GCommande;
import ca.cours5b5.derecklledo.modeles.MPartie;
import ca.cours5b5.derecklledo.vues.VGrille;

public class APartie extends Activite implements Fournisseur {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partie);

        fournirActionTerminerPartie();

    }


    private void fournirActionTerminerPartie() {

        ControleurAction.fournirAction(this,
                GCommande.TERMINER_PARTIE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        quitterCetteActivite();
                        //efface les donnees de la partie lorsqu'elle se termine
                        ControleurModeles.detruireModele(MPartie.class.getSimpleName());


                    }
                });
    }


    @Override
    protected void onPause() {
        super.onPause();
        sauvegarderPartie();
    }


    protected void sauvegarderPartie(){
        ControleurModeles.sauvegarderModele(MPartie.class.getSimpleName());
    }


}