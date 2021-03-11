# 经验记录

# 1.mac book 安装Homebrew
[macbook安装homebrew](https://www.cnblogs.com/jacktu/p/12868222.html)    
网上的那个外国地址已经不可用了,用国内的可以正常
```  shell
/bin/zsh -c "$(curl -fsSL https://gitee.com/cunkai/HomebrewCN/raw/master/Homebrew.sh)"
```
按照操作即可完成安装。
我是用的 1:中科大下载器

# 2.macbook 更改pip路径
应用场景

默认mac上已经安装了 python2; 而我又安装了 python3，并使用 python3;

安装了 pip 默认，pip安装的包安装在了 python2上了；

但是我想用 pip把安装的包安装在 python3上 ，所以如下解决方式；

1：在mac上先安装 virtualenv

```shell 
sudo pip install virtualenv
```

2: 找到 python3的路径；

默认 python2的路径都在 /usr/lib/目录下，但是python3的不在

查找python3路径
``` shell
which python3 
```

3：执行 virtualenv 命令，修改 pip的安装路径 到 python3上

``` shell
sudo virtualenv -p /Library/Frameworks/Python.framework/Versions/3.9/bin/python3 py3env

source py3env/bin/activate
```

4：环境修改之后：

查看变量修改是否成功
``` shell
pip -V
```

pip 1.5.4 from /usr/bin/py3env/lib/python3.4/site-packages (python 3.4)

看到结果： 后面出现了 python3的路径，说明修改成功

5：安装python3包程序

pip install 包名，即可


sudo virtualenv -p /Library/Frameworks/Python.framework/Versions/3.9/bin/python3 py3env
source py3env/bin/activate
pip -V
sudo pip install -r requirements.txt -i https://pypi.tuna.tsinghua.edu.cn/simple/

# 3.绑定github.id到域名
[实用文章](https://www.cnblogs.com/liangmingshen/p/9561994.html)