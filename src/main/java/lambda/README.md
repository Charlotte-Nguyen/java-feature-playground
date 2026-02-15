# Lambda 模块学习笔记

---

## 📌 模块简介

本模块用于系统学习 Java8 及之后版本引入的 **Lambda 表达式与函数式编程特性**，目标是掌握现代 Java 的核心语法风格，并理解其在真实项目中的使用方式。

---

## 🎯 学习目标

通过本模块应掌握以下能力：

* 理解 Lambda 表达式本质
* 掌握 Lambda 语法规则
* 能熟练使用方法引用
* 理解函数式接口机制
* 能在实际开发中正确使用 Lambda
* 能读懂并编写现代 Java 风格代码

---

## 📚 知识点模块

### ① Lambda 基础写法

学习如何使用 Lambda 替代匿名内部类，使代码更简洁。

核心思想：

> Lambda = 用更短语法实现接口方法

典型对比：

旧写法：

```
new Runnable() {
    public void run() { }
}
```

Lambda：

```
() -> { }
```

---

### ② 方法引用（Method Reference）

方法引用是 Lambda 的进一步简化写法。

使用前提：

* Lambda 只调用一个方法
* 参数完全一致
* 没有额外逻辑

示例：

```
s -> System.out.println(s)
```

可写为：

```
System.out::println
```

---

### ③ 函数式接口（Functional Interface）

函数式接口是 Lambda 的基础。

定义规则：

> 只能有一个抽象方法

示例：

```
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}
```

Lambda 实现：

```
Calculator add = (a,b) -> a + b;
```

---

## 🧠 核心理解总结

### ✔ Lambda 本质

Lambda 不是语法糖，而是：

> 接口实现对象的简写形式

编译器会自动生成实现类。

---

### ✔ Lambda 能用的前提

只能用于函数式接口。

原因：
如果接口有多个方法，编译器无法判断要实现哪个。

---

### ✔ 常见函数式接口（必须熟悉）

| 接口        | 作用   |
| --------- | ---- |
| Runnable  | 线程任务 |
| Consumer  | 消费数据 |
| Supplier  | 提供数据 |
| Function  | 数据转换 |
| Predicate | 条件判断 |

---

### ✔ Lambda 简写规则（重点记忆）

可以省略：

* 参数类型
* 小括号（单参数）
* 大括号（单语句）
* return（单表达式）

---

## ⚙ 方法引用四种类型（必会）

| 类型     | 写法      | 示例                  |
| ------ | ------- | ------------------- |
| 对象实例方法 | 对象::方法  | System.out::println |
| 类实例方法  | 类名::方法  | String::toLowerCase |
| 静态方法   | 类名::方法  | Integer::parseInt   |
| 构造方法   | 类名::new | User::new           |

---

## 🚀 实际开发中的使用场景

Lambda 在真实项目中极其常见，典型应用：

* Stream 流处理
* 集合遍历
* 排序规则定义
* 条件过滤
* 回调逻辑
* 并发任务

示例：

```
users.stream()
     .filter(u -> u.getAge() > 18)
     .map(User::getName)
     .forEach(System.out::println);
```

---

## 🏁 阶段结论

掌握 Lambda 表达式代表你已经进入：

> 现代 Java 开发阶段

这是学习以下技术的基础：

* Stream API
* 并发编程
* 异步编程
* Spring 函数式风格
* 响应式编程

---

## 📌 当前能力定位（学习评估）

完成本模块后，你应该已经具备：

☑ 能读懂 Lambda 代码
☑ 能编写 Lambda 表达式
☑ 能使用方法引用优化代码
☑ 理解函数式接口原理

---

## 🎯 下一阶段建议学习内容

建议继续深入学习：

> **Stream API（重点）**

因为现代 Java 实际开发中最常见组合是：

```
Lambda + Stream
```

掌握后代码能力会明显提升。

---
