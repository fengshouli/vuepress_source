# github-CI/CD

### 1.为什么需要CI/CD

最简单来说,我们开发,都是对源码的操作,而我们看到的,都是源码编译后的文件,也就是说,应该有两个库,  

一个源码库,存源码,用于共享开发.  

一个编译库,存编译后文件,用于展示.

那么有个问题啊,我们需要push源码,还需要在本地编译,并且push编译文件到 编译库.是不是很麻烦??  

对,github的CI/CD就是干这个的 ,你只需要再push源码到源码库,他github自动帮你编译,发布到编译库,是不是很爽??下面我们用vuepress来详细说说如何操作.

### 2.使用github-Actions.

1. 点击源码库所在的Actions,选择一个workflow模板.

   ![actions](./picture/github-cicd/Actions.png)

2. 实际上在这里操作模板,最终也是在仓库中生成一个文件.[./github/workflows/xxx.yml],还记得那个CNAME吗,绑定域名后也是在库中生成一个文件,一个原理.这个yml文件里配置着流程.

3. workflow配置详解.

   ```shell
   #给这个workflow起个名字
   name: vuepress-CI
   #如何触发,这里是提交到master分支时候触发,
   on:
     push:
       branches:
         - master
   #具体的操作.
   jobs:
     build-deploy:
     	#运行虚拟机环境,Ubuntu是用的最多的.有很多插件,所以咱们也用这个.
       runs-on: ubuntu-latest
       #步骤,uses就是用插件,run就是执行命令.
       steps:
       #checkout插件
         - uses: actions/checkout@v1
         #都这么写.
         - run: npm ci
         #安装咱们要的vuepress组件
         - run: npm install -D vuepress
         #清空之前编译的文件,这个路径是你的docs/.vuepress/config.js里面的dest属性配置的.
         - run: rm -rf dist/
         #编译命令,npm run 是命令, docs:build是在package.json文件中配置的.
         - run: npm run docs:build
         #编译后域名文件会被冲掉,所以手写一个cp进去.
         - run: cp CNAME dist/
   
         # 发布到 fengshouli.github.io/master
         - name: Deploy
         #这也是个插件,如果想了解更多去他的git看.https://github.com/peaceiris/actions-gh-pages/tree/v2.5.0-rc0
           uses: peaceiris/actions-gh-pages@v2.5.0
           env:
           #口令,这个超级坑,下面详细说
             ACTIONS_DEPLOY_KEY: ${{secrets.RSA_KEY}}
             #发布地址
             EXTERNAL_REPOSITORY: fengshouli/fengshouli.github.io
             #发布分支
             PUBLISH_BRANCH: master
             #发布什么文件
             PUBLISH_DIR: dist
           with:
             emptyCommits: false
   
   ```



### 3.带你爬坑

1. 编译报错:

   在本地,不管是window机器,还是mac机器,编译都能过,但是一旦上git,就是失败,