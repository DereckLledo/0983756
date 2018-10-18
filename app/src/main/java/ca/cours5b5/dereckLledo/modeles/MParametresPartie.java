package ca.cours5b5.dereckLledo.modeles;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.dereckLledo.exceptions.ErreurSerialisation;
import ca.cours5b5.dereckLledo.global.GConstantes;
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


    //si il n'y a aucun parametre changé
    public MParametresPartie(){
        this.setHauteur(GConstantes.HAUTEUR_PAR_DEFAUT);
        this.setLargeur(GConstantes.LARGEUR_PAR_DEFAUT);
        this.setPourGagner(GConstantes.POUR_GAGNER_PAR_DEFAUT);

    }


    public static MParametresPartie aPartirMParametres( MParametres mParametres){
        MParametresPartie paramPartie = new MParametresPartie();

        paramPartie.setHauteur(mParametres.getHauteur());
        paramPartie.setLargeur (mParametres.getLargeur());
        paramPartie.setPourGagner(mParametres.getPourGagner());


        return paramPartie;
    }

    public MParametresPartie cloner(){
        MParametresPartie paramClone = new MParametresPartie();

        paramClone.hauteur = this.hauteur;
        paramClone.largeur = this.largeur;
        paramClone.pourGagner = this.pourGagner;

        return paramClone;

    }


    public Integer getHauteur() {
        return this.hauteur;
    }

    public Integer getLargeur() {
        return this.largeur;
    }

    public Integer getPourGagner() {
        return this.pourGagner;
    }

    public void setHauteur(int hauteur){
        this.hauteur = hauteur;
    }

    public void setLargeur(int largeur){
        this.largeur = largeur;
    }
    public void setPourGagner(int pourGagner){
        this.pourGagner = pourGagner;
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation{
        for(Map.Entry<String, Object> entry : objetJson.entrySet()){

            String chaineValeur = (String) entry.getValue();

            switch (entry.getKey()){

                case __hauteur:

                    hauteur = Integer.valueOf(chaineValeur);
                    break;

                case __largeur:

                    largeur = Integer.valueOf(chaineValeur);
                    break;


                case __pourGagner:

                    largeur = Integer.valueOf(chaineValeur);
                    break;

                default:

                    throw new ErreurSerialisation("Attribut inconnu: " + entry.getKey());
            }
        }
    }

    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation{


        Map<String, Object> objetJson = new HashMap<>();

        objetJson.put(__hauteur, hauteur.toString());
        objetJson.put(__largeur, largeur.toString());
        objetJson.put(__pourGagner, pourGagner.toString());

        return objetJson;
    }
}
