package com.douaa23at.roomwordssample.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.douaa23at.roomwordssample.config.WordRoomDatabase;
import com.douaa23at.roomwordssample.dao.WordDao;
import com.douaa23at.roomwordssample.model.Word;

import java.util.List;

/**
 * Created by douaa.atouailaa on 08/05/2019.
 */

public class WordRepository {
    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    public WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }
    LiveData<List<Word>> getAllWords(){
        return mAllWords;
    }
    public void insert (Word word){
        new insertAsyncTask(mWordDao).execute(word);
    }
    private static class insertAsyncTask extends AsyncTask<Word,Void,Void>{
        private WordDao mAsyncTaskDao;
        insertAsyncTask(WordDao wordDao){
            mAsyncTaskDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            mAsyncTaskDao.insert(words[0]);
            return null;
        }
    }
}
