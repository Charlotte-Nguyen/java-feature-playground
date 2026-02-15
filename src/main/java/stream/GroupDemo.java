package stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * =================================================
 * Stream 收集器：groupingBy 分组统计
 * =================================================
 *
 * groupingBy 是 Collectors 中最重要的方法之一
 *
 * 作用：
 * 👉 按某个规则对元素进行分组
 *
 * 类似 SQL：
 * SELECT key, list
 * FROM data
 * GROUP BY key
 *
 * 返回结构：
 * Map<分组键, 分组数据列表>
 */
public class GroupDemo {

    public static void main(String[] args) {

        /*
         * 创建不可变集合
         */
        List<String> names =
                List.of("Tom","Jack","Lucy","James","Anna");


        // =================================================
        // groupingBy 分组
        // =================================================

        /*
         * groupingBy 参数：
         * Function<T, K>
         *
         * 含义：
         * 指定“按什么规则分组”
         *
         * String::length
         * 表示：
         * 按字符串长度分组
         *
         * 等价 Lambda：
         * s -> s.length()
         */
        Map<Integer,List<String>> result =
                names.stream()

                        /*
                         * collect = 收集流结果
                         */
                        .collect(

                                /*
                                 * groupingBy
                                 * 返回 Map<K, List<T>>
                                 *
                                 * K = 分组键
                                 * T = 原元素
                                 */
                                Collectors.groupingBy(String::length)
                        );


        /*
         * 输出示例结果：
         *
         * {
         *   3=[Tom],
         *   4=[Jack, Lucy, Anna],
         *   5=[James]
         * }
         */
        System.out.println(result);
    }
}
