package com.zenovak.dataStorage.db.entity;

import androidx.annotation.Nullable;

public class Contact {
    private int id;
    private String name;
    private String num;
    private String email;

    public Contact(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Contact(int id, String name, @Nullable String num, @Nullable String email) {
        this.id = id;
        this.name = name;
        this.num = num;
        this.email = email;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getNum() { return num; }
    public String getEmail() { return email; }
}
