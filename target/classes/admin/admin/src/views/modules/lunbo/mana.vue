<template>
  <div class="main-content">
    <div v-if="showFlag">
      <!--搜索表单区域-->
      <el-form :inline="true" :model="searchForm" class="form-content">
        <el-row :gutter="20" class="slt" style="justify-content:flex-start;">
          <el-form-item>
            <el-input suffix-icon="el-icon-search" v-model="searchForm.biaoti" placeholder="标题" clearable></el-input>
          </el-form-item>

          <el-form-item>
            <el-button icon="el-icon-search" type="primary" @click="search()">查询</el-button>
          </el-form-item>
        </el-row>
        <el-row class="ad" style="justify-content:flex-start;">
          <el-form-item>
            <el-button :disabled="dataListSelections.length <= 0" type="danger" icon="el-icon-delete"
              @click="lunboDeleteHandler()">批量删除</el-button>
          </el-form-item>
        </el-row>
      </el-form>
      <!--数据列表区域-->
      <div class="table-content">
        <el-table class="tables" :size="contents.tableSize" :show-header="contents.tableShowHeader"
          :header-row-style="headerRowStyle" :header-cell-style="headerCellStyle" :border="contents.tableBorder"
          :fit="contents.tableFit" :stripe="contents.tableStripe" :row-style="rowStyle" :cell-style="cellStyle"
          :style="{ width: '100%', fontSize: contents.tableContentFontSize, color: contents.tableContentFontColor }"
          :data="dataList" v-loading="dataListLoading" @selection-change="selectionChangeHandler">
          <el-table-column v-if="contents.tableSelection" type="selection" header-align="center"
            :align="contents.tableAlign" width="50">
          </el-table-column>
          <el-table-column label="序号" v-if="contents.tableIndex" type="index" width="50" />
          <el-table-column :align="contents.tableAlign" header-align="center" label="标题">
            <template slot-scope="scope">
              {{ scope.row.biaoti }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="图片">
            <template slot-scope="scope">
              <div v-if="scope.row.image">
                <img :src="getFileSrc(scope.row.image)" width="80" height="80">
              </div>
              <div v-else>暂无图片</div>
            </template>
          </el-table-column>

          <el-table-column width="350" :align="contents.tableAlign" header-align="center" label="操作" fixed="right">
            <template slot-scope="scope">

              <el-button type="success" icon="el-icon-info" size="mini" @click="lunboDetailHandler(scope.row.id)">详情</el-button>
              <el-button type="primary" icon="el-icon-edit" size="mini" @click="lunboSetHandler(scope.row.id)">修改</el-button>
              <el-button type="danger" icon="el-icon-delete" size="mini" @click="lunboDeleteHandler(scope.row.id)">删除</el-button>

            </template>
          </el-table-column>
        </el-table>
        <!--分页-->
        <el-pagination clsss="pages" :layout="layouts" @size-change="sizeChangeHandle"
          @current-change="currentChangeHandle" :current-page="pageIndex" :page-sizes="[8, 10, 20, 30, 50]"
          :page-size="Number(contents.pageEachNum)" :total="totalPage" :small="contents.pageStyle"
          class="pagination-content" :background="contents.pageBtnBG"
          :style="{ textAlign: contents.pagePosition == 1 ? 'left' : contents.pagePosition == 2 ? 'center' : 'right' }"
          prev-text="<上一页" next-text="下一页>"></el-pagination>
      </div>
    </div>
    <!-- 轮播图修改-->
    <lunbo-set v-if="lunboSetFlag" :parent="this" ref="lunboSet"></lunbo-set>
    <!-- 轮播图详情-->
    <lunbo-detail v-if="lunboDetailFlag" :parent="this" ref="lunboDetail"></lunbo-detail>

  </div>
</template>
<script>
import LunboSet from "./lunbo-set"
import LunboDetail from "./lunbo-detail"

export default {
  data() {
    return {
      searchForm: {
        key: ""
      },
      dataList: [],
      pageIndex: 1,
      pageSize: 8,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: true,
      lunboSetFlag: false,
      lunboDetailFlag: false,

      contents: { "searchBtnFontColor": "#333", "pagePosition": "2", "inputFontSize": "14px", "inputBorderRadius": "4px", "tableBtnDelFontColor": "rgba(249, 104, 104, 1)", "tableBtnIconPosition": "1", "searchBtnHeight": "40px", "inputIconColor": "#C0C4CC", "searchBtnBorderRadius": "4px", "tableStripe": true, "btnAdAllWarnFontColor": "rgba(252, 197, 37, 1)", "tableBtnDelBgColor": "#fff", "searchBtnIcon": "1", "tableSize": "medium", "searchBtnBorderStyle": "solid", "tableSelection": true, "searchBtnBorderWidth": "1px", "tableContentFontSize": "14px", "searchBtnBgColor": "rgba(228, 231, 234, 1)", "inputTitleSize": "14px", "btnAdAllBorderColor": "rgba(144, 238, 144, 1)", "pageJumper": true, "btnAdAllIconPosition": "1", "searchBoxPosition": "1", "tableBtnDetailFontColor": "rgba(87, 199, 212, 1)", "tableBtnHeight": "40px", "pagePager": true, "searchBtnBorderColor": "#DCDFE6", "tableHeaderFontColor": "rgba(255, 255, 255, 1)", "inputTitle": "1", "tableBtnBorderRadius": "4px", "btnAdAllFont": "1", "btnAdAllDelFontColor": "rgba(249, 104, 104, 1)", "tableBtnIcon": "0", "btnAdAllHeight": "40px", "btnAdAllWarnBgColor": "#fff", "btnAdAllBorderWidth": "1px", "tableStripeFontColor": "#606266", "tableBtnBorderStyle": "solid", "inputHeight": "40px", "btnAdAllBorderRadius": "4px", "btnAdAllDelBgColor": "#fff", "pagePrevNext": true, "btnAdAllAddBgColor": "#fff", "searchBtnFont": "1", "tableIndex": true, "btnAdAllIcon": "1", "tableSortable": false, "pageSizes": true, "tableFit": true, "pageBtnBG": true, "searchBtnFontSize": "14px", "tableBtnEditBgColor": "#fff", "inputBorderWidth": "1px", "inputFontPosition": "1", "inputFontColor": "#333", "pageEachNum": 8, "tableHeaderBgColor": "rgba(144, 238, 144, 1)", "inputTitleColor": "#333", "btnAdAllBoxPosition": "1", "tableBtnDetailBgColor": "#fff", "inputIcon": "0", "searchBtnIconPosition": "1", "btnAdAllFontSize": "14px", "inputBorderStyle": "solid", "inputBgColor": "#fff", "pageStyle": false, "pageTotal": true, "btnAdAllAddFontColor": "rgba(51, 202, 187, 1)", "tableBtnFont": "1", "tableContentFontColor": "rgba(72, 72, 72, 1)", "inputBorderColor": "rgba(223, 230, 236, 1)", "tableShowHeader": true, "tableBtnFontSize": "14px", "tableBtnBorderColor": "rgba(144, 238, 144, 1)", "inputIconPosition": "1", "tableBorder": true, "btnAdAllBorderStyle": "solid", "tableBtnBorderWidth": "1px", "tableStripeBgColor": "rgba(252, 253, 254, 1)", "tableBtnEditFontColor": "rgba(249, 97, 151, 1)", "tableAlign": "center" },
      layouts: '',
      xingbieOptions: [],
      typeOptions: [],
      shenheOptions: [],

    };
  },
  created() {
    this.init();
    this.getDataList();
    this.contentStyleChange();
  },
  mounted() {
  },
  filters: {
    htmlfilter: function (val) {
      return val.replace(/<[^>]*>/g).replace(/undefined/g, '');
    }
  },
  components: {
    LunboSet,
    LunboDetail,

  },
  methods: {
    //页面元素样式加载
    contentStyleChange() {
      this.contentSearchStyleChange()
      this.contentBtnAdAllStyleChange()
      this.contentSearchBtnStyleChange()
      this.contentTableBtnStyleChange()
      this.contentPageStyleChange()
    },
    //搜索表单样式加载
    contentSearchStyleChange() {
      this.$nextTick(() => {
        document.querySelectorAll('.form-content .slt .el-input__inner').forEach(el => {
          let textAlign = 'left'
          if (this.contents.inputFontPosition == 2) textAlign = 'center'
          if (this.contents.inputFontPosition == 3) textAlign = 'right'
          el.style.textAlign = textAlign
          el.style.height = this.contents.inputHeight
          el.style.lineHeight = this.contents.inputHeight
          el.style.color = this.contents.inputFontColor
          el.style.fontSize = this.contents.inputFontSize
          el.style.borderWidth = this.contents.inputBorderWidth
          el.style.borderStyle = this.contents.inputBorderStyle
          el.style.borderColor = this.contents.inputBorderColor
          el.style.borderRadius = this.contents.inputBorderRadius
          el.style.backgroundColor = this.contents.inputBgColor
        })
        if (this.contents.inputTitle) {
          document.querySelectorAll('.form-content .slt .el-form-item__label').forEach(el => {
            el.style.color = this.contents.inputTitleColor
            el.style.fontSize = this.contents.inputTitleSize
            el.style.lineHeight = this.contents.inputHeight
          })
        }
        setTimeout(() => {
          document.querySelectorAll('.form-content .slt .el-input__prefix').forEach(el => {
            el.style.color = this.contents.inputIconColor
            el.style.lineHeight = this.contents.inputHeight
          })
          document.querySelectorAll('.form-content .slt .el-input__suffix').forEach(el => {
            el.style.color = this.contents.inputIconColor
            el.style.lineHeight = this.contents.inputHeight
          })
          document.querySelectorAll('.form-content .slt .el-input__icon').forEach(el => {
            el.style.lineHeight = this.contents.inputHeight
          })
        }, 10)

      })
    },
    // 搜索按钮样式加载
    contentSearchBtnStyleChange() {
      this.$nextTick(() => {
        document.querySelectorAll('.form-content .slt .el-button--success').forEach(el => {
          el.style.height = this.contents.searchBtnHeight
          el.style.color = this.contents.searchBtnFontColor
          el.style.fontSize = this.contents.searchBtnFontSize
          el.style.borderWidth = this.contents.searchBtnBorderWidth
          el.style.borderStyle = this.contents.searchBtnBorderStyle
          el.style.borderColor = this.contents.searchBtnBorderColor
          el.style.borderRadius = this.contents.searchBtnBorderRadius
          el.style.backgroundColor = this.contents.searchBtnBgColor
        })
      })
    },
    // 批量删除按钮样式加载
    contentBtnAdAllStyleChange() {
      this.$nextTick(() => {
        document.querySelectorAll('.form-content .ad .el-button--success').forEach(el => {
          el.style.height = this.contents.btnAdAllHeight
          el.style.color = this.contents.btnAdAllAddFontColor
          el.style.fontSize = this.contents.btnAdAllFontSize
          el.style.borderWidth = this.contents.btnAdAllBorderWidth
          el.style.borderStyle = this.contents.btnAdAllBorderStyle
          el.style.borderColor = this.contents.btnAdAllBorderColor
          el.style.borderRadius = this.contents.btnAdAllBorderRadius
          el.style.backgroundColor = this.contents.btnAdAllAddBgColor
        })
        document.querySelectorAll('.form-content .ad .el-button--danger').forEach(el => {
          el.style.height = this.contents.btnAdAllHeight
          el.style.color = this.contents.btnAdAllDelFontColor
          el.style.fontSize = this.contents.btnAdAllFontSize
          el.style.borderWidth = this.contents.btnAdAllBorderWidth
          el.style.borderStyle = this.contents.btnAdAllBorderStyle
          el.style.borderColor = this.contents.btnAdAllBorderColor
          el.style.borderRadius = this.contents.btnAdAllBorderRadius
          el.style.backgroundColor = this.contents.btnAdAllDelBgColor
        })
        document.querySelectorAll('.form-content .ad .el-button--warning').forEach(el => {
          el.style.height = this.contents.btnAdAllHeight
          el.style.color = this.contents.btnAdAllWarnFontColor
          el.style.fontSize = this.contents.btnAdAllFontSize
          el.style.borderWidth = this.contents.btnAdAllBorderWidth
          el.style.borderStyle = this.contents.btnAdAllBorderStyle
          el.style.borderColor = this.contents.btnAdAllBorderColor
          el.style.borderRadius = this.contents.btnAdAllBorderRadius
          el.style.backgroundColor = this.contents.btnAdAllWarnBgColor
        })
      })
    },
    // 表格行样式
    rowStyle({ row, rowIndex }) {
      if (rowIndex % 2 == 1) {
        if (this.contents.tableStripe) {
          return { color: this.contents.tableStripeFontColor }
        }
      } else {
        return ''
      }
    },
    //单元格样式
    cellStyle({ row, rowIndex }) {
      if (rowIndex % 2 == 1) {
        if (this.contents.tableStripe) {
          return { backgroundColor: this.contents.tableStripeBgColor }
        }
      } else {
        return ''
      }
    },
    //表头行样式
    headerRowStyle({ row, rowIndex }) {
      return { color: this.contents.tableHeaderFontColor }
    },
    //表头单元格样式
    headerCellStyle({ row, rowIndex }) {
      return { backgroundColor: this.contents.tableHeaderBgColor }
    },
    // 表格按钮样式
    contentTableBtnStyleChange() {
    },
    // 分页组件样式
    contentPageStyleChange() {
      let arr = []
      if (this.contents.pageTotal) arr.push('total')
      if (this.contents.pageSizes) arr.push('sizes')
      if (this.contents.pagePrevNext) {
        arr.push('prev')
        if (this.contents.pagePager) arr.push('pager')
        arr.push('next')
      }
      if (this.contents.pageJumper) arr.push('jumper')
      this.layouts = arr.join()
      this.contents.pageEachNum = 8
    },
    //pageSize触发
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    //currentPage触发
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
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
    //页面初始化
    init() {
      this.shenheOptions = "yes,no".split(',');
      this.xingbieOptions = "男,女".split(',');
      this.typeOptions = this.$userstypes;

    },

    //点击搜索按钮方法
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },

    // 获取轮播图分页数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        pageNo: this.pageIndex, //页码
        pageSize: this.pageSize, //页大小
        sortProperty: 'id',      //排序列
      }
      //搜索表单数据组装
      if (this.searchForm.biaoti != '' && this.searchForm.biaoti != undefined) {
        params['biaoti'] = this.searchForm.biaoti
      }

      this.$http({
        url: "lunbo/mana",
        method: "get",
        params: params
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.dataList = data.data.records;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },

    // 删除或批量删除轮播图方法
    lunboDeleteHandler(id) {
      var ids = id
        ? [Number(id)]
        : this.dataListSelections.map(item => {
          return Number(item.id);
        });
      let confirmText=  id ? "删除" : "批量删除";
      this.$confirm(`确定进行[${confirmText}]操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "lunbo/delete",
          method: "post",
          data: ids
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "操作成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.search();
              }
            });
          } else {
            this.$message.error(data.message);
          }
        });
      }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消'+confirmText
          });          
      });
    },

    //跳转到轮播图详情页面
    lunboDetailHandler(id) {
      this.showFlag = false;
      this.lunboDetailFlag = true;
      this.$nextTick(() => {
        this.$refs.lunboDetail.init(id);
      });

    },

    //跳转到轮播图修改页面
    lunboSetHandler(id) {
      this.showFlag = false;
      this.lunboSetFlag = true;
      this.$nextTick(() => {
        this.$refs.lunboSet.init(id);
      });
    },

    //更新轮播图信息操作方法
    lunboSet(tid,tname,property,value) {
      let params = {};
      params['id'] = tid;
      params[property] = value;

      this.$confirm(`确定'${tname}'操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: `lunbo/set`,
          method: "post",
          data: params
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "操作成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.search();
              }
            });
          } else {
            this.$message.error(data.message);
          }
        });
      }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消'+tname+'操作'
          });          
      });
    },




 
  }

};
</script>
<style lang="scss" scoped>
.slt {
  margin: 0 !important;
  display: flex;
}

.ad {
  margin: 0 !important;
  display: flex;
}

.pages {
  & /deep/ el-pagination__sizes {
    & /deep/ el-input__inner {
      height: 22px;
      line-height: 22px;
    }
  }
}


.el-button+.el-button {
  margin: 0;
}

.tables {
  & /deep/ .el-button--success {
    height: 40px;
    color: rgba(87, 199, 212, 1);
    font-size: 14px;
    border-width: 1px;
    border-style: solid;
    border-color: rgba(144, 238, 144, 1);
    border-radius: 4px;
    background-color: #fff;
  }

  & /deep/ .el-button--primary {
    height: 40px;
    color: rgba(249, 97, 151, 1);
    font-size: 14px;
    border-width: 1px;
    border-style: solid;
    border-color: rgba(144, 238, 144, 1);
    border-radius: 4px;
    background-color: #fff;
  }

  & /deep/ .el-button--danger {
    height: 40px;
    color: rgba(249, 104, 104, 1);
    font-size: 14px;
    border-width: 1px;
    border-style: solid;
    border-color: rgba(144, 238, 144, 1);
    border-radius: 4px;
    background-color: #fff;
  }

  & /deep/ .el-button {
    margin: 4px;
  }

  /deep/.el-table__footer-wrapper tbody td {
    color: red;
    font-weight: 600;
  }
}</style>
