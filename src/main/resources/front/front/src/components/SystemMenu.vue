<template>
    <div class="menu-preview dy-top-menu-div">
        <el-menu class="el-menu-horizontal-demo dy-top-horizonta-menu" :default-active="this.$router.path"
            :unique-opened="true" mode="horizontal" :router="true" @select="handleSelect">
            <el-menu-item index="/index/home">
                <i v-if="true" class="dy-top-menu-item-i el-icon-s-home"></i>
                <span class="dy-top-menu-item-span">首页</span>
            </el-menu-item>
            <el-menu-item index="/index/dxMana">
                <i v-if="true" class="dy-top-menu-item-i el-icon-document"></i>
                <span class="dy-top-menu-item-span">介绍</span>
            </el-menu-item>
            <el-menu-item index="/index/gonggaoManaTp">
                <i v-if="true" class="dy-top-menu-item-i el-icon-s-help"></i>
                <span class="dy-top-menu-item-span">公告</span>
            </el-menu-item>
            <el-submenu index="1">
                <template slot="title">
                    <i v-if="true" class="dy-top-menu-item-i el-icon-s-goods"></i>
                    <span class="dy-top-menu-item-span">商品</span>
                </template>
                <el-menu-item index="/index/shangpinManaTp" class="dy-el-menu-item">
                    <i v-if="true" class="dy-top-menu-item-i-2 el-icon-goods"></i>
                    <span class="dy-top-menu-item-span-2">商品信息</span>
                </el-menu-item>
                <el-menu-item index="/index/shangpinManaTp?shenhe=yes" class="dy-el-menu-item">
                    <i v-if="true" class="dy-top-menu-item-i-2 el-icon-present"></i>
                    <span class="dy-top-menu-item-span-2">特价商品</span>
                </el-menu-item>
                <!-- <el-menu-item index="/index/shangpinMana?sortProperty=xiaoshoushuliang" class="dy-el-menu-item">
                    <i v-if="true" class="dy-top-menu-item-i-2 el-icon-discount"></i>
                    <span class="dy-top-menu-item-span-2">热销商品</span>
                </el-menu-item> -->
            </el-submenu>
            <el-menu-item index="/index/shangpinMana?sortProperty=xiaoshoushuliang">
                <i v-if="true" class="dy-top-menu-item-i el-icon-shopping-cart-2"></i>
                <span class="dy-top-menu-item-span">热销商品</span>
            </el-menu-item>
            <el-menu-item index="/index/gouwucheManaMy">
                <i v-if="true" class="dy-top-menu-item-i el-icon-shopping-cart-2"></i>
                <span class="dy-top-menu-item-span">购物车</span>
            </el-menu-item>
            <el-menu-item index="/index/xinwenManaTp">
                <i v-if="true" class="dy-top-menu-item-i el-icon-view"></i>
                <span class="dy-top-menu-item-span">商品资讯</span>
            </el-menu-item>

            <!-- <el-submenu index="2">
                <template slot="title">
                    <i v-if="true" class="dy-top-menu-item-i el-icon-mic"></i>
                    <span class="dy-top-menu-item-span">音乐</span>
                </template>
                <el-menu-item index="/index/yinyueMana" class="dy-el-menu-item">
                    <i v-if="true" class="dy-top-menu-item-i-2 el-icon-service"></i>
                    <span class="dy-top-menu-item-span-2">在线音乐</span>
                </el-menu-item>
                <el-menu-item index="/index/yinyueMana?sortProperty=dianjicishu" class="dy-el-menu-item">
                    <i v-if="true" class="dy-top-menu-item-i-2 el-icon-headset"></i>
                    <span class="dy-top-menu-item-span-2">流行音乐</span>
                </el-menu-item>
            </el-submenu> -->

            <el-submenu index="3">
                <template slot="title">
                    <i v-if="true" class="dy-top-menu-item-i el-icon-s-comment"></i>
                    <span class="dy-top-menu-item-span">在线留言</span>
                </template>
                <el-menu-item index="/index/liuyanAdd" class="dy-el-menu-item">
                    <i v-if="true" class="dy-top-menu-item-i-2 el-icon-edit"></i>
                    <span class="dy-top-menu-item-span-2">我要留言</span>
                </el-menu-item>
                <el-menu-item index="/index/liuyanMana" class="dy-el-menu-item">
                    <i v-if="true" class="dy-top-menu-item-i-2 el-icon-chat-line-square"></i>
                    <span class="dy-top-menu-item-span-2">留言查看</span>
                </el-menu-item>
            </el-submenu>
            <!-- <el-menu-item index="/index/usersAdd">
                <i v-if="true" class="dy-top-menu-item-i el-icon-s-custom"></i>
                <span class="dy-top-menu-item-span">用户注册</span>
            </el-menu-item> -->
            <el-menu-item @click="goBackend">
                <i v-if="true" class="dy-top-menu-item-i el-icon-user-solid"></i>
                <span class="dy-top-menu-item-span">后台管理</span>
            </el-menu-item>
        </el-menu>
    </div>
</template>
<script>
export default{
    methods:{
        handleSelect(keyPath) {
			if (keyPath) {
				localStorage.setItem('keyPath', keyPath)
			}
		},
        goBackend() {
			window.open(`${this.$config.baseUrl}admin/dist/index.html`, "_blank");
		},
    },
}
</script>
<style></style>