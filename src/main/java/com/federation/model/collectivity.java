package com.federation.model;

import java.util.List;

public class Collectivity {
    private String id;
    private String id_number;
    private String name;
    private String location;
    private List<Member> members;

    public Collectivity() {
    }

    public Collectivity(String id, String id_number, String name, String location, List<Member> members) {
        this.id = id;
        this.id_number = id_number;
        this.name = name;
        this.location = location;
        this.members = members;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}