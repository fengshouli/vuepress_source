module.exports = {
    title: '冯手力-java学习之路',// 设置网站标题
    //dest: './docs/.vuepress/dist',// 设置输出目录
    dest: './dist',
    // base: '/',   // 设置站点根路径
    // base:'./',//打包用
    port: 8080,
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
            { text: '数据库知识', link: '/数据库/' },
            { text: '源码解析', link: '/源码解析/' },
            { text: '算法体系', link: '/算法体系/' }
            
        ],
        sidebar: {
            "/java/":["","java_base","lambda","juc","Kafka","设计模式","Redis","spring","SpringBoot","SpringCloud","总结的题目"],
            "/数据库/":["","mysql"],
            "/操作/":["","Git","Maven","sql","other","软件插件安装"],
            "/工作经验/":["","实用的类","problem","experience","知识积累"],
            "/项目经验/":["","服务拆分-接口设计","微服务项目架构"],
            "/源码解析/":["","springboot源码解析.md"],
            "/算法体系/":["","算法基础.md"]
        }
    }
}