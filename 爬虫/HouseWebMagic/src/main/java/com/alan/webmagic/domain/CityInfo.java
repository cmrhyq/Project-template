package com.alan.webmagic.domain;

import javax.persistence.*;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Title city_info 
 * @Description  
 * @author tlj 
 * @Date 2021-02-04 
 */

@Entity
@Table ( name ="city_info" )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityInfo implements Serializable {

	private static final long serialVersionUID =  5365682555981330842L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//主键生成策略
   	@Column(name = "city_id" , columnDefinition = "int(11) DEFAULT NULL COMMENT 'null'")
	private Long cityId;

   	@Column(name = "city_url" , columnDefinition = "varchar(255) DEFAULT NULL COMMENT 'null'")
	private String cityUrl;

   	@Column(name = "city_name" , columnDefinition = "varchar(255) DEFAULT NULL COMMENT 'null'")
	private String cityName;

   	@Column(name = "gmt_create" , columnDefinition = "datetime DEFAULT NULL COMMENT 'null'")
	private Date gmtCreate;

   	@Column(name = "gmt_modified" , columnDefinition = "datetime DEFAULT NULL COMMENT 'null'")
	private Date gmtModified;

}
