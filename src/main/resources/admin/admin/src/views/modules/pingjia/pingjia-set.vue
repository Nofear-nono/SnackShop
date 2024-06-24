<template>
  <div class="addEdit-block">
    <el-form class="detail-form-content" ref="ruleForm" :model="ruleForm" :rules="rules" label-width="80px"
      :style="{ backgroundColor: addEditForm.addEditBoxColor }">
      <el-row>
        <el-col :span="12">
          <el-form-item class="input" label="评语" prop="biaoti">
            <el-input v-model="ruleForm.biaoti" placeholder="评语" clearable
              :readonly="ro.biaoti"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item class="input" label="分数（范围1-5）" prop="fenshu">
            <!-- <el-input v-model="ruleForm.fenshu" placeholder="分数（范围1-5）" clearable
              :readonly="ro.fenshu"></el-input> -->
            <div :style='{ "bottom": "10px", "position": "absolute" }'>
              <el-rate v-model="ruleForm.fenshu" :colors="['#99A9BF', '#F7BA2A', '#FF9900']" :texts="['极差', '失望', '一般', '满意', '惊喜']" show-text></el-rate>
            </div>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item class="input" label="时间" prop="shijian">
            <el-date-picker v-model="ruleForm.shijian" type="datetime" format="yyyy-MM-dd HH:mm:ss"
              value-format="yyyy-MM-dd HH:mm:ss" placeholder="时间" default-time="12:00:00" :readonly="ro.shijian">
            </el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item class="input" label="零食" prop="shangpinid">
            <el-select v-model="ruleForm.shangpinid" :readonly="ro.zhongleiid" placeholder="请选择零食">
              <el-option v-for="(item, index) in shangpinOptions" v-bind:key="item.id" :label="item.mingcheng"
                :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item class="input" label="用户" prop="usersid">
            <el-select v-model="users.loginname" :readonly="ro.usersid" disabled>
            </el-select>
          </el-form-item>
        </el-col>

      </el-row>
      <el-form-item class="btn">
        <el-button type="primary" class="btn-success" @click="onSubmit">提交</el-button>
        <el-button class="btn-close" @click="back()">取消</el-button>
      </el-form-item>
    </el-form>
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
    var validateRate = (rule, value, callback) => {
      if (value == 0) {
        callback(new Error("分数选择范围为1-5"));
      } else {
        callback();
      }
    };
    return {
      addEditForm: { "btnSaveFontColor": "#fff", "selectFontSize": "14px", "btnCancelBorderColor": "#DCDFE6", "inputBorderRadius": "4px", "inputFontSize": "14px", "textareaBgColor": "#fff", "btnSaveFontSize": "14px", "textareaBorderRadius": "4px", "uploadBgColor": "#fff", "textareaBorderStyle": "solid", "btnCancelWidth": "88px", "textareaHeight": "120px", "dateBgColor": "#fff", "btnSaveBorderRadius": "4px", "uploadLableFontSize": "14px", "textareaBorderWidth": "1px", "inputLableColor": "#606266", "addEditBoxColor": "#fff", "dateIconFontSize": "14px", "btnSaveBgColor": "rgba(252, 201, 51, 1)", "uploadIconFontColor": "#8c939d", "textareaBorderColor": "#DCDFE6", "btnCancelBgColor": "rgba(220, 223, 230, 1)", "selectLableColor": "#606266", "btnSaveBorderStyle": "solid", "dateBorderWidth": "1px", "dateLableFontSize": "14px", "dateBorderRadius": "4px", "btnCancelBorderStyle": "solid", "selectLableFontSize": "14px", "selectBorderStyle": "solid", "selectIconFontColor": "#C0C4CC", "btnCancelHeight": "44px", "inputHeight": "40px", "btnCancelFontColor": "rgba(81, 81, 81, 1)", "dateBorderColor": "#DCDFE6", "dateIconFontColor": "#C0C4CC", "uploadBorderStyle": "solid", "dateBorderStyle": "solid", "dateLableColor": "#606266", "dateFontSize": "14px", "inputBorderWidth": "1px", "uploadIconFontSize": "28px", "selectHeight": "40px", "inputFontColor": "#606266", "uploadHeight": "148px", "textareaLableColor": "#606266", "textareaLableFontSize": "14px", "btnCancelFontSize": "14px", "inputBorderStyle": "solid", "btnCancelBorderRadius": "4px", "inputBgColor": "#fff", "inputLableFontSize": "14px", "uploadLableColor": "#606266", "uploadBorderRadius": "4px", "btnSaveHeight": "44px", "selectBgColor": "#fff", "btnSaveWidth": "88px", "selectIconFontSize": "14px", "dateHeight": "40px", "selectBorderColor": "#DCDFE6", "inputBorderColor": "#DCDFE6", "uploadBorderColor": "#DCDFE6", "textareaFontColor": "#606266", "selectBorderWidth": "1px", "dateFontColor": "#606266", "btnCancelBorderWidth": "0px", "uploadBorderWidth": "1px", "textareaFontSize": "14px", "selectBorderRadius": "4px", "selectFontColor": "#606266", "btnSaveBorderColor": "#409EFF", "btnSaveBorderWidth": "0px" },
      id: 0,
      users: { loginname: this.$storage.get('adminName') },
      ro: {
        biaoti: false,
        fenshu: false,
        shijian: false,
        shangpinid: false,
        usersid: false,

      },
      ruleForm: {
        biaoti: '',
        fenshu: 0,
        shijian: this.getCurrentTime(1),
        shangpinid: '',
        usersid: this.$storage.get('usersid'),

      },
      rules: {
        biaoti: [{ required: true, message: '评语不能为空', trigger: 'blur' },],
        fenshu: [{ required: true, message: '分数（范围1-5）不能为空', trigger: 'blur' }, { validator: validateRate, trigger: 'blur' },],
        shijian: [{ required: true, message: '时间不能为空', trigger: 'blur' },],
        shangpinid: [{ required: true, message: '零食不能为空', trigger: 'blur' }, { validator: validateIntNumber, trigger: 'blur' },],
        usersid: [{ required: true, message: '用户不能为空', trigger: 'blur' }, { validator: validateIntNumber, trigger: 'blur' },],

      },
      xingbieOptions: [],
      typeOptions: [],
      shenheOptions: [],
        shangpinOptions: [],
        usersOptions: [],

    };
  },
  props: ["parent"],
  computed: {
  },
  created() {
    this.addEditStyleChange();
    this.addEditUploadStyleChange();
 
    this.getShangpinList();
    this.getUsersList();
   
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
    init(id) {
      this.shenheOptions = "no,yes".split(',')
      this.xingbieOptions = "男,女".split(',')
      this.typeOptions = this.$userstypes
      if(id){
        this.id=id;
        this.info(id);
      }
    },

    // 返回
    back() {
      if (this.parent) {
        this.parent.showFlag = true;
        this.parent.pingjiaSetFlag = false;
        this.parent.pingjiaDetailFlag = false;
        this.parent.contentStyleChange();
      } else {
        this.$router.replace('/pingjiamana')
      }
    },

    // 获取database.tableMap.table.idColunmRemarksName详情数据
    info(id) {
      this.$http({
        url: `pingjia/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.ruleForm = data.data;
          if (this.ruleForm.fenshu) {
            this.ruleForm.fenshu = Number(this.ruleForm.fenshu);
          }
          if (this.ruleForm.loginpw) {
            this.ruleForm.loginpw = "";
          }
        } else {
          this.$message.error(data.message);
        }
      });
    },

    // 提交
    onSubmit() {
      this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `pingjia/save`,
            method: "post",
            data: this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  if (this.parent) {
                    this.parent.showFlag = true;
                    this.parent.pingjiaSetFlag = false;
                    this.parent.pingjiaDetailFlag = false;
                    this.parent.search();
                    this.parent.contentStyleChange();
                  } else {
                    this.$router.replace('/pingjiamana')
                  }
                }
              });
            } else {
              this.$message.error(data.message);
            }
          });
        }
      });
    },

 
    //获取所有零食
    getShangpinList() {
      this.$http({
        url: "shangpin/all",
        method: "get",
        params: null
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.shangpinOptions = data.data;
        }
      });
    },
    //获取所有用户
    getUsersList() {
      this.$http({
        url: "users/all",
        method: "get",
        params: null
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.usersOptions = data.data;
        }
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
