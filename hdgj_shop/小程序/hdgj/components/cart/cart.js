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
    selectedCarts:null    //选中的购物车
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
      cart.number = cart.number - 1

      if (cart.number <= 0) {
        return
      }

      wx.request({
        url: app.globalData.serverHost + '/cart/updateCart',
        data:{
          cart:JSON.stringify(cart)
        },
        success:function(res){
          var key = 'carts[' + index + ']'
          var resCart = res.data.data
          that.setData({
            [key]: resCart
          })
        }
      })
      
    },
    /**
     *  自增
     */
    increment: function (event) {
      var that = this
      var index = event.currentTarget.dataset.index
      var cart = this.data.carts[index]
      cart.number = cart.number + 1

      var stock = cart.product.buyStock

      if (cart.number > stock) {
        return
      } 

      wx.request({
        url: app.globalData.serverHost + '/cart/updateCart',
        data: {
          cart: JSON.stringify(cart)
        },
        success: function (res) {
          var key = 'carts[' + index + ']'
          var resCart = res.data.data
          that.setData({
            [key]: resCart
          })
        }
      })
    },
    removeCart:function(){
      console.log(111)
      var ids = this.data.selectedCarts
      if(ids == null){
        return 
      }
      wx.request({
        url: app.globalData.serverHost + '/cart/removeCart',
        data:{
          ids:JSON.stringify(ids)
        },
        success:function(res){
          console.log("成功")
        }
      })
    },
    checkboxChange:function(e){
      this.setData({
        selectedCarts:e.detail.value
      })
    }
  },
 
})
