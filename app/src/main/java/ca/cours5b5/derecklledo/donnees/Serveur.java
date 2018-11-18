package ca.cours5b5.derecklledo.donnees;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

public class Serveur extends  SourceDeDonnees{
//TODO: TOUT MODIFIER ICI
       // Serveur est un singleton



    private Serveur(){}

    private static final Serveur instance = new Serveur();

    public static Serveur getInstance(){
        return instance;
    }


    public Map<String, Object> chargerModele(final String cheminSauvegarde){
        //TODO: modifier les méthodes
         //   Bonus: est-ce possible d'implanter cette méthode avec cette signature?


        return null;
    }


    public  void sauvegarderModele(final String cheminSauvegarde, final Map<String, Object> objetJson){
        //    Sauvegarder sur le serveur
        //    Utiliser FirebaseDatabase et DatabaseReference
        Log.d("atelier11+", "Serveur: sauvegarderModele");
        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);
        noeud.setValue(objetJson);


    }

    @Override
    public void detruireSauvegarde(String cheminSauvegarde){
        Log.d("atelier11+", "Serveur: detruireSauvegarde");
        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);
        noeud.removeValue();

    }

}
