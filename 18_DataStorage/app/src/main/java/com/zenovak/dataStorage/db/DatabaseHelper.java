package com.zenovak.dataStorage.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.zenovak.dataStorage.db.dao.ContactDao;
import com.zenovak.dataStorage.db.entity.Contact;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "app_db";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ContactDao.CREATE_TABLE);
        // ...other tables
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ContactDao.TABLE_NAME);
        onCreate(db);
    }

    // Insert Data
    public long insertContact(String name, @Nullable String num, @Nullable String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(ContactDao.COLUMN_NAME, name);
        values.put(ContactDao.COLUMN_NUM, num);
        values.put(ContactDao.COLUMN_EMAIL, email);

        long id =  db.insert(ContactDao.TABLE_NAME, null, values);
        db.close();

        return  id;
    }

    public Contact getContact(long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(ContactDao.TABLE_NAME,
                new String[]{
                        ContactDao.COLUMN_ID,
                        ContactDao.COLUMN_NAME,
                        ContactDao.COLUMN_NUM,
                        ContactDao.COLUMN_EMAIL
                },
                ContactDao.COLUMN_ID  + "=?",
                new String[]{
                        String.valueOf(id)
                },
                null,
                null,
                null,
                null
            );

        if (cursor != null)
            cursor.moveToFirst();

        Contact contact = new Contact(
                cursor.getInt(cursor.getColumnIndexOrThrow(ContactDao.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndexOrThrow(ContactDao.COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndexOrThrow(ContactDao.COLUMN_NUM)),
                cursor.getString(cursor.getColumnIndexOrThrow(ContactDao.COLUMN_EMAIL))
        );

        db.close();
        return contact;
    }

    public ArrayList<Contact> getAllContacts() {
        var contacts = new ArrayList<Contact>();
        SQLiteDatabase db = this.getReadableDatabase();

        var cursor = db.query(ContactDao.TABLE_NAME,
                new String[]{
                        ContactDao.COLUMN_ID,
                        ContactDao.COLUMN_NAME,
                        ContactDao.COLUMN_NUM,
                        ContactDao.COLUMN_EMAIL
                },
                null,
                null,
                null,
                null,
                null
                );
        if (cursor != null)
            cursor.moveToFirst();

        while (true) {
            contacts.add(new Contact(
                    cursor.getInt(cursor.getColumnIndexOrThrow(ContactDao.COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(ContactDao.COLUMN_NAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(ContactDao.COLUMN_NUM)),
                    cursor.getString(cursor.getColumnIndexOrThrow(ContactDao.COLUMN_EMAIL))
            ));

            if (cursor.isLast()) {
                break;
            }
            cursor.moveToNext();
        }

        cursor.close();
        return  contacts;
    }
}
