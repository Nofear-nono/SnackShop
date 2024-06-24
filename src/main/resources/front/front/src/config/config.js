export default {
    baseUrl: 'http://localhost:8080/springbootzongse/',
    projectName:'零食购物网站',
    indexNav: [
        {
            name: '首页',
            url: '/index/home',
            icon:'el-icon-s-home'
        },
        {
            name: '介绍',
            url: '/index/dxMana',
            icon:'el-icon-document'
        },
        {
            name: '公告',
            url: '/index/gonggaoManaTp',
            icon:'el-icon-s-help'
        },
        {
            name: '药品信息',
            url: '/index/shangpinManaTp',
            icon:'el-icon-goods'
        },
        {
            name: '特价药品',
            url: '/index/shangpinManaTp?shenhe=yes',
            icon:'el-icon-s-goods'
        },
        {
            name: '热销药品',
            url: '/index/shangpinMana?sortProperty=xiaoshoushuliang',
            icon:'el-icon-s-shop'
        },
        {
            name: '购物车',
            url: '/index/gouwucheManaMy',
            icon:'el-icon-shopping-cart-2'
        },
        {
            name: '流行音乐',
            url: '/index/yinyueMana?sortProperty=dianjicishu',
            icon:'el-icon-mic'
        },
        {
            name: '药品资讯',
            url: '/index/yaopinzixunManaTp',
            icon:'el-icon-view'
        },
        {
            name: '在线留言',
            url: '/index/liuyanAdd',
            icon:'el-icon-edit'
        },
        {
            name: '用户登陆',
            url: '/login',
            icon:'el-icon-s-custom'
        },
        {
            name: '用户注册',
            url: '/index/usersAdd',
            icon:'el-icon-user'
        },
        {
            name: '留言查看',
            url: '/index/liuyanMana',
            icon:'el-icon-s-comment'
        },  
    ]
}
