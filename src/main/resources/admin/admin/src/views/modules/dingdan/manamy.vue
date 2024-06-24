<template>
  <div class="main-content">
    <div v-if="showFlag">
      <!--搜索表单区域-->
      <el-form :inline="true" :model="searchForm" class="form-content">
        <el-row :gutter="20" class="slt" style="justify-content:flex-start;">
          <el-form-item>
            <el-input suffix-icon="el-icon-search" v-model="searchForm.bianhao" placeholder="编号" clearable></el-input>
          </el-form-item>
          <el-form-item>
            <el-input suffix-icon="el-icon-search" v-model="searchForm.jine" placeholder="订单金额" clearable></el-input>
          </el-form-item>
          <el-form-item>
            <el-select v-model="searchForm.zhifushenhe" placeholder="请选择是否支付">
              <el-option label="全部" value=""></el-option>
              <el-option v-for="(item, index) in shenheOptions" v-bind:key="item" :label="item" :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-select v-model="searchForm.fahuoshenhe" placeholder="请选择是否发货">
              <el-option label="全部" value=""></el-option>
              <el-option v-for="(item, index) in shenheOptions" v-bind:key="item" :label="item" :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-select v-model="searchForm.shouhuoshenhe" placeholder="请选择是否收货">
              <el-option label="全部" value=""></el-option>
              <el-option v-for="(item, index) in shenheOptions" v-bind:key="item" :label="item" :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-select v-model="searchForm.zhifufangshiid" placeholder="请选择支付方式">
              <el-option label="全部" value=""></el-option>
              <el-option v-for="(item, index) in zhifufangshiOptions" v-bind:key="item.id" :label="item.mingcheng" :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-input suffix-icon="el-icon-search" v-model="searchForm.xingming" placeholder="姓名" clearable></el-input>
          </el-form-item>
          <el-form-item>
            <el-input suffix-icon="el-icon-search" v-model="searchForm.dianhua" placeholder="电话" clearable></el-input>
          </el-form-item>
          <el-form-item>
            <el-input suffix-icon="el-icon-search" v-model="searchForm.dizhi" placeholder="送货地址" clearable></el-input>
          </el-form-item>
          <el-form-item>
            <el-input suffix-icon="el-icon-search" v-model="searchForm.wuliu" placeholder="物流信息" clearable></el-input>
          </el-form-item>
          <el-form-item>
            <el-input suffix-icon="el-icon-search" v-model="searchForm.beizhu" placeholder="备注" clearable></el-input>
          </el-form-item>
          <el-form-item v-if="false">
            <el-select v-model="searchForm.usersid" placeholder="请选择用户">
              <el-option label="全部" value=""></el-option>
              <el-option v-for="(item, index) in usersOptions" v-bind:key="item.id" :label="item.loginname" :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>

          <el-form-item>
            <el-button icon="el-icon-search" type="primary" @click="search()">查询</el-button>
          </el-form-item>
        </el-row>
        <el-row class="ad" style="justify-content:flex-start;">
          <el-form-item>
            <el-button :disabled="dataListSelections.length <= 0" type="danger" icon="el-icon-delete"
              @click="dingdanDeleteHandler()">批量删除</el-button>
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
          <el-table-column :align="contents.tableAlign" header-align="center" label="编号">
            <template slot-scope="scope">
              {{ scope.row.bianhao }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="订单金额">
            <template slot-scope="scope">
              {{ scope.row.jine }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="是否支付">
            <template slot-scope="scope">
              {{ scope.row.zhifushenhe }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="是否发货">
            <template slot-scope="scope">
              {{ scope.row.fahuoshenhe }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="是否收货">
            <template slot-scope="scope">
              {{ scope.row.shouhuoshenhe }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="支付方式">
            <template slot-scope="scope" v-if="scope.row.zhifufangshi && scope.row.zhifufangshi.mingcheng">
              {{ scope.row.zhifufangshi.mingcheng }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="姓名">
            <template slot-scope="scope">
              {{ scope.row.xingming }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="电话">
            <template slot-scope="scope">
              {{ scope.row.dianhua }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="送货地址">
            <template slot-scope="scope">
              {{ scope.row.dizhi }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="时间">
            <template slot-scope="scope">
              {{ scope.row.shijian }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="物流信息">
            <template slot-scope="scope">
              {{ scope.row.wuliu }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="备注">
            <template slot-scope="scope">
              {{ scope.row.beizhu }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="用户">
            <template slot-scope="scope" v-if="scope.row.users && scope.row.users.loginname">
              {{ scope.row.users.loginname }}
            </template>
          </el-table-column>

          <el-table-column width="350" :align="contents.tableAlign" header-align="center" label="操作" fixed="right">
            <template slot-scope="scope">
              <el-button type="primary" icon="el-icon-edit-outline" size="mini" @click="dingdanSet(scope.row.id,scope.row.fahuoshenhe == 'no' ? '发货' : '取消发货','fahuoshenhe',scope.row.fahuoshenhe == 'no' ? 'yes' : 'no')">{{scope.row.fahuoshenhe == 'no' ? '发货' : '取消发货' }}</el-button>


              <el-button type="success" icon="el-icon-info" size="mini" @click="dingdanDetailHandler(scope.row.id)">详情</el-button>
              <el-button type="primary" icon="el-icon-edit" size="mini" @click="dingdanSetHandler(scope.row.id)">修改</el-button>
              <el-button type="danger" icon="el-icon-delete" size="mini" @click="dingdanDeleteHandler(scope.row.id)">删除</el-button>
              <!-- <el-button type="success" icon="el-icon-tickets" size="mini" @click="dingdanxiangChakanHandler(scope.row.id)">订单项查看</el-button> -->
              <!-- <el-button type="success" icon="el-icon-circle-plus" size="mini" @click="dingdanxiangAddHandler(scope.row.id, scope.row.bianhao)">订单项添加</el-button> -->

            </template>
          </el-table-column>
        </el-table>
        <span v-if="totalAmount"> 总金额：<strong style="color: red;">{{totalAmount}}元</strong></span>
        <!--分页-->
        <el-pagination clsss="pages" :layout="layouts" @size-change="sizeChangeHandle"
          @current-change="currentChangeHandle" :current-page="pageIndex" :page-sizes="[8, 10, 20, 30, 50]"
          :page-size="Number(contents.pageEachNum)" :total="totalPage" :small="contents.pageStyle"
          class="pagination-content" :background="contents.pageBtnBG"
          :style="{ textAlign: contents.pagePosition == 1 ? 'left' : contents.pagePosition == 2 ? 'center' : 'right' }"
          prev-text="<上一页" next-text="下一页>"></el-pagination>
      </div>
    </div>
    <!-- 订单修改-->
    <dingdan-set v-if="dingdanSetFlag" :parent="this" ref="dingdanSet"></dingdan-set>
    <!-- 订单详情-->
    <dingdan-detail v-if="dingdanDetailFlag" :parent="this" ref="dingdanDetail"></dingdan-detail>
    <!-- 订单订单项查看-->
    <dingdan-dingdanxiang-chakan v-if="dingdanDingdanxiangChakanFlag" :parent="this" ref="dingdanDingdanxiangChakan"></dingdan-dingdanxiang-chakan>
    <!-- 订单订单项添加-->
    <dingdan-dingdanxiang-add v-if="dingdanDingdanxiangAddFlag" :parent="this" ref="dingdanDingdanxiangAdd"></dingdan-dingdanxiang-add>

  </div>
</template>
<script>
import DingdanSet from "./dingdan-set"
import DingdanDetail from "./dingdan-detail"
import DingdanDingdanxiangChakan from './dingdan-dingdanxiang-chakan'
import DingdanDingdanxiangAdd from './dingdan-dingdanxiang-add'

export default {
  data() {
    return {
      searchForm: {
        key: ""
      },
      totalAmount: 0,
      dataList: [],
      pageIndex: 1,
      pageSize: 8,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: true,
      dingdanSetFlag: false,
      dingdanDetailFlag: false,
      dingdanDingdanxiangChakanFlag: false,
      dingdanDingdanxiangAddFlag: false,

      contents: { "searchBtnFontColor": "#333", "pagePosition": "2", "inputFontSize": "14px", "inputBorderRadius": "4px", "tableBtnDelFontColor": "rgba(249, 104, 104, 1)", "tableBtnIconPosition": "1", "searchBtnHeight": "40px", "inputIconColor": "#C0C4CC", "searchBtnBorderRadius": "4px", "tableStripe": true, "btnAdAllWarnFontColor": "rgba(252, 197, 37, 1)", "tableBtnDelBgColor": "#fff", "searchBtnIcon": "1", "tableSize": "medium", "searchBtnBorderStyle": "solid", "tableSelection": true, "searchBtnBorderWidth": "1px", "tableContentFontSize": "14px", "searchBtnBgColor": "rgba(228, 231, 234, 1)", "inputTitleSize": "14px", "btnAdAllBorderColor": "rgba(144, 238, 144, 1)", "pageJumper": true, "btnAdAllIconPosition": "1", "searchBoxPosition": "1", "tableBtnDetailFontColor": "rgba(87, 199, 212, 1)", "tableBtnHeight": "40px", "pagePager": true, "searchBtnBorderColor": "#DCDFE6", "tableHeaderFontColor": "rgba(255, 255, 255, 1)", "inputTitle": "1", "tableBtnBorderRadius": "4px", "btnAdAllFont": "1", "btnAdAllDelFontColor": "rgba(249, 104, 104, 1)", "tableBtnIcon": "0", "btnAdAllHeight": "40px", "btnAdAllWarnBgColor": "#fff", "btnAdAllBorderWidth": "1px", "tableStripeFontColor": "#606266", "tableBtnBorderStyle": "solid", "inputHeight": "40px", "btnAdAllBorderRadius": "4px", "btnAdAllDelBgColor": "#fff", "pagePrevNext": true, "btnAdAllAddBgColor": "#fff", "searchBtnFont": "1", "tableIndex": true, "btnAdAllIcon": "1", "tableSortable": false, "pageSizes": true, "tableFit": true, "pageBtnBG": true, "searchBtnFontSize": "14px", "tableBtnEditBgColor": "#fff", "inputBorderWidth": "1px", "inputFontPosition": "1", "inputFontColor": "#333", "pageEachNum": 8, "tableHeaderBgColor": "rgba(144, 238, 144, 1)", "inputTitleColor": "#333", "btnAdAllBoxPosition": "1", "tableBtnDetailBgColor": "#fff", "inputIcon": "0", "searchBtnIconPosition": "1", "btnAdAllFontSize": "14px", "inputBorderStyle": "solid", "inputBgColor": "#fff", "pageStyle": false, "pageTotal": true, "btnAdAllAddFontColor": "rgba(51, 202, 187, 1)", "tableBtnFont": "1", "tableContentFontColor": "rgba(72, 72, 72, 1)", "inputBorderColor": "rgba(223, 230, 236, 1)", "tableShowHeader": true, "tableBtnFontSize": "14px", "tableBtnBorderColor": "rgba(144, 238, 144, 1)", "inputIconPosition": "1", "tableBorder": true, "btnAdAllBorderStyle": "solid", "tableBtnBorderWidth": "1px", "tableStripeBgColor": "rgba(252, 253, 254, 1)", "tableBtnEditFontColor": "rgba(249, 97, 151, 1)", "tableAlign": "center" },
      layouts: '',
      xingbieOptions: [],
      typeOptions: [],
      shenheOptions: [],
      zhifufangshiOptions: [],
      usersOptions: [],

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
    DingdanSet,
    DingdanDetail,
    DingdanDingdanxiangChakan,
    DingdanDingdanxiangAdd,

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
      this.getZhifufangshiList();
      this.getUsersList();

    },

    //点击搜索按钮方法
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },

    // 获取订单分页数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        pageNo: this.pageIndex, //页码
        pageSize: this.pageSize, //页大小
        sortProperty: 'id',      //排序列
        usersid: this.$storage.get('usersid'),
      }
      //搜索表单数据组装
      if (this.searchForm.bianhao != '' && this.searchForm.bianhao != undefined) {
        params['bianhao'] = this.searchForm.bianhao
      }
      if (this.searchForm.jine != '' && this.searchForm.jine != undefined) {
        params['jine'] = this.searchForm.jine
      }
      if (this.searchForm.zhifushenhe != '' && this.searchForm.zhifushenhe != undefined) {
        params['zhifushenhe'] = this.searchForm.zhifushenhe
      }
      if (this.searchForm.fahuoshenhe != '' && this.searchForm.fahuoshenhe != undefined) {
        params['fahuoshenhe'] = this.searchForm.fahuoshenhe
      }
      if (this.searchForm.shouhuoshenhe != '' && this.searchForm.shouhuoshenhe != undefined) {
        params['shouhuoshenhe'] = this.searchForm.shouhuoshenhe
      }
      if (this.searchForm.zhifufangshiid != '' && this.searchForm.zhifufangshiid != undefined) {
        params['zhifufangshiid'] = this.searchForm.zhifufangshiid
      }
      if (this.searchForm.xingming != '' && this.searchForm.xingming != undefined) {
        params['xingming'] = this.searchForm.xingming
      }
      if (this.searchForm.dianhua != '' && this.searchForm.dianhua != undefined) {
        params['dianhua'] = this.searchForm.dianhua
      }
      if (this.searchForm.dizhi != '' && this.searchForm.dizhi != undefined) {
        params['dizhi'] = this.searchForm.dizhi
      }
      if (this.searchForm.wuliu != '' && this.searchForm.wuliu != undefined) {
        params['wuliu'] = this.searchForm.wuliu
      }
      if (this.searchForm.beizhu != '' && this.searchForm.beizhu != undefined) {
        params['beizhu'] = this.searchForm.beizhu
      }
      if (this.searchForm.usersid != '' && this.searchForm.usersid != undefined) {
        params['usersid'] = this.searchForm.usersid
      }

      this.$http({
        url: "dingdan/manamy",
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
      this.$http({
        url: "dingdan/totalamount",
        method: "get",
        params: params
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.totalAmount = data.data;
        } 
      });
    },

    // 表格末尾行添加金额合计方法
    getTotalAmount({ columns, data }) {
      const sums = [];
      columns.forEach((column, index) => {
        if (index === 2) {
          sums[index] = '合计';
          return;
        }
        if (column.property === 'jine') { // 判断当前prop绑定的ID
          const values = data.map(item => (item[column.property]))// 把对应一列中的之全部取出，放到一个数组中
          sums[index] = values.reduce((prev, curr) => {
            const value = Number(curr)// 将values中的每个值转换为number类型
            if (!isNaN(value)) {
              return prev + curr
            } else {
              return prev
            }
          }, 0)
          sums[index] += '元'
        }
        // if(index>2){
        //   const values = data.map(item => Number(item[column.property]));
        //   if (!values.every(value => isNaN(value))) {
        //     sums[index] = values.reduce((prev, curr) => {
        //       const value = Number(curr);
        //       if (!isNaN(value)) {
        //         return prev + curr;
        //       } else {
        //         return prev;
        //       }
        //     }, 0);
        //     sums[index] += ' 元';
        //   } else {
        //     sums[index] = '';
        //   }
        // }
      });
      return sums;
    },

    // 删除或批量删除订单方法
    dingdanDeleteHandler(id) {
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
          url: "dingdan/delete",
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

    //跳转到订单详情页面
    dingdanDetailHandler(id) {
      this.showFlag = false;
      this.dingdanDetailFlag = true;
      this.$nextTick(() => {
        this.$refs.dingdanDetail.init(id);
      });

    },

    //跳转到订单修改页面
    dingdanSetHandler(id) {
      this.showFlag = false;
      this.dingdanSetFlag = true;
      this.$nextTick(() => {
        this.$refs.dingdanSet.init(id);
      });
    },

    //更新订单信息操作方法
    dingdanSet(tid,tname,property,value) {
      let params = {};
      params['id'] = tid;
      params[property] = value;

      this.$confirm(`确定'${tname}'操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: `dingdan/set`,
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


    //跳转到订单订单项添加页面
    dingdanxiangAddHandler(id, bianhao) {
      this.showFlag = false;
      this.dingdanDingdanxiangAddFlag = true;
      this.$nextTick(() => {
        this.$refs.dingdanDingdanxiangAdd.init(id, bianhao);
      });
    },

    //跳转到订单订单项查看页面
    dingdanxiangChakanHandler(id) {
      this.showFlag = false;
      this.dingdanDingdanxiangChakanFlag = true;
      this.$nextTick(() => {
        this.$refs.dingdanDingdanxiangChakan.init(id);
      });
    },


    //获取所有支付方式
    getZhifufangshiList() {
      this.$http({
        url: "zhifufangshi/all",
        method: "get",
        params: null
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.zhifufangshiOptions = data.data;
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
