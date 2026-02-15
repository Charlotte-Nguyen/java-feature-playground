package stream;

import java.util.ArrayList;
import java.util.List;

/**
 * =================================================
 * Stream vs 传统循环写法对比
 * =================================================
 *
 * 目标：
 * 从列表中筛选出偶数 → 再乘2 → 收集为新列表
 *
 * 用两种方式实现：
 * ① 传统循环（命令式编程）
 * ② Stream 流式（函数式编程）
 */
public class StreamVsLoopDemo {

    public static void main(String[] args) {

        /*
         * 原始数据
         */
        List<Integer> list = List.of(1,2,3,4,5);


        // =================================================
        // ① 传统写法（命令式编程）
        // =================================================

        /*
         * 命令式编程特点：
         * 👉 告诉程序“怎么做”
         *
         * 缺点：
         * ❌ 代码冗长
         * ❌ 逻辑分散
         * ❌ 可读性差
         * ❌ 不易链式处理
         */
        List<Integer> result = new ArrayList<>();

        for(Integer n : list){

            /*
             * 条件判断
             */
            if(n % 2 == 0){

                /*
                 * 业务处理逻辑
                 */
                result.add(n * 2);
            }
        }

        System.out.println(result);



        // =================================================
        // ② Stream写法（函数式编程）
        // =================================================

        /*
         * Stream 编程特点：
         * 👉 告诉程序“做什么”
         *
         * 流处理步骤：
         *
         * 1️⃣ 数据来源
         * 2️⃣ 中间操作
         * 3️⃣ 终止操作
         */
        List<Integer> streamResult =
                list.stream()

                        /*
                         * filter = 条件筛选
                         */
                        .filter(n -> n % 2 == 0)

                        /*
                         * map = 数据转换
                         */
                        .map(n -> n * 2)

                        /*
                         * toList = 收集结果
                         */
                        .toList();

        System.out.println(streamResult);
    }
}
