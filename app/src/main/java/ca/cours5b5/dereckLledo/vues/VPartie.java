package ca.cours5b5.dereckLledo.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import ca.cours5b5.dereckLledo.R;
import ca.cours5b5.dereckLledo.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.dereckLledo.modeles.MPartie;
import ca.cours5b5.dereckLledo.modeles.Modele;
import ca.cours5b5.dereckLledo.controleurs.ControleurObservation;

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

        ControleurObservation.observerModele(MPartie.class.getSimpleName(), new ListenerObservateur() {

            @Override
            public void reagirNouveauModele(Modele modele) {
                Log.d("MonEtiquette", VPartie.class.getSimpleName() + "::reagirNouveauModele");
                super.reagirNouveauModele(modele);
                MPartie partie = (MPartie) modele;
                initialiserGrille(partie);


            }

            @Override
            public void reagirChangementAuModele(Modele modele) {
                Log.d("MonEtiquette", VPartie.class.getSimpleName() + "::reagirChangementAuModele");
                MPartie partie = (MPartie) modele;
                initialiserGrille(partie);
            }


        });
    }


    private MPartie getPartie(Modele modele){
        //FIXME: null pour l'instant
        return null;
    }



    private void initialiserGrille(MPartie partie){

        Log.d("MonEtiquette", VPartie.class.getSimpleName() + "::initialiserGrille");
// FIXME: CA FONCTIONNE SI J'ENTRE DES CHIFFRE MANUELLEMENT MAIS CA CRASH SINON
        int hauteur = partie.getParametres().getHauteur();
        int largeur = partie.getParametres().getLargeur();

        this.grille.creerGrille(hauteur, largeur);

        //this.grille.creerGrille(4,4);


    }
}
