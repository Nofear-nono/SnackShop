<template>
  <div>
    <div class="breadcrumb-preview dy-breadcrumb-div">
      <el-breadcrumb :separator="'Ξ'"
        :style='{ "width": "1200px", "margin": "0 auto", "fontSize": "14px", "lineHeight": "1" }'>
        <el-breadcrumb-item>首页</el-breadcrumb-item>
        <el-breadcrumb-item>用户订单添加</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="detail-preview"
      :style='{ "width": "1200px", "padding": "0 0 24px", "margin": "0px auto", "position": "relative" }'>
      <div class="dy-add-detail-attr-div">
        <el-form class="add-update-preview" ref="ruleForm" :model="ruleForm" :rules="rules" label-width="100px">
          <el-form-item
            :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }'
            label="用户" prop="usersid">
            <el-select v-model="usersloginname" disabled>
              </el-select>
          </el-form-item>
          <el-form-item
          :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }'
          label="编号" prop="bianhao">
          <el-input v-model="ruleForm.bianhao" placeholder="编号" clearable :readonly="ro.bianhao"></el-input>
        </el-form-item>
        <el-form-item
          :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }'
          label="订单金额" prop="jine">
          <el-input v-model="ruleForm.jine" placeholder="订单金额" clearable :readonly="ro.jine"></el-input>
        </el-form-item>
        <el-form-item v-show="false" :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }' label="是否支付" prop="zhifushenhe">
          <el-select v-model="ruleForm.zhifushenhe">
            <el-option v-for="(item, index) in shenheOptions" v-bind:key="index" :label="item" :value="item">
            </el-option>
          </el-select>
      </el-form-item>
        <el-form-item v-show="false" :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }' label="是否发货" prop="fahuoshenhe">
          <el-select v-model="ruleForm.fahuoshenhe">
            <el-option v-for="(item, index) in shenheOptions" v-bind:key="index" :label="item" :value="item">
            </el-option>
          </el-select>
      </el-form-item>
        <el-form-item v-show="false" :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }' label="是否收货" prop="shouhuoshenhe">
          <el-select v-model="ruleForm.shouhuoshenhe">
            <el-option v-for="(item, index) in shenheOptions" v-bind:key="index" :label="item" :value="item">
            </el-option>
          </el-select>
      </el-form-item>
        <el-form-item :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }' label="支付方式" prop="zhifufangshiid">
          <el-select v-model="ruleForm.zhifufangshiid" placeholder="请选择支付方式">
            <el-option v-for="(item, index) in zhifufangshiOptions" v-bind:key="item.id" :label="item.mingcheng"
              :value="item.id">
            </el-option>
          </el-select>
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
        <el-form-item
          :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }'
          label="送货地址" prop="dizhi">
          <el-input v-model="ruleForm.dizhi" placeholder="送货地址" clearable :readonly="ro.dizhi"></el-input>
        </el-form-item>
        <el-form-item
          :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }'
          label="时间" prop="shijian">
          <el-date-picker v-model="ruleForm.shijian" type="datetime" format="yyyy-MM-dd HH:mm:ss"
              value-format="yyyy-MM-dd HH:mm:ss" placeholder="时间" default-time="12:00:00" :readonly="ro.shijian">
          </el-date-picker>
        </el-form-item>
        <el-form-item v-if="false" :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }'
          label="物流信息" prop="wuliu">
          <el-input v-model="ruleForm.wuliu" placeholder="物流信息" clearable :readonly="ro.wuliu"></el-input>
        </el-form-item>
        <el-form-item
          :style='{ "border": "0px solid #dfdfdf", "padding": "10px", "boxShadow": "0px 0px 0px #eee", "margin": "0 0 8px 0", "borderRadius": "8px", "background": "none" }'
          label="备注" prop="beizhu">
          <el-input v-model="ruleForm.beizhu" placeholder="备注" clearable :readonly="ro.beizhu"></el-input>
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
      usersloginname: '',
      ro: {
        bianhao: true,
        jine: true,
        zhifushenhe: false,
        fahuoshenhe: false,
        shouhuoshenhe: false,
        zhifufangshiid: false,
        xingming: false,
        dianhua: false,
        dizhi: false,
        shijian: false,
        wuliu: false,
        beizhu: false,
        usersid: false,

      },
      ruleForm: {
        usersid: '',
        bianhao: this.getUUID(),
        jine: '',
        zhifushenhe: 'no',
        fahuoshenhe: 'no',
        shouhuoshenhe: 'no',
        zhifufangshiid: '',
        xingming: '',
        dianhua: '',
        dizhi: '',
        shijian: this.getCurrentTime(1),
        wuliu: '',
        beizhu: '',

      },
      rules: {
        bianhao: [{ required: true, message: '编号不能为空', trigger: 'blur' },],
        jine: [{ required: true, message: '订单金额不能为空', trigger: 'blur' }, { validator: this.$validate.isIntNumer, trigger: 'blur' },],
        zhifushenhe: [{ required: true, message: '是否支付不能为空', trigger: 'blur' },],
        fahuoshenhe: [{ required: true, message: '是否发货不能为空', trigger: 'blur' },],
        shouhuoshenhe: [{ required: true, message: '是否收货不能为空', trigger: 'blur' },],
        zhifufangshiid: [{ required: true, message: '支付方式不能为空', trigger: 'blur' }, { validator: this.$validate.isIntNumer, trigger: 'blur' },],
        xingming: [{ required: true, message: '姓名不能为空', trigger: 'blur' },],
        dianhua: [{ required: true, message: '电话不能为空', trigger: 'blur' }, { validator: this.$validate.isMobile, trigger: 'blur' },],
        dizhi: [{ required: true, message: '送货地址不能为空', trigger: 'blur' },],
        shijian: [{ required: true, message: '时间不能为空', trigger: 'blur' },],
        wuliu: [{ required: true, message: '物流信息不能为空', trigger: 'blur' }, { validator: this.$validate.isIntNumer, trigger: 'blur' },],
        beizhu: [{ required: true, message: '备注不能为空', trigger: 'blur' },],
        usersid: [{ required: true, message: '用户不能为空', trigger: 'blur' }, { validator: this.$validate.isIntNumer, trigger: 'blur' },],

      },
        zhifufangshiOptions: [],

    };
  },
  computed: {

  },
  created() {
    this.init();
    this.getZhifufangshiList();

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
        this.ruleForm.usersid = this.$route.query.id;
      }
      if (this.$route.query.mingcheng) {
        this.usersloginname = this.$route.query.mingcheng;
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
          this.$http.post('dingdan/add', this.ruleForm).then(res => {
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
 
    //获取所有支付方式
    getZhifufangshiList() {
      this.$http.get('zhifufangshi/all',).then(res => {
        if (res && res.data.code == 0) {
          this.zhifufangshiOptions = res.data.data;
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
