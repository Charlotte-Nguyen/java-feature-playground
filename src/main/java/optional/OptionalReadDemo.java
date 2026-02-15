package optional;

import java.util.Optional;

/**
 * =================================================
 * Optional 取值方式示例
 * =================================================
 *
 * Optional 的核心用途不是创建对象，而是：
 * 👉 安全获取值
 *
 * Optional 提供多种读取方式，
 * 每种方式适用于不同场景。
 */
public class OptionalReadDemo {

    public static void main(String[] args) {

        /*
         * 创建一个 Optional
         * 当前包含值："Tom"
         */
        Optional<String> name = Optional.ofNullable("Tom");


        // =================================================
        // ① orElse()
        // =================================================

        /*
         * orElse(默认值)
         *
         * 含义：
         * 如果 Optional 有值 → 返回该值
         * 如果为空 → 返回默认值
         *
         * 注意：
         * 默认值一定会执行（即使有值）
         */
        System.out.println(name.orElse("default"));


        // =================================================
        // ② orElseGet()
        // =================================================

        /*
         * orElseGet(Supplier)
         *
         * 含义：
         * 如果 Optional 有值 → 返回该值
         * 如果为空 → 执行 Supplier 生成默认值
         *
         * 优点：
         * 默认值是“懒加载”
         */
        System.out.println(name.orElseGet(() -> "generated"));


        // =================================================
        // ③ ifPresent()
        // =================================================

        /*
         * ifPresent(Consumer)
         *
         * 含义：
         * 如果有值 → 执行操作
         * 如果为空 → 什么都不做
         *
         * 等价传统写法：
         *
         * if(name != null){
         *     System.out.println(name);
         * }
         */
        name.ifPresent(System.out::println);
    }
}
