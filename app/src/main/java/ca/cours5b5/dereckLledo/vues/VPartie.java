package ca.cours5b5.dereckLledo.vues;

import android.content.Context;
import android.util.AttributeSet;

import ca.cours5b5.dereckLledo.modeles.MPartie;
import ca.cours5b5.dereckLledo.modeles.Modele;

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

//    @Override
//    protected void onFinishInflate() {
//        super.onFinishInflate();
//    }
//
//
//    private void observerPartie(){
//        /*
//        Appelet observer pour obtenir le modele
//        Une fois le modele obtenu, créer la grille d'affichage
//         */
//    }
//
//    private MPartie getPartie(Modele modele){
//
//    }
//
//    private void initialiserGrille(MPartie partie){
//
//    }
}
