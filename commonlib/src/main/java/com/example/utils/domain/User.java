package com.example.utils.domain;

/**
 * Created by isabelcosta on 28/03/2017.
 */
public class User {

    /**
     * Attributes
     */
    private String id;
    private String name;
    private String password;
    private String accessLevel;

    /**
     * Constructor
     */
    public User(String id, String name, String password, String accessLevel) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.accessLevel = accessLevel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }
}
