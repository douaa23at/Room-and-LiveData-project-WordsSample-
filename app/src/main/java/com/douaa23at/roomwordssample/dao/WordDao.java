package com.douaa23at.roomwordssample.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.douaa23at.roomwordssample.model.Word;

import java.util.List;

/**
 * Created by douaa.atouailaa on 07/05/2019.
 */
@Dao
public interface WordDao {
    @Insert
    void insert(Word word);
    @Query("DELETE FROM word_table")
    void deleteAll();
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();
}
