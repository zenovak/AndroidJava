package com.zenovak.room.db;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.zenovak.room.db.dao.ContactDao;
import com.zenovak.room.db.entity.Contact;

@Database(version = 1, entities = {Contact.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract ContactDao contactDao();

}
