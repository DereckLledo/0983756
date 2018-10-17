package ca.cours5b5.dereckLledo.controleurs;

import java.util.Map;

import ca.cours5b5.dereckLledo.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.dereckLledo.modeles.Modele;

public class ControlleurObservation {

    private static Map<Modele, ListenerObservateur> observation;

    static {

    }

    public static void observerModele(String nomModele, final ListenerObservateur listenerObservatuer){
        /* Enregistrer le listener dans le Map observations
         */
    }
}
