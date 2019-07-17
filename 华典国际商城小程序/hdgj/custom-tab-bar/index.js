// components/nav-bottom.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {

  },
  /**
   * 组件的初始数据
   */ 
  data: {
    list: [
      { switchUrl: '/components/index/index', title: '首页', iconStyle: 'icon-shouye' },
      { switchUrl: '/components/category/category', title: '分类', iconStyle: 'icon-icon' },
      { switchUrl: '/components/cart/cart', title: '购物车', iconStyle: 'icon-gouwuche'},
      { switchUrl: '/components/user/user', title: '我的', iconStyle: 'icon-wode'},
    ],
    selected: 0
  },
  /**
   * 组件的方法列表
   */
  methods: {
    switchTab: function (event) {
      var data = event.currentTarget.dataset;
      var url = data.url;
      wx.switchTab({ url });
    }
  }
})
