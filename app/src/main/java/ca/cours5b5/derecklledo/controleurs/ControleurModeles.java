package ca.cours5b5.derecklledo.controleurs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.derecklledo.controleurs.interfaces.Fournisseur;
import ca.cours5b5.derecklledo.donnees.Serveur;
import ca.cours5b5.derecklledo.donnees.SourceDeDonnees;
import ca.cours5b5.derecklledo.exceptions.ErreurModele;
import ca.cours5b5.derecklledo.modeles.MParametres;
import ca.cours5b5.derecklledo.modeles.MParametresPartie;
import ca.cours5b5.derecklledo.modeles.MPartie;
import ca.cours5b5.derecklledo.modeles.Modele;
import ca.cours5b5.derecklledo.donnees.Disque;
import ca.cours5b5.derecklledo.usagers.UsagerCourant;

public final class ControleurModeles {

    private ControleurModeles(){}

    private static Map<String, Modele> modelesEnMemoire;

    private static SourceDeDonnees[] sequenceDeChargement;

    private static List<SourceDeDonnees> listeDeSauvegardes;

    static {

        modelesEnMemoire = new HashMap<>();

        listeDeSauvegardes = new ArrayList<>();
        listeDeSauvegardes.add(Disque.getInstance());
        listeDeSauvegardes.add(Serveur.getInstance());

    }

    public static void setSequenceDeChargement(SourceDeDonnees... sequenceDeChargement){

        ControleurModeles.sequenceDeChargement = sequenceDeChargement;

    }

    public static void sauvegarderModeleDansCetteSource(String nomModele, SourceDeDonnees sourceDeDonnees) {

        Modele modele = modelesEnMemoire.get(nomModele);

        if(modele != null){

            Map<String, Object> objetJson = modele.enObjetJson();

            sourceDeDonnees.sauvegarderModele(getCheminSauvegarde(nomModele), objetJson);

        }
    }

    static Modele getModele(final String nomModele){

        Modele modele = modelesEnMemoire.get(nomModele);

        if(modele == null){

            modele =  chargerViaSequenceDeChargement(nomModele);

        }

        return modele;
    }


    private static Modele chargerViaSequenceDeChargement(final String nomModele){

        Modele modele = creerModeleSelonNom(nomModele);

        modelesEnMemoire.put(nomModele, modele);

        for(SourceDeDonnees sourceDeDonnees : sequenceDeChargement){

            Map<String, Object> objetJson = sourceDeDonnees.chargerModele(nomModele);

            if(objetJson != null){

                modele.aPartirObjetJson(objetJson);
                break;

            }

        }

        return modele;
    }

    public static void sauvegarderModele(String nomModele) throws ErreurModele {

        for(SourceDeDonnees source : listeDeSauvegardes){

            sauvegarderModeleDansCetteSource(nomModele, source);

        }

    }


    private static Modele creerModeleSelonNom(String nomModele) throws ErreurModele {

        if(nomModele.equals(MParametres.class.getSimpleName())){

            return new MParametres();

        }else if(nomModele.equals(MPartie.class.getSimpleName())){

            MParametres mParametres = (MParametres) getModele(MParametres.class.getSimpleName());

            return new MPartie(mParametres.getParametresPartie().cloner());

        }else{

            throw new ErreurModele("Modèle inconnu: " + nomModele);

        }
    }

    public static void detruireModele(String nomModele) {

        Modele modele = modelesEnMemoire.get(nomModele);

        if(modele != null){

            modelesEnMemoire.remove(nomModele);

            ControleurObservation.detruireObservation(modele);

            if(modele instanceof Fournisseur){

                ControleurAction.oublierFournisseur((Fournisseur) modele);

            }
        }
    }

    public static String getCheminSauvegarde(String nomModele) {
        /*
            Le chemin est de la forme:

        nomModele/idUsager

        ex:

        MPartie/T1m4328789hw98129dnWe12
                */
        return nomModele + "/" + UsagerCourant.getId();
    }

}
