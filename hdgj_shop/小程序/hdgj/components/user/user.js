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
    userInfo:null
  },

  /**
   * 组件的方法列表
   */
  methods: {
    onLoad: function (options) {
      // 页面创建时执行
    },
    onReady:function(){
      // 页面创建时执行
      var userInfo = app.globalData.userInfo;
      this.setData({
        userInfo: userInfo
      })    
      console.log('准备好了' + userInfo)
    }
  },
  pageLifetimes: {
    show:function() {   
      // 页面创建时执行
      // var userInfo = app.globalData.userInfo;
      // this.setData({
      //   userInfo: userInfo
      // })       

      if (typeof this.getTabBar === 'function' &&
        this.getTabBar()) {
        this.getTabBar().setData({
          selected: 3
        })
      }
    }
  },

})
