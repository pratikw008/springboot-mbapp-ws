package com.mb.app.ws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
//@SQLDelete(sql = "update users set is_deleted=true where user_id=?")
//@Where(clause = "is_deleted = false")
public class UserEntity extends Auditable<String> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String userId;
	
	@Column(nullable = false, length = 50)
	private String firstName;
	
	@Column(nullable = false, length = 50)
	private String lastName;
	
	@Column(nullable = false, unique = true, length = 120)
	private String email;
	
	@Column(nullable = false)
	private String encryptedPassword;
	
	private String emailVerificationToken;
	
	@Column(nullable = false)	//columnDefinition = "boolean default false"
	private Boolean emailVerificationStatus = false;
	
	@Column(nullable = false)
	private boolean isDeleted = Boolean.FALSE;
	
	/*@PreRemove
	private void preRemove() {
		this.isDeleted = true;
	}*/
}
