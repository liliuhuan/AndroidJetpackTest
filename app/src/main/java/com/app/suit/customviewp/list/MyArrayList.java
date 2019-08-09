package com.app.suit.customviewp.list;

import android.support.annotation.NonNull;

import java.util.Iterator;

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
 * @date：2019/8/8 10:46
 * @version:1.0.0
 * @description: MyArrayList
 */
public class MyArrayList<T> implements Iterable<T> {
    private static final int DEFAULT_COUNT = 10;
    private int theSize;
    private T[] items;

    public MyArrayList() {
        doClear();

    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        theSize = 0;
        ensureCount(DEFAULT_COUNT);
    }

    private int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("越界");
        }
        return items[index];
    }

    public T set(int index, T t) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("越界");
        }
        T old = items[index];
        items[index] = t;
        return old;
    }

    public boolean add(T t) {
        add(size(), t);
        return true;
    }

    private void add(int index, T t) {
        if (items.length == size()) {
            ensureCount(size() * 2 + 1);
        }
        for (int i = index; i < size(); i++) {
            items[i + 1] = items[i];
        }
        items[index] = t;
        theSize++;
    }

    private void ensureCount(int defaultCount) {
        if (defaultCount < theSize) {
            return;
        }
        T[] old = items;
        items = (T[]) new Object[defaultCount];
        if (size() >= 0) System.arraycopy(old, 0, items, 0, size());
    }

    private T remove(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("越界");
        }
        T t = items[index];
        for (int i = index; i < size(); i++) {
            items[i] = items[index + 1];
        }
        theSize--;
        return t;
    }

    @NonNull
    @Override
    public Iterator<T> iterator() {
        return new MyIterator(this);
    }

    private class MyIterator<T> implements Iterator<T> {
        private int count;
        private MyArrayList<T> theItems;

        private MyIterator(MyArrayList<T> ts) {
            this.theItems = ts;
        }

        @Override
        public boolean hasNext() {
            return count < theItems.size();
        }

        @Override
        public T next() {
            if (hasNext()) {
                return  theItems.items[count++];
            }
            return null;
        }

        @Override
        public void remove() {
            theItems.remove(--count);
        }
    }
}
