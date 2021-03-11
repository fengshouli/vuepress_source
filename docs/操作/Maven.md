# Maven
IDE默认集成了maven,简单改下即可使用.

## 一.换源

首先,找到maven的setting.xml文件,我的mac的文件在Users/用户/.m2/setting.xml 

mac如何显示隐藏文件夹,command+shift+.

需要改一下源,改成阿里云的,会快很多,在setting.xml中加入如下配置.

```xml
	<mirror>
      <id>alimaven</id>
      <mirrorOf>central</mirrorOf>  
      <name>aliyun maven</name>
      <url>http://maven.aliyun.com/nexus/content/groups/public/</url>      
    </mirror>
```

