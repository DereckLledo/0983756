package ca.cours5b5.dereckLledo.controleurs;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.dereckLledo.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.dereckLledo.modeles.MParametres;
import ca.cours5b5.dereckLledo.modeles.MPartie;
import ca.cours5b5.dereckLledo.modeles.Modele;

public class ControleurObservation {

    private static Map<Modele, ListenerObservateur> observations;


    private static MPartie partie;

    static {
        observations = new HashMap<>();
    }

    public static void observerModele(String nomModele, final ListenerObservateur listenerObservateur){
        /* Enregistrer le listener dans le Map observations
         */
        Log.d("MonEtiquette", ControleurObservation.class.getSimpleName() + "::observerModele + " + nomModele);


        if ( nomModele.equals(MPartie.class.getSimpleName())){

            partie = new MPartie(MParametres.instance.getParametresPartie().cloner());
            observations.put(partie,listenerObservateur);
            listenerObservateur.reagirNouveauModele(partie);

        } else {

            observations.put(MParametres.instance, listenerObservateur);
            listenerObservateur.reagirNouveauModele(MParametres.instance);
        }

    }


    public static MPartie getPartie() {
        return partie;
    }

}
