package com.app.suit.customviewp;

import android.util.Log;

import org.w3c.dom.Node;

import java.util.ArrayList;
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
 * @date：2019/8/9 10:57
 * @version:1.0.0
 * @description: Test2
 */
public class Test2 {
    /**
     * @param n
     * @param z 目前只支持2
     */
    private static void countNumber(int n, int z) {
        if (z < 1 || n < z) {
            throw new IllegalArgumentException("非法参数");
        }
        int minCount;
        if (n % z == 0) {
            minCount = n / z;
        } else {
            minCount = n / z + 1;
        }
        List<Node<Integer>> list = new ArrayList<>();
        for (int i = 0; i < z; i++) {
            Node<Integer> startNode = new Node<Integer>(null, i * minCount, null);
            list.add(startNode);
        }
        for (int i = 0; i < z; i++) {
            Node<Integer> f = list.get(i);
            Node<Integer> temp = f;
            int size;
            if (i == z - 1) {
                size = n - (i - 1) * minCount;
            } else {
                size = temp.e + minCount;
            }
            System.out.println("起始位置---"+temp.e);
            for (int j = temp.e; j < size; j++) {
                Node<Integer> tempNode = new Node<Integer>(temp, j+1, null);
                temp.next = tempNode;
                temp = tempNode;
            }
            Node t =f;
            while (t.next != null) {
                System.out.println("第" + i + "组====" + t.e);
                t = t.next;
            }
            temp.next = f;
        }
    }

    static class Node<T> {
        Node pre;
        Node next;
        T e;

        public Node(Node pre, T e, Node next) {
            this.pre = pre;
            this.next = next;
            this.e = e;
        }
    }

    public static void main(String[] ags) {
        countNumber(13, 2);
    }
}
