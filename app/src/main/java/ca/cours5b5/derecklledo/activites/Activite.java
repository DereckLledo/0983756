package ca.cours5b5.derecklledo.activites;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class Activite extends AppCompatActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        Log.d("MonEtiquette", this.getClass().getSimpleName() + "::onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MonEtiquette", this.getClass().getSimpleName() + "::onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MonEtiquette", this.getClass().getSimpleName() + "::onPause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d("MonEtiquette", this.getClass().getSimpleName() + "::onSaveInstanceState");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MonEtiquette", this.getClass().getSimpleName() + "::onDestroy");
    }
}
