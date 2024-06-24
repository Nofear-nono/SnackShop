<template>
  <div class="main-content">
    <div v-if="showFlag">
      <!--搜索表单区域-->
      <el-form :inline="true" :model="searchForm" class="form-content">
        <el-row :gutter="20" class="slt" style="justify-content:flex-start;">
          <el-form-item>
            <el-input suffix-icon="el-icon-search" v-model="searchForm.mingcheng" placeholder="名称" clearable></el-input>
          </el-form-item>
          <el-form-item>
            <el-input suffix-icon="el-icon-search" v-model="searchForm.bianhao" placeholder="编号" clearable></el-input>
          </el-form-item>
          <el-form-item>
            <el-select v-model="searchForm.pinleiid" placeholder="请选择分类">
              <el-option label="全部" value=""></el-option>
              <el-option v-for="(item, index) in pinleiOptions" v-bind:key="item.id" :label="item.mingcheng" :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-input suffix-icon="el-icon-search" v-model="searchForm.danwei" placeholder="单位" clearable></el-input>
          </el-form-item>
          <el-form-item>
            <el-select v-model="searchForm.shenhe" placeholder="请选择是否特价">
              <el-option label="全部" value=""></el-option>
              <el-option v-for="(item, index) in shenheOptions" v-bind:key="item" :label="item" :value="item">
              </el-option>
            </el-select>
          </el-form-item>

          <el-form-item>
            <el-button icon="el-icon-search" type="primary" @click="search()">查询</el-button>
          </el-form-item>
        </el-row>
        <!-- <el-row class="ad" style="justify-content:flex-start;">
          <el-form-item>
            <el-button :disabled="dataListSelections.length <= 0" type="danger" icon="el-icon-delete"
              @click="shangpinDeleteHandler()">批量删除</el-button>
          </el-form-item>
        </el-row> -->
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
          <el-table-column :align="contents.tableAlign" header-align="center" label="名称">
            <template slot-scope="scope">
              {{ scope.row.mingcheng }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="编号">
            <template slot-scope="scope">
              {{ scope.row.bianhao }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="分类">
            <template slot-scope="scope" v-if="scope.row.pinlei && scope.row.pinlei.mingcheng">
              {{ scope.row.pinlei.mingcheng }}
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
          <el-table-column :align="contents.tableAlign" header-align="center" label="原价">
            <template slot-scope="scope">
              {{ scope.row.yuanshijiage }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="现价">
            <template slot-scope="scope">
              {{ scope.row.jiage }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="单位">
            <template slot-scope="scope">
              {{ scope.row.danwei }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="是否特价">
            <template slot-scope="scope">
              {{ scope.row.shenhe }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="库存数量">
            <template slot-scope="scope">
              {{ scope.row.kucunshuliang }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="销售数量">
            <template slot-scope="scope">
              {{ scope.row.xiaoshoushuliang }}
            </template>
          </el-table-column>

          <el-table-column width="350" :align="contents.tableAlign" header-align="center" label="操作" fixed="right">
            <template slot-scope="scope">
              <!-- <el-button type="primary" icon="el-icon-edit-outline" size="mini" @click="shangpinSet(scope.row.id,scope.row.shenhe == 'no' ? '是否特价' : '取消是否特价','shenhe',scope.row.shenhe == 'no' ? 'yes' : 'no')">{{scope.row.shenhe == 'no' ? '是否特价' : '取消是否特价' }}</el-button> -->


              <el-button type="success" icon="el-icon-info" size="mini" @click="shangpinDetailHandler(scope.row.id)">详情</el-button>
              <!-- <el-button type="primary" icon="el-icon-edit" size="mini" @click="shangpinSetHandler(scope.row.id)">修改</el-button> -->
              <!-- <el-button type="danger" icon="el-icon-delete" size="mini" @click="shangpinDeleteHandler(scope.row.id)">删除</el-button> -->
              <!-- <el-button type="success" icon="el-icon-tickets" size="mini" @click="dingdanxiangChakanHandler(scope.row.id)">订单项查看</el-button> -->
              <!-- <el-button type="success" icon="el-icon-circle-plus" size="mini" @click="dingdanxiangAddHandler(scope.row.id, scope.row.mingcheng)">订单项添加</el-button> -->
              <!-- <el-button type="success" icon="el-icon-tickets" size="mini" @click="gouwucheChakanHandler(scope.row.id)">购物车查看</el-button> -->
              <!-- <el-button type="success" icon="el-icon-circle-plus" size="mini" @click="gouwucheAddHandler(scope.row.id, scope.row.mingcheng)">购物车添加</el-button> -->
              <!-- <el-button type="success" icon="el-icon-tickets" size="mini" @click="pingjiaChakanHandler(scope.row.id)">评论查看</el-button> -->
              <!-- <el-button type="success" icon="el-icon-circle-plus" size="mini" @click="pingjiaAddHandler(scope.row.id, scope.row.mingcheng)">评论添加</el-button> -->
              <!-- <el-button type="success" icon="el-icon-tickets" size="mini" @click="shoucangChakanHandler(scope.row.id)">收藏查看</el-button> -->
              <!-- <el-button type="success" icon="el-icon-circle-plus" size="mini" @click="shoucangAddHandler(scope.row.id, scope.row.mingcheng)">收藏添加</el-button> -->

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
    <!-- 零食修改-->
    <shangpin-set v-if="shangpinSetFlag" :parent="this" ref="shangpinSet"></shangpin-set>
    <!-- 零食详情-->
    <shangpin-detail v-if="shangpinDetailFlag" :parent="this" ref="shangpinDetail"></shangpin-detail>
    <!-- 零食订单项查看-->
    <shangpin-dingdanxiang-chakan v-if="shangpinDingdanxiangChakanFlag" :parent="this" ref="shangpinDingdanxiangChakan"></shangpin-dingdanxiang-chakan>
    <!-- 零食订单项添加-->
    <shangpin-dingdanxiang-add v-if="shangpinDingdanxiangAddFlag" :parent="this" ref="shangpinDingdanxiangAdd"></shangpin-dingdanxiang-add>
    <!-- 零食购物车查看-->
    <shangpin-gouwuche-chakan v-if="shangpinGouwucheChakanFlag" :parent="this" ref="shangpinGouwucheChakan"></shangpin-gouwuche-chakan>
    <!-- 零食购物车添加-->
    <shangpin-gouwuche-add v-if="shangpinGouwucheAddFlag" :parent="this" ref="shangpinGouwucheAdd"></shangpin-gouwuche-add>
    <!-- 零食评论查看-->
    <shangpin-pingjia-chakan v-if="shangpinPingjiaChakanFlag" :parent="this" ref="shangpinPingjiaChakan"></shangpin-pingjia-chakan>
    <!-- 零食评论添加-->
    <shangpin-pingjia-add v-if="shangpinPingjiaAddFlag" :parent="this" ref="shangpinPingjiaAdd"></shangpin-pingjia-add>
    <!-- 零食收藏查看-->
    <shangpin-shoucang-chakan v-if="shangpinShoucangChakanFlag" :parent="this" ref="shangpinShoucangChakan"></shangpin-shoucang-chakan>
    <!-- 零食收藏添加-->
    <shangpin-shoucang-add v-if="shangpinShoucangAddFlag" :parent="this" ref="shangpinShoucangAdd"></shangpin-shoucang-add>

  </div>
</template>
<script>
import ShangpinSet from "./shangpin-set"
import ShangpinDetail from "./shangpin-detail"
import ShangpinDingdanxiangChakan from './shangpin-dingdanxiang-chakan'
import ShangpinDingdanxiangAdd from './shangpin-dingdanxiang-add'
import ShangpinGouwucheChakan from './shangpin-gouwuche-chakan'
import ShangpinGouwucheAdd from './shangpin-gouwuche-add'
import ShangpinPingjiaChakan from './shangpin-pingjia-chakan'
import ShangpinPingjiaAdd from './shangpin-pingjia-add'
import ShangpinShoucangChakan from './shangpin-shoucang-chakan'
import ShangpinShoucangAdd from './shangpin-shoucang-add'

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
      shangpinSetFlag: false,
      shangpinDetailFlag: false,
      shangpinDingdanxiangChakanFlag: false,
      shangpinDingdanxiangAddFlag: false,
      shangpinGouwucheChakanFlag: false,
      shangpinGouwucheAddFlag: false,
      shangpinPingjiaChakanFlag: false,
      shangpinPingjiaAddFlag: false,
      shangpinShoucangChakanFlag: false,
      shangpinShoucangAddFlag: false,

      contents: { "searchBtnFontColor": "#333", "pagePosition": "2", "inputFontSize": "14px", "inputBorderRadius": "4px", "tableBtnDelFontColor": "rgba(249, 104, 104, 1)", "tableBtnIconPosition": "1", "searchBtnHeight": "40px", "inputIconColor": "#C0C4CC", "searchBtnBorderRadius": "4px", "tableStripe": true, "btnAdAllWarnFontColor": "rgba(252, 197, 37, 1)", "tableBtnDelBgColor": "#fff", "searchBtnIcon": "1", "tableSize": "medium", "searchBtnBorderStyle": "solid", "tableSelection": false, "searchBtnBorderWidth": "1px", "tableContentFontSize": "14px", "searchBtnBgColor": "rgba(228, 231, 234, 1)", "inputTitleSize": "14px", "btnAdAllBorderColor": "rgba(144, 238, 144, 1)", "pageJumper": true, "btnAdAllIconPosition": "1", "searchBoxPosition": "1", "tableBtnDetailFontColor": "rgba(87, 199, 212, 1)", "tableBtnHeight": "40px", "pagePager": true, "searchBtnBorderColor": "#DCDFE6", "tableHeaderFontColor": "rgba(255, 255, 255, 1)", "inputTitle": "1", "tableBtnBorderRadius": "4px", "btnAdAllFont": "1", "btnAdAllDelFontColor": "rgba(249, 104, 104, 1)", "tableBtnIcon": "0", "btnAdAllHeight": "40px", "btnAdAllWarnBgColor": "#fff", "btnAdAllBorderWidth": "1px", "tableStripeFontColor": "#606266", "tableBtnBorderStyle": "solid", "inputHeight": "40px", "btnAdAllBorderRadius": "4px", "btnAdAllDelBgColor": "#fff", "pagePrevNext": true, "btnAdAllAddBgColor": "#fff", "searchBtnFont": "1", "tableIndex": true, "btnAdAllIcon": "1", "tableSortable": false, "pageSizes": true, "tableFit": true, "pageBtnBG": true, "searchBtnFontSize": "14px", "tableBtnEditBgColor": "#fff", "inputBorderWidth": "1px", "inputFontPosition": "1", "inputFontColor": "#333", "pageEachNum": 8, "tableHeaderBgColor": "rgba(144, 238, 144, 1)", "inputTitleColor": "#333", "btnAdAllBoxPosition": "1", "tableBtnDetailBgColor": "#fff", "inputIcon": "0", "searchBtnIconPosition": "1", "btnAdAllFontSize": "14px", "inputBorderStyle": "solid", "inputBgColor": "#fff", "pageStyle": false, "pageTotal": true, "btnAdAllAddFontColor": "rgba(51, 202, 187, 1)", "tableBtnFont": "1", "tableContentFontColor": "rgba(72, 72, 72, 1)", "inputBorderColor": "rgba(223, 230, 236, 1)", "tableShowHeader": true, "tableBtnFontSize": "14px", "tableBtnBorderColor": "rgba(144, 238, 144, 1)", "inputIconPosition": "1", "tableBorder": true, "btnAdAllBorderStyle": "solid", "tableBtnBorderWidth": "1px", "tableStripeBgColor": "rgba(252, 253, 254, 1)", "tableBtnEditFontColor": "rgba(249, 97, 151, 1)", "tableAlign": "center" },
      layouts: '',
      xingbieOptions: [],
      typeOptions: [],
      shenheOptions: [],
      pinleiOptions: [],

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
    ShangpinSet,
    ShangpinDetail,
    ShangpinDingdanxiangChakan,
    ShangpinDingdanxiangAdd,
    ShangpinGouwucheChakan,
    ShangpinGouwucheAdd,
    ShangpinPingjiaChakan,
    ShangpinPingjiaAdd,
    ShangpinShoucangChakan,
    ShangpinShoucangAdd,

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
      this.getPinleiList();

    },

    //点击搜索按钮方法
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },

    // 获取零食分页数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        pageNo: this.pageIndex, //页码
        pageSize: this.pageSize, //页大小
        sortProperty: 'id',      //排序列
      }
      //搜索表单数据组装
      if (this.searchForm.mingcheng != '' && this.searchForm.mingcheng != undefined) {
        params['mingcheng'] = this.searchForm.mingcheng
      }
      if (this.searchForm.bianhao != '' && this.searchForm.bianhao != undefined) {
        params['bianhao'] = this.searchForm.bianhao
      }
      if (this.searchForm.pinleiid != '' && this.searchForm.pinleiid != undefined) {
        params['pinleiid'] = this.searchForm.pinleiid
      }
      if (this.searchForm.danwei != '' && this.searchForm.danwei != undefined) {
        params['danwei'] = this.searchForm.danwei
      }
      if (this.searchForm.shenhe != '' && this.searchForm.shenhe != undefined) {
        params['shenhe'] = this.searchForm.shenhe
      }

      this.$http({
        url: "shangpin/chakan",
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

    // 删除或批量删除零食方法
    shangpinDeleteHandler(id) {
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
          url: "shangpin/delete",
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

    //跳转到零食详情页面
    shangpinDetailHandler(id) {
      this.showFlag = false;
      this.shangpinDetailFlag = true;
      this.$nextTick(() => {
        this.$refs.shangpinDetail.init(id);
      });

    },

    //跳转到零食修改页面
    shangpinSetHandler(id) {
      this.showFlag = false;
      this.shangpinSetFlag = true;
      this.$nextTick(() => {
        this.$refs.shangpinSet.init(id);
      });
    },

    //更新零食信息操作方法
    shangpinSet(tid,tname,property,value) {
      let params = {};
      params['id'] = tid;
      params[property] = value;

      this.$confirm(`确定'${tname}'操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: `shangpin/set`,
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


    //跳转到零食订单项添加页面
    dingdanxiangAddHandler(id, mingcheng) {
      this.showFlag = false;
      this.shangpinDingdanxiangAddFlag = true;
      this.$nextTick(() => {
        this.$refs.shangpinDingdanxiangAdd.init(id, mingcheng);
      });
    },

    //跳转到零食订单项查看页面
    dingdanxiangChakanHandler(id) {
      this.showFlag = false;
      this.shangpinDingdanxiangChakanFlag = true;
      this.$nextTick(() => {
        this.$refs.shangpinDingdanxiangChakan.init(id);
      });
    },
    //跳转到零食购物车添加页面
    gouwucheAddHandler(id, mingcheng) {
      this.showFlag = false;
      this.shangpinGouwucheAddFlag = true;
      this.$nextTick(() => {
        this.$refs.shangpinGouwucheAdd.init(id, mingcheng);
      });
    },

    //跳转到零食购物车查看页面
    gouwucheChakanHandler(id) {
      this.showFlag = false;
      this.shangpinGouwucheChakanFlag = true;
      this.$nextTick(() => {
        this.$refs.shangpinGouwucheChakan.init(id);
      });
    },
    //跳转到零食评论添加页面
    pingjiaAddHandler(id, mingcheng) {
      this.showFlag = false;
      this.shangpinPingjiaAddFlag = true;
      this.$nextTick(() => {
        this.$refs.shangpinPingjiaAdd.init(id, mingcheng);
      });
    },

    //跳转到零食评论查看页面
    pingjiaChakanHandler(id) {
      this.showFlag = false;
      this.shangpinPingjiaChakanFlag = true;
      this.$nextTick(() => {
        this.$refs.shangpinPingjiaChakan.init(id);
      });
    },
    //跳转到零食收藏添加页面
    shoucangAddHandler(id, mingcheng) {
      this.showFlag = false;
      this.shangpinShoucangAddFlag = true;
      this.$nextTick(() => {
        this.$refs.shangpinShoucangAdd.init(id, mingcheng);
      });
    },

    //跳转到零食收藏查看页面
    shoucangChakanHandler(id) {
      this.showFlag = false;
      this.shangpinShoucangChakanFlag = true;
      this.$nextTick(() => {
        this.$refs.shangpinShoucangChakan.init(id);
      });
    },


    //获取所有分类
    getPinleiList() {
      this.$http({
        url: "pinlei/all",
        method: "get",
        params: null
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.pinleiOptions = data.data;
        }
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