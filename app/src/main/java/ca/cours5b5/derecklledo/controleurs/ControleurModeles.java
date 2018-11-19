package ca.cours5b5.derecklledo.controleurs;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.derecklledo.controleurs.interfaces.Fournisseur;
import ca.cours5b5.derecklledo.controleurs.interfaces.ListenerGetModele;
import ca.cours5b5.derecklledo.donnees.ListenerChargement;
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

    static Modele getModele(final String nomModele, ListenerGetModele listenerGetModele){

        //TODO: nouvelle signature
        Log.d("atelier12++", "ControleurModeles::getModele");

        Modele modele = modelesEnMemoire.get(nomModele);


        //condition 1
        if(modele == null){

            creerModeleEtChargerDonnees(nomModele,listenerGetModele);

        } else {
            listenerGetModele.reagirAuModele(modele);
        }

        return modele;
    }

    public static void detruireSauvegarde(String nomModele) {
        Log.d("atelier11+", "ControleurModeles: detruireSauvegarde");
        String cheminSauvegarde = getCheminSauvegarde(nomModele);
        for(SourceDeDonnees source : listeDeSauvegardes ) {
            source.detruireSauvegarde(cheminSauvegarde);
        }
    }

/*
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

    */

    public static void sauvegarderModele(String nomModele) throws ErreurModele {

        for(SourceDeDonnees source : listeDeSauvegardes){

            sauvegarderModeleDansCetteSource(nomModele, source);

        }

    }


    private static void creerModeleSelonNom(String nomModele, final ListenerGetModele listenerGetModele) throws ErreurModele {

        //TODO: nouvelle signature

        /**ajout**
         *
         * Attention aux trois conditions
         * Attention a la méthode creerModeleEtChargerDonnes qui doit aussi memorise le modele
         */
        /* code atelier 11
        if(nomModele.equals(MParametres.class.getSimpleName())){

            return new MParametres();

        }else if(nomModele.equals(MPartie.class.getSimpleName())){

            MParametres mParametres = (MParametres) getModele(MParametres.class.getSimpleName());

            return new MPartie(mParametres.getParametresPartie().cloner());

        }else{

            throw new ErreurModele("Modèle inconnu: " + nomModele);

        }*/


        if (nomModele.equals(MParametres.class.getSimpleName())){
            MParametres mParametres = new MParametres();
            listenerGetModele.reagirAuModele(mParametres);

        } else if ( nomModele.equals(MPartie.class.getSimpleName())) {


            getModele(MParametres.class.getSimpleName(), new ListenerGetModele() {
                @Override
                public void reagirAuModele(Modele modele) {
                    MParametres mParametres = (MParametres) modele;

                    MPartie mPartie = new MPartie(mParametres.getParametresPartie().cloner());

                    listenerGetModele.reagirAuModele(mPartie);
                }
            });

        } else {
            throw new ErreurModele("Modèle inconnu: " + nomModele);
        }



    }

    private static void creerModeleEtChargerDonnees (final String nomModele, final ListenerGetModele listenerGetModele){
        /**
         * Aussi: mémoriser le modele dans modelesEnMemoire
         */

        Log.d("atelier12++", "ControleurModeles::creerModeleEtChargerdonnees");

        creerModeleSelonNom(nomModele, new ListenerGetModele() {
            @Override
            public void reagirAuModele(Modele modele) {
                //instruction A
                modelesEnMemoire.put(nomModele,modele);
                chargerDonnees(modele, nomModele, listenerGetModele);
            }
        });




    }

    private static void chargerDonnees(Modele modele,
                                       String nomModele,
                                       ListenerGetModele listenerGetModele) {

        Log.d("atelier12++", "ControleurModeles::chargerDonnees");

        String chemin = getCheminSauvegarde(nomModele);

        Log.d("atelier12+", "ControleurModeles::chargéDonner:: " + chemin);
        chargementViaSequence(modele,chemin,listenerGetModele,0);

    }

    private static void chargementViaSequence(Modele modele,
                                              String cheminDeSauvegarde,
                                              ListenerGetModele listenerGetModele,
                                              int indiceSourceCourante){

        Log.d("atelier12++", "ControleurModeles::chargementViaSequence");

            //Condition 2: si on a utilisé toutes les SourceDeDonnees de la SequenceDeChargement
        if (indiceSourceCourante >= sequenceDeChargement.length){
            terminerChargement(modele,listenerGetModele);
        } else {
            chargementViaSourceCouranteOuSuivante(modele,cheminDeSauvegarde,listenerGetModele,indiceSourceCourante);
        }

    }

    private static void chargementViaSourceCouranteOuSuivante (final Modele modele,
                                                               final String cheminDeSauvegarde,
                                                               final ListenerGetModele listenerGetModele,
                                                               final int indiceSourceCourante) {

        //Condition 3 (dans SourceDeDonnees): si le chargement réussit ou échoue
        Log.d("atelier12++", "ControleurModeles::chargementViaSourceCouranteOuSuivante::sequence" + indiceSourceCourante + " " +  sequenceDeChargement[indiceSourceCourante] );

        sequenceDeChargement[indiceSourceCourante].chargerModele(cheminDeSauvegarde, new ListenerChargement() {
            @Override
            public void reagirSuccess(Map<String, Object> objetJson) {
                terminerChargementAvecDonnees(objetJson,modele,listenerGetModele);
            }

            @Override
            public void reagirErreur(Exception e) {
                chargementViaSourceSuivante(modele,cheminDeSauvegarde,listenerGetModele,indiceSourceCourante);
            }
        });

    }

    private static void terminerChargementAvecDonnees(Map<String, Object> objetJson, Modele modele, ListenerGetModele listenerGetModele){

        modele.aPartirObjetJson(objetJson);
        terminerChargement(modele, listenerGetModele);

    }

    private static void terminerChargement (Modele modele, ListenerGetModele listenerGetModele) {
        listenerGetModele.reagirAuModele(modele);
    }

    private static void chargementViaSourceSuivante (Modele modele,
                                                     String cheminDeSauvegarde,
                                                     ListenerGetModele listenerGetModele,
                                                     int indiceSourceCourante) {

        chargementViaSequence(modele,cheminDeSauvegarde,listenerGetModele,indiceSourceCourante+1);

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

    //TODO: AJOUTs atelier 12



}
