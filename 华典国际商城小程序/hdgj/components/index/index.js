// components/index/index.js
Component({
  pageLifetimes: {
    show() {
      console.log("awqqeq");
      if (typeof this.getTabBar === 'function' &&
        this.getTabBar()) {
        this.getTabBar().setData({
          selected: 0
        })
      }
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
    images: {
      url: 'http://img1.imgtn.bdimg.com/it/u=735014917,976731480&fm=26&gp=0.jpg',
    }
  },

  /**
   * 组件的方法列表
   */
  methods: {

  }
  
})
