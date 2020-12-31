package com.reviewdekho.report.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reviewdekho.report.model.Report;
import com.reviewdekho.report.service.ReportService;

@RequestMapping("api/report")
@RestController
public class ReportController {
	private ReportService reportService;
	
	@Autowired
	public ReportController( ReportService reportService ) {
		System.out.println("From Controller-constructor");
		this.reportService = reportService;
	}
	
	@PostMapping
	public void add( @RequestBody Report report ) {
		if( report.getComment() == null ) {
			report.setReview( reportService.getReviewById( report.getReview().getReview_id() ) );
			report.setUser( reportService.getUserById( report.getUser().getUser_id() ) );
		} 
		
		else if( report.getReview() == null ) {
			report.setComment( reportService.getCommentById( report.getComment().getComment_id() ) );
			report.setUser( reportService.getUserById( report.getUser().getUser_id() ) );
		}
		System.out.println("From Controller-add");
		reportService.add(report);
	}
	
	@GetMapping
	public List<Report> get(){
		System.out.println("From Controller-get");
		return reportService.get();
	}
	
	@GetMapping(path="{id}")
	public Report getById( @PathVariable("id") Integer report_id ) {
		System.out.println("From Controller-get-id"+report_id);
		return reportService.getById(report_id);
	}
//	as report cant be updated or deleted, we havent implemented that !!!
//	@PutMapping(path="{id}")
//	public void update( @RequestBody Report report, @PathVariable("id") Integer report_id ) {
//		System.out.println("From Controller-update");
//		reportService.update(report, report_id);
//	}
//	
//	@DeleteMapping(path="{id}")
//	public void delete( @PathVariable("id") Integer report_id ) {
//		System.out.println("From Controller-delete");
//		reportService.delete(report_id);
//	}
}
