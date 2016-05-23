package com.pauljulian.zumo_programmation;

import java.util.ArrayList;

public final class VerificationCommandes {

    private static ArrayList<Action> arrayListActions;

    /**
     * Cette méthode est la méthode principale de la classe, elle a pour objectif de déterminer si
     * le programme peut envoyer les actions au robot ou s'il y a une erreur et l'utilisateur doit
     * revoir l'odre de ses choix d'actions élémentaires.
     * @param list Arraylist contenant les actions à envoyer au robot
     * @return erreurProgrammation "" si les actions peuvent être envoyées au robot sinon envoyer le message
     * d'erreur.
     */
    public static String verificationCommandes(ArrayList<Action> list) {
        arrayListActions = list;
        String erreurProgrammation = "";

        return  erreurProgrammation;
    }
}
