package com.reviewdekho.reportdescription.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.reviewdekho.report.dao.ReportDao;
import com.reviewdekho.report.model.Report;
import com.reviewdekho.reportdescription.dao.ReportDescriptionDao;
import com.reviewdekho.reportdescription.model.ReportDescription;

@Service
public class ReportDescriptionService {
	private ReportDescriptionDao dao;
	
	@Autowired
	public ReportDescriptionService( @Qualifier("report_description") ReportDescriptionDao dao ) {
		this.dao = dao;
	}
	
	public void add( ReportDescription desc ) {
		dao.add(desc);
	}
	
	public List<ReportDescription> getAll(){
		return dao.get();
	}
	
	public ReportDescription getById( Integer reportDescId ) {
		return dao.getById(reportDescId);
	}
	

	public Report getReportById( Integer reportId ){
		return dao.getReportById(reportId);
	}
}
