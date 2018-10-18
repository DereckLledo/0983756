package ca.cours5b5.dereckLledo.controleurs;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.dereckLledo.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.dereckLledo.modeles.MParametres;
import ca.cours5b5.dereckLledo.modeles.MPartie;
import ca.cours5b5.dereckLledo.modeles.Modele;
import ca.cours5b5.dereckLledo.vues.VPartie;

public class ControlleurObservation {

    private static Map<Modele, ListenerObservateur> observations;

    //L'attribut est private: la vue doit obtenir le modele par l'observation
    private static MPartie partie;

    static {
        observations = new HashMap<>();
    }

    public static void observerModele(String nomModele, final ListenerObservateur listenerObservateur){
        /* Enregistrer le listener dans le Map observations
         */
        Log.d("MonEtiquette", ControlleurObservation.class.getSimpleName() + "::observerModele");

        observations.put(MParametres.instance, listenerObservateur);

        partie = new MPartie(MParametres.instance.getParametresPartie());

        listenerObservateur.reagirNouveauModele(partie);



    }
}
