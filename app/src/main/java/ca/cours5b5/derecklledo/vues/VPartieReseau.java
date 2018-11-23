package ca.cours5b5.derecklledo.vues;

import android.content.Context;
import android.util.AttributeSet;

import ca.cours5b5.derecklledo.R;
import ca.cours5b5.derecklledo.controleurs.ControleurObservation;
import ca.cours5b5.derecklledo.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.derecklledo.exceptions.ErreurObservation;
import ca.cours5b5.derecklledo.modeles.MParametresPartie;
import ca.cours5b5.derecklledo.modeles.MPartie;
import ca.cours5b5.derecklledo.modeles.MPartieReseau;
import ca.cours5b5.derecklledo.modeles.Modele;


public class VPartieReseau extends VPartie {


    private VGrille grille;


    public VPartieReseau(Context context) {
        super(context);
    }

    public VPartieReseau(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VPartieReseau(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected String getNomModele(){
        return MPartieReseau.class.getSimpleName();
    }

}
