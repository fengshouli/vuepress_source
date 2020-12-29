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