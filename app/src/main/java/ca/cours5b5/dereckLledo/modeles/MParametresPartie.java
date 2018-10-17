package ca.cours5b5.dereckLledo.modeles;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.dereckLledo.exceptions.ErreurSerialisation;
import ca.cours5b5.dereckLledo.serialisation.AttributSerialisable;

public class MParametresPartie extends Modele{

    @AttributSerialisable
    public Integer hauteur;
    protected  final String __hauteur = "hauteur";

    @AttributSerialisable
    public Integer largeur;
    protected  final String __largeur = "largeur";

    @AttributSerialisable
    public Integer pourGagner;
    protected  final String __pourGagner = "pourGagner";


    public static MParametresPartie aPartirMParametres( MParametres mParametres){

        //A ENLEVER, SEULEMENT POUR TESTER
        return new MParametresPartie();
    }

//    public MParametresPartie cloner(){
//
//    }
//
//    public MParametresPartie(){
//    }
//
//    public Integer getHauteur() {
//        return hauteur;
//    }
//
//    public Integer getLargeur() {
//        return largeur;
//    }
//
//    public Integer getPourGagner() {
//        return pourGagner;
//    }
//
//    public void setHauteur(int hauteur){
//
//    }
//
//    public void setLargeur(int largeur){
//
//    }
//    public void setPourGagner(int pourGagner){
//
//    }
//
    @Override
    public void aPartirObjetJson(Map<String, Object> objectJson) throws ErreurSerialisation{

    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation{


        /* A ENLEVER SEULEMENT POUR LES TEST */
        Map<String, Object> objetJson = new HashMap<>();

        objetJson.put(__hauteur, hauteur.toString());
        objetJson.put(__largeur, largeur.toString());
        objetJson.put(__pourGagner, pourGagner.toString());

        return objetJson;
    }
}
