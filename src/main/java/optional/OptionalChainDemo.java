package optional;

import java.util.Optional;

/**
 * =================================================
 * Optional 链式调用示例（核心能力）
 * =================================================
 *
 * 作用：
 * 安全访问对象属性，避免空指针异常
 *
 * 使用场景：
 * 多层对象访问
 * DTO转换
 * JSON解析
 */
public class OptionalChainDemo {

    public static void main(String[] args) {

        /*
         * 创建用户对象
         */
        User user = new User("Tom");


        // =================================================
        // Optional 链式处理流程
        // =================================================

        String result =
                Optional.ofNullable(user)     // Step1：包装对象（允许为空）

                        /*
                         * map(User::getName)
                         *
                         * 如果 user 不为空：
                         *    获取 name
                         *
                         * 如果 user 为空：
                         *    直接跳过后续步骤
                         */
                        .map(User::getName)

                        /*
                         * map(String::toUpperCase)
                         *
                         * 如果 name 不为空：
                         *    转换为大写
                         */
                        .map(String::toUpperCase)

                        /*
                         * orElse("UNKNOWN")
                         *
                         * 如果前面任一步为 null：
                         * 返回默认值
                         */
                        .orElse("UNKNOWN");


        /*
         * 输出：
         * TOM
         */
        System.out.println(result);
    }
}


/**
 * 简单用户类
 */
class User{

    private String name;

    public User(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }
}
