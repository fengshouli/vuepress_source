# sql

# 一.mac安装mysql.

[m1芯片的mac的mysql安装](https://blog.csdn.net/qq_42006613/article/details/111773038)

上面就是下载mysql客户端,并且一通安装,唯一需要注意的就是,在Configuration那步,选下边的,然后输入密码.

安装完成后,配置环境变量

打开终端切换至根目录 编辑.bash_profile

```shell
cd ~ 
vim ./.bash_profile
```


按i键选择insert模式，加入这两行代码

```shell
export PATH=$PATH:/usr/local/mysql/bin
export PATH=$PATH:/usr/local/mysql/support-files
```

按esc输出':wq'推出

刷新环境变量

```shell
source ~/.bash_profile 
```

测试运行是否成功,控制台输入下面的指令,回车,输入密码,打印出mysql信息.

```shell
mysql -u root -p
```


最后的最后要注意

如果关闭终端在运行mysql 命令没有成功的话，是因为Mac终端在启动时没有自动刷新环境变量要在执行以下操作

    vim ~/.zshrc
    source ~/.bash_profile

esc :wq 退出即可
————————————————
