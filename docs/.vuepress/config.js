module.exports = {
    title: '冯手力-java学习之路',// 设置网站标题
    //dest: './docs/.vuepress/dist',// 设置输出目录
    dest: './dist',
    // base: '/',   // 设置站点根路径
    // base:'./',//打包用
    port: 9999,
    head: [],
    plugins: [],
    themeConfig: {
        sidebarDepth: 2,
        nav: [
            { text: '首页', link: '/' },
            { text: '操作', link: '/操作/' },
            { text:'工作经验', link: '/工作经验/'},
            { text:'项目经验', link: '/项目经验/'},
            { text: 'java知识', link: '/java/' },
            { text: '领域驱动设计', link: '/领域驱动设计/' },
            { text: '数据库知识', link: '/数据库/' },
            { text: '源码解析', link: '/源码解析/' },
            { text: '程序员英语', link: '/程序员英语/' },
            { text: '算法体系', link: '/算法体系/' },
            { text: '用友', link: '/用友/' }
            
        ],
        sidebar: {
            "/java/":["","代码规范","java_base","execption","lambda","juc","JVM","Kafka","设计模式","Redis","spring","SpringBoot","SpringCloud","总结的题目"],
            "/领域驱动设计/":["","实体","值对象","领域服务"],
            "/数据库/":["","数据库操作","mysql"],
            "/操作/":["","Git","github-CICD","npm","Maven","sql","other","软件插件安装","macbook常用操作","idea常用操作及设置"],
            "/工作经验/":["","实用的类","problem","experience","知识积累"],
            "/项目经验/":["","服务拆分-接口设计","微服务项目架构"],
            "/源码解析/":["","springboot源码解析"],
            "/程序员英语/":["","程序员英语"],
            "/算法体系/":["","算法基础"],
            "/用友/":["","你在哪里","UI模板","编码规则","用友Rule规则","用友调试","其他操作","预警配置"]
        }
    }
}