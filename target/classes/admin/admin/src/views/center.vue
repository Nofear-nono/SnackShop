<template>
  <div>
    <el-form class="detail-form-content" ref="ruleForm" :model="ruleForm" label-width="80px">
      <el-row>
        <el-col :span="12">
          <el-form-item label="用户名" prop="loginname">
            <el-input v-model="ruleForm.loginname" readonly placeholder="用户名" clearable></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="姓名" prop="xingming">
            <el-input v-model="ruleForm.xingming" placeholder="姓名" clearable></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="性别" prop="xingbie">
            <el-select v-model="ruleForm.xingbie" placeholder="请选择性别">
              <el-option v-for="(item, index) in xingbieOptions" v-bind:key="index" :label="item" :value="item">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="联系电话" prop="dianhua">
            <el-input v-model="ruleForm.dianhua" placeholder="联系电话" clearable></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item>
            <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber, isIntNumer, isEmail, isMobile, isPhone, isURL, checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      usersFlag: false,
      xingbieOptions: [],
    };
  },
  mounted() {
    this.$http({
      url: `users/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
        this.ruleForm.loginpw = null;
      } else {
        this.$message.error(data.message);
      }
    });
    this.xingbieOptions = "男,女".split(',')
  },
  methods: {
    onUpdateHandler() {
      if ((!this.ruleForm.xingming)) {
        this.$message.error('姓名不能为空');
        return
      }
      if (this.ruleForm.dianhua && (!isMobile(this.ruleForm.dianhua))) {
        this.$message.error(`联系电话应输入手机格式`);
        return
      }
      this.$http({
        url: `users/save`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.message);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped></style>
