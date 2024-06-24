<template>
  <div v-if="this.parent.shangpinDetailFlag" class="addEdit-block">
    <el-form class="detail-form-content" ref="ruleForm" :model="ruleForm" label-width="100px"
      :style="{ backgroundColor: addEditForm.addEditBoxColor }">
      <el-row>
        <el-col :span="12">
          <el-form-item class="input" label="名称:">
            <el-input v-model="ruleForm.mingcheng" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item class="input" label="编号:">
            <el-input v-model="ruleForm.bianhao" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item class="input" label="分类:">
            <el-input v-if="ruleForm.pinlei && ruleForm.pinlei.mingcheng" v-model="ruleForm.pinlei.mingcheng" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item class="input" label="内容介绍:">
            <el-input style="min-width: 200px; max-width: 600px;" type="textarea" :rows="8" v-model="ruleForm.neirong" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item class="input" label="图片:">
            <div v-if="ruleForm.image">
              <img :src="getFileSrc(ruleForm.image)" style="margin-right:20px;" width="600" height="400">
              <el-button class="el-icon-download" type="text" @click="download(ruleForm.image)">下载</el-button>
            </div>
            <div v-else>暂无图片</div>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item class="input" label="原价:">
            <el-input v-model="ruleForm.yuanshijiage" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item class="input" label="现价:">
            <el-input v-model="ruleForm.jiage" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item class="input" label="单位:">
            <el-input v-model="ruleForm.danwei" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item class="input" label="是否特价:">
            <el-input v-model="ruleForm.shenhe" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item class="input" label="库存数量:">
            <el-input v-model="ruleForm.kucunshuliang" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item class="input" label="销售数量:">
            <el-input v-model="ruleForm.xiaoshoushuliang" readonly></el-input>
          </el-form-item>
        </el-col>

      </el-row>
      <el-form-item class="btn">
        <!-- <el-button class="btn-success" @click="dingdanxiangAddHandler">订单项添加</el-button> -->
        <!-- <el-button class="btn-success" @click="dingdanxiangChakanHandler">订单项查看</el-button> -->


        <!-- <el-button class="btn-success" @click="gouwucheAddHandler">购物车添加</el-button> -->
        <!-- <el-button class="btn-success" @click="gouwucheChakanHandler">购物车查看</el-button> -->


        <!-- <el-button class="btn-success" @click="pingjiaAddHandler">评论添加</el-button> -->
        <!-- <el-button class="btn-success" @click="pingjiaChakanHandler">评论查看</el-button> -->


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
        mingcheng: '',
        bianhao: '',
        pinlei: { mingcheng: '' },
        neirong: '',
        image: '',
        yuanshijiage: '',
        jiage: '',
        danwei: '',
        shenhe: '',
        kucunshuliang: '',
        xiaoshoushuliang: '',

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
      this.parent.shangpinSetFlag = false;
      this.parent.shangpinDetailFlag = false;
      this.parent.shangpinDingdanxiangChakanFlag = false;
      this.parent.shangpinDingdanxiangAddFlag = false;
      this.parent.shangpinGouwucheChakanFlag = false;
      this.parent.shangpinGouwucheAddFlag = false;
      this.parent.shangpinPingjiaChakanFlag = false;
      this.parent.shangpinPingjiaAddFlag = false;
      this.parent.shangpinShoucangChakanFlag = false;
      this.parent.shangpinShoucangAddFlag = false;
   
      this.parent.contentStyleChange();
    },

    // 获取零食详情数据
    info(id) {
      this.$http({
        url: `shangpin/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.ruleForm = data.data;
        } else {
          this.$message.error(data.message);
        }
      });
    },
    //跳转到零食订单项查看页面
    dingdanxiangChakanHandler() {
      this.parent.showFlag = false;
      this.parent.shangpinDetailFlag = false;
      this.parent.shangpinDingdanxiangChakanFlag = true;
      this.$nextTick(() => {
        this.parent.$refs.shangpinDingdanxiangChakan.init(this.id);
      });
    },

    //跳转到零食订单项添加页面
    dingdanxiangAddHandler() {
      this.parent.showFlag = false;
      this.parent.shangpinDetailFlag = false;
      this.parent.shangpinDingdanxiangAddFlag = true;
      this.$nextTick(() => {
        this.parent.$refs.shangpinDingdanxiangAdd.init(this.id, this.ruleForm.mingcheng);
      });
    },

    //跳转到零食购物车查看页面
    gouwucheChakanHandler() {
      this.parent.showFlag = false;
      this.parent.shangpinDetailFlag = false;
      this.parent.shangpinGouwucheChakanFlag = true;
      this.$nextTick(() => {
        this.parent.$refs.shangpinGouwucheChakan.init(this.id);
      });
    },

    //跳转到零食购物车添加页面
    gouwucheAddHandler() {
      this.parent.showFlag = false;
      this.parent.shangpinDetailFlag = false;
      this.parent.shangpinGouwucheAddFlag = true;
      this.$nextTick(() => {
        this.parent.$refs.shangpinGouwucheAdd.init(this.id, this.ruleForm.mingcheng);
      });
    },

    //跳转到零食评论查看页面
    pingjiaChakanHandler() {
      this.parent.showFlag = false;
      this.parent.shangpinDetailFlag = false;
      this.parent.shangpinPingjiaChakanFlag = true;
      this.$nextTick(() => {
        this.parent.$refs.shangpinPingjiaChakan.init(this.id);
      });
    },

    //跳转到零食评论添加页面
    pingjiaAddHandler() {
      this.parent.showFlag = false;
      this.parent.shangpinDetailFlag = false;
      this.parent.shangpinPingjiaAddFlag = true;
      this.$nextTick(() => {
        this.parent.$refs.shangpinPingjiaAdd.init(this.id, this.ruleForm.mingcheng);
      });
    },

    //跳转到零食收藏查看页面
    shoucangChakanHandler() {
      this.parent.showFlag = false;
      this.parent.shangpinDetailFlag = false;
      this.parent.shangpinShoucangChakanFlag = true;
      this.$nextTick(() => {
        this.parent.$refs.shangpinShoucangChakan.init(this.id);
      });
    },

    //跳转到零食收藏添加页面
    shoucangAddHandler() {
      this.parent.showFlag = false;
      this.parent.shangpinDetailFlag = false;
      this.parent.shangpinShoucangAddFlag = true;
      this.$nextTick(() => {
        this.parent.$refs.shangpinShoucangAdd.init(this.id, this.ruleForm.mingcheng);
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
