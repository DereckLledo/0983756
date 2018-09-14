
package ca.cours5b5.derecklledo.vues;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import ca.cours5b5.derecklledo.R;
import ca.cours5b5.derecklledo.global.GConstantes;

public class VParametres extends Vue {

    public VParametres(Context context){
        super(context);
    }

    public  VParametres(Context context, AttributeSet attrs) {
        super(context,attrs);
    }

    public  VParametres(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();


        //spinner hauteur
        Spinner spinnerHaut = this.findViewById(R.id.spinnerHauteur);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        spinnerHaut.setAdapter(adapter);

        //position des chiffres dans le spinner
        int position = 0;

        //ajoute les int dans le spinner selon les variables constantes
        for (int i= GConstantes.MIN_HAUTEUR; i <= GConstantes.MAX_HAUTEUR; i++) {
            adapter.add(i);

            //
            if (i == GConstantes.DEFAUT_HAUTEUR) {
                spinnerHaut.setSelection(position);
            }

            position++;

        }


        //spinner largeur
        Spinner spinnerLarg = this.findViewById(R.id.spinnerLargeur);
        ArrayAdapter<Integer> adapterLarg = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        spinnerLarg.setAdapter(adapterLarg);

        //position des chiffres dans le spinner
        position = 0;

        //ajoute les int dans le spinner selon les variables constantes
        for (int i= GConstantes.MIN_LARGEUR; i <= GConstantes.MAX_LARGEUR; i++) {
            adapterLarg.add(i);

            //
            if (i == GConstantes.DEFAUT_LARGEUR) {
                spinnerLarg.setSelection(position);
            }

            position++;
        }



        //spinner gagnant
        Spinner spinnerGagner = this.findViewById(R.id.spinnerGagner);
        ArrayAdapter<Integer> adapterGagner = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        spinnerGagner.setAdapter(adapterGagner);

        //position des chiffres dans le spinner
        position = 0;

        //ajoute les int dans le spinner selon les variables constantes
        for (int i= GConstantes.MIN_GAGNER; i <= GConstantes.MAX_GAGNER; i++) {
            adapterGagner.add(i);

            //
            if (i == GConstantes.DEFAUT_GAGNER) {
                spinnerGagner.setSelection(position);
            }

            position++;
        }


    }


}