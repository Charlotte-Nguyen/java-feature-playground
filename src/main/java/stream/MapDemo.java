package stream;

import java.util.List;

/**
 * =================================================
 * Stream 中间操作：map 数据转换
 * =================================================
 *
 * map 属于：
 * 👉 中间操作（Intermediate Operation）
 *
 * 作用：
 * 把流中的元素转换成另一种数据
 *
 * 核心思想：
 * 一个输入 → 一个输出
 *
 * 类似 SQL：
 * SELECT UPPER(name) FROM table
 */
public class MapDemo {

    public static void main(String[] args) {

        /*
         * 创建不可变 List
         */
        List<String> names = List.of("tom","jerry","spike");


        // =================================================
        // map：数据转换
        // =================================================

        List<String> upper =
                names.stream()

                        /*
                         * map 参数类型：
                         * Function<T,R>
                         *
                         * 含义：
                         * T → R 转换规则
                         *
                         * String::toUpperCase
                         * 表示：
                         * String → 大写String
                         *
                         * 等价 Lambda：
                         * s -> s.toUpperCase()
                         */
                        .map(String::toUpperCase)

                        /*
                         * toList()
                         * 终止操作（Java16+新增）
                         *
                         * 作用：
                         * 把流结果收集为 List
                         *
                         * 特点：
                         * ✔ 返回不可变List
                         */
                        .toList();


        /*
         * 输出结果：
         * [TOM, JERRY, SPIKE]
         */
        System.out.println(upper);
    }
}
