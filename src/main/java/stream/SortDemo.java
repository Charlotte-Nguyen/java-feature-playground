package stream;

import java.util.List;

/**
 * =================================================
 * Stream 中间操作：sorted 排序示例
 * =================================================
 *
 * sorted 属于：
 * 👉 中间操作（Intermediate Operation）
 *
 * 作用：
 * 对流中的元素进行排序
 *
 * 特点：
 * ✔ 不会修改原集合
 * ✔ 返回新的 Stream
 * ✔ 惰性执行（遇到终止操作才执行）
 */
public class SortDemo {

    public static void main(String[] args) {

        /*
         * 创建不可变 List
         */
        List<Integer> list = List.of(5,2,9,1);


        // =================================================
        // ① 默认排序（升序）
        // =================================================

        /*
         * sorted()
         *
         * 使用元素默认比较规则排序
         *
         * 要求：
         * 元素必须实现 Comparable 接口
         *
         * Integer 已经实现 Comparable
         */
        list.stream()
                .sorted()
                .forEach(System.out::println);


        System.out.println("倒序");


        // =================================================
        // ② 自定义排序规则
        // =================================================

        /*
         * sorted(Comparator)
         *
         * 参数类型：
         * Comparator<T>
         *
         * Lambda解释：
         * (a, b) -> b - a
         *
         * 含义：
         * 如果 b-a > 0
         * 表示 b > a
         * 就让 b 排在前面
         *
         * 结果：
         * 倒序排序
         */
        list.stream()
                .sorted((a,b)-> b-a)
                .forEach(System.out::println);
    }
}
