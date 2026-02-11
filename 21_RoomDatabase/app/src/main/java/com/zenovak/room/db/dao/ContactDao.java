package com.zenovak.room.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.zenovak.room.db.entity.Contact;

import java.util.List;

@Dao
public interface ContactDao {

    @Insert
    long addContact(Contact Contact);

    @Query("SELECT * FROM contacts")
    List<Contact> getAllContact();

    @Query("SELECT * FROM contacts where id ==:id")
    Contact getContact(long id);

    @Update
    void updateContact(Contact contact);

    @Delete
    void deleteContact(Contact contact);
}
