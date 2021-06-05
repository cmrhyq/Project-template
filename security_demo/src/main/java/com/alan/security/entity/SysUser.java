package com.alan.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 * @Title sys_user 
 * @Description  
 * @author tlj 
 * @Date 2021-06-05 
 */

@Entity
@Table ( name ="sys_user" )
@Data
public class SysUser implements Serializable {

	private static final long serialVersionUID =  8850527662825511278L;

	@Id
   	@Column(name = "id" , columnDefinition = "int(11) DEFAULT NULL COMMENT 'null'")
	private Long id;

   	@Column(name = "name" , columnDefinition = "varchar(255) DEFAULT NULL COMMENT 'null'")
	private String name;

   	@Column(name = "password" , columnDefinition = "varchar(255) DEFAULT NULL COMMENT 'null'")
	private String password;

}
