package ca.cours5b5.dereckLledo.modeles;

import java.util.Map;

import ca.cours5b5.dereckLledo.exceptions.ErreurSerialisation;
import ca.cours5b5.dereckLledo.serialisation.AttributSerialisable;

public class MPartie extends Modele{

    @AttributSerialisable
    public MParametresPartie parametres;
    private final String __parametres = "parametres";

    public MPartie(MParametresPartie parametres){

    }

    public MParametresPartie getParametres(){

    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation{
        /*inutilisé pour l'instant*/

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation{
        /*inutilisé pour l'instant*/
    }
}
