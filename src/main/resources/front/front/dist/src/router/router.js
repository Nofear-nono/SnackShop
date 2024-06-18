import VueRouter from 'vue-router'
//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import usersResetpw from '@/pages/users/users-resetpw'
import dingdanMana from '../pages/dingdan/dingdan-mana'
import dingdanDetail from '../pages/dingdan/dingdan-detail'
import dingdanManaMy from '../pages/dingdan/dingdan-mana-my'
import dingdanAdd from '../pages/dingdan/dingdan-add'
import zhifufangshiDingdanAdd from '../pages/zhifufangshi/zhifufangshi-dingdan-add'
import usersDingdanAdd from '../pages/users/users-dingdan-add'
import dingdanxiangMana from '../pages/dingdanxiang/dingdanxiang-mana'
import dingdanxiangDetail from '../pages/dingdanxiang/dingdanxiang-detail'
import dingdanxiangManaMy from '../pages/dingdanxiang/dingdanxiang-mana-my'
import dingdanxiangAdd from '../pages/dingdanxiang/dingdanxiang-add'
import dingdanDingdanxiangAdd from '../pages/dingdan/dingdan-dingdanxiang-add'
import shangpinDingdanxiangAdd from '../pages/shangpin/shangpin-dingdanxiang-add'
import usersDingdanxiangAdd from '../pages/users/users-dingdanxiang-add'
import dxMana from '../pages/dx/dx-mana'
import dxDetail from '../pages/dx/dx-detail'
import dxAdd from '../pages/dx/dx-add'
import gonggaoMana from '../pages/gonggao/gonggao-mana'
import gonggaoDetail from '../pages/gonggao/gonggao-detail'
import gonggaoManaTp from '../pages/gonggao/gonggao-mana-tp'
import gonggaoAdd from '../pages/gonggao/gonggao-add'
import gouwucheMana from '../pages/gouwuche/gouwuche-mana'
import gouwucheDetail from '../pages/gouwuche/gouwuche-detail'
import gouwucheManaMy from '../pages/gouwuche/gouwuche-mana-my'
import gouwucheAdd from '../pages/gouwuche/gouwuche-add'
import shangpinGouwucheAdd from '../pages/shangpin/shangpin-gouwuche-add'
import usersGouwucheAdd from '../pages/users/users-gouwuche-add'
import lianjieMana from '../pages/lianjie/lianjie-mana'
import lianjieDetail from '../pages/lianjie/lianjie-detail'
import lianjieAdd from '../pages/lianjie/lianjie-add'
import liuyanMana from '../pages/liuyan/liuyan-mana'
import liuyanDetail from '../pages/liuyan/liuyan-detail'
import liuyanManaMy from '../pages/liuyan/liuyan-mana-my'
import liuyanAdd from '../pages/liuyan/liuyan-add'
import usersLiuyanAdd from '../pages/users/users-liuyan-add'
import lunboMana from '../pages/lunbo/lunbo-mana'
import lunboDetail from '../pages/lunbo/lunbo-detail'
import lunboManaTp from '../pages/lunbo/lunbo-mana-tp'
import lunboAdd from '../pages/lunbo/lunbo-add'
import pingjiaMana from '../pages/pingjia/pingjia-mana'
import pingjiaDetail from '../pages/pingjia/pingjia-detail'
import pingjiaManaMy from '../pages/pingjia/pingjia-mana-my'
import pingjiaAdd from '../pages/pingjia/pingjia-add'
import shangpinPingjiaAdd from '../pages/shangpin/shangpin-pingjia-add'
import usersPingjiaAdd from '../pages/users/users-pingjia-add'
import pinleiMana from '../pages/pinlei/pinlei-mana'
import pinleiDetail from '../pages/pinlei/pinlei-detail'
import pinleiAdd from '../pages/pinlei/pinlei-add'
import shangpinMana from '../pages/shangpin/shangpin-mana'
import shangpinDetail from '../pages/shangpin/shangpin-detail'
import shangpinManaTp from '../pages/shangpin/shangpin-mana-tp'
import shangpinAdd from '../pages/shangpin/shangpin-add'
import pinleiShangpinAdd from '../pages/pinlei/pinlei-shangpin-add'
import shenqingMana from '../pages/shenqing/shenqing-mana'
import shenqingDetail from '../pages/shenqing/shenqing-detail'
import shenqingManaMy from '../pages/shenqing/shenqing-mana-my'
import shenqingAdd from '../pages/shenqing/shenqing-add'
import usersShenqingAdd from '../pages/users/users-shenqing-add'
import shoucangMana from '../pages/shoucang/shoucang-mana'
import shoucangDetail from '../pages/shoucang/shoucang-detail'
import shoucangManaMy from '../pages/shoucang/shoucang-mana-my'
import shoucangAdd from '../pages/shoucang/shoucang-add'
import shangpinShoucangAdd from '../pages/shangpin/shangpin-shoucang-add'
import usersShoucangAdd from '../pages/users/users-shoucang-add'
import usersMana from '../pages/users/users-mana'
import usersDetail from '../pages/users/users-detail'
import usersAdd from '../pages/users/users-add'
import xinwenMana from '../pages/xinwen/xinwen-mana'
import xinwenDetail from '../pages/xinwen/xinwen-detail'
import xinwenManaTp from '../pages/xinwen/xinwen-mana-tp'
import xinwenAdd from '../pages/xinwen/xinwen-add'
import zhifufangshiMana from '../pages/zhifufangshi/zhifufangshi-mana'
import zhifufangshiDetail from '../pages/zhifufangshi/zhifufangshi-detail'
import zhifufangshiAdd from '../pages/zhifufangshi/zhifufangshi-add'


const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
//配置路由
export default new VueRouter({
	routes: [
		{
			path: '/',
			redirect: '/index/home'
		},
		{
			path: '/index',
			component: Index,
			children: [
				{
					path: 'home',
					component: Home
				},
				{
					path: 'usersResetpw',
					component: usersResetpw
				},

				{
					path: 'usersDingdanAdd',
					component: usersDingdanAdd
				},

				{
					path: 'usersPingjiaAdd',
					component: usersPingjiaAdd
				},
				{
					path: 'pinleiMana',
					component: pinleiMana
				},
				{
					path: 'pinleiDetail',
					component: pinleiDetail
				},
				{
					path: 'pinleiAdd',
					component: pinleiAdd
				},
				{
					path: 'shangpinMana',
					component: shangpinMana
				},
				{
					path: 'shangpinDetail',
					component: shangpinDetail
				},
				{
					path: 'shangpinManaTp',
					component: shangpinManaTp
				},
				{
					path: 'shangpinAdd',
					component: shangpinAdd
				},
				{
					path: 'pinleiShangpinAdd',
					component: pinleiShangpinAdd
				},
				{
					path: 'shenqingMana',
					component: shenqingMana
				},
				{
					path: 'shenqingDetail',
					component: shenqingDetail
				},
				{
					path: 'shenqingManaMy',
					component: shenqingManaMy
				},
				{
					path: 'shenqingAdd',
					component: shenqingAdd
				},
				{
					path: 'usersShenqingAdd',
					component: usersShenqingAdd
				},
				{
					path: 'shoucangMana',
					component: shoucangMana
				},
				{
					path: 'shoucangDetail',
					component: shoucangDetail
				},
				{
					path: 'shoucangManaMy',
					component: shoucangManaMy
				},
				{
					path: 'shoucangAdd',
					component: shoucangAdd
				},
				{
					path: 'shangpinShoucangAdd',
					component: shangpinShoucangAdd
				},
				{
					path: 'usersShoucangAdd',
					component: usersShoucangAdd
				},
				{
					path: 'usersMana',
					component: usersMana
				},
				{
					path: 'usersDetail',
					component: usersDetail
				},
				{
					path: 'usersAdd',
					component: usersAdd
				},


			]
		},
		{
			path: '/login',
			component: Login
		},
	]
})
