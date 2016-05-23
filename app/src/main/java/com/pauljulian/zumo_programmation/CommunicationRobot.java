package com.pauljulian.zumo_programmation;


public final class CommunicationRobot {

    /**
     * Cette méthode envoie au robot une valeur et attend l'ACK (accusé de reception)
     * Une fois ACK reçu, la méthode se termine
     * @param valeur valeur à convertir en byte et à envoyer au robot
     */
    public static void sendInt(int valeur) {

    }

    /**
     * Cette méthode attent de l'information de la part du robot
     * Mettre une délai au delà du quel le programme doit se débloquer
     * @return le byte converti en int
     */
    public static int waitForInformation() {

        return -1;
    }


}
