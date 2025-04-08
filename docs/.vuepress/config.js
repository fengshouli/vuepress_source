module.exports = {
    title: '冯手力-java学习之路',// 设置网站标题
    //dest: './docs/.vuepress/dist',// 设置输出目录
    dest: './dist',
    // base: '/',   // 设置站点根路径
    // base:'./',//打包用
    port: 9999,
    //适配ipad
    head: [
        ['meta', { name: 'viewport', content: 'width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no' }]
      ],
    plugins: [],
    themeConfig: {
        sidebarDepth: 2,
        nav: [
            { text: '首页', link: '/' },
            { text: '操作', link: '/操作/' },
            { 
                text: '经验',
                items:[
                    { text: '工作经验', link: '/工作经验/'},
                    { text: '项目经验', link: '/项目经验/'}
                ] 
            },
            { text: 'java', link: '/java/' },
            { text: '架构之路', link: '/架构之路/' },
            { text: '领域驱动设计', link: '/领域驱动设计/' },
        
            { text: '源码解析', link: '/源码解析/' },
            { text: '程序员英语', link: '/程序员英语/' },
            { text: '面试突击班', link: '/面试突击班/' },
            { text: '算法体系', link: '/算法体系/' },
            { text: '用友', link: '/用友/' }
            
        ],
      
        sidebar: {
            // sudo vuepress dev docs 
            //新加的全新目录需要readMe文件.
            "/架构之路/":[
                {
                    title:"架构师的自我修炼",
                    children:["架构师的自我修炼/程序设计修炼","架构师的自我修炼/架构方法修炼"]
                }
                ,{
                    title:"中台架构及实现-基于DDD和微服务",
                    children:["中台架构及实现/中台实现"]
                }
            ],
            "/java/":["","代码规范","java_base","execption","JDK8新特性/JDK8新特性","lambda/Lambda表达式","juc","JVM","Kafka","设计模式","Redis","redis/redis系统性学习","spring","SpringBoot","SpringCloud","mysql","总结的题目"],
            "/领域驱动设计/":["","实体","值对象","领域服务"],
            "/操作/":["","Git","github-CICD","npm","Maven","sql","other","软件插件安装","macbook常用操作","idea常用操作及设置"],
            "/工作经验/":["","实用的类","problem","experience","知识积累"],
            "/项目经验/":["","服务拆分-接口设计","微服务项目架构"],
            "/源码解析/":["","springboot源码解析"],
            "/程序员英语/":["","程序员英语"],
            "/面试突击班/":["","面试表达","基础面试题","多线程与IO","JVM面试突击班2025","JVM2024-下","JVM2024-上","redis2025","redis2024-下","redis2024-上","Mysql","Mysql2024-下","并发编程2025","并发编程2024","Spring-2024下","Spring-2024上","MQ2025上","MQ2024下","MQ2024上"],
            "/算法体系/":["","算法基础","算法新手班","7~8-堆-被火车撞了都不能忘记的结构","9-前缀树","10-排序总结,链表相关题目.md","11~13-二叉树","15~16-并查集-查连通区域神器","17-图","18~24-暴力递归到动态规划","25-滑动窗口内最大值或最小值问题","26-单调栈","28-KMP算法","29-Manacher算法","30-蓄水池算法","30-bfprt算法-topk","31-Morris遍历","32-线段树","大厂-21-树链刨分.md","33-IndexTree,AC自动机","34-与哈希函数有关的数据结构","35-资源限制类题目解题思路","41-数组三连问题","大厂刷题"],
            "/用友/":["","你在哪里","过滤器拦截器/过滤器拦截器","元数据/元数据","UI模板","新ui模板注册","领域事件相关"
                    ,"编码规则","用友Rule规则","自定义参照配置/自定义参照配置","用友调试","其他操作","预警配置"]
        }
    }
}