<template>
  <div>
    <div class="breadcrumb-preview dy-breadcrumb-div">
      <el-breadcrumb :separator="'Ξ'"
        :style='{ "width": "1200px", "margin": "0 auto", "fontSize": "14px", "lineHeight": "1" }'>
        <el-breadcrumb-item>首页</el-breadcrumb-item>
        <el-breadcrumb-item>零食评论添加</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="detail-preview"
      :style='{ "width": "1200px", "padding": "0 0 24px", "margin": "0px auto", "position": "relative" }'>
      <div class="dy-add-detail-attr-div">
        <el-form class="add-update-preview" ref="ruleForm" :model="ruleForm" :rules="rules" label-width="100px">
          <el-form-item
            :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }'
            label="零食" prop="shangpinid">
            <el-select v-model="shangpinmingcheng" disabled>
              </el-select>
          </el-form-item>
          <el-form-item
          :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }'
          label="评语" prop="biaoti">
          <el-input v-model="ruleForm.biaoti" placeholder="评语" clearable :readonly="ro.biaoti"></el-input>
        </el-form-item>
        <el-form-item
          :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }'
          label="分数（范围1-5）" prop="fenshu">
          <div :style='{ "bottom": "10px", "position": "absolute" }'>
            <el-rate v-model="ruleForm.fenshu" :colors="['#99A9BF', '#F7BA2A', '#FF9900']" :texts="['极差', '失望', '一般', '满意', '惊喜']" show-text></el-rate>
          </div>
          <!-- <el-input v-model="ruleForm.fenshu" placeholder="分数（范围1-5）" clearable :readonly="ro.fenshu"></el-input> -->
        </el-form-item>
        <el-form-item
          :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }'
          label="时间" prop="shijian">
          <el-date-picker v-model="ruleForm.shijian" type="datetime" format="yyyy-MM-dd HH:mm:ss"
              value-format="yyyy-MM-dd HH:mm:ss" placeholder="时间" default-time="12:00:00" :readonly="ro.shijian">
          </el-date-picker>
        </el-form-item>
        <el-form-item v-if="false" :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }' label="用户" prop="usersid">
          <el-select v-model="users.loginname" disabled>
          </el-select>
      </el-form-item>

          <el-form-item :style='{ "padding": "0", "margin": "20px 0 20px 0" }'>
            <el-button class="dy-add-button" type="primary" @click="onSubmit">提交</el-button>
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
      shangpinmingcheng: '',
      ro: {
        biaoti: false,
        fenshu: false,
        shijian: false,
        shangpinid: false,
        usersid: false,

      },
      ruleForm: {
        shangpinid: '',
        biaoti: '',
        fenshu: 0,
        shijian: this.getCurrentTime(1),
        usersid: localStorage.getItem('usersid'),

      },
      rules: {
        biaoti: [{ required: true, message: '评语不能为空', trigger: 'blur' },],
        fenshu: [ { validator: this.$validate.isRate, trigger: 'blur' },],
        shijian: [{ required: true, message: '时间不能为空', trigger: 'blur' },],
        shangpinid: [{ required: true, message: '零食不能为空', trigger: 'blur' }, { validator: this.$validate.isIntNumer, trigger: 'blur' },],
        usersid: [{ required: true, message: '用户不能为空', trigger: 'blur' }, { validator: this.$validate.isIntNumer, trigger: 'blur' },],

      },
        usersOptions: [],

    };
  },
  computed: {

  },
  created() {
    this.init();
    this.getUsersList();

  },
  methods: {
    //获取当前日期或时间（yyyy-MM-dd 或 yyyy-MM-dd hh:mm:ss）
    getCurrentTime(type) {
      var date = new Date();
      var year = date.getFullYear();
      /* 在日期格式中，月份是从0开始的，因此要加0
       * 使用三元表达式在小于10的前面加0，以达到格式统一  如 09:11:05
       * */
      var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
      var day = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
      var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
      var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
      var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
      if (type && type == 1) {
        // 拼接
        return year + "-" + month + "-" + day + " " + hours + ":" + minutes + ":" + seconds;
      } else {
        return year + "-" + month + "-" + day
      }
    },
    typeChange(value) {
      // 
      console.log(value);
      let obj = {};
      obj = this.typeOptions.find((item) => { // 这里的userList就是上面遍历的数据源
        return item.value === value; // 筛选出匹配数据
      });
      console.log(obj.label);
      this.ruleForm.typename = obj.label;
    },
    // 初始化
    init() {
      if (this.$route.query.id) {
        this.ruleForm.shangpinid = this.$route.query.id;
      }
      if (this.$route.query.mingcheng) {
        this.shangpinmingcheng = this.$route.query.mingcheng;
      }
      this.shenheOptions = "no,yes".split(',')
      this.xingbieOptions = "男,女".split(',')
      this.typeOptions = [{ value: '0', label: '管理' }, { value: '2', label: '用户' }]
      this.$http.get('users/session').then(({ data }) => {
        if (data && data.code === 0) {
          // this.users = data.data;
          this.ruleForm.usersid = data.data.id;
          localStorage.setItem("users", data.data);
          localStorage.setItem("usersid", data.data.id);
        } else {
          let message = this.$message
          message.error(data.message);
        }
      });
    },

    // 提交
    onSubmit() {
      this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http.post('pingjia/add', this.ruleForm).then(res => {
            if (res.data.code == 0) {
              this.$message({
                message: '操作成功',
                type: 'success',
                duration: 1500,
                onClose: () => {
                  this.$router.go(-1);
                }
              });
            } else {
              this.$message({
                message: res.data.message,
                type: 'error',
                duration: 1500
              });
            }
          });
        }
      });
    },
    // 获取uuid
    getUUID() {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.$router.go(-1);
    },
 
    //获取所有用户
    getUsersList() {
      this.$http.get('users/all',).then(res => {
        if (res && res.data.code == 0) {
          this.usersOptions = res.data.data;
        }
      });
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