package com.app.suit.customviewp.room;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

/************************************************************
 *
 *
 *                   .::::.
 *                  .::::::::.
 *                 :::::::::::  COME ON BABY
 *             ..:::::::::::'
 *           '::::::::::::'
 *             .::::::::::
 *        '::::::::::::::..
 *             ..::::::::::::.
 *           ``::::::::::::::::
 *            ::::``:::::::::'        .:::.
 *           ::::'   ':::::'       .::::::::.
 *         .::::'      ::::     .:::::::'::::.
 *        .:::'       :::::  .:::::::::' ':::::.
 *       .::'        :::::.:::::::::'      ':::::.
 *      .::'         ::::::::::::::'         ``::::.
 *  ...:::           ::::::::::::'              ``::.
 * ```` ':.          ':::::::::'                  ::::..
 *                    '.:::::'                    ':'````..
 *
 *************************************************************
 * @author: 李刘欢
 * @date：2019/8/9 14:55
 * @version:1.0.0
 * @description: WordViewModel
 */
public class WordViewModel extends AndroidViewModel {
    private LiveData<List<Word>> mAllWord;
    private WordRepository mRepository;
    public WordViewModel(@NonNull Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWord = mRepository.getAllWords();
    }

    public LiveData<List<Word>> getAllWord() {
        return mAllWord;
    }

    public WordRepository getRepository() {
        return mRepository;
    }
    public void deleteAll(){
        mRepository.deleteAll();
    }
    public void insert(Word word) {
        mRepository.insert(word);
    }
}
