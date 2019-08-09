package com.app.suit.customviewp.room;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

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
 * @date：2019/8/9 14:52
 * @version:1.0.0
 * @description: WordRepository  Repository类用于访问多个数据源。Repository并不是架构组件库的一部分，
 * 而是代码解耦和架构比较推荐的方法。Repository类处理数据操作
 */
public class WordRepository {
    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    public WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getWordAll();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        new InsertAsyncTask(mWordDao).execute(word);
    }

    public void deleteAll(){
        mWordDao.deleteAll();
    }
    private class InsertAsyncTask extends AsyncTask<Word, Void, Void> {
        private WordDao mAsyncDao;

        InsertAsyncTask(WordDao wordDao) {
            this.mAsyncDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            mAsyncDao.insert(words[0]);
            return null;
        }
    }
}
