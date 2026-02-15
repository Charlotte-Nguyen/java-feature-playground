package optional;

import java.util.Optional;

/**
 * =================================================
 * Optional 推荐使用方式（Best Practice）
 * =================================================
 *
 * 本示例演示：
 * ✔ Optional 正确使用场景
 * ✔ 推荐设计方式
 *
 * 官方推荐：
 * Optional 主要用于方法返回值
 */
public class OptionalBestPractice {

    public static void main(String[] args) {

        /*
         * 调用方法获取 Optional
         *
         * 注意：
         * 方法直接返回 Optional
         * 而不是返回 null
         */
        Optional<String> name = findName();


        /*
         * ifPresent()
         *
         * 含义：
         * 如果存在值 → 执行逻辑
         * 如果为空 → 什么都不做
         *
         * 避免写：
         *
         * if(name != null)
         */
        name.ifPresent(n -> System.out.println("found: " + n));
    }


    // =================================================
    // 推荐写法示例方法
    // =================================================

    /**
     * 返回 Optional 表示：
     * 结果可能存在，也可能不存在
     *
     * 语义比 null 更清晰
     */
    static Optional<String> findName(){

        /*
         * of()
         * 因为这里确定不为 null
         */
        return Optional.of("Jerry");

        /*
         * 如果不确定是否为 null
         * 应使用：
         *
         * return Optional.ofNullable(value);
         */
    }
}
