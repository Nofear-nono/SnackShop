<template>
  <div>
    <div class="container dy-register-container-div">
      <div class="login-form dy-registe-center-div">
        <h1 class="dy-registe-title-h1">用户注册</h1>
        <el-form class="rgs-form" ref="ruleForm" :model="ruleForm" :rules="rules" label-width="80px">
          <el-row>
            <el-col :span="12">
              <el-form-item class="input" label="用户名称" prop="loginname">
                <el-input v-model="ruleForm.loginname" placeholder="用户名称" clearable :readonly="ro.loginname"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item class="input" label="密码" prop="loginpw">
                <el-input v-model="ruleForm.loginpw" placeholder="密码" clearable :readonly="ro.loginpw"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item class="input" label="类型" prop="type">
                <el-select v-model="ruleForm.type" placeholder="请选择类型" @change="typeChange($event)" disabled>
                  <el-option v-for="(item, index) in typeOptions" v-bind:key="item.value" :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item class="input" label="类型名称" prop="typename">
                <el-input v-model="ruleForm.typename" placeholder="类型名称" clearable :readonly="true" disabled></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item class="input" label="姓名" prop="xingming">
                <el-input v-model="ruleForm.xingming" placeholder="姓名" clearable :readonly="ro.xingming"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item class="input" label="头像" prop="image">
                <file-upload tip="点击上传头像" action="common/uploadfile" :limit="1" :multiple="true"
                  @change="imageUploadChange"></file-upload>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item class="input" label="性别" prop="xingbie">
                <el-select v-model="ruleForm.xingbie" placeholder="请选择性别">
                  <el-option v-for="(item, index) in xingbieOptions" v-bind:key="index" :label="item" :value="item">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item class="input" label="年龄" prop="nianling">
                <el-input v-model="ruleForm.nianling" placeholder="年龄" clearable :readonly="ro.nianling"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item class="input" label="地址" prop="address">
                <el-input v-model="ruleForm.address" placeholder="地址" clearable :readonly="ro.address"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item class="input" label="电话" prop="dianhua">
                <el-input v-model="ruleForm.dianhua" placeholder="电话" clearable :readonly="ro.dianhua"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item class="input" label="邮箱" prop="email">
                <el-input v-model="ruleForm.email" placeholder="邮箱" clearable :readonly="ro.email"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item class="input" label="审核" prop="shenhe" v-show="false">
                <el-select v-model="ruleForm.shenhe">
                  <el-option v-for="(item, index) in shenheOptions" v-bind:key="index" :label="item" :value="item">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-col :span="24">
          <el-form-item style="margin: 30px 28% 20px;">
            <el-button class="dy-registe-register-button" type="primary" @click="onSubmit">注册</el-button>

            <el-button class="dy-registe-login-div" type="primary" @click="toLogin">返回登陆</el-button>
          </el-form-item>
        </el-col>
        </el-form>
      </div>
    </div>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber, isIntNumer, isEmail, isPhone, isMobile, isURL, checkIdCard } from "@/utils/validate";
export default {
  data() {
    let self = this
    var validateIdCard = (rule, value, callback) => {
      if (!value) {
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if (!value) {
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validateMobile = (rule, value, callback) => {
      if (!value) {
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的手机号码"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if (!value) {
        callback();
      } else if (!isPhone(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if (!value) {
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if (!value) {
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if (!value) {
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
      ro: {
        loginname: false,
        loginpw: false,
        type: false,
        typename: false,
        xingming: false,
        image: false,
        xingbie: false,
        nianling: false,
        address: false,
        dianhua: false,
        email: false,
        shenhe: false,

      },
      ruleForm: {
        users: { loginname: this.$storage.get('adminName') },
        loginname: '',
        loginpw: '',
        type: '2',
        typename: '用户',
        xingming: '',
        image: '',
        xingbie: '',
        nianling: '',
        address: '',
        dianhua: '',
        email: '',
        shenhe: '',

      },
      rules: {
        loginname: [{ required: true, message: '用户名称不能为空', trigger: 'blur' },],
        loginpw: [{ required: true, message: '密码不能为空', trigger: 'blur' },],
        type: [{ required: true, message: '类型不能为空', trigger: 'blur' },],
        typename: [{ required: true, message: '类型名称不能为空', trigger: 'blur' },],
        xingming: [{ required: true, message: '姓名不能为空', trigger: 'blur' },],
        image: [{ required: true, message: '头像不能为空', trigger: 'blur' },],
        xingbie: [{ required: true, message: '性别不能为空', trigger: 'blur' },],
        nianling: [{ required: true, message: '年龄不能为空', trigger: 'blur' },],
        address: [{ required: true, message: '地址不能为空', trigger: 'blur' },],
        dianhua: [{ required: true, message: '电话不能为空', trigger: 'blur' }, { validator: validateMobile, trigger: 'blur' },],
        email: [{ required: true, message: '邮箱不能为空', trigger: 'blur' },],
        shenhe: [{ required: true, message: '审核不能为空', trigger: 'blur' },],

      },
      xingbieOptions: [],
      typeOptions: [],
      shenheOptions: [],

    };
  },
  computed: {
  },
  created() {
    this.init();
    this.ruleForm.shenhe = this.shenheOptions[0];
    this.ruleForm.shenhe = this.shenheOptions[0];


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
      this.shenheOptions = "no,yes".split(',')
      this.xingbieOptions = "男,女".split(',')
      this.typeOptions = this.$userstypes
    },

    // 提交
    onSubmit() {
      this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `users/save`,
            method: "post",
            data: this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "操作成功,现在可以去登陆了！",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.$router.replace('/login')
                }
              });
            } else {
              this.$message.error(data.message);
            }
          });
        }
      });
    },

    toLogin() {
      this.$router.push({ path: '/login' });
    },
    //头像上传回调
    imageUploadChange(fileUrl) {
      this.ruleForm.image = fileUrl;
      this.addEditUploadStyleChange();
    },


  }
};
</script>
<style lang="scss" scoped>
.el-radio__input.is-checked .el-radio__inner {
  border-color: #00c292;
  background: #00c292;
}

.el-radio__input.is-checked .el-radio__inner {
  border-color: #00c292;
  background: #00c292;
}

.el-radio__input.is-checked .el-radio__inner {
  border-color: #00c292;
  background: #00c292;
}

.el-radio__input.is-checked+.el-radio__label {
  color: #00c292;
}

.el-radio__input.is-checked+.el-radio__label {
  color: #00c292;
}

.el-radio__input.is-checked+.el-radio__label {
  color: #00c292;
}

.h1 {
  margin-top: 10px;
}

body {
  padding: 0;
  margin: 0;
}

.nk-navigation {
  margin-top: 15px;

  a {
    display: inline-block;
    color: #fff;
    background: rgba(255, 255, 255, .2);
    width: 100px;
    height: 50px;
    border-radius: 30px;
    text-align: center;
    display: flex;
    align-items: center;
    margin: 0 auto;
    justify-content: center;
    padding: 0 20px;
  }

  .icon {
    margin-left: 10px;
    width: 30px;
    height: 30px;
  }
}

.register-container {
  margin-top: 10px;

  a {
    display: inline-block;
    color: #fff;
    max-width: 500px;
    height: 50px;
    border-radius: 30px;
    text-align: center;
    display: flex;
    align-items: center;
    margin: 0 auto;
    justify-content: center;
    padding: 0 20px;

    div {
      margin-left: 10px;
    }
  }
}

.container {

  height: 100vh;
  background-position: center center;
  background-size: cover;
  background-repeat: no-repeat;

  .login-form {


    .h1 {
      margin: 0;
      text-align: center;
      line-height: 54px;
      font-size: 24px;
      color: #000;
    }

    .rgs-form {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;

      .input {
        width: 80%;

        & /deep/ .el-form-item__label {
          line-height: 40px;
          color: rgba(254, 254, 254, 1);
          font-size: #606266;
        }

        & /deep/ .el-input__inner {
          height: 40px;
          color: #606266;
          font-size: 14px;
          border-width: 0px;
          border-style: solid;
          border-color: #606266;
          border-radius: 4px;
          background-color: #fff;
        }
      }
    }
  }
}
</style>
