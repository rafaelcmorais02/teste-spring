package com.teste.wedding.models;

import java.util.UUID;

public class User {
    //#region Attributes
    private UUID id;
    private String name;
    private String email;
    //#endregion

    //#region Getters and Setters
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    //#endregion
}