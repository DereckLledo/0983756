package ca.cours5b5.dereckLledo.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridLayout;

import java.util.List;

public class VGrille extends GridLayout {

    public VGrille(Context context){

    }


    public VGrille(Context context, AttributeSet attrs){

    }

    public VGrille(Context context, AttributeSet attrs, int defStyleAttr){

    }

    private int nombreRangees;

    //mémoriser les en-tetes
    private List<VEntete> entetes;

    //mémoriser les VCase ajoutées (avec un tableau à deux dimensions)
    private VCase[][] lesCases;

  /*  // OU: mémoriser les VCase ajoutées avec des listes
    private class Colonne extends ArrayList<VCase>{}
    private List<Colonne> colonnesDeCases;*/

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    void creerGrille(int hauteur, int largeur){

    }

    //mémoriser les VCases avec un tableau
    private void initialiserTableauDeCases(int hauteur, int largeur){

    }

    private void ajouterEnTetes(int largeur){

    }

    private LayoutParams getMiseEnPageEntete(int colonne){

    }

    private void ajouterCases(int hauteur, int largeur){

    }

    private LayoutParams getMiseEnPageCase(int rangee, int colonne){

    }

}
