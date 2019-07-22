// components/category/category.js
Component({
  pageLifetimes: {
    show() {
      if (typeof this.getTabBar === 'function' &&
        this.getTabBar()) {
        this.getTabBar().setData({
          selected: 1
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
    selected: 0,    /*已选的一级菜单索引*/
    topCategory : [
      {
        title: '国际品牌',
        secondCategory: [
          {
            title: '手机',
            thirdCategory: [
              {name: '小米C9'},
              {name: 'iphone8'}
              ]
          },
          {
            title: '电视',
            thirdCategory: [
              { name: '32-40英寸' },
              { name: '43英寸' }
            ]
          },
        ]
      },
      {
        title: '国内品牌',
        secondCategory: [
          {
            title: '电脑',
            thirdCategory: [
              { name: '大米C9' },
              { name: '华为' }
            ]
          },
          {
            title: '平板',
            thirdCategory: [
              { name: '32-40英寸' },
              { name: '43英寸' }
            ]
          },
        ]
      }
    ]
  },

  /**
   * 组件的方法列表
   */
  methods: {
    //切换分类
    changeCategory: function(event){
      var index = event.currentTarget.dataset.index;
      this.setData({
        selected:index
      })
    }
  }
})
