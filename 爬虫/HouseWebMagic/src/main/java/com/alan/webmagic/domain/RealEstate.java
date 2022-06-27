package com.alan.webmagic.domain;

import javax.persistence.*;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Title real_estate 
 * @Description  
 * @author tlj 
 * @Date 2021-02-04 
 */

@Entity
@Table ( name ="real_estate" )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RealEstate implements Serializable {

	private static final long serialVersionUID =  4911135762993957517L;

	/**
	 * 楼盘信息-id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//主键生成策略
   	@Column(name = "real_estate_id" , columnDefinition = "int(11) DEFAULT NULL COMMENT '楼盘信息-id'")
	private Long realEstateId;

	/**
	 * 楼盘信息-物业类型
	 */
   	@Column(name = "real_estate_property_type" , columnDefinition = "varchar(255) DEFAULT NULL COMMENT '楼盘信息-物业类型'")
	private String realEstatePropertyType;

	/**
	 * 楼盘信息-参考价格
	 */
   	@Column(name = "real_estate_price" , columnDefinition = "varchar(255) DEFAULT NULL COMMENT '楼盘信息-参考价格'")
	private String realEstatePrice;

	/**
	 * 楼盘信息-项目特色
	 */
   	@Column(name = "real_estate_project_features" , columnDefinition = "varchar(255) DEFAULT NULL COMMENT '楼盘信息-项目特色'")
	private String realEstateProjectFeatures;

	/**
	 * 楼盘信息-区域位置
	 */
   	@Column(name = "real_estate_area_position" , columnDefinition = "varchar(255) DEFAULT NULL COMMENT '楼盘信息-区域位置'")
	private String realEstateAreaPosition;

	/**
	 * 楼盘信息-楼盘地址
	 */
   	@Column(name = "real_estate_address" , columnDefinition = "varchar(255) DEFAULT NULL COMMENT '楼盘信息-楼盘地址'")
	private String realEstateAddress;

	/**
	 * 楼盘信息-售楼处地址
	 */
   	@Column(name = "real_estate_sales_office_address" , columnDefinition = "varchar(255) DEFAULT NULL COMMENT '楼盘信息-售楼处地址'")
	private String realEstateSalesOfficeAddress;

	/**
	 * 楼盘信息-开发商
	 */
   	@Column(name = "real_estate_developer" , columnDefinition = "varchar(255) DEFAULT NULL COMMENT '楼盘信息-开发商'")
	private String realEstateDeveloper;

	/**
	 * 添加时间
	 */
   	@Column(name = "gmt_create" , columnDefinition = "datetime DEFAULT NULL COMMENT '添加时间'")
	private Date gmtCreate;

	/**
	 * 修改时间
	 */
   	@Column(name = "gmt_modify" , columnDefinition = "datetime DEFAULT NULL COMMENT '修改时间'")
	private Date gmtModify;

}
