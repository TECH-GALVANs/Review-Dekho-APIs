package com.reviewdekho.subcategory.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.reviewdekho.category.model.Category;

@Entity
@Table(name="sub_category_master")
public class SubCategory {
		@Id
		@GeneratedValue( strategy = GenerationType.AUTO )
		private Integer sub_category_id;
		@ManyToOne
		@JoinColumn( name="category_id" )
		private Category category;

		private String sub_category_name;
		@CreationTimestamp
		private Timestamp sub_category_created_at;
		@UpdateTimestamp
		private Timestamp sub_category_updated_at;

		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

		public SubCategory() {}

		public SubCategory(Integer subcategory_id,Category category, String subcategory_name, Timestamp subcategory_created_at,
				Timestamp subcategory_updated_at) {
			this.sub_category_id = subcategory_id;
			this.category = category;
			this.sub_category_name = subcategory_name;
			this.sub_category_created_at = subcategory_created_at;
			this.sub_category_updated_at = subcategory_updated_at;
		}

		public Integer getSub_category_id() {
			return sub_category_id;
		}

		public void setSub_category_id(Integer sub_category_id) {
			this.sub_category_id = sub_category_id;
		}

		public String getSub_category_name() {
			return sub_category_name;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		public void setSub_category_name(String sub_category_name) {
			this.sub_category_name = sub_category_name;
		}

		public Timestamp getSub_category_created_at() {
			return sub_category_created_at;
		}

		public void setSub_category_created_at(Timestamp sub_category_created_at) {
			this.sub_category_created_at = sub_category_created_at;
		}

		public Timestamp getSub_category_updated_at() {
			return sub_category_updated_at;
		}

		public void setSub_category_updated_at(Timestamp sub_category_updated_at) {
			this.sub_category_updated_at = sub_category_updated_at;
		}

		
}
