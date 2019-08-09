package com.app.suit.customviewp.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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
 * @date：2019/8/9 14:46
 * @version:1.0.0
 * @description: Word  每个@Entity类表示一个数据库表中的实体
 */
@Entity(tableName = "word_table")
public class Word {
    @android.support.annotation.NonNull
    @PrimaryKey
    @ColumnInfo(name = "word")
    public String word = "1";

    @NonNull
    public String getWord() {
        return word;
    }

    public void setWord(@NonNull String word) {
        this.word = word;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Word){
            Word word = (Word) obj;
            return word.getWord().equals(this.word);
        }
        return super.equals(obj);
    }
}
