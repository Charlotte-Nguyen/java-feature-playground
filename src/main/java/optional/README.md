# Optional 模块学习笔记

---

## 📌 模块简介

本模块系统学习 Java8 引入的 Optional API，重点掌握其设计理念、使用方式及最佳实践，理解如何通过 Optional 编写更安全、更规范的现代 Java 代码。

Optional 的核心目标不是替代 null，而是明确表达：

> “这个值可能不存在，需要显式处理”

---

## 🎯 学习目标

完成本模块后应掌握：

* Optional 的设计目的
* Optional 创建方式
* Optional 安全取值方式
* Optional 链式调用
* Optional 推荐使用规范
* Optional 与传统 null 判断区别

---

## 📚 本模块知识点

---

### ① Optional 创建方式

三种创建方式：

```
Optional.of(value)
Optional.ofNullable(value)
Optional.empty()
```

区别：

| 方法         | 是否允许 null |
| ---------- | --------- |
| of         | ❌ 不允许     |
| ofNullable | ✔ 允许      |
| empty      | ✔ 空值      |

推荐规则：

```
优先使用 ofNullable
```

---

### ② Optional 取值方式

常用方法：

```
orElse()
orElseGet()
ifPresent()
```

区别：

| 方法        | 特点      |
| --------- | ------- |
| orElse    | 默认值一定执行 |
| orElseGet | 默认值懒执行  |
| ifPresent | 有值才执行   |

---

### ③ Optional 链式调用

用于安全访问对象属性，避免多层 null 判断。

示例：

```
Optional.ofNullable(user)
        .map(User::getName)
        .map(String::toUpperCase)
        .orElse("UNKNOWN");
```

执行规则：

```
只要某一步为空 → 后续全部跳过
```

---

### ④ 推荐使用方式（Best Practice）

官方推荐用途：

```
用于方法返回值
```

示例：

```
Optional<User> findUser()
```

表示：

```
可能找到用户
也可能找不到
```

---

## 🧠 Optional 设计思想（重点理解）

Optional 本质不是容器，而是：

> 返回值语义表达工具

它的作用不是存数据，而是告诉调用者：

```
这个结果需要你处理是否存在
```

---

## ⚠ 常见错误用法（必须避免）

❌ 不推荐作为字段

```
class User {
    Optional<String> name;
}
```

原因：

* ORM兼容问题
* 序列化问题
* 性能开销

---

❌ 不推荐作为方法参数

```
void test(Optional<String> name)
```

原因：
调用者使用体验差。

---

❌ 不推荐使用 get()

```
optional.get()
```

原因：

```
为空会抛异常
```

违背 Optional 设计目的。

---

## 🚀 实际开发使用场景

Optional 常见使用位置：

* Service 查询结果返回
* DAO 查询结果返回
* 配置读取
* JSON解析
* 多层对象访问
* DTO转换

---

## 📊 Optional 方法速查表

| 方法          | 作用           |
| ----------- | ------------ |
| of          | 创建非空Optional |
| ofNullable  | 创建可空Optional |
| empty       | 创建空对象        |
| map         | 有值才转换        |
| flatMap     | 返回Optional转换 |
| orElse      | 默认值          |
| orElseGet   | 懒加载默认值       |
| orElseThrow | 为空抛异常        |
| ifPresent   | 有值执行         |

---

## 🏁 阶段总结

掌握 Optional 表示你已经具备：

✔ 安全处理空值能力
✔ 现代 Java 编码规范意识
✔ 函数式风格思维

Optional 是现代 Java 编码规范的重要组成部分。

---

## 🎯 当前能力等级定位

完成本模块说明你已经达到：

> 熟练掌握 Optional API 的开发者水平

这属于中级 Java 工程师核心能力之一。

---

## 📌 下一步建议学习内容

建议继续深入学习：

* Optional.filter()
* Optional.orElseThrow()
* Optional.stream()
* Optional + Stream 结合使用

---
