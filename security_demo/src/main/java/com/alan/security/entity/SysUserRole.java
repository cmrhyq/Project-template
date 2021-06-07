package com.alan.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 * @Title sys_user_role 
 * @Description  
 * @author tlj 
 * @Date 2021-06-05 
 */

@Entity
@Table ( name ="sys_user_role" )
@Data
public class SysUserRole implements Serializable {

	private static final long serialVersionUID =  8469524459597144143L;

	@Id
   	@Column(name = "user_id" , columnDefinition = "int(11) DEFAULT NULL COMMENT 'null'")
	private int userId;

   	@Column(name = "role_id" , columnDefinition = "int(11) DEFAULT NULL COMMENT 'null'")
	private Long roleId;

}
