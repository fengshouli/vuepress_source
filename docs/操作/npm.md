# npm 相关操作

## 学习.

### 一.npm是什么

全称:Node Package Manager.用 JavaScript （运行在 Node.js 上）写的 npm

干嘛用的?管理前端代码,例如 `npm install -D vuepress` 即可将vuepress需要的依赖都下载下来.想想以前,如果你需要JQuery,你要去JQuery官网下载,需要BootStrap ,又要去他的官网下载,就这样需要的依赖越来越多怎么办,node出现了.现在,你感觉到他的优秀了吗.

[npm是干什么的](https://zhuanlan.zhihu.com/p/24357770)

[npm菜鸟教程](https://www.runoob.com/nodejs/nodejs-npm.html)

## 问题.

### 一.下载很慢

在终端中npm install -D ***时候,发现很慢,是因为源的问题.

1. 查看是什么源：

   ```shell
   npm config get registry
   ```

2. 换源：

   ```shell
   npm config set registry http://registry.npm.taobao.org
   ```

3. 暂时换源：

   ```shell
   npm install --registry=https://registry.npm.taobao.org
   ```

   

