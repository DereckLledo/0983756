package ca.cours5b5.derecklledo.activites;




import android.os.Bundle;
import android.util.Log;
import android.widget.Spinner;

import ca.cours5b5.derecklledo.R;

public class AParametres extends Activite {


    Spinner spinnerHaut;
    Spinner spinnerLargeur;
    Spinner spinnerGagner;


    int hautTemp;
    int largTemp;
    int gagnerTemp;

    static{Log.d("MonEtiquette", AParametres.class.getSimpleName() + "::static");}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);



        spinnerHaut = this.findViewById(R.id.spinnerHauteur);
        spinnerLargeur = this.findViewById(R.id.spinnerLargeur);
        spinnerGagner = this.findViewById(R.id.spinnerGagner);

        //si il y a une sauvegarde temporaire il va utiliser ces informations
        if ( savedInstanceState != null) {
            Log.d("MonEtiquette", "create -> savedInstanceState");
            spinnerHaut.setSelection(savedInstanceState.getInt("HauteurTemp"));
            spinnerLargeur.setSelection(savedInstanceState.getInt("LargeurTemp"));
            spinnerGagner.setSelection(savedInstanceState.getInt("GagnerTemp"));


        }



    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
        hautTemp = spinnerHaut.getSelectedItemPosition();
        largTemp =  spinnerLargeur.getSelectedItemPosition();
        gagnerTemp = spinnerGagner.getSelectedItemPosition();

        Log.d("MonEtiquette", "haut: "+(Integer.toString(hautTemp)));
        Log.d("MonEtiquette","larg: " +(Integer.toString(largTemp)));
        Log.d("MonEtiquette","gagne: " + (Integer.toString(gagnerTemp)));

        Bundle outState = new Bundle();
        //position du spinner HAUTEUR
        outState.putInt("HauteurTemp", hautTemp);

        //position du spinner LARGEUR
        outState.putInt("LargeurTemp", largTemp);


        //position du spinner Gagner
        outState.putInt("GagnerTemp", gagnerTemp);

        this.onSaveInstanceState(outState);


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
