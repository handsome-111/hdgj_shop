// components/cart/cart.js
var app = getApp()
Component({
  pageLifetimes: {
    show() {
      if (typeof this.getTabBar === 'function' &&
        this.getTabBar()) {
        this.getTabBar().setData({
          selected: 2
        })
      }

      this.onload()

    }
  },
  /**
   * 组件的属性列表
   */
  properties: {

  },

  /**
   * 组件的初始数据
   */
  data: {
    carts:[
      {id:12123123},{id:4111131}
    ],
    aa:[1,2]
  },

  /**
   * 组件的方法列表
   */
  methods: {
    onload:function(){
      var that = this

      wx.request({
        url: app.globalData.serverHost + '/cart/getCarts',
        data:{
          userid: app.globalData.userInfo.id
        },
        success:function(res){
          console.log(res.data.data)
          // that.setData({
          //   carts:res.data.data
          // })
        }
      })
    }
  },
 
})
