package com.douaa23at.roomwordssample.config;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.douaa23at.roomwordssample.dao.WordDao;
import com.douaa23at.roomwordssample.model.Word;

/**
 * Created by douaa.atouailaa on 07/05/2019.
 */
@Database(entities = {Word.class},version = 1,exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {
    private static WordRoomDatabase INSTANCE;
    public abstract WordDao wordDao();
    public static WordRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (WordRoomDatabase.class){
             INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                     WordRoomDatabase.class,"word_database")
                     .fallbackToDestructiveMigration()
                     .build();
            }
        }
        return INSTANCE;
    }
}
