import Vue from 'vue'

Vue.component("Badge", () => import("/usr/local/lib/node_modules/vuepress/node_modules/@vuepress/theme-default/global-components/Badge"))
Vue.component("CodeBlock", () => import("/usr/local/lib/node_modules/vuepress/node_modules/@vuepress/theme-default/global-components/CodeBlock"))
Vue.component("CodeGroup", () => import("/usr/local/lib/node_modules/vuepress/node_modules/@vuepress/theme-default/global-components/CodeGroup"))


export default {}