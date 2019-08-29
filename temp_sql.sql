create table customer(
 	id 						int(20) 		unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
  	password_reset_token 		varchar(60) 	DEFAULT NULL COMMENT '密码token',
  	email 					varchar(60) 		DEFAULT NULL COMMENT '邮箱',
  	name 						varchar(100) 	DEFAULT NULL,
  	is_subscribed 			int(5) 				NOT NULL DEFAULT '2' COMMENT '1代表订阅，2代表不订阅邮件',
  	auth_key 					varchar(60) 	DEFAULT NULL,
  	status 					int(5) 				DEFAULT NULL COMMENT '状态',
  	created_at 				int(18) 			DEFAULT NULL COMMENT '创建时间',
  	updated_at 				int(18) 			DEFAULT NULL COMMENT '更新时间',
  	password 					varchar(50) 	DEFAULT NULL COMMENT '密码',
  	birth_date 				datetime 			DEFAULT NULL COMMENT '出生日期',
  	favorite_product_count 	int(15) 			NOT NULL DEFAULT '0' COMMENT '用户收藏的产品的总数',
  	type 						varchar(35) 	DEFAULT 'default' COMMENT '默认为default，如果是第三方登录，譬如google账号登录注册，那么这里的值为google',
  	access_token_created_at 	int(20) 		DEFAULT NULL COMMENT '创建token的时间',
  	allowance 				int(20) 			DEFAULT NULL COMMENT '限制次数访问',
  	allowance_updated_at 		int(20) 		DEFAULT NULL,
  	phone						varchar(20) 	COMMENT '手机号',
  	wxoppen_id				varchar(100) 		COMMENT '微信的oppenid'
)COMMENT '用户表';

customer删除的字段:
	  	password_hash 			varchar(80) 		DEFAULT NULL COMMENT '密码',


create table customer_address (
 	  address_id 			int(15) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	  email				varchar(155) DEFAULT NULL COMMENT '邮箱地址',
	  name 				varchar(150) DEFAULT NULL COMMENT '姓名',
	  company 			varchar(255) DEFAULT NULL COMMENT '公司',
	  phone 				varchar(100) DEFAULT NULL COMMENT '电话',
	  fax 				varchar(150) DEFAULT NULL COMMENT '传真',
	  street1 			text COMMENT '街道地址1',
	  street2 			varchar(255) DEFAULT NULL COMMENT '街道地址2',
	  city 				varchar(150) DEFAULT NULL COMMENT '城市',
	  province 			varchar(50)  DEFAULT NULL COMMENT '省/州',
	  post 				varchar(50)  DEFAULT NULL COMMENT '邮编',
	  region     			varchar(50)	 DEFAULT NULL COMMENT '收货人所在区',
	  country 			varchar(50)  DEFAULT NULL COMMENT '国家',
	  customer_id 		int(20) DEFAULT NULL COMMENT '用户的id',
	  created_at 			int(20) DEFAULT NULL COMMENT '创建时间戳',
	  updated_at 			int(20) DEFAULT NULL COMMENT '更新时间戳',
	  is_default 			int(11) NOT NULL DEFAULT '2' COMMENT '1代表是默认地址，2代表不是',
	  idCardNo			varchar(50) COMMENT '身份证号'
)comment '用户地址表';

create table role(
	id 						int 	not null AUTO_INCREMENT PRIMARY KEY,
	rolename  			varchar(30)   NOT NULL COMMENT '权限名称'
) comment '权限表';

CREATE TABLE order(	
		buyer_id 				varchar(100) 			买家ID
		name 					varchar (50)			买家姓名
		phone 					varchar(20) 			收货人电话
		address 				varchar(200) 			收货地址
		province 				varchar(20) 			收货人所在省
		city 					varchar(20)  			收货人所在市
		region 					varchar(20)  			收货人所在区
		post 					varchar(20)  			邮政编码
		self_address 			varchar(200)  			收货人的街道
		idCardNo 				varchar(50)  			身份证号

		order_id 				varchar(200) 			订单ID
 		seller_id				varchar(100) 			卖家id
 		f_phone					varchar(20) 			分销商手机号
		is_close				int 				订单是否可关闭	0（表示不可关闭）1（表示货到付款订单，可关闭）
		return_code				varchar(100)  			退货单号
		status_ori 				varchar(20)  			订单状态
 		add_time				datetime 			下单时间
 		updated_time 			datetime 			更新时间
 		express_fee_num			String 				运费，和express_fee相同
 		user_phone				String 			买家手机号
 		price 					String 			商品总价格，不包含运费
 		note 					String 			买家备注
 		seller_phone			String 			卖家手机号
		total_fee				String 			分成推广佣金
		seller_name 			String 			卖家微店名称
		order_type_des 			String 			订单类型描述
		argue_flag	   			NUMBER 			是否投诉
		f_shop_name 			STRING 			分销商店铺名称
		modify_price_enable		STRING 			是否可以改价0（表示不可改价）1（表示可以改价）
		fx_fee_value 			STRING 			分销商获取的分成金额

		express 				NULL			快递公司名称
		express_type 			String 			快递公司编号
		express_no				NULL 			快递单号
		send_time 				NULL 			发货时间
		quantity 				String 			商品总件数
		express_fee 			STRING 			快递费用

		confirm_expire			STRING 			担保交易过期时间
		order_type 				STRING 			订单类型编号，1为货到付款，2为直接交易，3为担保交易
		pay_time				STRING 			付款时间
		status_desc 			STRING 			订单状态详细描述
		express_note			String 			订单备注（卖家）

		original_total_price 	STRING 			订单原价格，包括运费 （此字段用于记录订单被创建时的价格,包含运费，减去优惠后的价格）

		total 					STRING 			订单总价 包含运费

		refund_status_ori 		STRING 			订单退款相关状态

		discount_list   		ARRAY (JSON)	优惠信息列表
			discount_info 		STRING 			优惠类型信息
			discount_type 		STRING 			101(店铺满包邮)102(满减)........

		full_gift_items			ARRAY（JSON）			满赠优惠的赠品，可以为空
			item_name 			STRING 			商品名称
			quantity 			STRING 			商品总件数
			item_id 			STRING 			商品id
			item_url 			STRING 			商品链接
			head_img 			String 			商品首图
)