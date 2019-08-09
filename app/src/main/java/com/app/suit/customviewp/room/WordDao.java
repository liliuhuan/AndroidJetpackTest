package com.app.suit.customviewp.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

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
 * @date：2019/8/9 14:48
 * @version:1.0.0
 * @description: WordDao  DAO，即数据访问接口。可以将SQL查询语句与方法相关联。
 */
@Dao
public interface  WordDao {
    @Insert
    void insert(Word word);

    @Query("select * from word_table order by word asc")
    List<Word> queryAll();

    @Query("delete from word_table")
    void deleteAll();

    @Query("select * from word_table order by word asc")
    LiveData<List<Word>> getWordAll();
}
