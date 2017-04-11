package com.example.utils.domain;

/**
 * Created by isabelcosta on 28/03/2017.
 */
public class User {

    /**
     * Attributes
     */
    private int id;
    private String name;
    private String password;
    private int accessLevel;

    /**
     * Constructor
     */
    public User(int id, String name, String password, int accessLevel) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.accessLevel = accessLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }
}
