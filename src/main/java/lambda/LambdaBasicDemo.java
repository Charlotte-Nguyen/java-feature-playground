package lambda;

import java.util.Arrays;
import java.util.List;

/**
 * ===============================
 * Lambda 基础语法学习示例（Java8+）
 * ===============================
 *
 * Lambda 表达式本质：
 * 👉 用更简洁的方式实现“函数式接口”的方法
 *
 * 函数式接口特点：
 * ✔ 只有一个抽象方法的接口
 * 例如：
 * Runnable -> run()
 * Comparator -> compare()
 * Consumer -> accept()
 *
 * Lambda = 匿名函数
 * 可以理解为：把方法当作参数传递
 */
public class LambdaBasicDemo {

    public static void main(String[] args) {

        // ======================================================
        // ① 旧写法（匿名内部类）
        // ======================================================

        /*
         * Runnable 是一个接口：
         *
         * public interface Runnable {
         *     void run();
         * }
         *
         * 传统写法：
         * 创建接口实现类 → 重写方法 → new对象
         *
         * 问题：
         * ❌ 写法冗长
         * ❌ 可读性差
         * ❌ 模板代码太多
         */
        Runnable oldRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Old Runnable running...");
            }
        };

        oldRunnable.run();

        System.out.println("--------------------------");


        // ======================================================
        // ② Lambda写法
        // ======================================================

        /*
         * Lambda语法结构：
         *
         * (参数列表) -> {方法体}
         *
         * 这里 Runnable.run() 没参数，所以：
         *
         * () -> System.out.println(...)
         *
         * 等价于：
         * public void run() { ... }
         *
         * 优点：
         * ✔ 更短
         * ✔ 更直观
         * ✔ 更符合函数式编程思想
         */
        Runnable lambdaRunnable =
                () -> System.out.println("Lambda Runnable running...");

        lambdaRunnable.run();


        // ======================================================
        // ③ List遍历示例
        // ======================================================

        /*
         * Arrays.asList()
         * 创建一个固定大小的 List
         */
        List<String> names = Arrays.asList("Tom", "Jerry", "Spike");


        // ---------------------------
        // 旧写法：增强for循环
        // ---------------------------
        /*
         * 传统写法优点：
         * ✔ 简单
         * ✔ 易懂
         *
         * 但缺点：
         * ❌ 不支持函数式操作
         * ❌ 不方便链式调用
         */
        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("----------");


        // ---------------------------
        // Lambda写法
        // ---------------------------
        /*
         * forEach 是 List 接口提供的方法：
         *
         * void forEach(Consumer<? super T> action)
         *
         * Consumer 是函数式接口：
         *
         * public interface Consumer<T> {
         *     void accept(T t);
         * }
         *
         * 因此这里可以用 Lambda 表达式
         */
        names.forEach(name -> System.out.println(name));


        System.out.println("----------");


        // ---------------------------
        // 方法引用（Method Reference）
        // ---------------------------
        /*
         * 当 Lambda 只有一句：
         *
         * name -> System.out.println(name)
         *
         * 可以进一步简化为：
         *
         * System.out::println
         *
         * 含义：
         * 把 println 方法当作函数传进去
         *
         * 等价于：
         * (name) -> System.out.println(name)
         *
         * 使用条件：
         * ✔ Lambda 内部只是调用一个方法
         * ✔ 参数完全一致
         */
        names.forEach(System.out::println);
    }
}
