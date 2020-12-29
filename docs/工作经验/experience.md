# 工作经验

## 1.对一张很大的数据库表所有数据进行操作.(千万级别)

> 1. 如果对一张很大的数据库表进行操作时候,程序是先将所有数据加载到内存,再操作.如果操作不慎,极容易造成内存溢出问题.  
>
> 2. 这时候,应当通过游标逐行读取,逐行操作的方式进行数据操作.

**解决方法:[使用JdbcTemplate流式（游标）读取数据库](https://juejin.cn/post/6844903880875065357)**

```java
jdbcTemplate.query(con -> {
            con.setAutoCommit(false);
            PreparedStatement preparedStatement =
                    con.prepareStatement("select * from table",
                                         ResultSet.TYPE_FORWARD_ONLY, 
                                                   ResultSet.CONCUR_READ_ONLY);
  //1.一次多少条 
  //2.输入固定大小经测试适用于postGreSql ,这里如果是从mysql取数,一定要是setFetchSize(Integer.MIN_VALUE);
            preparedStatement.setFetchSize(1000);
            preparedStatement.setFetchDirection(ResultSet.FETCH_FORWARD);
            return preparedStatement;
        }, rs -> {
  //这里为何不用while(rs.next())??
  //下面详细解答.
           System.err.println(resultSet.getString("id"));
        });


//上面的lambda等于
PreparedStatementCreator psc = new PreparedStatementCreator(){
  	@Override
    public PreparedStatement createPreparedStatement(Connection con)  throws SQLException {
      con.setAutoCommit(false);
      PreparedStatement preparedStatement =
        con.prepareStatement("select * from table",
                             ResultSet.TYPE_FORWARD_ONLY, 
                             ResultSet.CONCUR_READ_ONLY);
      preparedStatement.setFetchSize(1000);
      preparedStatement.setFetchDirection(ResultSet.FETCH_FORWARD);
      return preparedStatement;
    }
}
```

**解答为何不用while:这里lambda其实容易将人带入 [坑](https://yanbin.blog/jdbctemplate-java-8-lambda-trick/)**

1.以前没用lambda的时候,用匿名内部类的时候,错误写法是这样

```java
public List<User> findAll() {
    List<User> users = new ArrayList<>();
    jdbcTemplate.query("select id, name from user", new RowCallbackHandler() {
        @Override
        public void processRow(ResultSet rs) throws SQLException {
            while (rs.next()) {//错误在这里,不需要while,每执行一条数据执行一次这个方法.
                users.add(new User(rs.getInt("id"), rs.getString("name")));
            }
        }
    });
    return users;
}
```

现在我们明明白白的能看到回调函数的类型是 `RowCallbackHandler`, 如类名所示，它就是处理 ResultSet 的当前行, 有人在帮我们遍历结果集，所以我们再次对 rs.next() 就跳过了第一行记录。

2.在1.8 lambda前,出现上面错误概率很小,大概会写成下面的正确写法.

```java
public List<User> findAll() {
    List<User> users = new ArrayList<>();
    jdbcTemplate.query("select id, name from user", new RowCallbackHandler() {
        @Override
        public void processRow(ResultSet rs) throws SQLException {
           users.add(new User(rs.getInt("id"), rs.getString("name")));
        }
    });
    return users;
}
```

3.回到lambda后就是这样

```java
public List<User> findAll() {
    List<User> users = new ArrayList<>();
    jdbcTemplate.query("select id, name from user", rs -> {
        users.add(new User(rs.getInt("id"), rs.getString("name")));
    });
    return users;
}
//乍一看下面的代码和上面没区别,唯一的区别下面的有返回值,
//总结,有返回值的,需要自己遍历结果,没返回值的,不需要自己遍历结果.
public List<User> findAll() {
    return jdbcTemplate.query("select * from user", rs -> {
        List<User> users = new ArrayList<>();
        while(rs.next()) {
            users.add(new User(rs.getInt("id"), rs.getString("name")));
        }
        return users;
    });
}
```







