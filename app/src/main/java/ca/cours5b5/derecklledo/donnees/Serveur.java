package ca.cours5b5.derecklledo.donnees;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class Serveur extends  SourceDeDonnees{
//TODO: TOUT MODIFIER ICI
       // Serveur est un singleton



    private Serveur(){}

    private static final Serveur instance = new Serveur();

    public static Serveur getInstance(){
        return instance;
    }


    public void chargerModele(final String cheminSauvegarde, final ListenerChargement listenerChargement) {

        //TODO: il y a eu modification dans la signature!!

        //chemin de la sauvegarde doit etre nomModele/idUsager
        Log.d("atelier12+", "Serveur::nomModele/idUsager = " + cheminSauvegarde);

        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);


        noeud.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    Map<String, Object> objetJson = (Map<String, Object>) dataSnapshot.getValue();

                    Log.d("atelier12+", "Serveur::chargeModele::" + cheminSauvegarde);

                    //Données lues
                    listenerChargement.reagirSuccess(objetJson);
                } else {
                    //Pas de données dans ce noeud
                    Log.d("atelier12+", "Serveur::chargeModele::ERREUR");
                    listenerChargement.reagirErreur(new Exception("Pas de données"));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                listenerChargement.reagirErreur(new Exception("Erreur de lecture"));
            }
        });

    }


    public  void sauvegarderModele(final String cheminSauvegarde, final Map<String, Object> objetJson){
        //    Sauvegarder sur le serveur
        //    Utiliser FirebaseDatabase et DatabaseReference
        Log.d("atelier11+", "Serveur: sauvegarderModele + " + cheminSauvegarde);
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
