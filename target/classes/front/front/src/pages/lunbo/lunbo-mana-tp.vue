<template>
	<div>
		<div class="breadcrumb-preview dy-breadcrumb-div">
			<el-breadcrumb :separator="'Ξ'"
				:style='{ "width": "1200px", "margin": "0 auto", "fontSize": "14px", "lineHeight": "1" }'>
				<el-breadcrumb-item>首页</el-breadcrumb-item>
				<el-breadcrumb-item>轮播图图片列表</el-breadcrumb-item>
			</el-breadcrumb>
		</div>

		<div class="list-preview"
			:style='{ "margin": "0px auto", "flexWrap": "wrap", "background": "none", "display": "flex", "width": "1200px", "position": "relative", "justifyContent": "space-between" }'>
			<!-- 搜索区域 -->
			<el-form :inline="true" :model="formSearch" class="list-form-pv dy-list-form">
				<el-form-item :style='{ "margin": "0 10px" }' v-if="!isQuery.biaoti">
					<div v-if="true" class="lable" :style='{ "width": "auto", "padding": "0 10px", "lineHeight": "42px", "display": "inline-block" }'>标题</div>
					<el-input suffix-icon="el-icon-search" v-model="formSearch.biaoti" placeholder="标题" clearable></el-input>
				</el-form-item>

				<el-button class="dy-search-button" type="primary" @click="search">
					<i :style='{"margin": "0 10px 0 0"}' class="el-icon-search"></i>查询</el-button>
			</el-form>

			<!-- 数据列表 -->
			<div class="list" :style='{ "width": "100%", "margin": "0", "background": "none", "order": "3" }'>

				<div class="list2 index-pv1 dy-list-div">
					<div :style='{ "border": "1px solid #ccc", "padding": "8px", "margin": "10px 5px", "borderRadius": "4px", "flexWrap": "wrap", "background": "#fff", "display": "flex", "width": "24%", "fontSize": "0", "position": "relative", "justifyContent": "space-between", "height": "auto", "float": "left"}'
						v-for="(item, index) in dataList" :key="index" @click="toDetail(item.id)"
						class="list-item animation-box">
						<img :style='{ "cursor": "pointer", "padding": "16px", "objectFit": "cover", "borderRadius": "10%", "display": "inline-block", "width": "240px", "height": "240px" }'
							:src="baseUrl + item.image" class="image" />
						<div class="item-info"
							:style='{ "width": "100%", "padding": "20px 20px 0", "overflow": "hidden", "background": "rgba(255,255,255,1)", "display": "inline-block", "height": "50px","text-align":"center" }'>
							<div :style='{"cursor": "pointer", "color": "#333", "background": "none", "borderWidth": "0 0 1px", "lineHeight": "32px", "fontSize": "14px", "borderStyle": "solid" }'
								class="name">{{ item.biaoti }}<span class="price" v-if="item.jiage" :style='{ "fontSize": "12px","color": "#c00" }'>&nbsp;&nbsp;&nbsp;&nbsp;￥{{ item.jiage }}</span></div>
						</div>
					</div>
				</div>
			</div>

			<el-pagination background class="pagination" :pager-count="7" :page-size="pageSize" :page-sizes="pageSizes"
			prev-text="上一页" next-text="下一页" :hide-on-single-page="false"
			:layout='["total", "prev", "pager", "next", "sizes", "jumper"].join()' :total="total"
			:style='{ "padding": "0", "margin": "20px auto  50px auto", "whiteSpace": "nowrap", "color": "#333", "width": "1200px", "fontWeight": "500", "order": "4" }'
			@current-change="curChange" @prev-click="prevClick" @next-click="nextClick"
			@size-change="sizeChangeHandle">
		    </el-pagination>
			<div :style='{ "padding": "0px 500px 0px 565px ", "position": "absolute", "bottom": "0" }'>
				<el-button class="dy-back-button" type="info" @click="back">返回</el-button>
			</div>

		</div>
	</div>
</template>

<script>
export default {
	//数据集合
	data() {
		return {
			baseUrl: this.$config.baseUrl,
			isQuery: {
			},
			formSearch: {
				key: '',
			},
			sortProperty: "id",
			dataList: [],
			total: 1,
			pageSize: 8,
			pageIndex: 1,
			pageSizes: [8, 12, 24, 40, 80],
			totalPage: 1,
			xingbieOptions: [],
			typeOptions: [],
			shenheOptions: [],

		}
	},
	watch: {
		$route: function (to, from) {
			this.$router.go(0);
			// window.location.reload();
		},
	},
	created() {
		this.init();
		this.getList();
	},
	//方法集合
	methods: {
		//返回
		back() {
			this.$router.go(-1);
		},
		//页面初始化
		init() {
			this.shenheOptions = "yes,no".split(',');
			this.xingbieOptions = "男,女".split(',');
			this.typeOptions = [{ value: '0', label: '管理' }, { value: '2', label: '用户' }];
			if (this.$route.query.sortProperty) {
				this.sortProperty = this.$route.query.sortProperty;
			}

		},
		//点击搜索按钮方法
		search() {
			this.pageIndex = 1;
			this.getList();
		},
		getList() {
			let params = {
				pageNo: this.pageIndex, //页码
				pageSize: this.pageSize, //页大小
				sortProperty: this.sortProperty, //排序列
			}
			let searchWhere = {};
			if (this.formSearch.biaoti != '' && this.formSearch.biaoti != undefined) {
				searchWhere.biaoti = this.formSearch.biaoti;
			}

			if (this.$route.query.biaoti) {
				searchWhere.biaoti = this.$route.query.biaoti;
				this.formSearch.biaoti = this.$route.query.biaoti;
				this.isQuery.biaoti = true;
			} else {
				this.isQuery.biaoti = false;
			}


			this.$http.get('lunbo/manaqiantp', { params: Object.assign(params, searchWhere) }).then(res => {
				if (res.data.code == 0) {
					this.dataList = res.data.data.records;
					this.totalPage = res.data.data.pageCount;
					this.total = res.data.data.total;
				}
			});
		},
		curChange(page) {
			this.pageIndex = page;
			this.getList();
		},
		prevClick(page) {
			this.pageIndex = page;
			this.getList();
		},
		nextClick(page) {
			this.pageIndex = page;
			this.getList();
		},
		//pageSize触发
		sizeChangeHandle(val) {
			this.pageSize = val;
			this.pageIndex = 1;
			this.getList();
		},
		toDetail(id) {
			this.$router.push({ path: '/index/lunboDetail', query: { id: id } });
		},

	}
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.list-preview .list-form-pv .el-input {
	width: auto;
}

.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__separator {
	margin: 0 9px;
	color: #ccc;
	font-weight: 500;
}

.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__inner a {
	color: #333;
	display: inline-block;
}

.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__inner {
	color: #999;
	display: inline-block;
}

.category-1 .item {
	cursor: pointer;
	border: 0px solid #ffd800;
	margin: 0 10px 0 0;
	color: #555;
	white-space: nowrap;
	font-size: 14px;
	line-height: 40px;
	text-overflow: ellipsis;
	border-radius: 30px;
	box-shadow: 0px 0px 0px #ceb44a;
	overflow: hidden;
	background: linear-gradient(180deg, rgba(255, 238, 161, 1) 0%, rgba(255, 238, 161, 1) 51%, rgba(252, 213, 69, 1) 51%, rgba(252, 216, 69, 1) 100%);
	width: 130px;
	text-align: center;
}

.category-1 .item:hover {
	cursor: pointer;
	border: 0px solid #fcbc45;
	border-radius: 10px;
	margin: 0 10px 0 0;
	color: #333;
	background: linear-gradient(180deg, rgba(255, 238, 161, 1) 0%, rgba(255, 238, 161, 1) 51%, rgba(252, 188, 69, 1) 51%, rgba(252, 188, 69, 1) 100%);
	width: 130px;
	font-size: 14px;
	line-height: 40px;
	text-align: center;
}

.category-1 .item.active {
	cursor: pointer;
	border: 0px solid #fcbc45;
	border-radius: 10px;
	margin: 0 10px 0 0;
	color: #333;
	background: linear-gradient(180deg, rgba(255, 238, 161, 1) 0%, rgba(255, 238, 161, 1) 51%, rgba(252, 188, 69, 1) 51%, rgba(252, 188, 69, 1) 100%);
	width: 130px;
	font-size: 14px;
	line-height: 40px;
	text-align: center;
}

.category-2 .item {
	cursor: pointer;
	border-radius: 4px;
	box-shadow: 0;
	margin: 0 0 10px 0;
	color: #fff;
	background: linear-gradient(135deg, rgba(17, 112, 210, 1) 0%, rgba(8, 179, 68, 1) 100%);
	width: 100%;
	font-size: 14px;
	line-height: 36px;
	text-align: center;
}

.category-2 .item:hover {
	cursor: pointer;
	border: 1px solid #1170d2;
	border-radius: 4px;
	box-shadow: 0;
	margin: 0 0 10px 0;
	color: #fff;
	background: linear-gradient(135deg, rgba(8, 179, 68, 1) 0%, rgba(17, 112, 210, 1) 100%);
	width: 100%;
	font-size: 14px;
	line-height: 36px;
	text-align: center;
}

.category-2 .item.active {
	cursor: pointer;
	border: 1px solid #1170d2;
	border-radius: 4px;
	box-shadow: 0;
	margin: 0 0 10px 0;
	color: #fff;
	background: linear-gradient(135deg, rgba(8, 179, 68, 1) 0%, rgba(17, 112, 210, 1) 100%);
	width: 100%;
	font-size: 14px;
	line-height: 36px;
	text-align: center;
}

.list-form-pv .el-input /deep/ .el-input__inner {
	border: 1px solid #ccc;
	border-radius: 8px;
	padding: 0 10px;
	box-shadow: 1px 1px 1px #ccc;
	margin: 0px;
	outline: none;
	color: #666;
	width: 140px;
	font-size: 14px;
	line-height: 40px;
	height: 40px;
}

.list-form-pv .el-select /deep/ .el-input__inner {
	border: 1px solid #ccc;
	border-radius: 8px;
	padding: 0 10px;
	box-shadow: 1px 1px 1px #ccc;
	margin: 0px;
	outline: none;
	color: #666;
	width: 140px;
	font-size: 14px;
	line-height: 40px;
	height: 40px;
}

.list-form-pv .el-date-editor /deep/ .el-input__inner {
	border: 1px solid #ccc;
	border-radius: 8px;
	padding: 0 30px;
	box-shadow: 1px 1px 1px #ccc;
	margin: 0px;
	outline: none;
	color: #666;
	width: 140px;
	font-size: 14px;
	line-height: 40px;
	height: 40px;
}

.list .index-pv1 .animation-box {
	transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
	z-index: initial;
}

.list .index-pv1 .animation-box:hover {
	-webkit-perspective: 1000px;
	perspective: 1000px;
	transition: 0.3s;
	z-index: 1;
}

.list .index-pv1 .animation-box img {
	transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
}

.list .index-pv1 .animation-box img:hover {
	filter: brightness(1.1);
	transform: rotate(0deg) scale(1.06);
	-webkit-perspective: 1000px;
	perspective: 1000px;
	transition: all 0.3s ease-in-out 0s;
}

.el-pagination /deep/ .el-pagination__total {
	margin: 0 10px 0 0;
	color: #666;
	font-weight: 400;
	display: inline-block;
	vertical-align: top;
	font-size: 13px;
	line-height: 28px;
	height: 28px;
}

.el-pagination /deep/ .btn-prev {
	border: none;
	border-radius: 2px;
	padding: 0;
	margin: 0 5px;
	color: #666;
	background: #f4f4f5;
	display: inline-block;
	vertical-align: top;
	font-size: 13px;
	line-height: 28px;
	min-width: 35px;
	height: 28px;
}

.el-pagination /deep/ .btn-next {
	border: none;
	border-radius: 2px;
	padding: 0;
	margin: 0 5px;
	color: #666;
	background: #f4f4f5;
	display: inline-block;
	vertical-align: top;
	font-size: 13px;
	line-height: 28px;
	min-width: 35px;
	height: 28px;
}

.el-pagination /deep/ .btn-prev:disabled {
	border: none;
	cursor: not-allowed;
	border-radius: 2px;
	padding: 0;
	margin: 0 5px;
	color: #C0C4CC;
	background: #f4f4f5;
	display: inline-block;
	vertical-align: top;
	font-size: 13px;
	line-height: 28px;
	height: 28px;
}

.el-pagination /deep/ .btn-next:disabled {
	border: none;
	cursor: not-allowed;
	border-radius: 2px;
	padding: 0;
	margin: 0 5px;
	color: #C0C4CC;
	background: #f4f4f5;
	display: inline-block;
	vertical-align: top;
	font-size: 13px;
	line-height: 28px;
	height: 28px;
}

.el-pagination /deep/ .el-pager {
	padding: 0;
	margin: 0;
	display: inline-block;
	vertical-align: top;
}

.el-pagination /deep/ .el-pager .number {
	cursor: pointer;
	padding: 0 4px;
	margin: 0 5px;
	color: #666;
	display: inline-block;
	vertical-align: top;
	font-size: 13px;
	line-height: 28px;
	border-radius: 2px;
	background: #f4f4f5;
	text-align: center;
	min-width: 30px;
	height: 28px;
}

.el-pagination /deep/ .el-pager .number:hover {
	cursor: pointer;
	padding: 0 4px;
	margin: 0 5px;
	color: #fff;
	display: inline-block;
	vertical-align: top;
	font-size: 13px;
	line-height: 28px;
	border-radius: 2px;
	background: radial-gradient(circle, rgba(17, 112, 210, 1) 0%, rgba(8, 179, 68, 1) 100%);
	text-align: center;
	min-width: 30px;
	height: 28px;
}

.el-pagination /deep/ .el-pager .number.active {
	cursor: default;
	padding: 0 4px;
	margin: 0 5px;
	color: #FFF;
	display: inline-block;
	vertical-align: top;
	font-size: 13px;
	line-height: 28px;
	border-radius: 2px;
	background: radial-gradient(circle, rgba(17, 112, 210, 1) 0%, rgba(8, 179, 68, 1) 100%);
	text-align: center;
	min-width: 30px;
	height: 28px;
}

.el-pagination /deep/ .el-pagination__sizes {
	display: inline-block;
	vertical-align: top;
	font-size: 13px;
	line-height: 28px;
	height: 28px;
}

.el-pagination /deep/ .el-pagination__sizes .el-input {
	margin: 0 5px;
	width: 100px;
	position: relative;
}

.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
	border: 1px solid #DCDFE6;
	cursor: pointer;
	padding: 0 25px 0 8px;
	color: #606266;
	display: inline-block;
	font-size: 13px;
	line-height: 28px;
	border-radius: 3px;
	outline: 0;
	background: #FFF;
	width: 100%;
	text-align: center;
	height: 28px;
}

.el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
	top: 0;
	position: absolute;
	right: 0;
	height: 100%;
}

.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
	cursor: pointer;
	color: #C0C4CC;
	width: 25px;
	font-size: 14px;
	line-height: 28px;
	text-align: center;
}

.el-pagination /deep/ .el-pagination__jump {
	margin: 0 0 0 24px;
	color: #606266;
	display: inline-block;
	vertical-align: top;
	font-size: 13px;
	line-height: 28px;
	height: 28px;
}

.el-pagination /deep/ .el-pagination__jump .el-input {
	border-radius: 3px;
	padding: 0 2px;
	margin: 0 2px;
	display: inline-block;
	width: 50px;
	font-size: 14px;
	line-height: 18px;
	position: relative;
	text-align: center;
	height: 28px;
}

.el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
	border: 1px solid #DCDFE6;
	cursor: pointer;
	padding: 0 3px;
	color: #606266;
	display: inline-block;
	font-size: 14px;
	line-height: 28px;
	border-radius: 3px;
	outline: 0;
	background: #FFF;
	width: 100%;
	text-align: center;
	height: 28px;
}
</style>
