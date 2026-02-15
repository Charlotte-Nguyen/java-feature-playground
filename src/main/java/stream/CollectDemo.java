package stream;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * =================================================
 * Stream终止操作：collect() 示例
 * =================================================
 *
 * 什么是终止操作？
 * Stream 分两类操作：
 *
 * 中间操作（intermediate）
 *   filter / map / sorted / distinct ...
 *
 * 终止操作（terminal）
 *   collect / forEach / count / findFirst ...
 *
 * 特点：
 * ✔ 终止操作执行后，Stream 就关闭了
 * ✔ 不能再次使用
 */
public class CollectDemo {

    public static void main(String[] args) {

        /*
         * List.of()
         * 创建不可变List（Java9+推荐写法）
         */
        List<String> list = List.of("A","B","C","A");


        // =================================================
        // collect：收集流中的元素
        // =================================================

        /*
         * stream()
         * 把集合转换为 Stream 流
         */
        Set<String> set =
                list.stream()

                        /*
                         * collect()
                         * 作用：把流中的数据收集到指定容器中
                         *
                         * 参数：
                         * Collector 类型对象
                         */
                        .collect(Collectors.toSet());


        /*
         * Collectors.toSet()
         * 含义：
         * 把流中元素收集到 Set 集合
         *
         * 特点：
         * ✔ 自动去重
         * ✔ 无序（HashSet）
         */
        System.out.println(set);
    }
}
