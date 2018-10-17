package ca.cours5b5.dereckLledo.controleurs.interfaces;

import ca.cours5b5.dereckLledo.modeles.Modele;

public abstract class ListenerObservateur {

    public void reagirNouveauModele(Modele modele){
        /*
            L'implantation par défaut est d'appler reagirChangementAuModele
         */
    }

    public abstract void reagirChangementAuModele(Modele modele);
}
