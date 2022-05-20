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
    /**
     * 每一类型题目的数量
     */
    private int num = 15;

    public static void main(String[] args) {
        new Starter().run();
    }

    private void run() {
        var scan = new Scanner(System.in);
        var c = 0;
        c += bo01(scan);
        c += bo02(scan);
        c += bo03(scan);
//        c += bo04(scan);
//        c += bo05(scan);
        c += bo06(scan);
        c += bo07(scan);
        c += bo08(scan);
        //c += bo09(scan);
        System.out.println(String.format("=========================\n" +
                "correct rate:%.2f", ((double) c / (num * 6)) * 100) + "%");
    }

    /**
     * &运算
     */
    private int bo01(Scanner scan) {
        System.out.println("======='&运算'=======");
        return template(scan, 1);
    }

    /**
     * |运算
     */
    private int bo02(Scanner scan) {
        System.out.println("======='|运算'=======");
        return template(scan, 2);
    }

    /**
     * ^运算
     */
    private int bo03(Scanner scan) {
        System.out.println("======='^运算'=======");
        return template(scan, 3);
    }

    /**
     * <<运算
     */
    private int bo04(Scanner scan) {
        System.out.println("======='<<运算'=======");
        return template(scan, 4);
    }

    /**
     * >>运算
     */
    private int bo05(Scanner scan) {
        System.out.println("======='<<运算'=======");
        return template(scan, 5);
    }

    /**
     * +运算
     */
    private int bo06(Scanner scan) {
        System.out.println("======='+运算'=======");
        return template(scan, 6);
    }

    /**
     * -运算
     */
    private int bo07(Scanner scan) {
        System.out.println("======='-运算'=======");
        return template(scan, 7);
    }

    /**
     * *运算
     */
    private int bo08(Scanner scan) {
        System.out.println("======='*运算'=======");
        return template(scan, 8);
    }

    /**
     * /运算
     */
    private int bo09(Scanner scan) {
        System.out.println("======='/运算'=======");
        return template(scan, 9);
    }

    private int template(Scanner scan, int t) {
        var c = num;
        var s = 0;
        do {
            var s1 = getBinaryString(8 == t || 9 == t ? 4 : 8);
            var s2 = getBinaryString(8 == t || 9 == t ? 4 : 8);
            System.out.println(String.format("%s\n%s\ninput:", s1, s2));
            var rt = operation(s1, s2, scan.nextLine(), t);
            var r = rt.getSuccess();
            if (!r) {
                System.out.println(String.format("answer:%s", rt.getAnswer()));
            }
            System.out.println(String.format("result:%s\n", r));
            s = r ? ++s : s;
            --c;
        }
        while (c > 0);
        return s;
    }

    private Result operation(String s1, String s2, String i, int t) {
        s1 = trim(s1);
        s2 = trim(s2);
        i = trim(i);
        int r = -1;
        switch (t) {
            case 1 -> r = parse(s1) & parse(s2);
            case 2 -> r = parse(s1) | parse(s2);
            case 3 -> r = parse(s1) ^ parse(s2);
            case 4 -> r = parse(s1) << parse(s2);
            case 5 -> r = parse(s1) >> parse(s2);
            case 6 -> r = parse(s1) + parse(s2);
            case 7 -> r = parse(s1) - parse(s2);
            case 8 -> r = parse(s1) * parse(s2);
            case 9 -> r = parse(s1) / parse(s2);
        }
        return new Result((byte) r == (byte) parse(i), format((byte) r));
    }

    private String format(byte r) {
        var s = Integer.toBinaryString(r);
        return s.length() > 8 ? s.substring(s.length() - 8) : s;
    }

    /**
     * 去除字符串空格
     *
     * @param str
     * @return
     */
    private String trim(String str) {
        return str.replaceAll(" ", "");
    }

    private int parse(String s) {
        return Integer.parseInt(s, 2);
    }

    /**
     * 获取8bit的原码
     *
     * @return
     */
    private String getBinaryString(int bit) {
        var buf = new StringBuffer();
        // 确保都是正数
        buf.append("0 ");
        for (int i = 0; i < bit - 1; i++) {
            buf.append(String.format("%s%s", (int) (Math.random() * 2), " "));
        }
        return buf.toString();
    }

    private String getBinaryString() {
        return getBinaryString(8);
    }
}