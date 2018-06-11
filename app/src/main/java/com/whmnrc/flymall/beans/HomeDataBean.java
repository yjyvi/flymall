package com.whmnrc.flymall.beans;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @author yjyvi
 * @data 2018/5/29.
 */

public class HomeDataBean {

    /**
     * type : 1
     * code : 0
     * message : 请求成功
     * resultdata : {"Banners":[{"Id":16,"ShopId":0,"ImageUrl":"/Storage/Plat/ImageAd/201804111543525428070.png","Url":"product/index?type=1&id=1482"},{"Id":17,"ShopId":0,"ImageUrl":"/Storage/Plat/ImageAd/201804111544090320360.png","Url":"/product/index?type=1&id=1454"},{"Id":18,"ShopId":0,"ImageUrl":"/Storage/Plat/ImageAd/201804111544583281220.png","Url":"/product/index?type=1&id=1267"},{"Id":19,"ShopId":0,"ImageUrl":"/Storage/Plat/ImageAd/201804111547103043540.png","Url":"/product/index?type=1&id=1446"},{"Id":20,"ShopId":0,"ImageUrl":"/Storage/Plat/ImageAd/201804111546146122560.png","Url":"/product/index?type=1&id=1129"}],"Brands":[{"Description":"1","DisplaySequence":0,"Id":1,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_1.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"Test","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":3,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_3.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"妖精口袋","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":4,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_4.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"TCL","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":5,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_5.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"飞科","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":6,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_6.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"创维","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":7,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_7.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"九阳","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":8,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_8.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"长虹","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":9,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_9.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"康佳","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":10,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_10.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"LG","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":11,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_11.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"努比亚","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":12,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_12.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"海尔","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":13,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_13.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"英特尔","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":14,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_14.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"佳能","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":15,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_15.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"微软","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":16,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_16.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"宏碁","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":17,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_17.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"齐心办公","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":18,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_18.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"神舟","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":19,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_19.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"Thinkpad","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":20,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_20.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"得力办公","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":21,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_21.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"惠普","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":22,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_22.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"清华同方","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":23,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_23.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"HKC","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":24,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_24.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"AOC","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":25,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_25.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"TP-LINK","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":26,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_26.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"海尔","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":27,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_27.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"罗技","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":28,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_28.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"天威","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":29,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_29.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"海澜之家","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":30,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_30.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"爱慕","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":31,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_31.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"GXG","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":32,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_32.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"mango","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":33,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_33.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"ELLE","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":34,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_34.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"百丽","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":35,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_35.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"探路者","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":36,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_36.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"丝界","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":37,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_37.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"KENZO","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":38,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_38.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"万里马","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":39,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_39.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"兰芝","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":40,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_40.gif","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"天梭","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":41,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_41.gif","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"飞亚达","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":42,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_42.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"丝蓓绮","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":43,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_43.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"日百","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":44,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_44.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"欧莱雅","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":45,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_45.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"千寻海风","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":46,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_46.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"莱百首饰","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":47,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_47.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"谢瑞麟","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":48,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_48.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"潮宏基","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":49,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_49.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"罗莱家纺","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":50,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_50.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"爱仕达","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":51,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_51.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"拉歌蒂尼","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":52,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_52.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"美国康宁","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":53,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_53.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"滴露","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":54,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_54.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"好事达","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":55,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_55.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"GLY","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":56,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_56.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"光明家具","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":57,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_57.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"宝优妮","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":58,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_58.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"水星家纺","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":59,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_59.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"惠氏","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":60,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_60.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"帮宝适","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":61,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_61.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"乐儿宝","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":62,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_62.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"合生元","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":63,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_63.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"路途乐","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":64,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_64.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"好奇","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":65,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_65.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"孕之彩","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":66,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_66.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"New Balance kids","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":67,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_67.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"南极人","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":68,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_68.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"红孩儿","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":69,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_69.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"百草味","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":70,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_70.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"五粮液","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":71,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_71.gif","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"贵州馆","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":72,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_72.gif","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"庄民","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":73,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_73.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"拉菲","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":74,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_74.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"日百","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":75,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_75.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"汇源","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":76,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_76.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"洋河","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":77,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_77.gif","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"顺丰","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":78,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_78.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"马莎","RewriteName":null},{"Description":"111","DisplaySequence":0,"Id":79,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_79.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"111","RewriteName":null},{"Description":"苹果\r\n","DisplaySequence":0,"Id":80,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_80.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"iPhone","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":82,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_82.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"老人头","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":83,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_83.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"浪美","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":84,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_84.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"雪曼","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":85,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_85.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"茜茜","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":86,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_86.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"朗芙丝","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":87,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_87.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"千百惠","RewriteName":null},{"Description":"法国欧莱雅集团是世界上最大的化妆品公司，创办于1907年。\r\n欧莱雅集团世界美妆品行业中的的领导者，经营范围遍及130多个国家和地区，在全球拥有283家分公司、42家工厂、100多个代理商，以及5万多名的员工，是总部设于法国旳跨国公司，也是财富全球500强企业之一。","DisplaySequence":0,"Id":90,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_90.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"欧莱雅","RewriteName":null},{"Description":"海飞丝去屑洗发露清爽去油型500mlX2 ","DisplaySequence":0,"Id":92,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_92.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"海飞丝","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":93,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_93.gif","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"苹果","RewriteName":null},{"Description":"潘婷乳液修复洗发水750ml*2瓶深层修复滋润洗发露套装","DisplaySequence":0,"Id":95,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_95.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"潘婷","RewriteName":null},{"Description":"全新多芬，比牛奶更滋润。","DisplaySequence":0,"Id":96,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_96.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"多芬","RewriteName":null},{"Description":"专业保护健康全家","DisplaySequence":0,"Id":98,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_98.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"舒肤佳","RewriteName":null},{"Description":"飘柔滋润去屑洗发水/露700mlX2 去屑","DisplaySequence":0,"Id":99,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_99.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"飘柔","RewriteName":null},{"Description":"幽莲魅肤力士，精油香氛沐浴露。","DisplaySequence":0,"Id":101,"IsRecommend":true,"Logo":"/Storage/Plat/Brand/logo_101.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"力士","RewriteName":null},{"Description":"水疗素护发素柔顺发膜 倒膜套装染烫受损修复毛躁","DisplaySequence":0,"Id":104,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_104.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"拉芳","RewriteName":null},{"Description":"Loreal欧莱雅","DisplaySequence":0,"Id":106,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_106.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"Loreal欧莱雅","RewriteName":null},{"Description":"深度损伤洗发水","DisplaySequence":0,"Id":107,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_107.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"多芬","RewriteName":null},{"Description":"Olay是一款全球领导护肤品牌，60年来倍受全球女性信任挚爱。Olay一直坚持深入聆听女性需求，并通过将尖端护肤科技注入产品以满足女性日新月异的护肤需求。Olay以卓越的产品品质成为广大女性的美丽标志，为全球超过八千万女性带来健康美丽的肌肤。","DisplaySequence":0,"Id":109,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_109.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"玉兰油","RewriteName":null},{"Description":"去屑无硅油洗发露护发素","DisplaySequence":0,"Id":111,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_111.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"资生堂","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":112,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_112.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"华为","RewriteName":null},{"Description":" 垂坠质感洗发水+护发素 弹性轻盈保湿顺滑","DisplaySequence":0,"Id":113,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_113.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"沙宣","RewriteName":null},{"Description":"coe韩伊Olive橄榄营养洗发水护发素套装男女士洗发水","DisplaySequence":0,"Id":115,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_115.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"韩伊","RewriteName":null},{"Description":"纳美纳米抗菌牙刷软毛牙刷","DisplaySequence":0,"Id":116,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_116.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"纳美牙刷","RewriteName":null},{"Description":"黑人牙膏套装超白","DisplaySequence":0,"Id":117,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_117.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"黑人牙刷","RewriteName":null},{"Description":"温和洗净，祛除油脂污垢，深锁肌肤水分，持久滋润，让肌肤保持自然清爽！","DisplaySequence":0,"Id":118,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_118.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"水之密语","RewriteName":null},{"Description":"郁美净人坚持优质产品的标准起步要高，郁美净儿童系列护肤品，如郁美净儿童霜、高级儿童霜、儿童营养霜、儿童营养保湿霜等都采用了国际标准，并取得了采用国际标准产品标志证书，产品水平认定为国际先进水平。","DisplaySequence":0,"Id":119,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_119.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"郁美净","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":120,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_120.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"三星","RewriteName":null},{"Description":"高露洁三重深洁波浪牙刷（有效清洁牙缝）","DisplaySequence":0,"Id":121,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_121.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"高露洁","RewriteName":null},{"Description":"李施德林漱口水","DisplaySequence":0,"Id":122,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_122.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"李施德林","RewriteName":null},{"Description":"ora2皓乐齿0酒精漱口水 去除牙龈出血口臭口气牙渍 日本进口","DisplaySequence":0,"Id":123,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_123.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"ora2皓乐齿","RewriteName":null},{"Description":"袋鼠妈妈孕妇专用护肤品，坏境中生长有机原料有机植物和有机植被以及大豆里面提取的精华研制而成的。适合准妈妈们食用 非转基因小麦成分，为准妈妈带来更好的福音","DisplaySequence":0,"Id":124,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_124.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"袋鼠妈妈","RewriteName":null},{"Description":"护舒宝卫生巾","DisplaySequence":0,"Id":125,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_125.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"护舒宝","RewriteName":null},{"Description":"ABC卫生巾","DisplaySequence":0,"Id":126,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_126.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"ABC卫生巾","RewriteName":null},{"Description":"安尔乐护垫","DisplaySequence":0,"Id":127,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_127.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"安尔乐","RewriteName":null},{"Description":"高洁丝卫生巾","DisplaySequence":0,"Id":128,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_128.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"高洁丝","RewriteName":null},{"Description":"妇炎洁洗液","DisplaySequence":0,"Id":129,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_129.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"妇炎洁","RewriteName":null},{"Description":"七度空间护垫","DisplaySequence":0,"Id":131,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_131.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"七度空间","RewriteName":null},{"Description":"LION狮王日本进口CLINICA酵素洁净牙膏","DisplaySequence":0,"Id":132,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_132.gif","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"LION狮王","RewriteName":null},{"Description":"苏菲卫生巾","DisplaySequence":0,"Id":133,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_133.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"苏菲","RewriteName":null},{"Description":"娇妍私处护理液","DisplaySequence":0,"Id":134,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_134.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"娇妍","RewriteName":null},{"Description":"洁尔阴洗液","DisplaySequence":0,"Id":135,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_135.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"洁尔阴","RewriteName":null},{"Description":"发剂 植物遮白发 黑色棕黑棕色酒红紫红全套工具染发膏","DisplaySequence":0,"Id":136,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_136.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"迪彩","RewriteName":null},{"Description":"正品威娜可丽丝倍佳染发膏60g 染膏染发剂送双氧染黑发","DisplaySequence":0,"Id":137,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_137.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"威娜","RewriteName":null},{"Description":"凡士林是vaseline的译音，一种油脂状的石油产品。白色至黄棕色允许有矿物油气味，而不允许有煤油气味。滴点约37-54度。是由石油的残油经硫酸和白土精制而得，也可以由固体石腊烃和矿物润滑油调制而成。凡士林的化学成分长链烷烃。","DisplaySequence":0,"Id":138,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_138.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"凡士林","RewriteName":null},{"Description":"老人头五倍子泡沫染发剂纯植物染发梳染发膏染发笔染发棒黑色","DisplaySequence":0,"Id":139,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_139.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"老人头","RewriteName":null},{"Description":"佰草集","DisplaySequence":0,"Id":140,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_140.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"佰草集","RewriteName":null},{"Description":"香奈儿（CHANEL)），是由Gabrielle Chanel于1913年在法国巴黎创立的品牌，至今已有百年历史。","DisplaySequence":0,"Id":141,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_141.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"香奈儿","RewriteName":null},{"Description":"LA MER海蓝之谜，中国唯一官方网站，全球高端奢华护肤品牌，从具深层滋养保湿能量的深海巨藻中萃取神奇活性精萃，拥有强大修复再生功效。","DisplaySequence":0,"Id":142,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_142.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"海蓝之谜","RewriteName":null},{"Description":"福安康秉承\u201c弘扬敬老助残传统美德，发展老残病人用品事业\u201d的宗旨，积极倡导老残病人护理新概念，积极推动敬老助残事业的发展，在做大、做强\u201c福安康\u201d 品牌的辛勤努力下，从最初的直营店经营发展为现在的连锁经营，经营品种由几十个发展到现在的六大类十二大系列、数千个品种，涵盖了老年人、残疾人、病人康复、保健护理、治疗、健身、娱乐、休闲的各个方面。","DisplaySequence":0,"Id":143,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_143.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"福安康","RewriteName":null},{"Description":"曼秀雷敦自1889年创立以来,分支机构遍布全球多个国家。1991年,曼秀雷敦(中国)药业有限公司在广东省中山市成立,其先进的生产设备、严谨的生产标准及专业的销售团队。","DisplaySequence":0,"Id":144,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_144.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"曼秀雷敦","RewriteName":null},{"Description":"柏莱雅化妆品","DisplaySequence":0,"Id":145,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_145.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"柏莱雅","RewriteName":null},{"Description":"MedSPA的产品由法国顶级联合医学实验室出品，其实验室为全球最前沿皮肤诊所及抗衰老中心、著名护肤品牌商而定制小众产品。","DisplaySequence":0,"Id":146,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_146.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"美帕","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":147,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_147.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"HTC","RewriteName":null},{"Description":"御泥坊，相传在滩头，这个有着1500年历史的湘西边陲小镇，古代的居民们一直保留着一种奇特的\u201c祭泥仪式\u201d。 清光绪年间，以这种神秘泥块为原料生产的护肤品颇受妇女欢迎，成为宫中养颜圣品，被封为\u201c御泥\u201d。御泥坊通过网络口碑相传，已成为中国泥浆面膜第一品牌","DisplaySequence":0,"Id":148,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_148.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"御泥坊","RewriteName":null},{"Description":"松下电器始终秉承着\u201c通过生产、销售活动，改善并提高社会生活，为世界文化的发展做贡献\u201d的经营理念，潜心研发了Econavi节能导航与nanoe纳米水离子两项先进技术，致力于为中国消费者提供最新的冰箱、电视机、4K数码相机、空气净化器在内的高品质电器产品。 ","DisplaySequence":0,"Id":149,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_149.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"松下","RewriteName":null},{"Description":"高丝（日语：コーセー），是日本一家以化妆品制造与贩售为主的企业，初期以代理其他美容化妆品牌为主，1948年开始发展自己的品牌，由创办者小林孝三郎结合化学与药学人士于1946年创立。","DisplaySequence":0,"Id":150,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_150.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"高丝","RewriteName":null},{"Description":"春天般的微笑","DisplaySequence":0,"Id":151,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_151.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"春笑","RewriteName":null},{"Description":"仟草佰露严选最纯净的有机植物与芳香精油、结合传统医疗的古老智慧，呈现了最天然、最完整的植物商品。以合理、生活化的价格分享给大家，让精油产品唾手可得。","DisplaySequence":0,"Id":152,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_152.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"仟草佰露 ","RewriteName":null},{"Description":"Gukoo","DisplaySequence":0,"Id":153,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_153.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"Gukoo","RewriteName":null},{"Description":"小米科技","DisplaySequence":0,"Id":154,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_154.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"小米","RewriteName":null},{"Description":"美特斯邦威","DisplaySequence":0,"Id":155,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_155.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"美特斯邦威","RewriteName":null},{"Description":"Allin","DisplaySequence":0,"Id":156,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_156.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"Allin","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":259,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_259.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"Nike","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":260,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_260.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"杰克琼斯","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":261,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_261.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"京天华盛","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":262,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_262.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"乔丹","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":263,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_263.gif","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"周先生","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":264,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_264.gif","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"戴尔","RewriteName":null},{"Description":"商家申请新品牌","DisplaySequence":0,"Id":265,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_265.png","Meta_Description":"1","Meta_Keywords":"1","Meta_Title":"1","Name":"1acer","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":266,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_266.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"ceshi","RewriteName":null},{"Description":null,"DisplaySequence":0,"Id":267,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_267.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"hishop","RewriteName":null},{"Description":"策士","DisplaySequence":0,"Id":270,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_270.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"测试","RewriteName":null},{"Description":"德国风格的","DisplaySequence":0,"Id":271,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_271.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"第三方","RewriteName":null},{"Description":"斯蒂芬","DisplaySequence":0,"Id":272,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_272.png","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"斯蒂芬","RewriteName":null},{"Description":"七格格","DisplaySequence":0,"Id":273,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_273.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"七格格","RewriteName":null},{"Description":"马克华菲","DisplaySequence":0,"Id":274,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_274.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"马克华菲","RewriteName":null},{"Description":"卡宾","DisplaySequence":0,"Id":275,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_275.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"卡宾","RewriteName":null},{"Description":"vishop","DisplaySequence":0,"Id":276,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_276.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"vishop","RewriteName":null},{"Description":"olrain","DisplaySequence":0,"Id":277,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_277.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"olrain","RewriteName":null},{"Description":"韩都衣舍","DisplaySequence":0,"Id":278,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_278.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"韩都衣舍","RewriteName":null},{"Description":"森马","DisplaySequence":0,"Id":279,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_279.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"森马","RewriteName":null},{"Description":"珀莱雅","DisplaySequence":0,"Id":280,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_280.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"珀莱雅","RewriteName":null},{"Description":"自然堂","DisplaySequence":0,"Id":281,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_281.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"自然堂","RewriteName":null},{"Description":"Shiseido资生堂","DisplaySequence":0,"Id":282,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_282.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"Shiseido资生堂","RewriteName":null},{"Description":"Clinique倩碧","DisplaySequence":0,"Id":283,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_283.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"Clinique倩碧","RewriteName":null},{"Description":"SKII","DisplaySequence":0,"Id":284,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_284.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"SKII","RewriteName":null},{"Description":"美肤宝","DisplaySequence":0,"Id":285,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_285.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"美肤宝","RewriteName":null},{"Description":"Marubi/丸美","DisplaySequence":0,"Id":286,"IsRecommend":false,"Logo":"/Storage/Plat/Brand/logo_286.jpg","Meta_Description":null,"Meta_Keywords":null,"Meta_Title":null,"Name":"Marubi丸美","RewriteName":null}],"Videos":[{"Id":1,"VideoName":"视频名称","ImageUrl":"/Storage/Video/Thumbnail/780aabf4-38bf-46b5-a92c-ff7c428c4eea.jpg","Description":"","ProductId":1454,"VideoUrl":"/Storage/Video/Videos/09aade79-3140-4de7-b918-004c071aa52e.mp4","IsShow":true,"CreateDate":"2018-06-09 02:57:01"},{"Id":1,"VideoName":"视频名称","ImageUrl":"/Storage/Video/Thumbnail/780aabf4-38bf-46b5-a92c-ff7c428c4eea.jpg","Description":"","ProductId":1454,"VideoUrl":"/Storage/Video/Videos/09aade79-3140-4de7-b918-004c071aa52e.mp4","IsShow":true,"CreateDate":"2018-06-09 02:57:01"},{"Id":1,"VideoName":"视频名称","ImageUrl":"/Storage/Video/Thumbnail/780aabf4-38bf-46b5-a92c-ff7c428c4eea.jpg","Description":"","ProductId":1454,"VideoUrl":"/Storage/Video/Videos/09aade79-3140-4de7-b918-004c071aa52e.mp4","IsShow":true,"CreateDate":"2018-06-09 02:57:01"},{"Id":1,"VideoName":"视频名称","ImageUrl":"/Storage/Video/Thumbnail/780aabf4-38bf-46b5-a92c-ff7c428c4eea.jpg","Description":"","ProductId":1454,"VideoUrl":"/Storage/Video/Videos/09aade79-3140-4de7-b918-004c071aa52e.mp4","IsShow":true,"CreateDate":"2018-06-09 02:57:01"},{"Id":1,"VideoName":"视频名称","ImageUrl":"/Storage/Video/Thumbnail/780aabf4-38bf-46b5-a92c-ff7c428c4eea.jpg","Description":"","ProductId":1454,"VideoUrl":"/Storage/Video/Videos/09aade79-3140-4de7-b918-004c071aa52e.mp4","IsShow":true,"CreateDate":"2018-06-09 02:57:01"}]}
     */

    private int type;
    private int code;
    private String message;
    private ResultdataBean resultdata;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultdataBean getResultdata() {
        return resultdata;
    }

    public void setResultdata(ResultdataBean resultdata) {
        this.resultdata = resultdata;
    }

    public static class ResultdataBean implements  Parcelable {
        private List<BannersBean> Banners;
        private List<BrandsBean> Brands;
        private List<VideosBean> Videos;

        public ResultdataBean() {
        }

        protected ResultdataBean(Parcel in) {
            Videos = in.createTypedArrayList(VideosBean.CREATOR);
        }

        public static final Creator<ResultdataBean> CREATOR = new Creator<ResultdataBean>() {
            @Override
            public ResultdataBean createFromParcel(Parcel in) {
                return new ResultdataBean(in);
            }

            @Override
            public ResultdataBean[] newArray(int size) {
                return new ResultdataBean[size];
            }
        };

        public List<BannersBean> getBanners() {
            return Banners;
        }

        public void setBanners(List<BannersBean> Banners) {
            this.Banners = Banners;
        }

        public List<BrandsBean> getBrands() {
            return Brands;
        }

        public void setBrands(List<BrandsBean> Brands) {
            this.Brands = Brands;
        }

        public List<VideosBean> getVideos() {
            return Videos;
        }

        public void setVideos(List<VideosBean> Videos) {
            this.Videos = Videos;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeTypedList(Videos);
        }

        public static class BannersBean {
            /**
             * Id : 16
             * ShopId : 0
             * ImageUrl : /Storage/Plat/ImageAd/201804111543525428070.png
             * Url : product/index?type=1&id=1482
             */

            private int Id;
            private int ShopId;
            private String ImageUrl;
            private String Url;

            public int getId() {
                return Id;
            }

            public void setId(int Id) {
                this.Id = Id;
            }

            public int getShopId() {
                return ShopId;
            }

            public void setShopId(int ShopId) {
                this.ShopId = ShopId;
            }

            public String getImageUrl() {
                return ImageUrl;
            }

            public void setImageUrl(String ImageUrl) {
                this.ImageUrl = ImageUrl;
            }

            public String getUrl() {
                return Url;
            }

            public void setUrl(String Url) {
                this.Url = Url;
            }
        }

        public static class BrandsBean implements Parcelable {
            public BrandsBean() {
            }

            /**
             * Description : 1
             * DisplaySequence : 0
             * Id : 1
             * IsRecommend : true
             * Logo : /Storage/Plat/Brand/logo_1.jpg
             * Meta_Description : null
             * Meta_Keywords : null
             * Meta_Title : null
             * Name : Test
             * RewriteName : null
             */

            private String Description;
            private int DisplaySequence;
            private int Id;
            private boolean IsRecommend;
            private String Logo;
            private Object Meta_Description;
            private Object Meta_Keywords;
            private Object Meta_Title;
            private String Name;
            private Object RewriteName;

            protected BrandsBean(Parcel in) {
                Description = in.readString();
                DisplaySequence = in.readInt();
                Id = in.readInt();
                IsRecommend = in.readByte() != 0;
                Logo = in.readString();
                Name = in.readString();
            }

            public static final Creator<BrandsBean> CREATOR = new Creator<BrandsBean>() {
                @Override
                public BrandsBean createFromParcel(Parcel in) {
                    return new BrandsBean(in);
                }

                @Override
                public BrandsBean[] newArray(int size) {
                    return new BrandsBean[size];
                }
            };

            public String getDescription() {
                return Description;
            }

            public void setDescription(String Description) {
                this.Description = Description;
            }

            public int getDisplaySequence() {
                return DisplaySequence;
            }

            public void setDisplaySequence(int DisplaySequence) {
                this.DisplaySequence = DisplaySequence;
            }

            public int getId() {
                return Id;
            }

            public void setId(int Id) {
                this.Id = Id;
            }

            public boolean isIsRecommend() {
                return IsRecommend;
            }

            public void setIsRecommend(boolean IsRecommend) {
                this.IsRecommend = IsRecommend;
            }

            public String getLogo() {
                return Logo;
            }

            public void setLogo(String Logo) {
                this.Logo = Logo;
            }

            public Object getMeta_Description() {
                return Meta_Description;
            }

            public void setMeta_Description(Object Meta_Description) {
                this.Meta_Description = Meta_Description;
            }

            public Object getMeta_Keywords() {
                return Meta_Keywords;
            }

            public void setMeta_Keywords(Object Meta_Keywords) {
                this.Meta_Keywords = Meta_Keywords;
            }

            public Object getMeta_Title() {
                return Meta_Title;
            }

            public void setMeta_Title(Object Meta_Title) {
                this.Meta_Title = Meta_Title;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public Object getRewriteName() {
                return RewriteName;
            }

            public void setRewriteName(Object RewriteName) {
                this.RewriteName = RewriteName;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(Description);
                dest.writeInt(DisplaySequence);
                dest.writeInt(Id);
                dest.writeByte((byte) (IsRecommend ? 1 : 0));
                dest.writeString(Logo);
                dest.writeString(Name);
            }
        }

        public static class VideosBean implements Parcelable {
            public VideosBean() {
            }

            /**
             * Id : 1
             * VideoName : 视频名称
             * ImageUrl : /Storage/Video/Thumbnail/780aabf4-38bf-46b5-a92c-ff7c428c4eea.jpg
             * Description :
             * ProductId : 1454
             * VideoUrl : /Storage/Video/Videos/09aade79-3140-4de7-b918-004c071aa52e.mp4
             * IsShow : true
             * CreateDate : 2018-06-09 02:57:01
             */



            private int Id;
            private String VideoName;
            private String ImageUrl;
            private String Description;
            private int ProductId;
            private String VideoUrl;
            private boolean IsShow;
            private String CreateDate;

            protected VideosBean(Parcel in) {
                Id = in.readInt();
                VideoName = in.readString();
                ImageUrl = in.readString();
                Description = in.readString();
                ProductId = in.readInt();
                VideoUrl = in.readString();
                IsShow = in.readByte() != 0;
                CreateDate = in.readString();
            }

            public static final Creator<VideosBean> CREATOR = new Creator<VideosBean>() {
                @Override
                public VideosBean createFromParcel(Parcel in) {
                    return new VideosBean(in);
                }

                @Override
                public VideosBean[] newArray(int size) {
                    return new VideosBean[size];
                }
            };

            public int getId() {
                return Id;
            }

            public void setId(int Id) {
                this.Id = Id;
            }

            public String getVideoName() {
                return VideoName;
            }

            public void setVideoName(String VideoName) {
                this.VideoName = VideoName;
            }

            public String getImageUrl() {
                return ImageUrl;
            }

            public void setImageUrl(String ImageUrl) {
                this.ImageUrl = ImageUrl;
            }

            public String getDescription() {
                return Description;
            }

            public void setDescription(String Description) {
                this.Description = Description;
            }

            public int getProductId() {
                return ProductId;
            }

            public void setProductId(int ProductId) {
                this.ProductId = ProductId;
            }

            public String getVideoUrl() {
                return VideoUrl;
            }

            public void setVideoUrl(String VideoUrl) {
                this.VideoUrl = VideoUrl;
            }

            public boolean isIsShow() {
                return IsShow;
            }

            public void setIsShow(boolean IsShow) {
                this.IsShow = IsShow;
            }

            public String getCreateDate() {
                return CreateDate;
            }

            public void setCreateDate(String CreateDate) {
                this.CreateDate = CreateDate;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(Id);
                dest.writeString(VideoName);
                dest.writeString(ImageUrl);
                dest.writeString(Description);
                dest.writeInt(ProductId);
                dest.writeString(VideoUrl);
                dest.writeByte((byte) (IsShow ? 1 : 0));
                dest.writeString(CreateDate);
            }
        }
    }
}
