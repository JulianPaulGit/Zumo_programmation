package com.pauljulian.zumo_programmation;

import java.util.ArrayList;

public class ThreadNouveauTour extends Thread {

    private ArrayList<Action> arrayListActions;

    public ThreadNouveauTour(ArrayList<Action> arrayListActions) {
        super();
        this.arrayListActions = arrayListActions;
    }

    @Override
    public void run() {
        super.run();

        // Communique au robot qu'il va lui donner une série d'instructions
        CommunicationRobot.sendInt(Action.DEBUT_PROGRAMMATION.getId());

        // Tant qu'il y a des actions à envoyer, il les exécute
        while (!arrayListActions.isEmpty()) {
            CommunicationRobot.sendInt(arrayListActions.get(0).getId());
        }

        // Communique au robot que la série d'instruction est terminée
        CommunicationRobot.sendInt(Action.FIN_PROGRAMMATION.getId());

    }
}
