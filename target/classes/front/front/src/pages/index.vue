<template>
	<div class="main-containers">
		<div class="top-container dy-top-container-div">
			<!--顶部项目名称展示-->
			<div class="dy-top-project-div">
				{{projectName}}
			</div>
			<!--顶部登陆信息展示-->
			<div>
				<div v-if="Token" class="dy-top-usersinfo-div">
					<span>用户名: {{ usersname }}；您的权限: {{ typename }} </span>
				</div>
				<el-button class="dy-top-logout-button" v-if="Token" @click="logout">退出登陆</el-button>
				<el-button class="dy-top-login-button" v-if="!Token" @click="toLogin()">登录/注册</el-button>
			</div>
		</div>
		<div class="body-containers dy-body-container-div">
			<!--顶部导航栏组件-->
			<system-menu></system-menu>
			<!--轮播图展示-->
			<div class="banner-preview" :style='{ "width": "100%", "margin": "0", "height": "auto" }'>
				<el-carousel :style='{ "width": "90%", "margin": "0 auto" }' trigger="click" indicator-position="inside"
					arrow="always" type="default" direction="horizontal" height="400px" :autoplay="true" :interval="3000"
					:loop="true">
					<el-carousel-item :style='{ "borderRadius": "0", "width": "100%", "height": "100%" }'
						v-for="item in carouselList" :key="item.id">
						<el-image :style='{ "objectFit": "cover", "width": "100%", "height": "100%"}'
							:src="baseUrl + item.image" fit="cover"></el-image>
					</el-carousel-item>
				</el-carousel>
			</div>
			<!--切换导航栏动态路由页面内容-->
			<router-view></router-view>
			<!--底部友情链接-->
			<div v-if="lianjieList && lianjieList.length > 0" class="dy-bottom-div">
			    <div :style='{"margin":"0"}'>友情链接</div>
			    <div v-for="item in lianjieList" :key="item.id"><el-link :underline='false' type="success" :href="item.url" target="_blank">{{ item.name }}</el-link></div>
			</div>
		</div>

	</div>
</template>

<script>
import Vue from 'vue'

export default {
	data() {
		return {
			activeIndex: '/index/home',
			baseUrl: this.$config.baseUrl,
			projectName: this.$config.projectName,
			carouselList: [],
			lianjieList:[],
			// menuList: this.$config.indexNav,
			Token: localStorage.getItem('Token')?localStorage.getItem('Token').replace('"','').replace('"',''):'',
			usersname: localStorage.getItem('usersname')?localStorage.getItem('usersname').replace('"','').replace('"',''):'',
			typename: localStorage.getItem('typename')?localStorage.getItem('typename').replace('"','').replace('"',''):'',
		}
	},
	created() {
		this.getCarousel();
		this.getAlLianjie();
	},
	mounted() {
		this.activeIndex = localStorage.getItem('keyPath') || '/index/home';
	},
	watch: {
		$route(newValue) {
			let that = this
			let url = window.location.href
			let arr = url.split('#')
			// for (let x in this.menuList) {
			// 	if (newValue.path == this.menuList[x].url) {
			// 		this.activeIndex = x
			// 	}
			// }
			this.Token = localStorage.getItem('Token')
		},
	},
	methods: {
		toLogin() {
			this.$router.push('/login');
		},
		logout() {
			localStorage.clear();
			Vue.http.headers.common['Token'] = "";
			this.$router.push('/index/home');
			this.activeIndex = '0'
			localStorage.setItem('keyPath', '/index/home')
			this.Token = ''
			this.$forceUpdate()
			this.$message({
				message: '退出成功',
				type: 'success',
				duration: 1000,
			});
		},
		getCarousel() {
			this.$http.get('lunbo/all').then(res => {
				if (res.data.code == 0) {
					this.carouselList = res.data.data;
				}
			});
		},
		getAlLianjie() {
			this.$http.get('lianjie/all').then(res => {
				if (res.data.code == 0) {
					this.lianjieList = res.data.data;
				}
			});
		},
		goMenu(path) {
			if (!localStorage.getItem('Token')) {
				this.toLogin();
			} else {
				this.$router.push(path);
			}
		},
	}
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.menu-preview {
	.el-scrollbar {
		height: 100%;

		& /deep/ .scrollbar-wrapper {
			overflow-x: hidden;
		}
	}
}


.banner-preview {
	.el-carousel /deep/ .el-carousel__indicator button {
		width: 0;
		height: 0;
		display: none;
	}
}

.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left {
	width: 36px;
	font-size: 12px;
	height: 36px;
}

.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left:hover {
	background: #2087c3;
}

.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right {
	width: 36px;
	font-size: 12px;
	height: 36px;
}

.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right:hover {
	background: #2087c3;
}

.banner-preview .el-carousel /deep/ .el-carousel__indicators {
	padding: 0;
	margin: 0 0 12px 0;
	z-index: 2;
	position: absolute;
	list-style: none;
}

.banner-preview .el-carousel /deep/ .el-carousel__indicators li {
	border-radius: 50%;
	padding: 0;
	margin: 0 4px;
	background: #fff;
	display: inline-block;
	width: 12px;
	opacity: 0.4;
	transition: 0.3s;
	height: 12px;
}

.banner-preview .el-carousel /deep/ .el-carousel__indicators li:hover {
	border-radius: 50%;
	padding: 0;
	margin: 0 4px;
	background: #fff;
	display: inline-block;
	width: 12px;
	opacity: 0.7;
	height: 12px;
}

.banner-preview .el-carousel /deep/ .el-carousel__indicators li.is-active {
	border-radius: 50%;
	padding: 0;
	margin: 0 4px;
	background: #fff;
	display: inline-block;
	width: 12px;
	opacity: 1;
	height: 12px;
}

.chat-content {
	.left-content {
		width: 100%;
		text-align: left;
	}

	.right-content {
		width: 100%;
		text-align: right;
	}
}
</style>
