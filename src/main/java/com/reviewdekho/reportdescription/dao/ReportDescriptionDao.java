package com.reviewdekho.reportdescription.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reviewdekho.report.dao.ReportDaoI;
import com.reviewdekho.report.model.Report;
import com.reviewdekho.reportdescription.dao.ReportDescriptionDaoI;
import com.reviewdekho.reportdescription.model.ReportDescription;

@Repository("report_description")
public class ReportDescriptionDao {
	@Autowired
	ReportDescriptionDaoI descRepo;
	
	@Autowired 
	ReportDaoI reportRepo;
	
	public void add( ReportDescription report_desc ) {
		descRepo.save( report_desc );
	}
	
	public List<ReportDescription> get(){
		return descRepo.findAll();
	}
	
	public ReportDescription getById( final Integer report_desc_id ) {
		return descRepo.findById(report_desc_id).orElse(null);
	}
	
	public Report getReportById( Integer reportId ){
		return reportRepo.findById(reportId).orElse(null);
	}
	
//	public void update( ReportDescription report_desc, Integer report_desc_id ) {
//		ReportDescription report_descTo = getById(report_desc_id);
//		report_descTo.setReport_id(report_desc.getReport_id());
//		
//		descRepo.save(report_descTo);
//	}
//	
//	public void delete( Integer report_desc_id ) {
//		descRepo.deleteById(report_desc_id);
//	}
}
