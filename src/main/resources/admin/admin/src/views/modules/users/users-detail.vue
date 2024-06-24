<template>
  <div v-if="this.parent.usersDetailFlag" class="addEdit-block">
    <el-form class="detail-form-content" ref="ruleForm" :model="ruleForm" label-width="100px"
      :style="{ backgroundColor: addEditForm.addEditBoxColor }">
      <el-row>
        <el-col :span="12">
          <el-form-item class="input" label="用户名称:">
            <el-input v-model="ruleForm.loginname" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item class="input" label="密码:">
            <el-input v-model="ruleForm.loginpw" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item class="input" label="类型:">
            <el-input v-model="ruleForm.type" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item class="input" label="类型名称:">
            <el-input v-model="ruleForm.typename" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item class="input" label="姓名:">
            <el-input v-model="ruleForm.xingming" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item class="input" label="性别:">
            <el-input v-model="ruleForm.xingbie" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item class="input" label="年龄:">
            <el-input v-model="ruleForm.nianling" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item class="input" label="地址:">
            <el-input v-model="ruleForm.address" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item class="input" label="电话:">
            <el-input v-model="ruleForm.dianhua" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item class="input" label="审核:">
            <el-input v-model="ruleForm.shenhe" readonly></el-input>
          </el-form-item>
        </el-col>

      </el-row>
      <el-form-item class="btn">
        <!-- <el-button class="btn-success" @click="dingdanAddHandler">订单添加</el-button> -->
        <!-- <el-button class="btn-success" @click="dingdanChakanHandler">订单查看</el-button> -->


        <!-- <el-button class="btn-success" @click="dingdanxiangAddHandler">订单项添加</el-button> -->
        <!-- <el-button class="btn-success" @click="dingdanxiangChakanHandler">订单项查看</el-button> -->


        <!-- <el-button class="btn-success" @click="gouwucheAddHandler">购物车添加</el-button> -->
        <!-- <el-button class="btn-success" @click="gouwucheChakanHandler">购物车查看</el-button> -->


        <!-- <el-button class="btn-success" @click="liuyanAddHandler">留言反馈添加</el-button> -->
        <!-- <el-button class="btn-success" @click="liuyanChakanHandler">留言反馈查看</el-button> -->


        <!-- <el-button class="btn-success" @click="pingjiaAddHandler">评论添加</el-button> -->
        <!-- <el-button class="btn-success" @click="pingjiaChakanHandler">评论查看</el-button> -->


        <!-- <el-button class="btn-success" @click="shenqingAddHandler">售后申请添加</el-button> -->
        <!-- <el-button class="btn-success" @click="shenqingChakanHandler">售后申请查看</el-button> -->


        <!-- <el-button class="btn-success" @click="shoucangAddHandler">收藏添加</el-button> -->
        <!-- <el-button class="btn-success" @click="shoucangChakanHandler">收藏查看</el-button> -->



        <el-button class="btn-close" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  data() {
    let self = this;
    return {
      addEditForm: { "btnSaveFontColor": "#fff", "selectFontSize": "14px", "btnCancelBorderColor": "#DCDFE6", "inputBorderRadius": "4px", "inputFontSize": "14px", "textareaBgColor": "#fff", "btnSaveFontSize": "14px", "textareaBorderRadius": "4px", "uploadBgColor": "#fff", "textareaBorderStyle": "solid", "btnCancelWidth": "88px", "textareaHeight": "120px", "dateBgColor": "#fff", "btnSaveBorderRadius": "4px", "uploadLableFontSize": "14px", "textareaBorderWidth": "1px", "inputLableColor": "#606266", "addEditBoxColor": "#fff", "dateIconFontSize": "14px", "btnSaveBgColor": "rgba(252, 201, 51, 1)", "uploadIconFontColor": "#8c939d", "textareaBorderColor": "#DCDFE6", "btnCancelBgColor": "rgba(220, 223, 230, 1)", "selectLableColor": "#606266", "btnSaveBorderStyle": "solid", "dateBorderWidth": "1px", "dateLableFontSize": "14px", "dateBorderRadius": "4px", "btnCancelBorderStyle": "solid", "selectLableFontSize": "14px", "selectBorderStyle": "solid", "selectIconFontColor": "#C0C4CC", "btnCancelHeight": "44px", "inputHeight": "40px", "btnCancelFontColor": "rgba(81, 81, 81, 1)", "dateBorderColor": "#DCDFE6", "dateIconFontColor": "#C0C4CC", "uploadBorderStyle": "solid", "dateBorderStyle": "solid", "dateLableColor": "#606266", "dateFontSize": "14px", "inputBorderWidth": "1px", "uploadIconFontSize": "28px", "selectHeight": "40px", "inputFontColor": "#606266", "uploadHeight": "148px", "textareaLableColor": "#606266", "textareaLableFontSize": "14px", "btnCancelFontSize": "14px", "inputBorderStyle": "solid", "btnCancelBorderRadius": "4px", "inputBgColor": "#fff", "inputLableFontSize": "14px", "uploadLableColor": "#606266", "uploadBorderRadius": "4px", "btnSaveHeight": "44px", "selectBgColor": "#fff", "btnSaveWidth": "88px", "selectIconFontSize": "14px", "dateHeight": "40px", "selectBorderColor": "#DCDFE6", "inputBorderColor": "#DCDFE6", "uploadBorderColor": "#DCDFE6", "textareaFontColor": "#606266", "selectBorderWidth": "1px", "dateFontColor": "#606266", "btnCancelBorderWidth": "0px", "uploadBorderWidth": "1px", "textareaFontSize": "14px", "selectBorderRadius": "4px", "selectFontColor": "#606266", "btnSaveBorderColor": "#409EFF", "btnSaveBorderWidth": "0px" },
      id: '',
      ruleForm: {
        loginname: '',
        loginpw: '',
        type: '',
        typename: '',
        xingming: '',
        xingbie: '',
        nianling: '',
        address: '',
        dianhua: '',
        shenhe: '',

      },
    };
  },
  props: ["parent"],
  computed: {
  },
  created() {
    this.addEditStyleChange()
    this.addEditUploadStyleChange()
  },
  methods: {
    //页面元素样式加载
    addEditStyleChange() {
      this.$nextTick(() => {
        // input
        document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el => {
          el.style.height = this.addEditForm.inputHeight
          el.style.color = this.addEditForm.inputFontColor
          el.style.fontSize = this.addEditForm.inputFontSize
          el.style.borderWidth = this.addEditForm.inputBorderWidth
          el.style.borderStyle = this.addEditForm.inputBorderStyle
          el.style.borderColor = this.addEditForm.inputBorderColor
          el.style.borderRadius = this.addEditForm.inputBorderRadius
          el.style.backgroundColor = this.addEditForm.inputBgColor
        })
        document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el => {
          el.style.lineHeight = this.addEditForm.inputHeight
          el.style.color = this.addEditForm.inputLableColor
          el.style.fontSize = this.addEditForm.inputLableFontSize
        })
        // select
        document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el => {
          el.style.height = this.addEditForm.selectHeight
          el.style.color = this.addEditForm.selectFontColor
          el.style.fontSize = this.addEditForm.selectFontSize
          el.style.borderWidth = this.addEditForm.selectBorderWidth
          el.style.borderStyle = this.addEditForm.selectBorderStyle
          el.style.borderColor = this.addEditForm.selectBorderColor
          el.style.borderRadius = this.addEditForm.selectBorderRadius
          el.style.backgroundColor = this.addEditForm.selectBgColor
        })
        document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el => {
          el.style.lineHeight = this.addEditForm.selectHeight
          el.style.color = this.addEditForm.selectLableColor
          el.style.fontSize = this.addEditForm.selectLableFontSize
        })
        document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el => {
          el.style.color = this.addEditForm.selectIconFontColor
          el.style.fontSize = this.addEditForm.selectIconFontSize
        })
        // date
        document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el => {
          el.style.height = this.addEditForm.dateHeight
          el.style.color = this.addEditForm.dateFontColor
          el.style.fontSize = this.addEditForm.dateFontSize
          el.style.borderWidth = this.addEditForm.dateBorderWidth
          el.style.borderStyle = this.addEditForm.dateBorderStyle
          el.style.borderColor = this.addEditForm.dateBorderColor
          el.style.borderRadius = this.addEditForm.dateBorderRadius
          el.style.backgroundColor = this.addEditForm.dateBgColor
        })
        document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el => {
          el.style.lineHeight = this.addEditForm.dateHeight
          el.style.color = this.addEditForm.dateLableColor
          el.style.fontSize = this.addEditForm.dateLableFontSize
        })
        document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el => {
          el.style.color = this.addEditForm.dateIconFontColor
          el.style.fontSize = this.addEditForm.dateIconFontSize
          el.style.lineHeight = this.addEditForm.dateHeight
        })
        // upload
        let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
        document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el => {
          el.style.width = this.addEditForm.uploadHeight
          el.style.height = this.addEditForm.uploadHeight
          el.style.borderWidth = this.addEditForm.uploadBorderWidth
          el.style.borderStyle = this.addEditForm.uploadBorderStyle
          el.style.borderColor = this.addEditForm.uploadBorderColor
          el.style.borderRadius = this.addEditForm.uploadBorderRadius
          el.style.backgroundColor = this.addEditForm.uploadBgColor
        })
        document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el => {
          el.style.lineHeight = this.addEditForm.uploadHeight
          el.style.color = this.addEditForm.uploadLableColor
          el.style.fontSize = this.addEditForm.uploadLableFontSize
        })
        document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el => {
          el.style.color = this.addEditForm.uploadIconFontColor
          el.style.fontSize = this.addEditForm.uploadIconFontSize
          el.style.lineHeight = iconLineHeight
          el.style.display = 'block'
        })
        // 多文本输入框
        document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el => {
          el.style.height = this.addEditForm.textareaHeight
          el.style.color = this.addEditForm.textareaFontColor
          el.style.fontSize = this.addEditForm.textareaFontSize
          el.style.borderWidth = this.addEditForm.textareaBorderWidth
          el.style.borderStyle = this.addEditForm.textareaBorderStyle
          el.style.borderColor = this.addEditForm.textareaBorderColor
          el.style.borderRadius = this.addEditForm.textareaBorderRadius
          el.style.backgroundColor = this.addEditForm.textareaBgColor
        })
        document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el => {
          // el.style.lineHeight = this.addEditForm.textareaHeight
          el.style.color = this.addEditForm.textareaLableColor
          el.style.fontSize = this.addEditForm.textareaLableFontSize
        })
        // 保存
        document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el => {
          el.style.width = this.addEditForm.btnSaveWidth
          el.style.height = this.addEditForm.btnSaveHeight
          el.style.color = this.addEditForm.btnSaveFontColor
          el.style.fontSize = this.addEditForm.btnSaveFontSize
          el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
          el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
          el.style.borderColor = this.addEditForm.btnSaveBorderColor
          el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
          el.style.backgroundColor = this.addEditForm.btnSaveBgColor
        })
        // 返回
        document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el => {
          el.style.width = this.addEditForm.btnCancelWidth
          el.style.height = this.addEditForm.btnCancelHeight
          el.style.color = this.addEditForm.btnCancelFontColor
          el.style.fontSize = this.addEditForm.btnCancelFontSize
          el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
          el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
          el.style.borderColor = this.addEditForm.btnCancelBorderColor
          el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
          el.style.backgroundColor = this.addEditForm.btnCancelBgColor
        })
      })
    },
    //文件上传组件样式加载
    addEditUploadStyleChange() {
      this.$nextTick(() => {
        document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el => {
          el.style.width = this.addEditForm.uploadHeight
          el.style.height = this.addEditForm.uploadHeight
          el.style.borderWidth = this.addEditForm.uploadBorderWidth
          el.style.borderStyle = this.addEditForm.uploadBorderStyle
          el.style.borderColor = this.addEditForm.uploadBorderColor
          el.style.borderRadius = this.addEditForm.uploadBorderRadius
          el.style.backgroundColor = this.addEditForm.uploadBgColor
        })
      })
    },

    // 下载
    download(fileUrl) {
      let url = this.$base.url + "/common/download?filename=" + fileUrl;
      url = encodeURI(url);
      window.open(url);
      // window.open(this.$base.url + fileUrl);
    },
    getFileSrc(fileUrl) {
      return this.$base.url + fileUrl;
    },
    // 初始化
    init(id) {
      if (id) {
        this.id = id;
        this.info(id);
      }
    },
    // 返回按钮事件
    back() {
      this.parent.showFlag = true;
      this.parent.usersSetFlag = false;
      this.parent.usersDetailFlag = false;
      this.parent.usersDingdanChakanFlag = false;
      this.parent.usersDingdanAddFlag = false;
      this.parent.usersDingdanxiangChakanFlag = false;
      this.parent.usersDingdanxiangAddFlag = false;
      this.parent.usersGouwucheChakanFlag = false;
      this.parent.usersGouwucheAddFlag = false;
      this.parent.usersLiuyanChakanFlag = false;
      this.parent.usersLiuyanAddFlag = false;
      this.parent.usersPingjiaChakanFlag = false;
      this.parent.usersPingjiaAddFlag = false;
      this.parent.usersShenqingChakanFlag = false;
      this.parent.usersShenqingAddFlag = false;
      this.parent.usersShoucangChakanFlag = false;
      this.parent.usersShoucangAddFlag = false;
   
      this.parent.contentStyleChange();
    },

    // 获取用户详情数据
    info(id) {
      this.$http({
        url: `users/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.ruleForm = data.data;
        } else {
          this.$message.error(data.message);
        }
      });
    },
    //跳转到用户订单查看页面
    dingdanChakanHandler() {
      this.parent.showFlag = false;
      this.parent.usersDetailFlag = false;
      this.parent.usersDingdanChakanFlag = true;
      this.$nextTick(() => {
        this.parent.$refs.usersDingdanChakan.init(this.id);
      });
    },

    //跳转到用户订单添加页面
    dingdanAddHandler() {
      this.parent.showFlag = false;
      this.parent.usersDetailFlag = false;
      this.parent.usersDingdanAddFlag = true;
      this.$nextTick(() => {
        this.parent.$refs.usersDingdanAdd.init(this.id, this.ruleForm.loginname);
      });
    },

    //跳转到用户订单项查看页面
    dingdanxiangChakanHandler() {
      this.parent.showFlag = false;
      this.parent.usersDetailFlag = false;
      this.parent.usersDingdanxiangChakanFlag = true;
      this.$nextTick(() => {
        this.parent.$refs.usersDingdanxiangChakan.init(this.id);
      });
    },

    //跳转到用户订单项添加页面
    dingdanxiangAddHandler() {
      this.parent.showFlag = false;
      this.parent.usersDetailFlag = false;
      this.parent.usersDingdanxiangAddFlag = true;
      this.$nextTick(() => {
        this.parent.$refs.usersDingdanxiangAdd.init(this.id, this.ruleForm.loginname);
      });
    },

    //跳转到用户购物车查看页面
    gouwucheChakanHandler() {
      this.parent.showFlag = false;
      this.parent.usersDetailFlag = false;
      this.parent.usersGouwucheChakanFlag = true;
      this.$nextTick(() => {
        this.parent.$refs.usersGouwucheChakan.init(this.id);
      });
    },

    //跳转到用户购物车添加页面
    gouwucheAddHandler() {
      this.parent.showFlag = false;
      this.parent.usersDetailFlag = false;
      this.parent.usersGouwucheAddFlag = true;
      this.$nextTick(() => {
        this.parent.$refs.usersGouwucheAdd.init(this.id, this.ruleForm.loginname);
      });
    },

    //跳转到用户留言反馈查看页面
    liuyanChakanHandler() {
      this.parent.showFlag = false;
      this.parent.usersDetailFlag = false;
      this.parent.usersLiuyanChakanFlag = true;
      this.$nextTick(() => {
        this.parent.$refs.usersLiuyanChakan.init(this.id);
      });
    },

    //跳转到用户留言反馈添加页面
    liuyanAddHandler() {
      this.parent.showFlag = false;
      this.parent.usersDetailFlag = false;
      this.parent.usersLiuyanAddFlag = true;
      this.$nextTick(() => {
        this.parent.$refs.usersLiuyanAdd.init(this.id, this.ruleForm.loginname);
      });
    },

    //跳转到用户评论查看页面
    pingjiaChakanHandler() {
      this.parent.showFlag = false;
      this.parent.usersDetailFlag = false;
      this.parent.usersPingjiaChakanFlag = true;
      this.$nextTick(() => {
        this.parent.$refs.usersPingjiaChakan.init(this.id);
      });
    },

    //跳转到用户评论添加页面
    pingjiaAddHandler() {
      this.parent.showFlag = false;
      this.parent.usersDetailFlag = false;
      this.parent.usersPingjiaAddFlag = true;
      this.$nextTick(() => {
        this.parent.$refs.usersPingjiaAdd.init(this.id, this.ruleForm.loginname);
      });
    },

    //跳转到用户售后申请查看页面
    shenqingChakanHandler() {
      this.parent.showFlag = false;
      this.parent.usersDetailFlag = false;
      this.parent.usersShenqingChakanFlag = true;
      this.$nextTick(() => {
        this.parent.$refs.usersShenqingChakan.init(this.id);
      });
    },

    //跳转到用户售后申请添加页面
    shenqingAddHandler() {
      this.parent.showFlag = false;
      this.parent.usersDetailFlag = false;
      this.parent.usersShenqingAddFlag = true;
      this.$nextTick(() => {
        this.parent.$refs.usersShenqingAdd.init(this.id, this.ruleForm.loginname);
      });
    },

    //跳转到用户收藏查看页面
    shoucangChakanHandler() {
      this.parent.showFlag = false;
      this.parent.usersDetailFlag = false;
      this.parent.usersShoucangChakanFlag = true;
      this.$nextTick(() => {
        this.parent.$refs.usersShoucangChakan.init(this.id);
      });
    },

    //跳转到用户收藏添加页面
    shoucangAddHandler() {
      this.parent.showFlag = false;
      this.parent.usersDetailFlag = false;
      this.parent.usersShoucangAddFlag = true;
      this.$nextTick(() => {
        this.parent.$refs.usersShoucangAdd.init(this.id, this.ruleForm.loginname);
      });
    },


  }
};
</script>
<style lang="scss">
.editor {
  height: 500px;

  & /deep/ .ql-container {
    height: 310px;
  }
}

.amap-wrapper {
  width: 100%;
  height: 500px;
}

.search-box {
  position: absolute;
}

.addEdit-block {
  margin: -10px;
}

.detail-form-content {
  padding: 12px;
}

.btn .el-button {
  padding: 0;
}
</style>
