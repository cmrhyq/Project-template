package com.alan.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 * @Title sys_role 
 * @Description  
 * @author tlj 
 * @Date 2021-06-05 
 */

@Entity
@Table ( name ="sys_role" )
@Data
public class SysRole implements Serializable {

	private static final long serialVersionUID =  8685018276585276917L;

	@Id
	@Column(name = "id" , columnDefinition = "int(11) DEFAULT NULL COMMENT 'null'")
	private int id;

   	@Column(name = "name" , columnDefinition = "varchar(255) DEFAULT NULL COMMENT 'null'")
	private String name;

}
