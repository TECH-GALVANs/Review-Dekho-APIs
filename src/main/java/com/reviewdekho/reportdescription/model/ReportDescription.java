package com.reviewdekho.reportdescription.model;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.reviewdekho.report.model.Report;

@Entity
@Table(name="report_description")
public class ReportDescription {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer report_desc_id;
	private String report_desc;
	@OneToOne()
    @JoinColumn(name = "report_id", nullable = false)
    private Report report;
	@CreationTimestamp
	private Timestamp desc_created_at;
	@UpdateTimestamp
	private Timestamp desc_updated_at;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	
	public ReportDescription() {}
	
	public ReportDescription(Integer report_desc_id, Report report , Timestamp desc_created_at,
			Timestamp desc_updated_at) {
		super();
		this.report_desc_id = report_desc_id;
		this.report = report;
		this.desc_created_at = desc_created_at;
		this.desc_updated_at = desc_updated_at;
	}
	
	public Integer getReport_desc_id() {
		return report_desc_id;
	}
	public void setReport_desc_id(Integer report_desc_id) {
		this.report_desc_id = report_desc_id;
	}
	
	public String getReport_desc() {
		return report_desc;
	}

	public void setReport_desc(String report_desc) {
		this.report_desc = report_desc;
	}

	
	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public Timestamp getDesc_created_at() {
		return desc_created_at;
	}
	public void setDesc_created_at(Timestamp desc_created_at) {
		this.desc_created_at = desc_created_at;
	}
	public Timestamp getDesc_updated_at() {
		return desc_updated_at;
	}
	public void setDesc_updated_at(Timestamp desc_updated_at) {
		this.desc_updated_at = desc_updated_at;
	}
	
}
