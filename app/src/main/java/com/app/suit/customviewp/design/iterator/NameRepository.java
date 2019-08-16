package com.app.suit.customviewp.design.iterator;

import java.util.ArrayList;
import java.util.Arrays;
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
 * @date：2019/8/6 11:08
 * @version:1.0.0
 * @description: NameRepository
 */
public class NameRepository implements Container {
    private List<String> names ;

    public NameRepository(ArrayList names) {
        this.names = names;
    }

    @Override
    public Iterator<String> getIterator() {
        return new NameIterator(names);
    }

    private class NameIterator implements Iterator<String> {
        int index;
        private List<String> asList;

        NameIterator(List<String> asList) {
            this.asList = asList;
        }

        @Override
        public boolean hasNext() {
            if (asList == null || asList.size() == 0) return false;
            return index < asList.size();
        }

        @Override
        public String next() {
            if (this.hasNext()) {
                return asList.get(index++);
            }
            return null;
        }
        @Override
        public String remove() {
            return asList.remove(--index);
        }
    }
}
