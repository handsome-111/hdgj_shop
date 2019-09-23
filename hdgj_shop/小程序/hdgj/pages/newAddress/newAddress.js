// pages/newAddress/newAddress.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    address:null,
    checked:2,
    region: ['广东省', '广州市', '海珠区'],
    customItem: '其他'
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
  /**
   * 删除
   */
  deleteAddress:function(){
    wx.request({
      url: '',
    })
  },

  bindRegionChange:function(e){
    var region = e.detail.value
    this.setData({
      region:region
    })
  },

  /**
   * 表单提交
   */
  formSubmit:function(e){
    console.log(e.detail.value.region)
    console.log(this.formatToAddress(e.detail.value))
    console.log(this.data.address)
  },
  /**
   * 格式化
   */
  formatToAddress:function(object){
    var region = object.region
    if(object == null){
      return null
    }
    console.log(region + "," +region[0] + "," + region.length)
    var address = {
      name: object.name,
      phone: object.phone,
      post: object.post,
      province: region[0],   //省
      city: region[1],       //城市
      region: region[2],     //区
      isDefault : object.isDefault.length == 0 ? 2 : 1    //是否为默认地址
    }
    return address
  },

  aaa:function(e){
    console.log(e.detail + ","  +e.target)
  } 
})