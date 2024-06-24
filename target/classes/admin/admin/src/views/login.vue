<template>
  <div>
    <div class="container loginIn dy-login-container-div">
      <div class="left center dy-login-center-div">
        <el-form class="login-form" label-position="left" :label-width="'0px'">
          <div class="title-container dy-login-title-container-div">
            <h3 class="title">系统登录</h3>
          </div>
          <el-form-item>
            <span class="svg-container dy-login-el-form-item-span"><svg-icon
                icon-class="user" /></span>
            <el-input placeholder="请输入用户名" name="loginname" type="text" v-model="rulesForm.loginname" />
          </el-form-item>
          <el-form-item>
            <span class="svg-container dy-login-el-form-item-span"><svg-icon
                icon-class="password" /></span>
            <el-input placeholder="请输入密码" name="loginpw" type="password" v-model="rulesForm.loginpw" />
          </el-form-item>
          <el-form-item class="code">
            <span class="svg-container dy-login-el-form-item-span"><svg-icon
                icon-class="code" /></span>
            <el-input placeholder="请输入验证码" name="code" type="text" v-model="rulesForm.code" />
            <div class="getCodeBt" @click="getRandCode(4)" style="height:44px;line-height:44px">
              <span v-for="(item, index) in codes" :key="index"
                :style="{ color: item.color, transform: item.rotate, fontSize: item.size }">{{ item.num }}</span>
            </div>
          </el-form-item>
          <el-form-item class="role" style="text-align: center;">
            <el-radio v-for="item in rulesForm.types" v-bind:key="item.typename" v-model="rulesForm.type"
              :label="item.value" @change="getRadioVal(item.label)">
              {{ item.label }}
            </el-radio>
          </el-form-item>
          <el-button type="primary" @click="login()" class="dy-login-button">登 录</el-button>
          <el-form-item class="setting">

            <div style="color:rgba(255, 255, 255, 1)" class="reset" v-show="false"><a href="javascript:void(0);" @click="toRegister" style="text-decoration: none;">免费注册</a></div>
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
      rulesForm: {
        loginname: "",
        loginpw: "",
        type: "0",
        typename: '管理员',
        code: '',
        types: this.$userstypes,
      },
      tableName: "",
      codes: [{
        num: 1,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      }, {
        num: 2,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      }, {
        num: 3,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      }, {
        num: 4,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      }],
    };
  },
  mounted() {
  },
  created() {
    this.setInputColor()
    this.getRandCode()
  },
  methods: {
    setInputColor() {
      this.$nextTick(() => {
        document.querySelectorAll('.loginIn .el-input__inner').forEach(el => {
          el.style.backgroundColor = "rgba(255, 255, 255, 1)"
          el.style.color = "rgba(51, 51, 51, 1)"
          el.style.height = "44px"
          el.style.lineHeight = "44px"
          el.style.borderRadius = "4px"
        })
        document.querySelectorAll('.loginIn .style3 .el-form-item__label').forEach(el => {
          el.style.height = "44px"
          el.style.lineHeight = "44px"
        })
        document.querySelectorAll('.loginIn .el-form-item__label').forEach(el => {
          el.style.color = "rgba(238, 238, 238, 1)"
        })
        setTimeout(() => {
          document.querySelectorAll('.loginIn .role .el-radio__label').forEach(el => {
            el.style.color = "#fff"
          })
        }, 350)
      })

    },
    getRadioVal(typename) {
      this.rulesForm.typename = typename;
      console.log(this.rulesForm.typename);
    },
    register(tableName) {
      this.$storage.set("loginTable", tableName);
      this.$router.push({ path: '/register' })
    },
    // 登陆
    login() {
      if (!this.rulesForm.loginname) {
        this.$message.error("请输入用户名");
        return;
      }
      if (!this.rulesForm.loginpw) {
        this.$message.error("请输入密码");
        return;
      }
      let code = ''
      for (let i in this.codes) {
        code += this.codes[i].num
      }
      if (!this.rulesForm.code) {
        this.$message.error("请输入验证码");
        return;
      }
      if (this.rulesForm.code.toLowerCase() != code.toLowerCase()) {
        this.$message.error("验证码输入有误");
        this.getRandCode()
        return;
      }

      this.$http({
        url: `/login?loginname=${this.rulesForm.loginname}&loginpw=${this.rulesForm.loginpw}&type=${this.rulesForm.type}`,
        method: "post"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$storage.set("Token", data.data.token);
          this.$storage.set("usersid", data.data.usersId);
          this.$storage.set("typename", this.rulesForm.typename);
          this.$storage.set("type", this.rulesForm.type);
          this.$storage.set("adminName", this.rulesForm.loginname);
          this.$storage.set("usersname", this.rulesForm.loginname);
          this.$router.replace({ path: "/index/" });
        } else {
          this.$message.error(data.message);
        }
      });
    },

    toRegister(){
      this.$router.push({path:'/register'});
    },

    getRandCode(len = 4) {
      this.randomString(len)
    },
    randomString(len = 4) {
      let chars = [
        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
      ]
      let colors = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"]
      let sizes = ['18']

      let output = [];
      for (let i = 0; i < len; i++) {
        // 随机验证码
        let key = Math.floor(Math.random() * chars.length)
        this.codes[i].num = chars[key]
        // 随机验证码颜色
        let code = '#'
        for (let j = 0; j < 6; j++) {
          let key = Math.floor(Math.random() * colors.length)
          code += colors[key]
        }
        this.codes[i].color = code
        // 随机验证码方向
        let rotate = Math.floor(Math.random() * 10)
        let plus = Math.floor(Math.random() * 2)
        if (plus == 1) rotate = '-' + rotate
        this.codes[i].rotate = 'rotate(' + rotate + 'deg)'
        // 随机验证码字体大小
        let size = Math.floor(Math.random() * sizes.length)
        this.codes[i].size = sizes[size] + 'px'
      }
    },
  }
};
</script>
<style lang="scss" scoped>
.loginIn {
  
  .left {
    position: absolute;
    left: 0;
    top: 0;
    width: 360px;
    height: 100%;

    .login-form {
      background-color: transparent;
      width: 100%;
      right: inherit;
      padding: 0 12px;
      box-sizing: border-box;
      display: flex;
      justify-content: center;
      flex-direction: column;
    }

    .title-container {
      text-align: center;
      font-size: 24px;

      .title {
        margin: 20px 0;
      }
    }

    .el-form-item {
      position: relative;

      .svg-container {
        padding: 6px 5px 6px 15px;
        color: #889aa4;
        vertical-align: middle;
        display: inline-block;
        position: absolute;
        left: 0;
        top: 0;
        z-index: 1;
        padding: 0;
        line-height: 40px;
        width: 30px;
        text-align: center;
      }

      .el-input {
        display: inline-block;
        height: 40px;
        width: 100%;

        & /deep/ input {
          background: transparent;
          border: 0px;
          -webkit-appearance: none;
          padding: 0 15px 0 30px;
          color: #fff;
          height: 40px;
        }
      }

    }


  }

  .center {
    position: absolute;
    left: 50%;
    top: 50%;
    width: 360px;
    transform: translate3d(-50%, -50%, 0);
    height: 446px;
    border-radius: 8px;
  }

  .right {
    position: absolute;
    left: inherit;
    right: 0;
    top: 0;
    width: 360px;
    height: 100%;
  }

  .code {
    .el-form-item__content {
      position: relative;

      .getCodeBt {
        position: absolute;
        right: 0;
        top: 0;
        line-height: 40px;
        width: 100px;
        background-color: rgba(51, 51, 51, 0.4);
        color: #fff;
        text-align: center;
        border-radius: 0 4px 4px 0;
        height: 40px;
        overflow: hidden;

        span {
          padding: 0 5px;
          display: inline-block;
          font-size: 16px;
          font-weight: 600;
        }
      }

      .el-input {
        & /deep/ input {
          padding: 0 130px 0 30px;
        }
      }
    }
  }

  .setting {
    & /deep/ .el-form-item__content {
      padding: 0 15px;
      box-sizing: border-box;
      line-height: 32px;
      height: 32px;
      font-size: 14px;
      color: #999;
      margin: 0 !important;

      .register {
        float: left;
        width: 50%;
      }

      .reset {
        float: right;
        width: 50%;
        text-align: right;
      }
    }
  }

  .style2 {
    padding-left: 30px;

    .svg-container {
      left: -30px !important;
    }

    .el-input {
      & /deep/ input {
        padding: 0 15px !important;
      }
    }
  }

  .code.style2,
  .code.style3 {
    .el-input {
      & /deep/ input {
        padding: 0 115px 0 15px;
      }
    }
  }

  .style3 {
    & /deep/ .el-form-item__label {
      padding-right: 6px;
    }

    .el-input {
      & /deep/ input {
        padding: 0 15px !important;
      }
    }
  }

  .role {
    & /deep/ .el-form-item__label {
      width: 56px !important;
    }

    & /deep/ .el-radio {
      margin-right: 12px;
    }
  }

}</style>
