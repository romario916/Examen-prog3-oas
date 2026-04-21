package com.federation.model;

public class CollectivityStructure {
    private String president;
    private String vicePresident;
    private String treasurer;
    private String secretary;

    public CollectivityStructure() {}

    // Getters
    public String getPresident() { return president; }
    public String getVicePresident() { return vicePresident; }
    public String getTreasurer() { return treasurer; }
    public String getSecretary() { return secretary; }

    // Setters
    public void setPresident(String president) { this.president = president; }
    public void setVicePresident(String vicePresident) { this.vicePresident = vicePresident; }
    public void setTreasurer(String treasurer) { this.treasurer = treasurer; }
    public void setSecretary(String secretary) { this.secretary = secretary; }
}
