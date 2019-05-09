package com.douaa23at.roomwordssample.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.douaa23at.roomwordssample.Repository.WordRepository;
import com.douaa23at.roomwordssample.model.Word;

import java.util.List;

/**
 * Created by douaa.atouailaa on 09/05/2019.
 */

public class WordViewModel extends AndroidViewModel{
    private WordRepository mRepository;
    private LiveData<List<Word>> mAllWords;

    public WordViewModel(Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
    }
    public LiveData<List<Word>> getAllWords() { return mAllWords; }
    public void insert(Word word) { mRepository.insert(word); }
}
