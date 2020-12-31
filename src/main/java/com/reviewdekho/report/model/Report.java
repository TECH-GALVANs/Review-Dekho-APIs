package com.reviewdekho.report.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.reviewdekho.comment.model.Comment;
import com.reviewdekho.reportdescription.model.ReportDescription;
import com.reviewdekho.reviews.model.Review;
import com.reviewdekho.user.model.User;

@Entity
@Table(name="report_master")
public class Report {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Integer report_id;
	@ManyToOne(optional = true)
	@JoinColumn( name="review_id" ) 
	private Review review;
	@ManyToOne( optional = true )
	@JoinColumn( name="comment_id" ) 
	private Comment comment;
	@ManyToOne(optional=true)
	@JoinColumn( name="user_id" ) 
	private User user;
	private String report_description;
	private Boolean report_status;
	@CreationTimestamp
	private Timestamp report_created_at;
	@UpdateTimestamp
	private Timestamp report_updated_at;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	
	public Report() {}

	public Report(Integer report_id, Review review, Comment comment, User user, String report_description,
			Boolean report_status, Timestamp report_created_at, Timestamp report_updated_at) {
		super();
		this.report_id = report_id;
		this.review = review;
		this.comment = comment;
		this.user = user;
		this.report_description = report_description;
		this.report_status = report_status;
		this.report_created_at = report_created_at;
		this.report_updated_at = report_updated_at;
	}

	public Integer getReport_id() {
		return report_id;
	}

	public void setReport_id(Integer report_id) {
		this.report_id = report_id;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getReport_created_at() {
		return report_created_at;
	}

	public void setReport_created_at(Timestamp report_created_at) {
		this.report_created_at = report_created_at;
	}

	public Timestamp getReport_updated_at() {
		return report_updated_at;
	}

	public void setReport_updated_at(Timestamp report_updated_at) {
		this.report_updated_at = report_updated_at;
	}

	public String getReport_description() {
		return report_description;
	}

	public void setReport_description(String report_description) {
		this.report_description = report_description;
	}

	public Boolean getReport_status() {
		return report_status;
	}

	public void setReport_status(Boolean report_status) {
		this.report_status = report_status;
	}
	
}
