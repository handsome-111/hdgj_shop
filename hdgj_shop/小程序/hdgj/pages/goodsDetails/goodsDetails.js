// pages/goodsDetails/goodsDetails.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    goods:'',
    // goods:{
    //   images:[
    //     { src:'/images/index/1.jpg',url:'', id: 1 },
    //     { src: '/images/index/1.jpg', url:'', id: 2 },
    //   ]
    // },
    //商品规格
    goodsSpec:[
      {
        specNname:'规格',
        values: ['X', 'M', 'L', 'XL', 'XXL', 'X', 'M', 'L', 'XL', 'XXL']
      },
      {
        specNname: '规格',
        values: ['X', 'M', 'L', 'XL', 'XXL', 'X', 'M', 'L', 'XL', 'XXL']
      },
      {
        specNname: '规格',
        values: ['X', 'M', 'L', 'XL', 'XXL', 'X', 'M', 'L', 'XL', 'XXL']
      }
    ],
    //是否弹窗
    alerts:'',
    //弹出层模板名称
    alertsTemplateName:'',
    selectedTitle:10
  },


  /**
   * 生命周期函数--监听页面加载
   * 传递的参数:/pages/goodsDetails?itemid=1234679
   */
  onLoad: function (options) {
    var that = this
    wx.request({
      url: app.globalData.serverHost + '/product/' + options.itemId,
      success: function (res) {
        var goods = res.data.data
        console.log(that)
        that.setData({
          goods:goods
        })
       // that.data.goods = goods
        console.log(that.data)
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
      alerts: 'alerts',
      alertsTemplateName:'spec'
    })
  },
  /*切换到配送选项 */
  switchSkippingAddress: function(){
    this.setData({
      alerts: 'alerts',
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
  selectedTitle:function(index){
    console.log("当前选择的是第" + index)
    this.setData({
      selectedTitle:index
    })
  }
})