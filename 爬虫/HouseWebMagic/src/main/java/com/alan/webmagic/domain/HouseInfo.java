package com.alan.webmagic.domain;

import javax.persistence.*;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Title house_info 
 * @Description  
 * @author tlj 
 * @Date 2021-02-04 
 */

@Entity
@Table ( name ="house_info" )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseInfo implements Serializable {

	private static final long serialVersionUID =  6524288772730551048L;

	/**
	 * 房屋信息-id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//主键生成策略
   	@Column(name = "house_info_id" , columnDefinition = "int(11) DEFAULT NULL COMMENT '房屋信息-id'")
	private Long houseInfoId;

	/**
	 * 房屋信息-房屋名称
	 */
   	@Column(name = "house_info_name" , columnDefinition = "varchar(255) DEFAULT NULL COMMENT '房屋信息-房屋名称'")
	private String houseInfoName;

	/**
	 * 房屋信息-图片url
	 */
   	@Column(name = "house_info_img_url" , columnDefinition = "text DEFAULT NULL COMMENT '房屋信息-图片url'")
	private String houseInfoImgUrl;

	/**
	 * 房屋信息-总价
	 */
   	@Column(name = "house_info_total_price" , columnDefinition = "decimal(11,2) DEFAULT NULL COMMENT '房屋信息-总价'")
	private Double houseInfoTotalPrice;

	/**
	 * 房屋信息-每平米价格
	 */
   	@Column(name = "house_info_meter_price" , columnDefinition = "decimal(8,2) DEFAULT NULL COMMENT '房屋信息-每平米价格'")
	private Double houseInfoMeterPrice;

	/**
	 * 房屋信息-小区名称
	 */
   	@Column(name = "house_info_community_name" , columnDefinition = "varchar(255) DEFAULT NULL COMMENT '房屋信息-小区名称'")
	private String houseInfoCommunityName;

	/**
	 * 房屋信息-小区所在区域
	 */
   	@Column(name = "house_info_area" , columnDefinition = "varchar(255) DEFAULT NULL COMMENT '房屋信息-小区所在区域'")
	private String houseInfoArea;

	/**
	 * 房屋信息-看房时间
	 */
   	@Column(name = "house_info_look_time" , columnDefinition = "varchar(255) DEFAULT NULL COMMENT '房屋信息-看房时间'")
	private String houseInfoLookTime;

	/**
	 * 房屋信息-房屋编号
	 */
   	@Column(name = "house_info_number" , columnDefinition = "decimal(12) DEFAULT NULL COMMENT '房屋信息-房屋编号'")
	private Double houseInfoNumber;

	/**
	 * 房屋信息-房源所在省市
	 */
   	@Column(name = "house_info_place_province_city" , columnDefinition = "varchar(255) DEFAULT NULL COMMENT '房屋信息-房源所在省市'")
	private String houseInfoPlaceProvinceCity;

	/**
	 * 房屋信息-页面地址
	 */
   	@Column(name = "house_info_url" , columnDefinition = "text DEFAULT NULL COMMENT '房屋信息-页面地址'")
	private String houseInfoUrl;

	/**
	 * 创建时间
	 */
   	@Column(name = "gmt_create" , columnDefinition = "datetime DEFAULT NULL COMMENT '创建时间'")
	private Date gmtCreate;

	/**
	 * 更新时间
	 */
   	@Column(name = "gmt_modified" , columnDefinition = "datetime DEFAULT NULL COMMENT '更新时间'")
	private Date gmtModified;

}
