package ca.cours5b5.derecklledo.activites;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import ca.cours5b5.derecklledo.R;
import ca.cours5b5.derecklledo.vues.VMenuPrincipal;

public class AMenuPrincipal extends Activite {


    static {
        Log.d("MonEtiquette", AMenuPrincipal.class.getSimpleName() + "::static");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button boutonParametres = this.findViewById(R.id.bouton_parametres);

        boutonParametres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent monIntention = new Intent(AMenuPrincipal.this, AParametres.class);
                AMenuPrincipal.this.startActivity(monIntention);
            }
        });


    }

}
