package ca.cours5b5.derecklledo.activites;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.firebase.ui.auth.AuthUI;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.derecklledo.R;
import ca.cours5b5.derecklledo.controleurs.ControleurAction;
import ca.cours5b5.derecklledo.controleurs.interfaces.Fournisseur;
import ca.cours5b5.derecklledo.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.derecklledo.global.GCommande;
import ca.cours5b5.derecklledo.global.GConstantes;

public class AMenuPrincipal extends Activite implements Fournisseur {

    private static   List<AuthUI.IdpConfig> fournisseursDeConnexion = new ArrayList<>();

    static {

            fournisseursDeConnexion.add(new AuthUI.IdpConfig.GoogleBuilder().build());
            fournisseursDeConnexion.add(new AuthUI.IdpConfig.EmailBuilder().build());
            fournisseursDeConnexion.add(new AuthUI.IdpConfig.PhoneBuilder().build());

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        fournirActions();

    }

    private void fournirActions() {

        fournirActionOuvrirMenuParametres();

        fournirActionDemarrerPartie();

        fournirActionConnexion();

        //fournirActionDeconnexion();
    }

    private void fournirActionOuvrirMenuParametres() {

        ControleurAction.fournirAction(this,
                GCommande.OUVRIR_MENU_PARAMETRES,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        transitionParametres();

                    }
                });
    }

    private void fournirActionDemarrerPartie() {

        ControleurAction.fournirAction(this,
                GCommande.DEMARRER_PARTIE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        transitionPartie();

                    }
                });
    }

    private void fournirActionConnexion(){


        ControleurAction.fournirAction(this, GCommande.CONNEXION, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                transitionConnexion();
            }
        });





    }

    private void transitionParametres(){

        Intent intentionParametres = new Intent(this, AParametres.class);
        startActivity(intentionParametres);

    }

    private void transitionPartie(){

        Intent intentionParametres = new Intent(this, APartie.class);
        startActivity(intentionParametres);

    }

    private void transitionConnexion(){
        Intent intentionConnexion = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(fournisseursDeConnexion)
                .build();
        startActivityForResult(intentionConnexion, GConstantes.CODE_CONNEXION_FIREBASE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent Data) {
        if ( requestCode == GConstantes.CODE_CONNEXION_FIREBASE) {

            if (resultCode == RESULT_OK) {
                //Connexion réussie
                Log.d("atelier11+", "AMenuPrincipal -> connexion: TRUE");

            } else {
                //connexion échoué
                Log.d("atelier11+", "AMenuPrincipal -> connexion: FALSE");

            }
        }
    }



}
