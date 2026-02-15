package optional;

import java.util.Optional;

/**
 * =================================================
 * Optional 创建方式示例
 * =================================================
 *
 * Optional 是 Java8 引入的容器类
 *
 * 作用：
 * 👉 用来表示“可能为空”的值
 *
 * 设计目的：
 * 避免 NullPointerException（空指针异常）
 *
 * 可以理解为：
 * Optional = 更安全的 null 包装器
 */
public class OptionalCreateDemo {

    public static void main(String[] args) {

        // =================================================
        // ① Optional.of()
        // =================================================

        /*
         * of() 要求：
         * 传入值必须非 null
         *
         * 如果传入 null：
         * 会直接抛异常
         */
        Optional<String> a = Optional.of("hello");


        // =================================================
        // ② Optional.ofNullable()
        // =================================================

        /*
         * ofNullable()
         * 可以接收 null
         *
         * 如果参数为 null：
         * 返回 Optional.empty()
         */
        Optional<String> b = Optional.ofNullable(null);


        // =================================================
        // ③ Optional.empty()
        // =================================================

        /*
         * empty()
         * 创建一个空 Optional 对象
         *
         * 常用于：
         * 方法返回无结果时
         */
        Optional<String> c = Optional.empty();


        // =================================================
        // 输出结果
        // =================================================

        /*
         * 输出内容：
         *
         * Optional[hello]
         * Optional.empty
         * Optional.empty
         */
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
