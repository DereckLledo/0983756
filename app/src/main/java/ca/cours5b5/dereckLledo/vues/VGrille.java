package ca.cours5b5.dereckLledo.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.dereckLledo.modeles.MParametres;

public class VGrille extends GridLayout {

    public VGrille(Context context){
        super(context);
    }


    public VGrille(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public VGrille(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }

    private int nombreRangees;

    //mémoriser les en-tetes
    private List<VEntete> entetes;

    //mémoriser les VCase ajoutées (avec un tableau à deux dimensions)
    private VCase[][] lesCases;


    private class Colonne extends ArrayList<VCase> {}
    private List<Colonne> colonnesDeCases;

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        Log.d("MonEtiquette", VGrille.class.getSimpleName() + "::onFinishInflate");
    //    this.creerGrille(MParametres.instance.getHauteur(), MParametres.instance.getLargeur());
    }

    void creerGrille(int hauteur, int largeur){
        //on ajoute les en-tetes et les cases pour remplir le gridlayout
        ajouterEnTetes(largeur);
        ajouterCases(hauteur, largeur);

   }

    //mémoriser les VCases avec un tableau
    private void initialiserTableauDeCases(int hauteur, int largeur){

    }

    private void ajouterEnTetes(int largeur){

        this.entetes = new ArrayList<>();
        VEntete entete;
        for (int i = 0; i < largeur; i++){
            entete = new VEntete(this.getContext(), i);
            this.entetes.add(entete);
            this.addView(entete, getMiseEnPageEntete(i));
        }

    }

    private LayoutParams getMiseEnPageEntete(int colonne){
        int rangee = 0; //entete a toujours un range=0

        float poidsColonne = 0;
        float poidsRangee = 2;

        Spec specRangee = GridLayout.spec(rangee, poidsRangee);
        Spec specColonne = GridLayout.spec(colonne, poidsColonne);

        LayoutParams mesParams = new LayoutParams(specRangee, specColonne);

        mesParams.width = 0;
        mesParams.height = 0;
        mesParams.setGravity(Gravity.FILL);
        mesParams.rightMargin = 5;
        mesParams.leftMargin = 5;

        return mesParams;

    }

    //ajout des cases dynamiquement selon les parametres
    private void ajouterCases(int hauteur, int largeur){
        this.colonnesDeCases = new ArrayList<>();
        for (int i = 0; i < largeur; i++) {
            this.colonnesDeCases.add(new Colonne());
        }


        VCase vCase;
        //on fait double boucle, premiere pour les lignes (hauteur) et deuxiemes pour les colonnes(largeur)
        for (int i = 0; i < hauteur; i++){

            for ( int j = 0; j < largeur ; j++ ) {
                vCase = new VCase(this.getContext(),i,j);
                this.colonnesDeCases.get(j).add(vCase);

                //la hauteur = hauteur - i - 1
                this.addView(vCase,getMiseEnPageCase(hauteur-i-1,j));
            }

        }


    }

    private LayoutParams getMiseEnPageCase(int rangee, int colonne){
        float poidsRangee = 1;
        float poidsColonne = 1;


        //rangee+1 pour eviter len-tete

        Spec specRangee = GridLayout.spec(rangee+1, poidsRangee);
        Spec specColonne = GridLayout.spec(colonne, poidsColonne);

        LayoutParams mesParams = new LayoutParams(specRangee, specColonne);
        mesParams.width = 0;
        mesParams.height = 0;
        mesParams.setGravity(Gravity.FILL);
        mesParams.rightMargin = 5;
        mesParams.leftMargin = 5;

        return mesParams;

    }

}
