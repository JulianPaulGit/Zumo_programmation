package com.pauljulian.zumo_programmation;

public enum Action {

    AVANCE_PREMIER_TRAIT(200, "J'avance jusqu'au premier trait."),
    AVANCE_SECOND_TRAIT(200, "J'avance jusqu'au second trait"),
    DEBUT_PROGRAMMATION(200, "C'est le début de la programmation"),
    FIN_PROGRAMMATION(200, "C'est la fin de la programmation");

    private int id;
    private String description;

    // Constructeur
    Action(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
