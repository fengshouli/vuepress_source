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

**用法**:类名::方法名

注意是方法名哦，后面没有括号“()”的。为啥不要括号，因为这样的是式子并不代表一定会调用这个方法。这种式子一般是用作Lambda表达式，Lambda有所谓懒加载嘛，不要括号就是说，看情况调用方法。

#### 1.例1:

表达式:

```java
person -> person.getAge();
```

可以替换成

```java
Person::getAge
```

#### 2.例2:

表达式

```java
() -> new HashMap<>();
```

可以替换成

```java
HashMap::new
```

这种[方法引用]或者说[双冒号运算]对应的参数类型是Function<T,R> T表示传入类型，R表示返回类型。比如表达式person -> person.getAge(); 传入参数是person，返回值是person.getAge()，那么方法引用Person::getAge就对应着Function<Person,Integer>类型。

下面这段代码，进行的操作是，把`List<String>`里面的String全部大写并返还新的`ArrayList<String>`，在前面的例子中我们是这么写的：

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



### 2.lambda的stream()

假设有一个TestObj

```java
@Data
public class TestObj {
    private String pid;
    private String cid;

    private String attr1;
    private String attr2;
}
```

```java
List<TestObj> objs = new ArrayList(){{
           add(new TestObj("1","1","1","1"));
   		   add(new TestObj("1","1","2","2"));
           add(new TestObj("1","2","1","1"));
           add(new TestObj("2","1","1","1"));
           add(new TestObj("2","2","1","1"));
           add(new TestObj("3","4","1","1"));
        }};
```

```java
public class FilterUtil {
    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return object -> seen.putIfAbsent(keyExtractor.apply(object), Boolean.TRUE) == null;
    }
}
```

####  生成流函数

    把集合装成流，可以多次使用这个集合，但是不转换流的话，只能用一次，这就是转换成流的好处
    stream() − 为集合创建串行流。
    parallelStream() − 为集合创建并行流。

#### forEach

```java
List<String> list =Arrays.asList("a","ad","dr");
list.stream().forEach(System.out::println);
//或者如下也可以
list.stream().forEach(a -> System.out.println(a));
//或者不创建流也可以直接使用函数
list.forEach(System.out::println);
//或者
list.forEach(a -> System.out.println(a));
```

#### limit

​          主要用来限制显示的量：eg:

```java
//该random函数若是不传递参数，那么就采用当前时间的毫秒数当做种子数，若是传递了参数，就用传递的数字作为种子数了，但是这样的话，生成的随机数就是伪随机数，虽然随机，但是点几次，都基本一样，因为传入的种子数限制了函数的选择性
Random random = new Random();
//受到limit限制，只会随机显示10个数字，因为没有传递参数，那么每次点击都会不一样，否则，若传递了种子数，点击几次都一样
random.ints().limit(10).forEach(System.out::println);
 
//像下面的都一样
Random random = new Random(10);//传递了种子数
random.ints().limit(10).forEach(System.out::println);
```

#### map函数

​            主要用来对传入的参数进行逻辑处理，例如：

```java
//用数组来转换集合
List<Integer> list = Arrays.asList(9,3,3);
//distinct()函数，是去重复函数
list = list.stream().distinct().map(i -> i*i).collect(Collectors.toList());
//打印输出list
list.forEach(System.out::println);

```

#### Filter函数

​          用来过滤所需要的数据

```java
List<String> list = Arrays.asList("1","sd");
list = list.stream().filter(i -> !i.isEmpty()).collect(Collectors.toList());
```

#### Collectors函数

​			可以集合成所需要的集合类型

```java
List<String> list =Arrays.toList("asd","dsg");
//把list集合转换成带逗号“，”的字符串
String str=list.stream().filter(a -> !a.isEmpty()).collect(Collectors.joining(","));
//把得到的字符串转换为了数组了
String[] split = str.split(",");
```
#### 统计函数

​            用来统计数组集合的最大最小平均总和的各个值

```
List<Integer> list = Arrays.asList(12,34,23,12,3,34);
IntSummaryStatistics stats= list.stream().mapToInt(x -> x).summaryStatistics();
//最大值
stats.getMax();
//最小值
stats.getMin();
//平均值
stats.getAverage();
//总数
stats.getCount();
//总和
stats.getSum();
```



#### 1.将一个`List<TestObj>`抽取某个字段组成新`List<String>`字段并去重

```java
List<String> pids = objs.stream().map(TestObj::getPid).distinct().collect(Collectors.toList());
System.out.println("pids===="+pids);
//pids====[1, 2, 3]
```

#### 2.`List<TestObj>`按某个字段分堆

```java
Map<String, List<PreWarningDTO>> warnListMap = preWarningDTOS.stream().collect(Collectors.groupingBy(
                item ->
                     getKey(item.getProjectId(),item.getContractId())
        ));

//warnListMap===={1-1=[TestObj(pid=1, cid=1, attr1=1, attr2=1), TestObj(pid=1, cid=1, attr1=2, attr2=2)], 2-1=[TestObj(pid=2, cid=1, attr1=1, attr2=1)], 1-2=[TestObj(pid=1, cid=2, attr1=1, attr2=1)], 2-2=[TestObj(pid=2, cid=2, attr1=1, attr2=1)], 3-4=[TestObj(pid=3, cid=4, attr1=1, attr2=1)]}

```

#### 3.`List<TestObj>`按照指定主键去重(仅重复主键仅保留前面的)

```java
List<TestObj> collect = objs.stream().filter(FilterUtil.distinctByKey(
                item ->
                        item.getPid() + "-" + item.getCid()
                )
        ).collect(Collectors.toList());

//collect====[TestObj(pid=1, cid=1, attr1=1, attr2=1), TestObj(pid=1, cid=2, attr1=1, attr2=1), TestObj(pid=2, cid=1, attr1=1, attr2=1), TestObj(pid=2, cid=2, attr1=1, attr2=1), TestObj(pid=3, cid=4, attr1=1, attr2=1)]

```

