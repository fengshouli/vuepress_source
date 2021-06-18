# lambda

>Lambda 表达式，也可称为闭包，它是推动 Java 8 发布的最重要新特性。  
>Lambda 允许把函数作为一个方法的参数（函数作为参数传递进方法中）。  
>使用 Lambda 表达式可以使代码变的更加简洁紧凑  

## 一.重要特性

- ​		**可选类型声明:** 不需要声明参数类型，编译器可以统一识别参数值。 
- ​		**可选的参数圆括号:** 一个参数无需定义圆括号，但多个参数需要定义圆括号。 
- ​		**可选的大括号:** 如果主体包含了一个语句，就不需要使用大括号。 
- ​		**可选的返回关键字:** 如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。 

## 二.具体用法

### 1.双冒号"::".

类名::方法名

注意是方法名哦，后面没有括号“()”哒。为啥不要括号，因为这样的是式子并不代表一定会调用这个方法。这种式子一般是用作Lambda表达式，Lambda有所谓懒加载嘛，不要括号就是说，看情况调用方法。

例如

表达式:

```java
person -> person.getAge();
```

可以替换成

```java
Person::getAge
```

表达式

```java
() -> new HashMap<>();
```

可以替换成

```java
HashMap::new
```

这种[方法引用]或者说[双冒号运算]对应的参数类型是Function<T,R> T表示传入类型，R表示返回类型。比如表达式person -> person.getAge(); 传入参数是person，返回值是person.getAge()，那么方法引用Person::getAge就对应着Function<Person,Integer>类型。

下面这段代码，进行的操作是，把List<String>里面的String全部大写并返还新的ArrayList<String>，在前面的例子中我们是这么写的：

```java
@Test
public void convertTest() {
    List<String> collected = new ArrayList<>();
    collected.add("alpha");
    collected.add("beta");
    collected = collected.stream().map(string -> string.toUpperCase()).collect(Collectors.toList());
    System.out.println(collected);
}
```

现在也可以被替换成下面的写法：

```java
@Test
public void convertTest() {
    List<String> collected = new ArrayList<>();
    collected.add("alpha");
    collected.add("beta");
    collected = collected.stream().map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new));//注意发生的变化
    //上面是从网上看的,不过看起来Collectors.toCollection(ArrayList::new)和Collectors.toList()区别不大.
    System.out.println(collected);
}
```
