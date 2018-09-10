package ca.cours5b5.derecklledo.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import ca.cours5b5.derecklledo.R;

public class AParametres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);
        Log.d("MonEtiquette",this.getResources().getString(R.string.bonjour) + " " + this.getResources().getString(R.string.orientation));
    }
}
