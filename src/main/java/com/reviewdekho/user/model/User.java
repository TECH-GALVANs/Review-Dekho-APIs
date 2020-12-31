package com.reviewdekho.user.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@NamedQuery(name = "User.findByEmailId", query = "SELECT user FROM User user WHERE email_id = ?1")
@Table( name="user_master")
public class User {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Integer user_id;
	private String email_id;
	private String profileImage;
	private String imageType;
	private String user_name;
	private String password;
	private int user_role;
	@CreationTimestamp
	private Timestamp user_created_at;
	@UpdateTimestamp
	private Timestamp user_updated_at;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUser_role() {
		return user_role;
	}
	public void setUser_role(int user_role) {
		this.user_role = user_role;
	}
	public Timestamp getUser_created_at() {
		return user_created_at;
	}
	public void setUser_created_at(Timestamp user_created_at) {
		this.user_created_at = user_created_at;
	}
	public Timestamp getUser_updated_at() {
		return user_updated_at;
	}
	public void setUser_updated_at(Timestamp user_updated_at) {
		this.user_updated_at = user_updated_at;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
}

