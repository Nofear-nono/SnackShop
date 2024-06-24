<template>
  <div>
    <div class="breadcrumb-preview dy-breadcrumb-div">
      <el-breadcrumb :separator="'Ξ'"
        :style='{ "width": "1200px", "margin": "0 auto", "fontSize": "14px", "lineHeight": "1" }'>
        <el-breadcrumb-item>首页</el-breadcrumb-item>
        <el-breadcrumb-item>零食添加</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="detail-preview"
      :style='{ "width": "1200px", "padding": "0 0 24px", "margin": "0px auto", "position": "relative" }'>
      <div class="dy-add-detail-attr-div">
        <el-form class="add-update-preview" ref="ruleForm" :model="ruleForm" :rules="rules" label-width="100px">
          <el-form-item
          :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }'
          label="名称" prop="mingcheng">
          <el-input v-model="ruleForm.mingcheng" placeholder="名称" clearable :readonly="ro.mingcheng"></el-input>
        </el-form-item>
        <el-form-item
          :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }'
          label="编号" prop="bianhao">
          <el-input v-model="ruleForm.bianhao" placeholder="编号" clearable :readonly="ro.bianhao"></el-input>
        </el-form-item>
        <el-form-item :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }' label="分类" prop="pinleiid">
          <el-select v-model="ruleForm.pinleiid" placeholder="请选择分类">
            <el-option v-for="(item, index) in pinleiOptions" v-bind:key="item.id" :label="item.mingcheng"
              :value="item.id">
            </el-option>
          </el-select>
      </el-form-item>
        <el-form-item
          :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }'
          label="内容介绍" prop="neirong">
          <el-input style="min-width: 200px; max-width: 600px;" type="textarea" :rows="8" placeholder="内容介绍" v-model="ruleForm.neirong" :readonly="ro.neirong">
          </el-input>
        </el-form-item>
        <el-form-item :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }' label="图片" prop="image">
          <file-upload tip="点击上传图片" action="common/uploadfile" :limit="1" :multiple="true" @change="imageUploadChange"></file-upload>
        </el-form-item>
        <el-form-item
          :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }'
          label="原价" prop="yuanshijiage">
          <el-input v-model="ruleForm.yuanshijiage" placeholder="原价" clearable :readonly="ro.yuanshijiage"></el-input>
        </el-form-item>
        <el-form-item
          :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }'
          label="现价" prop="jiage">
          <el-input v-model="ruleForm.jiage" placeholder="现价" clearable :readonly="ro.jiage"></el-input>
        </el-form-item>
        <el-form-item
          :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }'
          label="单位" prop="danwei">
          <el-input v-model="ruleForm.danwei" placeholder="单位" clearable :readonly="ro.danwei"></el-input>
        </el-form-item>
        <el-form-item v-show="false" :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }' label="是否特价" prop="shenhe">
          <el-select v-model="ruleForm.shenhe">
            <el-option v-for="(item, index) in shenheOptions" v-bind:key="index" :label="item" :value="item">
            </el-option>
          </el-select>
      </el-form-item>
        <el-form-item
          :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }'
          label="库存数量" prop="kucunshuliang">
          <el-input v-model="ruleForm.kucunshuliang" placeholder="库存数量" clearable :readonly="ro.kucunshuliang"></el-input>
        </el-form-item>
        <el-form-item
          :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }'
          label="销售数量" prop="xiaoshoushuliang">
          <el-input v-model="ruleForm.xiaoshoushuliang" placeholder="销售数量" clearable :readonly="ro.xiaoshoushuliang"></el-input>
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
      ro: {
        mingcheng: false,
        bianhao: false,
        pinleiid: false,
        neirong: false,
        image: false,
        yuanshijiage: false,
        jiage: false,
        danwei: false,
        shenhe: false,
        kucunshuliang: false,
        xiaoshoushuliang: false,

      },
      ruleForm: {
        mingcheng: '',
        bianhao: '',
        pinleiid: '',
        neirong: '',
        image: '',
        yuanshijiage: 0,
        jiage: 0,
        danwei: '',
        shenhe: 'no',
        kucunshuliang: 0,
        xiaoshoushuliang: 0,

      },
      rules: {
        mingcheng: [{ required: true, message: '名称不能为空', trigger: 'blur' },],
        bianhao: [{ required: true, message: '编号不能为空', trigger: 'blur' },],
        pinleiid: [{ required: true, message: '分类不能为空', trigger: 'blur' }, { validator: this.$validate.isIntNumer, trigger: 'blur' },],
        neirong: [],
        image: [{ required: true, message: '图片不能为空', trigger: 'blur' },],
        yuanshijiage: [{ required: true, message: '原价不能为空', trigger: 'blur' }, { validator: this.$validate.isIntNumer, trigger: 'blur' },],
        jiage: [{ required: true, message: '现价不能为空', trigger: 'blur' }, { validator: this.$validate.isIntNumer, trigger: 'blur' },],
        danwei: [{ required: true, message: '单位不能为空', trigger: 'blur' },],
        shenhe: [{ required: true, message: '是否特价不能为空', trigger: 'blur' },],
        kucunshuliang: [{ required: true, message: '库存数量不能为空', trigger: 'blur' }, { validator: this.$validate.isIntNumer, trigger: 'blur' },],
        xiaoshoushuliang: [{ required: true, message: '销售数量不能为空', trigger: 'blur' }, { validator: this.$validate.isIntNumer, trigger: 'blur' },],

      },
        pinleiOptions: [],

    };
  },
  computed: {

  },
  created() {
    this.init();
    this.getPinleiList();

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
          this.$http.post('shangpin/add', this.ruleForm).then(res => {
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
    //图片上传回调
    imageUploadChange(fileUrl) {
      this.ruleForm.image= fileUrl;
    },
 
    //获取所有分类
    getPinleiList() {
      this.$http.get('pinlei/all',).then(res => {
        if (res && res.data.code == 0) {
          this.pinleiOptions = res.data.data;
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