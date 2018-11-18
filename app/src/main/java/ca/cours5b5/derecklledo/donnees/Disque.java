package ca.cours5b5.derecklledo.donnees;

import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Map;

import ca.cours5b5.derecklledo.global.GConstantes;
import ca.cours5b5.derecklledo.serialisation.Jsonification;

public final class Disque extends SourceDeDonnees {

    private static final Disque instance = new Disque();

    public static Disque getInstance() {
        return instance;
    }

    private File repertoireRacine;

    private Disque() {}

    public void setRepertoireRacine(File repertoireRacine) {

        this.repertoireRacine = repertoireRacine;

    }

    @Override
    public Map<String, Object> chargerModele(String cheminSauvegarde) {

        File fichier = getFichier(cheminSauvegarde);

        try {

            String json = new String(Files.readAllBytes(fichier.toPath()));

            Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);

            return objetJson;

        } catch (FileNotFoundException e) {

            return null;

        } catch (IOException e) {

            return null;

        }
    }

    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objetJson) {

        File fichier = getFichier(cheminSauvegarde);

        String json = Jsonification.enChaineJson(objetJson);

        try {

            OutputStream outputStream = new FileOutputStream(fichier);

            outputStream.write(json.getBytes());

        } catch (FileNotFoundException e) {

            Log.d("Atelier07", "File not found: " + cheminSauvegarde);

        } catch (IOException e) {

            Log.d("Atelier07", "IOException: " + cheminSauvegarde);

        }
    }

    @Override
    public void detruireSauvegarde(String cheminSauvegarde){
        //todo: Peut-etre a modifier
      //  getFichier(cheminSauvegarde).delete();
    }


    private File getFichier(String nomModele) {

        /*
            Obtenir le nomModele et l'utiliser pour le nom du fichier

            ex: MParametres/Timf083247djhER13817 => MParametres.json
         */
        //TODO: MODIFIER CET METHODE



        String nomFichier = "";


        int couperNomModele = nomModele.indexOf('/');

        if (couperNomModele > 0){
            String modele = nomModele.substring(0,couperNomModele);

            nomFichier = getNomFichier(modele);

        } else {
            nomFichier = getNomFichier(nomModele);
        }

        Log.d("atelier11+", "Disque: getFichier :" + nomFichier);


        return new File(repertoireRacine, nomFichier);

    }

    private String getNomFichier(String nomModele) {

        return nomModele + GConstantes.EXTENSION_PAR_DEFAUT;

    }

}
