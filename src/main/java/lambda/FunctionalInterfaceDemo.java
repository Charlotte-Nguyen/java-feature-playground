package lambda;

/**
 * ===================================================
 * 函数式接口（Functional Interface）演示
 * ===================================================
 *
 * 什么是函数式接口？
 *
 * 👉 只有一个抽象方法的接口
 *
 * 为什么Lambda只能用于函数式接口？
 *
 * 因为 Lambda 本质是：
 * "给接口方法提供实现"
 *
 * 如果接口有多个抽象方法：
 * ❌ 编译器不知道你要实现哪一个
 *
 * 所以：
 * Lambda = 单方法接口实现器
 */
public class FunctionalInterfaceDemo {

    public static void main(String[] args) {

        // =================================================
        // ① Lambda实现接口（加法）
        // =================================================

        /*
         * Lambda：
         * (a, b) -> a + b
         *
         * 等价传统写法：
         *
         * Calculator add = new Calculator() {
         *     @Override
         *     public int calculate(int a, int b) {
         *         return a + b;
         *     }
         * };
         *
         * Lambda优势：
         * ✔ 少写80%代码
         * ✔ 可读性强
         * ✔ 更符合现代Java风格
         */
        Calculator add = (a, b) -> a + b;


        // =================================================
        // ② Lambda实现接口（乘法）
        // =================================================

        /*
         * 同一个接口可以有多个实现逻辑
         * Lambda只是实现方式之一
         *
         * 这里定义了另一个实现逻辑：
         * 乘法
         */
        Calculator multiply = (a, b) -> a * b;


        // =================================================
        // ③ 调用接口方法
        // =================================================

        /*
         * 实际执行的是：
         * Lambda中定义的逻辑
         */
        System.out.println(add.calculate(2, 3));       // 5
        System.out.println(multiply.calculate(2, 3));  // 6
    }
}


/**
 * ===================================================
 * 函数式接口定义
 * ===================================================
 *
 * @FunctionalInterface 注解作用：
 *
 * ✔ 强制编译器检查
 * ✔ 保证只有一个抽象方法
 * ✔ 如果写了两个抽象方法 → 编译报错
 *
 * 注意：
 * 可以有多个默认方法或静态方法
 * 只限制“抽象方法数量”
 */
@FunctionalInterface
interface Calculator {

    /*
     * 抽象方法（唯一）
     *
     * Lambda就是实现这个方法
     */
    int calculate(int a, int b);


    // 下面这些是允许的（不会破坏函数式接口规则）

    /*
    default void test() {
        System.out.println("default method");
    }

    static void helper() {
        System.out.println("static method");
    }
    */
}
