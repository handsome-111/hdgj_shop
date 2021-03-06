// components/user/user.js
const app = getApp()
Component({
  /**
   * 组件的属性列表
   */
  properties: {

  },

  attached:function(){
    //console.log("attached:" + this.data.userInfo)
  },

  /**
   * 组件的初始数据
   */
  data: {
    userInfo:null,
    template:'unLoginUserInfo'      //是否登录模板
  },

  /**
   * 组件的方法列表
   */
  methods: {
    onLoad: function (options) {
      // 页面创建时执行
    },
    onReady:function(){
      
    },
    forwardGoodsOrderList :function(){
      var url = '/pages/goodsOrderList/goodsOrderList';
      app.filter({
        url:url
      })
    }
  },
  pageLifetimes: {
    show:function() {   
      // 页面创建时执行
      var userInfo = app.globalData.userInfo;
      //如果已登录
      if (userInfo != null) {
        this.setData({
          userInfo: userInfo,
          template: 'loginUserInfo'
        })
      }
      
      //如果未登录
      if(userInfo == null){
        this.setData({
          template:'unLoginUserInfo'
        })
      }
       

      if (typeof this.getTabBar === 'function' &&
        this.getTabBar()) {
        this.getTabBar().setData({
          selected: 3
        })  
      }
    }
  },  
 
})
