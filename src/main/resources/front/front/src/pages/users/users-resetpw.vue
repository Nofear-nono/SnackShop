<template>
  <div>
    <div class="breadcrumb-preview dy-breadcrumb-div">
      <el-breadcrumb :separator="'Ξ'"
        :style='{ "width": "1200px", "margin": "0 auto", "fontSize": "14px", "lineHeight": "1" }'>
        <el-breadcrumb-item>首页</el-breadcrumb-item>
        <el-breadcrumb-item>密码重置</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="detail-preview"
      :style='{ "width": "1200px", "padding": "0 0 24px", "margin": "0px auto", "position": "relative" }'>
      <div class="dy-add-detail-attr-div">
        <el-form class="add-update-preview" ref="ruleForm" :model="ruleForm" :rules="rules" label-width="100px">
          <el-form-item
            :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }'
            label="用户名称" prop="loginname">
            <el-input v-model="ruleForm.loginname" placeholder="用户名称" clearable :readonly="ro.loginname"></el-input>
          </el-form-item>
          <el-form-item
            :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }'
            label="姓名" prop="xingming">
            <el-input v-model="ruleForm.xingming" placeholder="姓名" clearable :readonly="ro.xingming"></el-input>
          </el-form-item>
          <el-form-item
            :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }'
            label="电话" prop="dianhua">
            <el-input v-model="ruleForm.dianhua" placeholder="电话" clearable :readonly="ro.dianhua"></el-input>
          </el-form-item>

          <el-form-item :style='{ "padding": "0", "margin": "20px 0 20px 0" }'>
            <el-button class="dy-add-button" type="primary" @click="onSubmit">重置密码</el-button>
            <el-button class="dy-back-button" @click="back()">返回</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      baseUrl: this.$config.baseUrl,
      xingbieOptions: [],
      typeOptions: [],
      shenheOptions: [],
      users: { loginname: localStorage.getItem('adminName') },
      ro: {
        loginname: false,
        xingming: false,
        dianhua: false,
      },
      ruleForm: {
        loginname: '',
        xingming: '',
        dianhua: '',
      },
      rules: {
        loginname: [{ required: true, message: '用户名称不能为空', trigger: 'blur' },],
        xingming: [{ required: true, message: '姓名不能为空', trigger: 'blur' },],
        dianhua: [{ required: true, message: '电话不能为空', trigger: 'blur' }, { validator: this.$validate.isMobile, trigger: 'blur' },],
      },

    };
  },
  computed: {

  },
  created() {

  },
  methods: {

    // 提交
    onSubmit() {
      this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http.post('users/resetPw', this.ruleForm).then(res => {
            if (res.data.code == 0) {
              this.$message({
                dangerouslyUseHTMLString: true,
                message: '您的密码已被重置为<strong style="color: red;">000000</strong>，如需修改，请登陆个人中心操作!',
                type: 'success',
                duration: 3000,
                // onClose: () => {
                //   this.$router.go(-1);
                // }
              });
            } else {
              this.$message({
                message: res.data.message,
                type: 'error',
                duration: 3000
              });
            }
          });
        }
      });
    },
    // 返回
    back() {
      this.$router.go(-1);
    },


  }
};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.el-date-editor.el-input {
  width: auto;
}

.add-update-preview .el-form-item /deep/ .el-form-item__label {
  padding: 0 10px 0 0;
  color: #666;
  font-weight: 500;
  width: 80px;
  font-size: 14px;
  line-height: 40px;
  text-align: right;
}

.add-update-preview .el-form-item /deep/ .el-form-item__content {
  margin-left: 80px;
}

.add-update-preview .el-input /deep/ .el-input__inner {
  border: 1px solid #ccc;
  border-radius: 4px;
  padding: 0 12px;
  outline: none;
  color: #999;
  background: #fff;
  width: 400px;
  font-size: 14px;
  height: 40px;
}

.add-update-preview .el-select /deep/ .el-input__inner {
  border: 1px solid #ccc;
  border-radius: 4px;
  padding: 0 10px;
  outline: none;
  color: #999;
  background: #fff;
  width: 200px;
  font-size: 14px;
  height: 40px;
}

.add-update-preview .el-date-editor /deep/ .el-input__inner {
  border: 1px solid #ccc;
  border-radius: 4px;
  padding: 0 10px 0 30px;
  outline: none;
  color: #999;
  background: #fff;
  width: 200px;
  font-size: 14px;
  height: 40px;
}

.add-update-preview /deep/ .el-upload--picture-card {
  background: transparent;
  border: 0;
  border-radius: 0;
  width: auto;
  height: auto;
  line-height: initial;
  vertical-align: middle;
}

.add-update-preview /deep/ .upload .upload-img {
  border: 1px solid #ccc;
  cursor: pointer;
  border-radius: 6px;
  color: #999;
  background: #fff;
  width: 200px;
  font-size: 32px;
  line-height: 120px;
  text-align: center;
  height: auto;
}

.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
  border: 1px solid #ccc;
  cursor: pointer;
  border-radius: 6px;
  color: #999;
  background: #fff;
  width: 200px;
  font-size: 32px;
  line-height: 120px;
  text-align: center;
  height: auto;
}

.add-update-preview /deep/ .el-upload .el-icon-plus {
  border: 1px solid #ccc;
  cursor: pointer;
  border-radius: 6px;
  color: #999;
  background: #fff;
  width: 200px;
  font-size: 32px;
  line-height: 120px;
  text-align: center;
  height: auto;
}

.add-update-preview .el-textarea /deep/ .el-textarea__inner {
  border: 1px solid #ccc;
  border-radius: 4px;
  padding: 12px;
  outline: none;
  color: #999;
  background: #fff;
  width: 400px;
  font-size: 14px;
  min-height: 120px;
}
</style>
