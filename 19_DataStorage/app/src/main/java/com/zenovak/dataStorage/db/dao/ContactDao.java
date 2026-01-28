package com.zenovak.dataStorage.db.dao;

public class ContactDao {
    // constants for db
    public static final String TABLE_NAME = "contacts";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_NUM = "num";
    public static final String COLUMN_EMAIL = "email";

    public static final String CREATE_TABLE = String.format(
        "CREATE TABLE IF NOT EXISTS %s (" +
        "%s INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
        "%s STRING NOT NULL, \n" +
        "%s STRING, \n" +
        "%s STRING " +
        ")",
            TABLE_NAME,
            COLUMN_ID,
            COLUMN_NAME,
            COLUMN_NUM,
            COLUMN_EMAIL
    );
}
