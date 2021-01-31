# 问题记录
## 1.idea使用lombok后,编译提示找不到符号.
>打开enable Annotation processing
![lombok找不到符号解决](./picture/lombok_problem.jpeg)  

## 2.weblogic,下载excel等文件,点击乱码.
>在包里的web.xml文件中增加配置
``` java 
<mime-mapping>
    <extension>xls</extension>
    <mime-type>application/xls</mime-type>
</mime-mapping> 
```
>其他常用类型
```js 
<mime-mapping>
    <extension>rar</extension>
    <mime-type>application/octet-stream</mime-type>
</mime-mapping>
<mime-mapping>
    <extension>rmvb</extension>
    <mime-type>application/octet-stream</mime-type>
</mime-mapping>
<mime-mapping>
    <extension>doc</extension>
    <mime-type>application/msword</mime-type>
</mime-mapping>
```
## 3.debug模式跳转到其他同名类中
File -->Settings -->Debugger ,勾选Show alternative source switchwer
![debug跳转到同名类](./picture/debug_switch.png) 

## 4.读取config.properties中文乱码

是因为编码字符集导致的,两个解决方法.

1. 用编辑器将properties的编码格式整体改为UTF-8.

   这种方法不好的是会将文本中现有的中文变成乱码,不推荐.

2. 读取properties时候,使用InputStreamReader将字符集转为UTF-8.

   ```java
   static Properties props = new Properties();
   
   static {
     try {
       //解决中文乱码问题.
       props.load(new InputStreamReader(
         PropertyMgr.class.getClassLoader().getResourceAsStream("config")
         ,"UTF-8"
       )
                 );
     } catch (IOException e) {
       e.printStackTrace();
     }
   }
   
   public static Object get(String key) {
     if(props == null) return null;
     return props.get(key);
   }
   ```

   