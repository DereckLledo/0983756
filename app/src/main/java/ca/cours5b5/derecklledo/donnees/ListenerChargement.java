package ca.cours5b5.derecklledo.donnees;

import java.util.Map;

public interface ListenerChargement {

    void reagirSuccess(Map<String,Object> objetJson);
    void reagirErreur(Exception e);


}
