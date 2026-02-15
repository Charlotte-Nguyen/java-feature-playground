package stream;

import java.util.List;

/**
 * =================================================
 * Stream 中间操作：filter 过滤示例
 * =================================================
 *
 * filter 属于：
 * 👉 中间操作（Intermediate Operation）
 *
 * 特点：
 * ✔ 不会立即执行
 * ✔ 返回新的 Stream
 * ✔ 支持链式调用
 *
 * 只有遇到终止操作（如 forEach / collect）
 * Stream 才会真正执行
 */
public class FilterDemo {

    public static void main(String[] args) {

        /*
         * 创建不可变 List（Java9+ 推荐写法）
         */
        List<Integer> numbers = List.of(3,7,10,15,20);


        // =================================================
        // Stream处理流程
        // =================================================

        numbers.stream()

                /*
                 * filter：过滤元素
                 *
                 * 参数类型：
                 * Predicate<T>
                 *
                 * Predicate 接口定义：
                 * boolean test(T t)
                 *
                 * Lambda含义：
                 * n -> n > 10
                 *
                 * 等价写法：
                 * (Integer n) -> {
                 *     return n > 10;
                 * }
                 *
                 * 作用：
                 * 只保留满足条件的元素
                 */
                .filter(n -> n > 10)

                /*
                 * forEach：终止操作
                 *
                 * 作用：
                 * 遍历流中每个元素
                 *
                 * 参数：
                 * Consumer<T>
                 *
                 * System.out::println
                 * 是方法引用写法
                 */
                .forEach(System.out::println);
    }
}
