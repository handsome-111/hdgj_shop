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
    userInfo:'',
  },

  /**
   * 组件的方法列表
   */
  methods: {
    aa:function(){
      console.log(app.globalData.userInfo)
    },
    onLoad: function (options) {
      // 页面创建时执行
      var userInfo = app.globalData.userInfo;
      this.setData({
        userInfo: userInfo
      })
      console.log('userInfo:' + userInfo + ',' + this.data.userInfo)

    },
  },
  pageLifetimes: {
    show:function() {     
      if (typeof this.getTabBar === 'function' &&
        this.getTabBar()) {
        this.getTabBar().setData({
          selected: 3
        })
      }
    }
  },

})
