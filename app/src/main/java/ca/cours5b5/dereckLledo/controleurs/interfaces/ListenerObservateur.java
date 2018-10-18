package ca.cours5b5.dereckLledo.controleurs.interfaces;

import android.util.Log;

import ca.cours5b5.dereckLledo.controleurs.ControlleurObservation;
import ca.cours5b5.dereckLledo.modeles.Modele;

public abstract class ListenerObservateur {

    public void reagirNouveauModele(Modele modele){
        /*
            L'implantation par défaut est d'appler reagirChangementAuModele
         */

        reagirChangementAuModele(modele);
        Log.d("MonEtiquette", ListenerObservateur.class.getSimpleName() + "::reagirNouveauModele");
    }

    public abstract void reagirChangementAuModele(Modele modele);
}
