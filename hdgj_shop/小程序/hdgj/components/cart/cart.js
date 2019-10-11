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
    carts:null,           //全部购物车
    selectedCarts:[],    //选中的购物车
    checkAll:false
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
    /**
     * 删除购物车,包括删除单个和删除全部
     */
    removeCart:function(e){
      var that = this
      var id = e.currentTarget.dataset.id
      var ids = new Array(id)

      /**
       * 如果点击的是删除全部,而不是单个删除
       */
      if(id == null){
        var ids = this.data.selectedCarts
      }

      if(ids.length == 0){
        return 
      }
      wx.request({
        url: app.globalData.serverHost + '/cart/removeCart',
        data:{
          ids:JSON.stringify(ids)
        },
        success:function(res){
          var code = res.data.code
          var carts = that.data.carts
          var resIds = res.data.data    //返回删除的购物车id

          if(code == '0000'){
            /**
             * 迭代页面里的购物车列表
             */
            var iterator = carts.entries();

            for (var i = carts.length - 1; i >= 0; i--) {
              var cart = carts[i]
              var id = cart.id
              if (resIds.includes(id)) {
                var reObject = carts.splice(i,1)
              }
            }

            that.setData({
              carts:carts
            })
          }
        }
      })
    },



    /**
     * 切换选项
     */
    checkboxChange:function(e){
      console.log(e.detail.value)
      this.setData({
        selectedCarts:e.detail.value
      })
    },
    /**
     * 全选
     * 
     */
    checkAll:function(e){
      //checkAll = 1则已全选,反之0为取消全选
      var checkValue = e.detail.value.length

      //全选
      if (checkValue == 1){
        /**
         * 获取所有的购物车ids
         */
        var carts = this.data.carts
        var selectedCarts = []
        for(var i = 0; i < carts.length; i++){
          selectedCarts[i] = carts[i].id
        }

        //赋值所有为已选
        this.setData({
          checkAll: true,
          selectedCarts: selectedCarts
        })

        return 
      }

      //反全选
      if (checkValue == 0){
        this.setData({
          checkAll: false,
          selectedCarts:[]
        })

        return 
      }
      
    }
  },
 
})
