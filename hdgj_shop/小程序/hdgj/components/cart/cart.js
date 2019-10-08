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
    carts:null,
    number:1
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
          that.setData({
            carts:res.data.data
          })
        }
      })
    },
    /**
   * 自减
   */
    decrement: function (event) {
      var that = this
      var index = event.currentTarget.dataset.index
      var cart = this.data.carts[index]
     
      wx.request({
        url: app.globalData.serverHost + '/cart/decrementCart',
        data:{
          cart:cart
        },
        success:fucntion(res){
          that.setData({

          })
        }
      })
      var number = this.data.number;
      if (number <= 1) {
        return;
      }
      this.setData({
        number: --number
      })
    },
    /**
     *  自增
     */
    increment: function (event) {
      var number = this.data.number
      var stock = this.data.stock
      if (number >= stock) {
        this.setData({
          number: stock
        })
        return;
      }
      this.setData({
        number: ++number
      })
    },
  },
 
})
