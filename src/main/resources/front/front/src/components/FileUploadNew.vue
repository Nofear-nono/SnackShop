<template>
  <div style="width: 600px;">
    <!-- 上传文件组件 -->
    <el-upload class="upload-demo" ref="upload" :action="getActionUrl" :multiple="multiple" :limit="limit" :headers="myHeaders"
      :on-exceed="handleExceed" :on-remove="handleRemove" :on-success="handleUploadSuccess" :on-error="handleUploadErr"
      :before-upload="handleBeforeUpload" :file-list="fileList" :on-change="handleChange">
      <el-button size="small" type="primary">点击上传</el-button>
      <div class="el-upload__tip" slot="tip">文件大小不超过50M</div>
    </el-upload>
  </div>
</template>
<script>
import storage from "@/common/storage";
import config from "@/config/config";
export default {
  data() {
    return {
      baseUrl: config.baseUrl,
      // 组件渲染图片的数组字段，有特殊格式要求
      fileList: [],
      fileUrlList: [],
      myHeaders: {}
    };
  },
  props: ["tip", "action", "limit", "multiple", "fileUrls"],
  mounted() {
    this.init();
    this.myHeaders = {
      'Token': storage.get("Token")
    }
  },
  watch: {
    fileUrls: function (val, oldVal) {
      //   console.log("new: %s, old: %s", val, oldVal);
      this.init();
    }
  },
  computed: {
    // 计算属性的 getter
    getActionUrl: function () {
      return this.baseUrl + this.action;
    }
  },
  methods: {
    // 初始化
    init() {
      // console.log("gg:"+this.fileUrls);
      if (this.fileUrls) {
        this.fileUrlList = this.fileUrls.split(",");
        let fileArray = [];
        this.fileUrlList.forEach(function (item, index) {
          var url = item;
          var name = item;
          var file = {
            name: name,
            url: url
          };
          fileArray.push(file);
        });
        this.setFileList(fileArray);
      }
    },
    handleChange(file, fileList) {
      this.fileList = fileList;
    },
    handleBeforeUpload(file) {
      const { name, size } = file;
      // 判断文件大小
      // alert(size);
      if (size > 50 * 1024 * 1024) {
        this.$message.warning(`文件大小不超过50M`);
        return false;
      }
    },
    // 上传文件成功后执行
    handleUploadSuccess(res, file, fileList) {
      if (res && res.code === 0) {
        fileList[fileList.length - 1]["url"] =
          this.baseUrl + "upload/" + file.response.data;
        this.setFileList(fileList);
        this.$emit("change", "upload/" + file.response.data);
      } else {
        this.$message.error(res.message);
      }
    },
    // 图片上传失败
    handleUploadErr(err, file, fileList) {
      this.$message.error("文件上传失败");
    },
    // 移除图片
    handleRemove(file, fileList) {
      this.setFileList(fileList);
      this.$emit("change", this.fileUrlList.join(","));
    },
    // 限制上传文件数量
    handleExceed(files, fileList) {
      this.$message.warning(`最多上传${this.limit}个文件`);
    },
    // 重新对fileList进行赋值
    setFileList(fileList) {
      var fileArray = [];
      var fileUrlArray = [];
      // 有些图片不是公开的，所以需要携带token信息做权限校验
      var token = storage.get("Token");
      fileList.forEach(function (item, index) {
        var url = item.url.split("?")[0];
        var name = item.name;
        var file = {
          name: name,
          url: url + "?token=" + token
        };
        fileArray.push(file);
        fileUrlArray.push(url);
      });
      this.fileList = fileArray;
      this.fileUrlList = fileUrlArray;
    }
  }
};
</script>
<style lang="scss" scoped>


.upload-demo  /deep/ .el-upload-list .el-upload-list__item {
    border: 1px solid #ccc;
    cursor: pointer;
    border-radius: 6px;
    color: #999;
    background: #fff;
    width: 300px;
    font-size: 12px;
    line-height: 40px;
    text-align: left;
    height: auto;
  }
</style>
