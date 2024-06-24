<template>
	<div>
		<div class="container"
			:style='{ "minHeight": "100vh", "alignItems": "center", "background": "url(http://codegen.caihongy.cn/20221119/42a749ea93b14beeaacd28a90106aa3d.jpg) no-repeat", "display": "flex", "width": "100%", "backgroundSize": "cover", "backgroundPosition": "center center", "backgroundRepeat": "no-repeat", "justifyContent": "center" }'>
			<el-form ref="loginForm" :model="loginForm"
				:style='{ "padding": "40px 40px 40px 40px", "boxShadow": "0px 0px 0px #ccc,inset 0px 0px 0px 0px #e0f8e8", "margin": "20px 0 0 40%", "borderColor": "#1170d2 #08b344 #08b344 #1170d2", "borderRadius": "10% 10%", "background": "rgba(255,255,255,.8)", "borderWidth": "4px", "width": "30%", "borderStyle": "solid double solid double", "height": "auto" }'
				:rules="rules">
				<div
					:style='{ "width": "100%", "margin": "0 0 10px 0", "fontSize": "24px", "color": "#08b344", "textAlign": "center", "fontWeight": "bold" }'>
					USER / LOGIN</div>
				<div
					:style='{ "width": "100%", "margin": "0 0 30px 0", "fontSize": "24px", "color": "#08b344", "textAlign": "center", "fontWeight": "bold" }'>
					用户登录</div>
				<el-form-item class="list-item" :style='{ "width": "80%", "margin": "0 auto 24px", "textAlign": "center" }'
					prop="loginname">
					<input
						:style='{ "border": "0px solid #eacb96", "padding": "0 10px", "boxShadow": "0px 2px 0px #08b344", "color": "#999", "borderRadius": "0px", "background": "#fff", "width": "50%", "fontSize": "14px", "height": "44px" }'
						v-model="loginForm.loginname" placeholder="请输入用户名">
				</el-form-item>
				<el-form-item class="list-item" :style='{ "width": "80%", "margin": "0 auto 24px", "textAlign": "center" }'
					prop="loginpw">
					<input
						:style='{ "border": "0px solid #eacb96", "padding": "0 10px", "boxShadow": "0px 2px 0px #08b344", "color": "#999", "borderRadius": "0px", "background": "#fff", "width": "50%", "fontSize": "14px", "height": "44px" }'
						v-model="loginForm.loginpw" placeholder="请输入密码" type="password">
				</el-form-item>
				<el-form-item class="list-type" :style='{ "width": "80%", "margin": "20px auto", "textAlign": "center" }'
					prop="type">
					<el-radio v-for="item in loginForm.types" v-bind:key="item.typename" v-model="loginForm.type"
						:label="item.type" @change="getRadioVal(item.typename)">{{ item.typename }} </el-radio>
				</el-form-item>
				<el-form-item :style='{ "width": "80%", "margin": "20px auto", "textAlign": "center" }'>
					<el-button v-if="loginType == 1"
						:style='{ "border": "0", "cursor": "pointer", "padding": "0px", "boxShadow": "1px 2px 3px #aaa", "margin": "0 5px", "outline": "none", "color": "#fff", "borderRadius": "4px", "background": "linear-gradient(180deg, rgba(17,112,210,1) 0%, rgba(8,179,68,1) 100%)", "width": "128px", "fontSize": "14px", "height": "40px" }'
						@click="submitForm('loginForm')">登录</el-button>
					<el-button v-if="loginType == 1"
						:style='{ "border": "1px solid #bbb", "cursor": "pointer", "padding": "0px", "boxShadow": "1px 2px 3px #ccc", "margin": "0 5px", "outline": "none", "color": "#999", "borderRadius": "4px", "background": "#fff", "width": "128px", "fontSize": "14px", "height": "40px" }'
						@click="resetForm('loginForm')">重置</el-button>
				</el-form-item>
				<div :style='{ "width": "80%", "margin": "20px auto" }'>
					<router-link
						:style='{ "cursor": "pointer", "margin": "0 5px", "fontSize": "14px", "textDecoration": "none", "color": "#08b344" }'
						:to="{ path: '/index/usersAdd' }">用户注册</router-link>
				</div>
			</el-form>
		</div>
	</div>
</template>

<script>

export default {
	//数据集合
	data() {
		return {
			baseUrl: this.$config.baseUrl,
			loginType: 1,
			loginForm: {
				loginname: '',
				loginpw: '',
				type: '0',
				typename: '管理员',
				code: '',
				types: [{ type: '0', typename: '管理员' }, { type: '2', typename: '用户' }],
			},
			role: '',
			rules: {
				loginname: [
					{ required: true, message: '请输入账户', trigger: 'blur' }
				],
				loginpw: [
					{ required: true, message: '请输入密码', trigger: 'blur' }
				]
			},
		}
	},
	created() {
		localStorage.clear();
	},
	mounted() {
	},
	//方法集合
	methods: {
		getRadioVal(typename) {
			this.loginForm.typename = typename;
			// console.log(this.loginForm.typename);
		},
		submitForm(formName) {
			this.$refs[formName].validate((valid) => {
				if (valid) {
					this.$http.post(`login?loginname=${this.loginForm.loginname}&loginpw=${this.loginForm.loginpw}&type=${this.loginForm.type}`).then(res => {
						if (res.data.code === 0) {
							localStorage.setItem('Token', res.data.data.token);
							localStorage.setItem('usersid', res.data.data.usersId);
							localStorage.setItem('usersname', this.loginForm.loginname);
							localStorage.setItem('adminName', this.loginForm.loginname);
							localStorage.setItem('type', this.loginForm.type);
							localStorage.setItem('keyPath', 0);
							localStorage.setItem('typename', this.loginForm.typename);
							this.$router.push('/index/home');
							this.$message({
								message: '登录成功',
								type: 'success',
								duration: 1500,
							});
						} else {
							this.$message.error(res.data.message);
						}
					});
				} else {
					return false;
				}
			});
		},
		resetForm(formName) {
			this.$refs[formName].resetFields();
		}
	}
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.container {
	position: relative;
	background: url(http://codegen.caihongy.cn/20221119/42a749ea93b14beeaacd28a90106aa3d.jpg) no-repeat;

	.el-form-item {
		& /deep/ .el-form-item__content {
			width: 100%;
		}
	}

	.list-item /deep/ .el-input .el-input__inner {
		border: 0px solid #eacb96;
		border-radius: 0px;
		padding: 0 10px;
		box-shadow: 0px 2px 0px #08b344;
		color: #999;
		background: #fff;
		width: 100%;
		font-size: 14px;
		height: 44px;
	}

	.list-code /deep/ .el-input .el-input__inner {
		border: 0px solid #eacb96;
		border-radius: 0px;
		padding: 0 10px;
		box-shadow: 0px 2px 0px #08b344;
		outline: none;
		color: #999;
		background: none;
		display: inline-block;
		vertical-align: middle;
		width: calc(100% - 160px);
		font-size: 14px;
		height: 44px;
	}

	.list-type /deep/ .el-radio__input .el-radio__inner {
		background: rgba(53, 53, 53, 0);
		border-color: #666666;
	}

	.list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
		background: #08b344;
		border-color: #0ca140;
	}

	.list-type /deep/ .el-radio__label {
		color: #666666;
		font-size: 14px;
	}

	.list-type /deep/ .el-radio__input.is-checked+.el-radio__label {
		color: #ffa100;
		font-size: 14px;
	}
}
</style>
