<template>
  <div class="main-content">
    <div v-if="showFlag">
      <!--搜索表单区域-->
      <el-form :inline="true" :model="searchForm" class="form-content">
        <el-row :gutter="20" class="slt" style="justify-content:flex-start;">
          <el-form-item>
            <el-input suffix-icon="el-icon-search" v-model="searchForm.loginname" placeholder="用户名称" clearable></el-input>
          </el-form-item>
          <el-form-item>
            <el-input suffix-icon="el-icon-search" v-model="searchForm.type" placeholder="类型" clearable></el-input>
          </el-form-item>
          <el-form-item>
            <el-input suffix-icon="el-icon-search" v-model="searchForm.typename" placeholder="类型名称" clearable></el-input>
          </el-form-item>
          <el-form-item>
            <el-input suffix-icon="el-icon-search" v-model="searchForm.xingming" placeholder="姓名" clearable></el-input>
          </el-form-item>
          <el-form-item>
            <el-select v-model="searchForm.xingbie" placeholder="请选择性别">
              <el-option label="全部" value=""></el-option>
              <el-option v-for="(item, index) in xingbieOptions" v-bind:key="item" :label="item" :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-input suffix-icon="el-icon-search" v-model="searchForm.nianling" placeholder="年龄" clearable></el-input>
          </el-form-item>
          <el-form-item>
            <el-input suffix-icon="el-icon-search" v-model="searchForm.address" placeholder="地址" clearable></el-input>
          </el-form-item>
          <el-form-item>
            <el-input suffix-icon="el-icon-search" v-model="searchForm.dianhua" placeholder="电话" clearable></el-input>
          </el-form-item>
          <el-form-item>
            <el-select v-model="searchForm.shenhe" placeholder="请选择审核">
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
              @click="usersDeleteHandler()">批量删除</el-button>
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
          <el-table-column :align="contents.tableAlign" header-align="center" label="用户名称">
            <template slot-scope="scope">
              {{ scope.row.loginname }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="密码">
            <template slot-scope="scope">
              {{ scope.row.loginpw }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="类型">
            <template slot-scope="scope">
              {{ scope.row.type }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="类型名称">
            <template slot-scope="scope">
              {{ scope.row.typename }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="姓名">
            <template slot-scope="scope">
              {{ scope.row.xingming }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="性别">
            <template slot-scope="scope">
              {{ scope.row.xingbie }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="年龄">
            <template slot-scope="scope">
              {{ scope.row.nianling }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="地址">
            <template slot-scope="scope">
              {{ scope.row.address }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="电话">
            <template slot-scope="scope">
              {{ scope.row.dianhua }}
            </template>
          </el-table-column>
          <el-table-column :align="contents.tableAlign" header-align="center" label="审核">
            <template slot-scope="scope">
              {{ scope.row.shenhe }}
            </template>
          </el-table-column>

          <el-table-column width="350" :align="contents.tableAlign" header-align="center" label="操作" fixed="right">
            <template slot-scope="scope">
              <!-- <el-button type="primary" icon="el-icon-edit-outline" size="mini" @click="usersSet(scope.row.id,scope.row.shenhe == 'no' ? '审核' : '取消审核','shenhe',scope.row.shenhe == 'no' ? 'yes' : 'no')">{{scope.row.shenhe == 'no' ? '审核' : '取消审核' }}</el-button> -->


              <el-button type="success" icon="el-icon-info" size="mini" @click="usersDetailHandler(scope.row.id)">详情</el-button>
              <!-- <el-button type="primary" icon="el-icon-edit" size="mini" @click="usersSetHandler(scope.row.id)">修改</el-button> -->
              <!-- <el-button type="danger" icon="el-icon-delete" size="mini" @click="usersDeleteHandler(scope.row.id)">删除</el-button> -->
              <!-- <el-button type="success" icon="el-icon-tickets" size="mini" @click="dingdanChakanHandler(scope.row.id)">订单查看</el-button> -->
              <!-- <el-button type="success" icon="el-icon-circle-plus" size="mini" @click="dingdanAddHandler(scope.row.id, scope.row.loginname)">订单添加</el-button> -->
              <!-- <el-button type="success" icon="el-icon-tickets" size="mini" @click="dingdanxiangChakanHandler(scope.row.id)">订单项查看</el-button> -->
              <!-- <el-button type="success" icon="el-icon-circle-plus" size="mini" @click="dingdanxiangAddHandler(scope.row.id, scope.row.loginname)">订单项添加</el-button> -->
              <!-- <el-button type="success" icon="el-icon-tickets" size="mini" @click="gouwucheChakanHandler(scope.row.id)">购物车查看</el-button> -->
              <!-- <el-button type="success" icon="el-icon-circle-plus" size="mini" @click="gouwucheAddHandler(scope.row.id, scope.row.loginname)">购物车添加</el-button> -->
              <!-- <el-button type="success" icon="el-icon-tickets" size="mini" @click="liuyanChakanHandler(scope.row.id)">留言反馈查看</el-button> -->
              <!-- <el-button type="success" icon="el-icon-circle-plus" size="mini" @click="liuyanAddHandler(scope.row.id, scope.row.loginname)">留言反馈添加</el-button> -->
              <!-- <el-button type="success" icon="el-icon-tickets" size="mini" @click="pingjiaChakanHandler(scope.row.id)">评论查看</el-button> -->
              <!-- <el-button type="success" icon="el-icon-circle-plus" size="mini" @click="pingjiaAddHandler(scope.row.id, scope.row.loginname)">评论添加</el-button> -->
              <!-- <el-button type="success" icon="el-icon-tickets" size="mini" @click="shenqingChakanHandler(scope.row.id)">售后申请查看</el-button> -->
              <!-- <el-button type="success" icon="el-icon-circle-plus" size="mini" @click="shenqingAddHandler(scope.row.id, scope.row.loginname)">售后申请添加</el-button> -->
              <!-- <el-button type="success" icon="el-icon-tickets" size="mini" @click="shoucangChakanHandler(scope.row.id)">收藏查看</el-button> -->
              <!-- <el-button type="success" icon="el-icon-circle-plus" size="mini" @click="shoucangAddHandler(scope.row.id, scope.row.loginname)">收藏添加</el-button> -->

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
    <!-- 用户修改-->
    <users-set v-if="usersSetFlag" :parent="this" ref="usersSet"></users-set>
    <!-- 用户详情-->
    <users-detail v-if="usersDetailFlag" :parent="this" ref="usersDetail"></users-detail>
    <!-- 用户订单查看-->
    <users-dingdan-chakan v-if="usersDingdanChakanFlag" :parent="this" ref="usersDingdanChakan"></users-dingdan-chakan>
    <!-- 用户订单添加-->
    <users-dingdan-add v-if="usersDingdanAddFlag" :parent="this" ref="usersDingdanAdd"></users-dingdan-add>
    <!-- 用户订单项查看-->
    <users-dingdanxiang-chakan v-if="usersDingdanxiangChakanFlag" :parent="this" ref="usersDingdanxiangChakan"></users-dingdanxiang-chakan>
    <!-- 用户订单项添加-->
    <users-dingdanxiang-add v-if="usersDingdanxiangAddFlag" :parent="this" ref="usersDingdanxiangAdd"></users-dingdanxiang-add>
    <!-- 用户购物车查看-->
    <users-gouwuche-chakan v-if="usersGouwucheChakanFlag" :parent="this" ref="usersGouwucheChakan"></users-gouwuche-chakan>
    <!-- 用户购物车添加-->
    <users-gouwuche-add v-if="usersGouwucheAddFlag" :parent="this" ref="usersGouwucheAdd"></users-gouwuche-add>
    <!-- 用户留言反馈查看-->
    <users-liuyan-chakan v-if="usersLiuyanChakanFlag" :parent="this" ref="usersLiuyanChakan"></users-liuyan-chakan>
    <!-- 用户留言反馈添加-->
    <users-liuyan-add v-if="usersLiuyanAddFlag" :parent="this" ref="usersLiuyanAdd"></users-liuyan-add>
    <!-- 用户评论查看-->
    <users-pingjia-chakan v-if="usersPingjiaChakanFlag" :parent="this" ref="usersPingjiaChakan"></users-pingjia-chakan>
    <!-- 用户评论添加-->
    <users-pingjia-add v-if="usersPingjiaAddFlag" :parent="this" ref="usersPingjiaAdd"></users-pingjia-add>
    <!-- 用户售后申请查看-->
    <users-shenqing-chakan v-if="usersShenqingChakanFlag" :parent="this" ref="usersShenqingChakan"></users-shenqing-chakan>
    <!-- 用户售后申请添加-->
    <users-shenqing-add v-if="usersShenqingAddFlag" :parent="this" ref="usersShenqingAdd"></users-shenqing-add>
    <!-- 用户收藏查看-->
    <users-shoucang-chakan v-if="usersShoucangChakanFlag" :parent="this" ref="usersShoucangChakan"></users-shoucang-chakan>
    <!-- 用户收藏添加-->
    <users-shoucang-add v-if="usersShoucangAddFlag" :parent="this" ref="usersShoucangAdd"></users-shoucang-add>

  </div>
</template>
<script>
import UsersSet from "./users-set"
import UsersDetail from "./users-detail"
import UsersDingdanChakan from './users-dingdan-chakan'
import UsersDingdanAdd from './users-dingdan-add'
import UsersDingdanxiangChakan from './users-dingdanxiang-chakan'
import UsersDingdanxiangAdd from './users-dingdanxiang-add'
import UsersGouwucheChakan from './users-gouwuche-chakan'
import UsersGouwucheAdd from './users-gouwuche-add'
import UsersLiuyanChakan from './users-liuyan-chakan'
import UsersLiuyanAdd from './users-liuyan-add'
import UsersPingjiaChakan from './users-pingjia-chakan'
import UsersPingjiaAdd from './users-pingjia-add'
import UsersShenqingChakan from './users-shenqing-chakan'
import UsersShenqingAdd from './users-shenqing-add'
import UsersShoucangChakan from './users-shoucang-chakan'
import UsersShoucangAdd from './users-shoucang-add'

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
      usersSetFlag: false,
      usersDetailFlag: false,
      usersDingdanChakanFlag: false,
      usersDingdanAddFlag: false,
      usersDingdanxiangChakanFlag: false,
      usersDingdanxiangAddFlag: false,
      usersGouwucheChakanFlag: false,
      usersGouwucheAddFlag: false,
      usersLiuyanChakanFlag: false,
      usersLiuyanAddFlag: false,
      usersPingjiaChakanFlag: false,
      usersPingjiaAddFlag: false,
      usersShenqingChakanFlag: false,
      usersShenqingAddFlag: false,
      usersShoucangChakanFlag: false,
      usersShoucangAddFlag: false,

      contents: { "searchBtnFontColor": "#333", "pagePosition": "2", "inputFontSize": "14px", "inputBorderRadius": "4px", "tableBtnDelFontColor": "rgba(249, 104, 104, 1)", "tableBtnIconPosition": "1", "searchBtnHeight": "40px", "inputIconColor": "#C0C4CC", "searchBtnBorderRadius": "4px", "tableStripe": true, "btnAdAllWarnFontColor": "rgba(252, 197, 37, 1)", "tableBtnDelBgColor": "#fff", "searchBtnIcon": "1", "tableSize": "medium", "searchBtnBorderStyle": "solid", "tableSelection": false, "searchBtnBorderWidth": "1px", "tableContentFontSize": "14px", "searchBtnBgColor": "rgba(228, 231, 234, 1)", "inputTitleSize": "14px", "btnAdAllBorderColor": "rgba(144, 238, 144, 1)", "pageJumper": true, "btnAdAllIconPosition": "1", "searchBoxPosition": "1", "tableBtnDetailFontColor": "rgba(87, 199, 212, 1)", "tableBtnHeight": "40px", "pagePager": true, "searchBtnBorderColor": "#DCDFE6", "tableHeaderFontColor": "rgba(255, 255, 255, 1)", "inputTitle": "1", "tableBtnBorderRadius": "4px", "btnAdAllFont": "1", "btnAdAllDelFontColor": "rgba(249, 104, 104, 1)", "tableBtnIcon": "0", "btnAdAllHeight": "40px", "btnAdAllWarnBgColor": "#fff", "btnAdAllBorderWidth": "1px", "tableStripeFontColor": "#606266", "tableBtnBorderStyle": "solid", "inputHeight": "40px", "btnAdAllBorderRadius": "4px", "btnAdAllDelBgColor": "#fff", "pagePrevNext": true, "btnAdAllAddBgColor": "#fff", "searchBtnFont": "1", "tableIndex": true, "btnAdAllIcon": "1", "tableSortable": false, "pageSizes": true, "tableFit": true, "pageBtnBG": true, "searchBtnFontSize": "14px", "tableBtnEditBgColor": "#fff", "inputBorderWidth": "1px", "inputFontPosition": "1", "inputFontColor": "#333", "pageEachNum": 8, "tableHeaderBgColor": "rgba(144, 238, 144, 1)", "inputTitleColor": "#333", "btnAdAllBoxPosition": "1", "tableBtnDetailBgColor": "#fff", "inputIcon": "0", "searchBtnIconPosition": "1", "btnAdAllFontSize": "14px", "inputBorderStyle": "solid", "inputBgColor": "#fff", "pageStyle": false, "pageTotal": true, "btnAdAllAddFontColor": "rgba(51, 202, 187, 1)", "tableBtnFont": "1", "tableContentFontColor": "rgba(72, 72, 72, 1)", "inputBorderColor": "rgba(223, 230, 236, 1)", "tableShowHeader": true, "tableBtnFontSize": "14px", "tableBtnBorderColor": "rgba(144, 238, 144, 1)", "inputIconPosition": "1", "tableBorder": true, "btnAdAllBorderStyle": "solid", "tableBtnBorderWidth": "1px", "tableStripeBgColor": "rgba(252, 253, 254, 1)", "tableBtnEditFontColor": "rgba(249, 97, 151, 1)", "tableAlign": "center" },
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
    UsersSet,
    UsersDetail,
    UsersDingdanChakan,
    UsersDingdanAdd,
    UsersDingdanxiangChakan,
    UsersDingdanxiangAdd,
    UsersGouwucheChakan,
    UsersGouwucheAdd,
    UsersLiuyanChakan,
    UsersLiuyanAdd,
    UsersPingjiaChakan,
    UsersPingjiaAdd,
    UsersShenqingChakan,
    UsersShenqingAdd,
    UsersShoucangChakan,
    UsersShoucangAdd,

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

    // 获取用户分页数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        pageNo: this.pageIndex, //页码
        pageSize: this.pageSize, //页大小
        sortProperty: 'id',      //排序列
      }
      //搜索表单数据组装
      if (this.searchForm.loginname != '' && this.searchForm.loginname != undefined) {
        params['loginname'] = this.searchForm.loginname
      }
      if (this.searchForm.type != '' && this.searchForm.type != undefined) {
        params['type'] = this.searchForm.type
      }
      if (this.searchForm.typename != '' && this.searchForm.typename != undefined) {
        params['typename'] = this.searchForm.typename
      }
      if (this.searchForm.xingming != '' && this.searchForm.xingming != undefined) {
        params['xingming'] = this.searchForm.xingming
      }
      if (this.searchForm.xingbie != '' && this.searchForm.xingbie != undefined) {
        params['xingbie'] = this.searchForm.xingbie
      }
      if (this.searchForm.nianling != '' && this.searchForm.nianling != undefined) {
        params['nianling'] = this.searchForm.nianling
      }
      if (this.searchForm.address != '' && this.searchForm.address != undefined) {
        params['address'] = this.searchForm.address
      }
      if (this.searchForm.dianhua != '' && this.searchForm.dianhua != undefined) {
        params['dianhua'] = this.searchForm.dianhua
      }
      if (this.searchForm.shenhe != '' && this.searchForm.shenhe != undefined) {
        params['shenhe'] = this.searchForm.shenhe
      }

      this.$http({
        url: "users/chakan",
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

    // 删除或批量删除用户方法
    usersDeleteHandler(id) {
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
          url: "users/delete",
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

    //跳转到用户详情页面
    usersDetailHandler(id) {
      this.showFlag = false;
      this.usersDetailFlag = true;
      this.$nextTick(() => {
        this.$refs.usersDetail.init(id);
      });

    },

    //跳转到用户修改页面
    usersSetHandler(id) {
      this.showFlag = false;
      this.usersSetFlag = true;
      this.$nextTick(() => {
        this.$refs.usersSet.init(id);
      });
    },

    //更新用户信息操作方法
    usersSet(tid,tname,property,value) {
      let params = {};
      params['id'] = tid;
      params[property] = value;

      this.$confirm(`确定'${tname}'操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: `users/set`,
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


    //跳转到用户订单添加页面
    dingdanAddHandler(id, loginname) {
      this.showFlag = false;
      this.usersDingdanAddFlag = true;
      this.$nextTick(() => {
        this.$refs.usersDingdanAdd.init(id, loginname);
      });
    },

    //跳转到用户订单查看页面
    dingdanChakanHandler(id) {
      this.showFlag = false;
      this.usersDingdanChakanFlag = true;
      this.$nextTick(() => {
        this.$refs.usersDingdanChakan.init(id);
      });
    },
    //跳转到用户订单项添加页面
    dingdanxiangAddHandler(id, loginname) {
      this.showFlag = false;
      this.usersDingdanxiangAddFlag = true;
      this.$nextTick(() => {
        this.$refs.usersDingdanxiangAdd.init(id, loginname);
      });
    },

    //跳转到用户订单项查看页面
    dingdanxiangChakanHandler(id) {
      this.showFlag = false;
      this.usersDingdanxiangChakanFlag = true;
      this.$nextTick(() => {
        this.$refs.usersDingdanxiangChakan.init(id);
      });
    },
    //跳转到用户购物车添加页面
    gouwucheAddHandler(id, loginname) {
      this.showFlag = false;
      this.usersGouwucheAddFlag = true;
      this.$nextTick(() => {
        this.$refs.usersGouwucheAdd.init(id, loginname);
      });
    },

    //跳转到用户购物车查看页面
    gouwucheChakanHandler(id) {
      this.showFlag = false;
      this.usersGouwucheChakanFlag = true;
      this.$nextTick(() => {
        this.$refs.usersGouwucheChakan.init(id);
      });
    },
    //跳转到用户留言反馈添加页面
    liuyanAddHandler(id, loginname) {
      this.showFlag = false;
      this.usersLiuyanAddFlag = true;
      this.$nextTick(() => {
        this.$refs.usersLiuyanAdd.init(id, loginname);
      });
    },

    //跳转到用户留言反馈查看页面
    liuyanChakanHandler(id) {
      this.showFlag = false;
      this.usersLiuyanChakanFlag = true;
      this.$nextTick(() => {
        this.$refs.usersLiuyanChakan.init(id);
      });
    },
    //跳转到用户评论添加页面
    pingjiaAddHandler(id, loginname) {
      this.showFlag = false;
      this.usersPingjiaAddFlag = true;
      this.$nextTick(() => {
        this.$refs.usersPingjiaAdd.init(id, loginname);
      });
    },

    //跳转到用户评论查看页面
    pingjiaChakanHandler(id) {
      this.showFlag = false;
      this.usersPingjiaChakanFlag = true;
      this.$nextTick(() => {
        this.$refs.usersPingjiaChakan.init(id);
      });
    },
    //跳转到用户售后申请添加页面
    shenqingAddHandler(id, loginname) {
      this.showFlag = false;
      this.usersShenqingAddFlag = true;
      this.$nextTick(() => {
        this.$refs.usersShenqingAdd.init(id, loginname);
      });
    },

    //跳转到用户售后申请查看页面
    shenqingChakanHandler(id) {
      this.showFlag = false;
      this.usersShenqingChakanFlag = true;
      this.$nextTick(() => {
        this.$refs.usersShenqingChakan.init(id);
      });
    },
    //跳转到用户收藏添加页面
    shoucangAddHandler(id, loginname) {
      this.showFlag = false;
      this.usersShoucangAddFlag = true;
      this.$nextTick(() => {
        this.$refs.usersShoucangAdd.init(id, loginname);
      });
    },

    //跳转到用户收藏查看页面
    shoucangChakanHandler(id) {
      this.showFlag = false;
      this.usersShoucangChakanFlag = true;
      this.$nextTick(() => {
        this.$refs.usersShoucangChakan.init(id);
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
