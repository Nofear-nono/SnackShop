import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import register from '@/views/register'
import center from '@/views/center'
import dingdanchakan from '@/views/modules/dingdan/chakan'
import dingdanmana from '@/views/modules/dingdan/mana'
import dingdanadd from '@/views/modules/dingdan/dingdan-add'
import dingdanchakanmy from '@/views/modules/dingdan/chakanmy'
import dingdanmanamy from '@/views/modules/dingdan/manamy'
import dingdanxiangchakan from '@/views/modules/dingdanxiang/chakan'
import dingdanxiangmana from '@/views/modules/dingdanxiang/mana'
import dingdanxiangadd from '@/views/modules/dingdanxiang/dingdanxiang-add'
import dingdanxiangchakanmy from '@/views/modules/dingdanxiang/chakanmy'
import dingdanxiangmanamy from '@/views/modules/dingdanxiang/manamy'
import dxchakan from '@/views/modules/dx/chakan'
import dxmana from '@/views/modules/dx/mana'
import dxadd from '@/views/modules/dx/dx-add'
import gonggaochakan from '@/views/modules/gonggao/chakan'
import gonggaomana from '@/views/modules/gonggao/mana'
import gonggaoadd from '@/views/modules/gonggao/gonggao-add'
import gouwuchechakan from '@/views/modules/gouwuche/chakan'
import gouwuchemana from '@/views/modules/gouwuche/mana'
import gouwucheadd from '@/views/modules/gouwuche/gouwuche-add'
import gouwuchechakanmy from '@/views/modules/gouwuche/chakanmy'
import gouwuchemanamy from '@/views/modules/gouwuche/manamy'
import lianjiechakan from '@/views/modules/lianjie/chakan'
import lianjiemana from '@/views/modules/lianjie/mana'
import lianjieadd from '@/views/modules/lianjie/lianjie-add'
import liuyanchakan from '@/views/modules/liuyan/chakan'
import liuyanmana from '@/views/modules/liuyan/mana'
import liuyanadd from '@/views/modules/liuyan/liuyan-add'
import liuyanchakanmy from '@/views/modules/liuyan/chakanmy'
import liuyanmanamy from '@/views/modules/liuyan/manamy'
import lunbochakan from '@/views/modules/lunbo/chakan'
import lunbomana from '@/views/modules/lunbo/mana'
import lunboadd from '@/views/modules/lunbo/lunbo-add'
import pingjiachakan from '@/views/modules/pingjia/chakan'
import pingjiamana from '@/views/modules/pingjia/mana'
import pingjiaadd from '@/views/modules/pingjia/pingjia-add'
import pingjiachakanmy from '@/views/modules/pingjia/chakanmy'
import pingjiamanamy from '@/views/modules/pingjia/manamy'
import pinleichakan from '@/views/modules/pinlei/chakan'
import pinleimana from '@/views/modules/pinlei/mana'
import pinleiadd from '@/views/modules/pinlei/pinlei-add'
import shangpinchakan from '@/views/modules/shangpin/chakan'
import shangpinmana from '@/views/modules/shangpin/mana'
import shangpinadd from '@/views/modules/shangpin/shangpin-add'
import shenqingchakan from '@/views/modules/shenqing/chakan'
import shenqingmana from '@/views/modules/shenqing/mana'
import shenqingadd from '@/views/modules/shenqing/shenqing-add'
import shenqingchakanmy from '@/views/modules/shenqing/chakanmy'
import shenqingmanamy from '@/views/modules/shenqing/manamy'
import shoucangchakan from '@/views/modules/shoucang/chakan'
import shoucangmana from '@/views/modules/shoucang/mana'
import shoucangadd from '@/views/modules/shoucang/shoucang-add'
import shoucangchakanmy from '@/views/modules/shoucang/chakanmy'
import shoucangmanamy from '@/views/modules/shoucang/manamy'
import userschakan from '@/views/modules/users/chakan'
import usersmana from '@/views/modules/users/mana'
import usersadd from '@/views/modules/users/users-add'
import xinwenchakan from '@/views/modules/xinwen/chakan'
import xinwenmana from '@/views/modules/xinwen/mana'
import xinwenadd from '@/views/modules/xinwen/xinwen-add'
import zhifufangshichakan from '@/views/modules/zhifufangshi/chakan'
import zhifufangshimana from '@/views/modules/zhifufangshi/mana'
import zhifufangshiadd from '@/views/modules/zhifufangshi/zhifufangshi-add'


//2.配置路由   注意：名字
const routes = [{
  path: '/index',
  name: '首页',
  component: Index,
  children: [{
    // 这里不设置值，是把main作为默认页面
    path: '/',
    name: '首页',
    component: Home,
    meta: { icon: '', title: 'center' }
  }
  , {
    path: '/updatePassword',
    name: '修改密码',
    component: UpdatePassword,
    meta: { icon: '', title: 'updatePassword' }
  }, {
    path: '/center',
    name: '修改资料',
    component: center,
    meta: { icon: '', title: 'center' }
  }
  , {
    path: '/dingdanchakan',
    name: '订单查看',
    component: dingdanchakan
  }
  , {
    path: '/dingdanmana',
    name: '订单查询',
    component: dingdanmana
  }
  , {
    path: '/dingdanadd',
    name: '订单添加',
    component: dingdanadd
  }
  , {
    path: '/dingdanchakanmy',
    name: '查看我的订单',
    component: dingdanchakanmy
  }
  , {
    path: '/dingdanmanamy',
    name: '管理我的订单',
    component: dingdanmanamy
  }
  , {
    path: '/dingdanxiangchakan',
    name: '订单项查看',
    component: dingdanxiangchakan
  }
  , {
    path: '/dingdanxiangmana',
    name: '订单项查询',
    component: dingdanxiangmana
  }
  , {
    path: '/dingdanxiangadd',
    name: '订单项添加',
    component: dingdanxiangadd
  }
  , {
    path: '/dingdanxiangchakanmy',
    name: '查看我的订单项',
    component: dingdanxiangchakanmy
  }
  , {
    path: '/dingdanxiangmanamy',
    name: '管理我的订单项',
    component: dingdanxiangmanamy
  }
  , {
    path: '/dxchakan',
    name: '信息介绍查看',
    component: dxchakan
  }
  , {
    path: '/dxmana',
    name: '信息介绍查询',
    component: dxmana
  }
  , {
    path: '/dxadd',
    name: '信息介绍添加',
    component: dxadd
  }
  , {
    path: '/gonggaochakan',
    name: '公告查看',
    component: gonggaochakan
  }
  , {
    path: '/gonggaomana',
    name: '公告查询',
    component: gonggaomana
  }
  , {
    path: '/gonggaoadd',
    name: '公告添加',
    component: gonggaoadd
  }
  , {
    path: '/gouwuchechakan',
    name: '购物车查看',
    component: gouwuchechakan
  }
  , {
    path: '/gouwuchemana',
    name: '购物车查询',
    component: gouwuchemana
  }
  , {
    path: '/gouwucheadd',
    name: '购物车添加',
    component: gouwucheadd
  }
  , {
    path: '/gouwuchechakanmy',
    name: '查看我的购物车',
    component: gouwuchechakanmy
  }
  , {
    path: '/gouwuchemanamy',
    name: '管理我的购物车',
    component: gouwuchemanamy
  }
  , {
    path: '/lianjiechakan',
    name: '友情链接查看',
    component: lianjiechakan
  }
  , {
    path: '/lianjiemana',
    name: '友情链接查询',
    component: lianjiemana
  }
  , {
    path: '/lianjieadd',
    name: '友情链接添加',
    component: lianjieadd
  }
  , {
    path: '/liuyanchakan',
    name: '留言反馈查看',
    component: liuyanchakan
  }
  , {
    path: '/liuyanmana',
    name: '留言反馈查询',
    component: liuyanmana
  }
  , {
    path: '/liuyanadd',
    name: '留言反馈添加',
    component: liuyanadd
  }
  , {
    path: '/liuyanchakanmy',
    name: '查看我的留言反馈',
    component: liuyanchakanmy
  }
  , {
    path: '/liuyanmanamy',
    name: '管理我的留言反馈',
    component: liuyanmanamy
  }
  , {
    path: '/lunbochakan',
    name: '轮播图查看',
    component: lunbochakan
  }
  , {
    path: '/lunbomana',
    name: '轮播图查询',
    component: lunbomana
  }
  , {
    path: '/lunboadd',
    name: '轮播图添加',
    component: lunboadd
  }
  , {
    path: '/pingjiachakan',
    name: '评论查看',
    component: pingjiachakan
  }
  , {
    path: '/pingjiamana',
    name: '评论查询',
    component: pingjiamana
  }
  , {
    path: '/pingjiaadd',
    name: '评论添加',
    component: pingjiaadd
  }
  , {
    path: '/pingjiachakanmy',
    name: '查看我的评论',
    component: pingjiachakanmy
  }
  , {
    path: '/pingjiamanamy',
    name: '管理我的评论',
    component: pingjiamanamy
  }
  , {
    path: '/pinleichakan',
    name: '分类查看',
    component: pinleichakan
  }
  , {
    path: '/pinleimana',
    name: '分类查询',
    component: pinleimana
  }
  , {
    path: '/pinleiadd',
    name: '分类添加',
    component: pinleiadd
  }
  , {
    path: '/shangpinchakan',
    name: '零食查看',
    component: shangpinchakan
  }
  , {
    path: '/shangpinmana',
    name: '零食查询',
    component: shangpinmana
  }
  , {
    path: '/shangpinadd',
    name: '零食添加',
    component: shangpinadd
  }
  , {
    path: '/shenqingchakan',
    name: '售后申请查看',
    component: shenqingchakan
  }
  , {
    path: '/shenqingmana',
    name: '售后申请查询',
    component: shenqingmana
  }
  , {
    path: '/shenqingadd',
    name: '售后申请添加',
    component: shenqingadd
  }
  , {
    path: '/shenqingchakanmy',
    name: '查看我的售后申请',
    component: shenqingchakanmy
  }
  , {
    path: '/shenqingmanamy',
    name: '管理我的售后申请',
    component: shenqingmanamy
  }
  , {
    path: '/shoucangchakan',
    name: '收藏查看',
    component: shoucangchakan
  }
  , {
    path: '/shoucangmana',
    name: '收藏查询',
    component: shoucangmana
  }
  , {
    path: '/shoucangadd',
    name: '收藏添加',
    component: shoucangadd
  }
  , {
    path: '/shoucangchakanmy',
    name: '查看我的收藏',
    component: shoucangchakanmy
  }
  , {
    path: '/shoucangmanamy',
    name: '管理我的收藏',
    component: shoucangmanamy
  }
  , {
    path: '/userschakan',
    name: '用户查看',
    component: userschakan
  }
  , {
    path: '/usersmana',
    name: '用户查询',
    component: usersmana
  }
  , {
    path: '/usersadd',
    name: '用户添加',
    component: usersadd
  }
  , {
    path: '/xinwenchakan',
    name: '新闻查看',
    component: xinwenchakan
  }
  , {
    path: '/xinwenmana',
    name: '新闻查询',
    component: xinwenmana
  }
  , {
    path: '/xinwenadd',
    name: '新闻添加',
    component: xinwenadd
  }
  , {
    path: '/zhifufangshichakan',
    name: '支付方式查看',
    component: zhifufangshichakan
  }
  , {
    path: '/zhifufangshimana',
    name: '支付方式查询',
    component: zhifufangshimana
  }
  , {
    path: '/zhifufangshiadd',
    name: '支付方式添加',
    component: zhifufangshiadd
  }

  ]
},
{
  path: '/login',
  name: 'login',
  component: Login,
  meta: { icon: '', title: 'login' }
},
{
  path: '/register',
  name: 'register',
  component: register,
  meta: { icon: '', title: 'register' }
},
{
  path: '/',
  name: '首页',
  redirect: '/index'
}, /*默认跳转路由*/
{
  path: '*',
  component: NotFound
}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

//路由导航冗余报错（路由重复）
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

export default router;
