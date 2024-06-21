<template>
	<div>
		<div class="breadcrumb-preview dy-breadcrumb-div">
			<el-breadcrumb :separator="'Ξ'"
				:style='{ "width": "1200px", "margin": "0 auto", "fontSize": "14px", "lineHeight": "1" }'>
				<el-breadcrumb-item>首页</el-breadcrumb-item>
				<el-breadcrumb-item>分类信息</el-breadcrumb-item>
			</el-breadcrumb>
		</div>

		<div class="detail-preview"
			:style='{ "width": "1200px", "padding": "0 0 24px", "margin": "0px auto", "position": "relative" }'>
			<div class="dy-add-detail-attr-div">

				<div class="info"
					:style='{ "width": "98%", "padding": "0px 0 20px", "margin": "40px auto 0 auto", "background": "none", "height": "auto" }'>
					<div class="item" :style='{ "border": "0px solid #dfdfdf", "padding": "0px 10px", "boxShadow": "0px 2px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "0px", "background": "none", "display": "flex", "justifyContent": "spaceBetween" }'>
						<div class="lable" :style='{ "width": "120px", "padding": "0 10px", "fontSize": "14px", "lineHeight": "40px", "color": "#333", "textAlign": "right" }'>名称</div>
						<div :style='{ "width": "498px", "padding": "8px 10px 0", "fontSize": "14px", "lineHeight": "24px", "color": "#666", "height": "auto" }'>{{ detail.mingcheng }}</div>
					</div>
					
					<div class="btn"
						:style='{ "padding": "10px 0", "flexWrap": "wrap", "display": "flex", "text-align": "-webkit-center" }'>
						<el-button type="primary" class="dy-add-button" @click="toPinleiShangpinAdd">零食添加</el-button>
						<el-button type="success" class="dy-chakan-button" @click="toPinleiShangpinChakan">零食查看</el-button>

						<el-button type="info" class="dy-back-button" @click="back">返回</el-button>
					</div>
				</div>

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
			id: 0,
			detail: {
				mingcheng: '',

			},
		}
	},
	created() {
		this.init();
	},
	//方法集合
	methods: {
		// 下载
		download(fileUrl) {
			let url = this.baseUrl + "common/download?filename=" + fileUrl;
			url = encodeURI(url);
			window.open(url);
		},
		//返回
		back() {
			this.$router.go(-1);
		},

		init() {
			if (this.$route.query.id) {
				this.id = this.$route.query.id;
			}
			this.$http.get('pinlei/detail/' + this.id, {}).then(res => {
				if (res.data.code == 0) {
					this.detail = res.data.data;
					// this.$forceUpdate();
				}
			});
		},
        //跳转到分类零食添加页面
		toPinleiShangpinAdd() {
			this.$router.push({ path: '/index/pinleiShangpinAdd', query: { id: this.id, mingcheng: this.detail.mingcheng } });
		},
		//跳转到分类零食查看页面
		toPinleiShangpinChakan() {
			this.$router.push({ path: '/index/shangpinMana', query: { pinleiid: this.id}});
		},

	},
	components: {
	}
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.detail-preview {

	.attr {
		.el-carousel /deep/ .el-carousel__indicator button {
			width: 0;
			height: 0;
			display: none;
		}

		.el-input-number__decrease:hover:not(.is-disabled)~.el-input .el-input__inner:not(.is-disabled),
		.el-input-number__increase:hover:not(.is-disabled)~.el-input .el-input__inner:not(.is-disabled) {
			border-color: none;
		}
	}

	.detail {
		& /deep/ .el-tabs__header .el-tabs__nav-wrap {
			margin-bottom: 0;
		}

		& .add .el-textarea {
			width: auto;
		}
	}
}

.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left {
	width: 36px;
	font-size: 12px;
	height: 36px;
}

.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left:hover {
	background: #ffa100;
}

.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right {
	width: 36px;
	font-size: 12px;
	height: 36px;
}

.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right:hover {
	background: #ffa100;
}

.attr .el-carousel /deep/ .el-carousel__indicators {
	padding: 0;
	margin: 0 0 8px 0;
	z-index: 2;
	position: absolute;
	list-style: none;
}

.attr .el-carousel /deep/ .el-carousel__indicators li {
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

.attr .el-carousel /deep/ .el-carousel__indicators li:hover {
	border-radius: 50%;
	padding: 0;
	margin: 0 4px;
	background: #fff;
	display: inline-block;
	width: 12px;
	opacity: 0.7;
	height: 12px;
}

.attr .el-carousel /deep/ .el-carousel__indicators li.is-active {
	border-radius: 50%;
	padding: 0;
	margin: 0 4px;
	background: #fff;
	display: inline-block;
	width: 12px;
	opacity: 1;
	height: 12px;
}

.attr .el-input-number /deep/ .el-input-number__decrease {
	cursor: pointer;
	z-index: 1;
	display: flex;
	border-color: #DCDFE6;
	border-radius: 4px 0 0 4px;
	top: 1px;
	left: 1px;
	background: #f5f5f5;
	width: 40px;
	justify-content: center;
	border-width: 0 1px 0 0;
	align-items: center;
	position: absolute;
	border-style: solid;
	text-align: center;
	height: 38px;
}

.attr .el-input-number /deep/ .el-input-number__decrease i {
	color: #666;
	font-size: 14px;
}

.attr .el-input-number /deep/ .el-input-number__increase {
	cursor: pointer;
	z-index: 1;
	display: flex;
	border-color: #DCDFE6;
	right: 1px;
	border-radius: 0 4px 4px 0;
	top: 1px;
	background: #f5f5f5;
	width: 40px;
	justify-content: center;
	border-width: 0 0 0 1px;
	align-items: center;
	position: absolute;
	border-style: solid;
	text-align: center;
	height: 38px;
}

.attr .el-input-number /deep/ .el-input-number__increase i {
	color: #666;
	font-size: 14px;
}

.attr .el-input-number /deep/ .el-input .el-input__inner {
	border: 1px solid #DCDFE6;
	border-radius: 4px;
	padding: 0 40px;
	outline: none;
	color: #666;
	background: #FFF;
	display: inline-block;
	width: 100%;
	font-size: 14px;
	line-height: 40px;
	text-align: center;
	height: 40px;
}

.detail-preview .detail.el-tabs /deep/ .el-tabs__header {
	border-radius: 8px;
	padding: 4px 6px;
	margin: 0;
	background: none;
	border-color: #E4E7ED;
	border-width: 0 0 0px 0;
	border-style: solid;
}

.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item {
	border: 1px solid #fff;
	padding: 0 24px;
	margin: 0 4px 0 4px;
	color: #ccc;
	font-weight: 500;
	display: inline-block;
	font-size: 14px;
	line-height: 40px;
	border-radius: 4px;
	background: linear-gradient(135deg, rgba(17, 112, 210, 1) 0%, rgba(8, 179, 68, 1) 100%);
	position: relative;
	list-style: none;
	height: 40px;
}

.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
	border: 1px solid #08b344;
	border-radius: 4px;
	padding: 0 24px;
	margin: 0 4px 0 4px;
	color: #fff;
	background: linear-gradient(135deg, rgba(8, 179, 68, 1) 0%, rgba(17, 112, 210, 1) 100%);
	line-height: 40px;
	height: 40px;
}

.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item.is-active {
	border: 1px solid #08b344;
	border-radius: 4px;
	padding: 0 24px;
	margin: 0 4px 0 4px;
	color: #fff;
	background: linear-gradient(135deg, rgba(8, 179, 68, 1) 0%, rgba(17, 112, 210, 1) 100%);
	line-height: 40px;
	height: 40px;
}

.detail-preview .detail.el-tabs /deep/ .el-tabs__content {
	padding: 15px;
}

.detail-preview .detail.el-tabs .add /deep/ .el-form-item__label {
	padding: 0 10px 0 0;
	color: #666;
	width: 80px;
	font-size: 14px;
	line-height: 40px;
	text-align: right;
}

.detail-preview .detail.el-tabs .add /deep/ .el-textarea__inner {
	border: 0;
	border-radius: 4px;
	padding: 4px 12px;
	box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	outline: none;
	color: #333;
	background: none;
	width: 1058px;
	font-size: 14px;
	min-height: 200px;
	line-height: 32px;
	height: 200px;
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