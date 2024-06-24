const menu = {
    list() {
        return [
            {
              "type": "0",
              "typename": "管理员",
              "backMenu": [
                {
                  "menu": "用户管理",
                  "child": [
                    {
                      "menu": "用户添加",
                      "routerName": "usersadd"
                    },
                    {
                      "menu": "用户列表",
                      "routerName": "usersmana"
                    },
                    {
                      "menu": "修改密码",
                      "routerName": "UpdatePassword"
                    },
                    {
                      "menu": "修改资料",
                      "routerName": "center"
                    }
                  ]
                },
                {
                  "menu": "轮播图管理",
                  "child": [
                    {
                      "menu": "轮播图添加",
                      "routerName": "lunboadd"
                    },
                    {
                      "menu": "轮播图列表",
                      "routerName": "lunbomana"
                    }
                  ]
                },
                {
                  "menu": "公告管理",
                  "child": [
                    {
                      "menu": "公告添加",
                      "routerName": "gonggaoadd"
                    },
                    {
                      "menu": "公告列表",
                      "routerName": "gonggaomana"
                    }
                  ]
                },
                {
                  "menu": "商品管理",
                  "child": [
                    {
                      "menu": "类别添加",
                      "routerName": "pinleiadd"
                    },
                    {
                      "menu": "类别查询",
                      "routerName": "pinleimana"
                    },
                    {
                      "menu": "商品添加",
                      "routerName": "shangpinadd"
                    },
                    {
                      "menu": "商品列表",
                      "routerName": "shangpinmana"
                    },
                    {
                      "menu": "收藏列表",
                      "routerName": "shoucangmana"
                    },
                    {
                      "menu": "评论列表",
                      "routerName": "pingjiamana"
                    }
                  ]
                },
                {
                  "menu": "订单管理",
                  "child": [
                    {
                      "menu": "订单列表",
                      "routerName": "dingdanmana"
                    }
                  ]
                },
                {
                  "menu": "付款方式管理",
                  "child": [
                    {
                      "menu": "付款方式添加",
                      "routerName": "zhifufangshiadd"
                    },
                    {
                      "menu": "付款方式列表",
                      "routerName": "zhifufangshimana"
                    }
                  ]
                },
                {
                  "menu": "新闻管理",
                  "child": [
                    {
                      "menu": "新闻添加",
                      "routerName": "xinwenadd"
                    },
                    {
                      "menu": "新闻列表",
                      "routerName": "xinwenmana"
                    }
                  ]
                },
                {
                  "menu": "售后管理",
                  "child": [
                   
                    {
                      "menu": "售后查询",
                      "routerName": "shenqingmana"
                    }
                  ]
                },
                {
                  "menu": "系统管理",
                  "child": [
                    {
                      "menu": "友情链接添加",
                      "routerName": "lianjieadd"
                    },
                    {
                      "menu": "友情链接列表",
                      "routerName": "lianjiemana"
                    },
                    {
                      "menu": "介绍添加",
                      "routerName": "dxadd"
                    },
                    {
                      "menu": "介绍列表",
                      "routerName": "dxmana"
                    },
                    {
                      "menu": "留言列表",
                      "routerName": "liuyanmana"
                    }
                  ]
                }
              ]
            },
            {
              "type": "2",
              "typename": "用户",
              "backMenu": [
                {
                  "menu": "用户管理",
                  "child": [
                    {
                      "menu": "修改密码",
                      "routerName": "UpdatePassword"
                    },
                    {
                      "menu": "修改资料",
                      "routerName": "center"
                    }
                  ]
                },
                {
                  "menu": "商品管理",
                  "child": [
                    {
                      "menu": "查看我的收藏",
                      "routerName": "shoucangchakanmy"
                    },
                    {
                      "menu": "查看我的评论",
                      "routerName": "pingjiachakanmy"
                    }
                  ]
                },
                {
                  "menu": "订单管理",
                  "child": [
                    {
                      "menu": "查看我的订单",
                      "routerName": "dingdanchakanmy"
                    }
                  ]
                },
                {
                  "menu": "售后管理",
                  "child": [
                    {
                      "menu": "售后添加",
                      "routerName": "shenqingadd"
                    },
                    {
                      "menu": "我的售后查询",
                      "routerName": "shenqingchakanmy"
                    }
                  ]
                },
                {
                  "menu": "系统管理",
                  "child": [
                    {
                      "menu": "我的留言查询",
                      "routerName": "liuyanchakanmy"
                    }
                  ]
                }
              ]
            }
          ]
    }
}
export default menu;
