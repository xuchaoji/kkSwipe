package com.xuchaoji.recycler.kk.utils;

public class CommonUtil {
    public static int randomBetween(int m, int n, int skip) {
        // 如果m大于n，交换两者的值
        if (m > n) {
            int temp = m;
            m = n;
            n = temp;
        }
        // 生成一个[m, n]之间的随机整数
        int ramdom = (int) (Math.random() * (n - m + 1)) + m;
        if (ramdom == skip) {
            ramdom = randomBetween(m, n, skip);
        }
        return ramdom;
    }
}
