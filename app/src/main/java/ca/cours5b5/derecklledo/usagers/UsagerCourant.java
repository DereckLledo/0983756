package ca.cours5b5.derecklledo.usagers;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;

public class UsagerCourant {

    public static boolean siUsagerConnecte(){
        /*
            Retourne vrai si l'usager est connecté

            Utiliser FirebaseAuth
         */
        boolean connecte = false;

        if (FirebaseAuth.getInstance().getCurrentUser()!= null ){
            connecte = true;
           // Log.d("atelier11+", FirebaseAuth.getInstance().getUid());
        }

        return connecte;
    }

    public static String getId(){
        /*
            Retourne l'identifiant de l'usager connecté
            Sinon retourner un ID par défaut

            Utiliser FirebaseAuth

         */
        if (siUsagerConnecte() ) {
            return FirebaseAuth.getInstance().getCurrentUser().getUid();
        } else {
            return FirebaseAuth.getInstance().getUid();
        }

    }
}
