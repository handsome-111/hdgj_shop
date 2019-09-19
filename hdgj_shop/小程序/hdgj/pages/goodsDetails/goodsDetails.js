// pages/goodsDetails/goodsDetails.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    itemId:null,
    userInfo:null,
    goods:'',
    // goods:{
    //   images:[
    //     { src:'/images/index/1.jpg',url:'', id: 1 },
    //     { src: '/images/index/1.jpg', url:'', id: 2 },
    //   ]
    // },
    //是否弹窗
    alerts:'',
    //弹出层模板名称
    alertsTemplateName:'',
    selectedTitle:1,
    selected:100,
    number:1,    //购买的商品数量
    stock:10,    //商品库存
    loginBuy:'',
    currentPrice:'' //当前筛选sku的价格
  },


  /**
   * 生命周期函数--监听页面加载
   * 传递的参数:/pages/goodsDetails?itemid=1234679
   */
  onLoad: function (options) {
    var that = this
    var loginBuy = 'login'

    if(app.globalData.userInfo == null){
      loginBuy = 'unLogin'
    }

    wx.request({
      url: app.globalData.serverHost + '/product/' + options.itemId,
      success: function (res) {
        var goods = res.data.data
        that.setData({
          goods:goods,
          stock: goods.stock,
          loginBuy:loginBuy,
          currentPrice: goods.lowPrice,
          itemId: options.itemId,
          userInfo:app.globalData.userInfo
        })
       // that.data.goods = goods
        console.log(that.data.goods)
      }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function (option,itemId) {
    
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  /*切换商品规格选项*/ 
  switchGoodsSpec: function () {
    this.setData({
      alerts: 'spec',
      alertsTemplateName:'spec'
    })
  },
  /*切换到配送选项 */
  switchSkippingAddress: function(){
    this.setData({
      alerts: 'shipping-address',
      alertsTemplateName: 'shipping-address'
    })
  },
  //关闭弹出层 
  closeAlters: function(){
    this.setData({
      alerts: 'null'
    })
  },
  /**
   * 选择指定规格
   */
  selectedTitle:function(event){
    this.setData({
      selectedTitle:event.target.dataset.index,
      selected: event.target.dataset.index,
      currentPrice: event.target.dataset.price
    })

  },

  decrement:function(){
    var number = this.data.number;
    if(number <= 1){
      return ;
    }
    this.setData({
      number:--number
    })
  },

  increment:function(){
    var number = this.data.number
    var stock = this.data.stock
    if (number >= stock) {
      this.setData({
        number:stock
      })
      return;
    }
    this.setData({
      number: ++number
    })
  },
  /**
   * 登录购买
   */
  goLogin:function(){
    var returnPath = '/' + this.route
    returnPath = returnPath + '?itemId=' + this.data.itemId
    returnPath = encodeURIComponent(returnPath)
    
    var url = '/pages/login/wxLogin/wxLogin?url=' + returnPath + '&type=2'
    
    wx.navigateTo({
      url: url
    })
  }
})