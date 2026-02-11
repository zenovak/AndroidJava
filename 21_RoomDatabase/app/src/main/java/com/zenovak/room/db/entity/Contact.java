package com.zenovak.room.db.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacts",
        indices = {@Index(value = "email", unique = true)})
public class Contact {

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name ="email")
    private String email;

    @ColumnInfo(name ="id")
    @PrimaryKey(autoGenerate = true)
    private int id;

}
