// pages/userinfo/userinfo.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo:null,
    serverHost:'/images/index/default.jpg'
  },

  /**
   * 日期更换
   */
  bindDateChange:function (e){    
    this.data.userInfo.birthday = e.detail.value
    this.setData({
      userInfo: this.data.userInfo
    })
  },

  /**
   * 注销
   */
  logout:function (){
    wx.showModal({
      title: '切换账号',
      content: '确定退出登陆么？如果该账号已绑定此微信下次进去默认登陆该账号',
      confirmText:'退出登陆',
      confirmColor:'#DC143C',
      success:function(res){
        if (res.confirm) {
          console.log('用户点击确定')
        }
        
        if (res.cancel) {
          console.log('用户点击取消')
        }
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    //设置过滤器
    app.setFilter()
    
    this.setData({
      userInfo: app.globalData.userInfo,
      serverHost: app.globalData.serverHost
    })
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

  }
})