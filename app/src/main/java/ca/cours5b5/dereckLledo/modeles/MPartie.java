package ca.cours5b5.dereckLledo.modeles;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.dereckLledo.exceptions.ErreurSerialisation;
import ca.cours5b5.dereckLledo.serialisation.AttributSerialisable;

public class MPartie extends Modele{

    @AttributSerialisable
    public MParametresPartie parametres;
    private final String __parametres = "parametres";



    public MPartie(MParametresPartie parametres){
        this.parametres = parametres;
    }

    public MParametresPartie getParametres(){ return this.parametres; }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation{
        /*inutilisé pour l'instant*/

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation{
        /*inutilisé pour l'instant*/

        /* A ENLEVER SEULEMENT POUR LES TEST */
        Map<String, Object> objetJson = new HashMap<>();

        objetJson.put(__parametres, parametres.toString());

        return objetJson;

    }
}
