// pages/login/wxLogin/wxLogin.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    forwardUrl:null,
    forwardType:null
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options)
    this.setData({
      forwardUrl:options.url,
      forwardType:options.type
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
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function (options) {
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
  onGotUserInfo: function(e){
    var userInfo = e.detail.userInfo
    // 获取用户信息
    // console.log(e.detail.errMsg  + "1")
    // console.log(e.detail.userInfo + '2')
    // console.log(e.detail.rawData + '3')
    var promise = app.login(userInfo)
    var url = this.data.forwardUrl
    var forwardType = this.data.forwardType

    url = decodeURIComponent(url)

    if (forwardType == 1) {
      promise.then(() => {
        wx.switchTab({
          url: url
        })
      })
      return ;
    }

    if (forwardType == 2){
      promise.then(() => {
        wx.navigateTo({
          url: url,
        })
      })
      return ;
    }
    
    promise.then(() => {
      wx.switchTab({
        url: "/components/user/user"
      })
    })
    
  }  
})   