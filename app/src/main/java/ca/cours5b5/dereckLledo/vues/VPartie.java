package ca.cours5b5.dereckLledo.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import ca.cours5b5.dereckLledo.R;
import ca.cours5b5.dereckLledo.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.dereckLledo.modeles.MParametresPartie;
import ca.cours5b5.dereckLledo.modeles.MPartie;
import ca.cours5b5.dereckLledo.modeles.Modele;
import ca.cours5b5.dereckLledo.controleurs.ControlleurObservation;

public class VPartie extends Vue{

    private VGrille grille;

    public VPartie(Context context){
        super(context);
    }


    public VPartie(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public VPartie(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }

    static{
        Log.d("MonEtiquette", VPartie.class.getSimpleName() + "::static");
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d("MonEtiquette", VPartie.class.getSimpleName() + "::onFinishInflate");

        this.grille = this.findViewById(R.id.gridLayout);

        observerPartie();

        

    }


    private void observerPartie(){
        /*
        Appelet observer pour obtenir le modele
        Une fois le modele obtenu, créer la grille d'affichage
         */
        Log.d("MonEtiquette", VPartie.class.getSimpleName() + "::observerPartie");

        ControlleurObservation.observerModele(MPartie.class.getSimpleName(), new ListenerObservateur() {
            @Override
            public void reagirChangementAuModele(Modele modele) {

                MPartie partie = (MPartie) modele;
                initialiserGrille(partie);

            }

            @Override
            public void reagirNouveauModele(Modele modele) {
                MPartie partie = getPartie(modele);
                initialiserGrille(partie);

            }
        });
    }


    private MPartie getPartie(Modele modele){
        //FIXME: null pour l'instant
        return null;
    }



    private void initialiserGrille(MPartie partie){


// FIXME: CA FONCTIONNE SI J'ENTRE DES CHIFFRE MANUELLEMENT MAIS CA CRASH SINON
        int hauteur = partie.getParametres().getHauteur();
        int largeur = partie.getParametres().getLargeur();

        this.grille.creerGrille(hauteur, largeur);



    }
}
