/*
 * Copyright 2019-2119 gao_xianglong@sina.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.bo;

import java.util.Scanner;

/**
 * @author gao_xianglong@sina.com
 * @version 0.1-SNAPSHOT
 * @date created in 2022/5/17 00:18
 */
public class Starter {
    public static void main(String[] args) {
        new Starter().run();
    }

    private void run() {
        var scan = new Scanner(System.in);
        var c = 0;
        c += bo01(scan);
        c += bo02(scan);
        c += bo03(scan);
        c += bo04(scan);
        c += bo05(scan);
        c += bo06(scan);
        c += bo07(scan);
        c += bo08(scan);
        c += bo09(scan);
        System.out.println(String.format("=========================\n" +
                "correct rate:%.2f", (double) c / 5 * 9) + "%");
    }

    /**
     * &运算,5道题
     */
    private int bo01(Scanner scan) {
        System.out.println("一、&运算");
        return template(scan, "&", 1);
    }

    /**
     * |运算,5道题
     */
    private int bo02(Scanner scan) {
        System.out.println("二、|运算");
        return template(scan, "|", 2);
    }

    /**
     * ^运算,5道题
     */
    private int bo03(Scanner scan) {
        System.out.println("三、^运算");
        return template(scan, "^", 3);
    }

    /**
     * <<运算,5道题
     */
    private int bo04(Scanner scan) {
        System.out.println("四、<<运算");
        return template(scan, "<<", 4);
    }

    /**
     * >>运算,5道题
     */
    private int bo05(Scanner scan) {
        System.out.println("五、<<运算");
        return template(scan, ">>", 5);
    }

    /**
     * +运算,5道题
     */
    private int bo06(Scanner scan) {
        System.out.println("六、+运算");
        return template(scan, "+", 6);
    }

    /**
     * -运算,5道题
     */
    private int bo07(Scanner scan) {
        System.out.println("七、-运算");
        return template(scan, "-", 7);
    }

    /**
     * *运算,5道题
     */
    private int bo08(Scanner scan) {
        System.out.println("八、*运算");
        return template(scan, "*", 8);
    }

    /**
     * /运算,5道题
     */
    private int bo09(Scanner scan) {
        System.out.println("九、/运算");
        return template(scan, "/", 9);
    }

    private int template(Scanner scan, String sign, int t) {
        var c = 5;
        var n = 1;
        var s = 0;
        do {
            var s1 = getBinaryString();
            var s2 = getBinaryString();
            System.out.println(String.format("%s、%s %s %s\ninput:", n++, s1, sign, s2));
            var r = operation(s1, s2, scan.nextLine(), t);
            System.out.println(String.format("result:%s\n", r));
            s = r ? ++s : s;
            --c;
        }
        while (c > 0);
        return s;
    }

    private boolean operation(String s1, String s2, String i, int t) {
        var result = false;
        switch (t) {
            case 1 -> result = (parseInt(s1) & parseInt(s2)) == parseInt(i);
            case 2 -> result = (parseInt(s1) | parseInt(s2)) == parseInt(i);
            case 3 -> result = (parseInt(s1) ^ parseInt(s2)) == parseInt(i);
            case 4 -> result = (parseInt(s1) << parseInt(s2)) == parseInt(i);
            case 5 -> result = (parseInt(s1) >> parseInt(s2)) == parseInt(i);
            case 6 -> result = (parseInt(s1) + parseInt(s2)) == parseInt(i);
            case 7 -> result = (parseInt(s1) - parseInt(s2)) == parseInt(i);
            case 8 -> result = (parseInt(s1) * parseInt(s2)) == parseInt(i);
            case 9 -> result = (parseInt(s1) / parseInt(s2)) == parseInt(i);
        }
        return result;
    }

    private int parseInt(String s) {
        return Integer.parseInt(s, 2);
    }

    /**
     * 获取8bit的原码
     *
     * @return
     */
    private String getBinaryString() {
        var buf = new StringBuffer();
        // 确保都是正数
        buf.append("0");
        for (int i = 0; i < 7; i++) {
            buf.append((int) (Math.random() * 2));
        }
        return buf.toString();
    }
}