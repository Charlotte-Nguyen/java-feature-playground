package lambda;

import java.util.List;

/**
 * ===================================
 * 方法引用（Method Reference）示例
 * ===================================
 *
 * 方法引用 = Lambda 的进一步简化写法
 *
 * 使用条件：
 * ✔ Lambda 只调用一个方法
 * ✔ 参数完全一致
 * ✔ 不做额外逻辑
 *
 * 本质：
 * 把方法当函数传递
 *
 * 语法：
 * 类名::方法名
 * 对象::方法名
 */
public class MethodReferenceDemo {

    public static void main(String[] args) {

        /*
         * List.of() 是 Java9 新方法
         * 用来创建不可变 List（推荐）
         *
         * 特点：
         * ✔ 简洁
         * ✔ 不可修改
         * ❌ add/remove 会报异常
         */
        List<String> list = List.of("A", "B", "C");


        // =====================================================
        // ① Lambda写法
        // =====================================================

        /*
         * forEach 需要一个 Consumer<T>
         *
         * Consumer 接口：
         * void accept(T t);
         *
         * Lambda解释：
         * s -> System.out.println(s)
         *
         * 意思：
         * 对每个元素 s 执行 println
         */
        list.forEach(s -> System.out.println(s));

        System.out.println("------------");


        // =====================================================
        // ② 方法引用写法（推荐）
        // =====================================================

        /*
         * Lambda：
         * s -> System.out.println(s)
         *
         * 可以直接变成：
         * System.out::println
         *
         * 含义：
         * 把 println 方法直接作为参数传进去
         *
         * 等价写法：
         * (String s) -> System.out.println(s)
         *
         * 使用场景：
         * ✔ 只调用一个方法
         * ✔ 参数完全一样
         * ✔ 不做额外逻辑
         *
         * 企业开发建议：
         * 能用方法引用就用方法引用
         * ✔ 更短
         * ✔ 更清晰
         * ✔ 更函数式
         */
        list.forEach(System.out::println);

        System.out.println("------------");


        // =====================================================
        // ③ 静态方法引用（结合Stream）
        // =====================================================

        /*
         * stream() → 把集合变成流
         *
         * map() → 转换元素
         * 接收 Function<T,R>
         *
         * Function接口：
         * R apply(T t);
         *
         * String::toLowerCase
         * 等价于：
         * s -> s.toLowerCase()
         *
         * 流程解释：
         * A → a
         * B → b
         * C → c
         */
        list.stream()
                .map(String::toLowerCase) // 方法引用（实例方法引用）
                .forEach(System.out::println); // 输出结果
    }
}
