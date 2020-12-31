package com.reviewdekho.reportdescription.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reviewdekho.reportdescription.model.ReportDescription;
import com.reviewdekho.reportdescription.service.ReportDescriptionService;

@RestController
@RequestMapping( "api/report_description" )
public class ReportDescriptionController {
	private ReportDescriptionService service;
	
	@Autowired
	public ReportDescriptionController( ReportDescriptionService service ) {
		this.service = service;
	}
	
	@PostMapping
	public void add( @RequestBody ReportDescription report_desc ) {
		System.out.println("From Controller-add");
		report_desc.setReport( service.getReportById( report_desc.getReport().getReport_id() ) );
		service.add(report_desc);
	}
	
	@GetMapping
	public List<ReportDescription> get(){
		System.out.println("From Controller-get");
		return service.getAll();
	}
	
	@GetMapping(path="{id}")
	public ReportDescription getById( @PathVariable("id") Integer report_desc_id ) {
		System.out.println("From Controller-get-id"+report_desc_id);
		return service.getById(report_desc_id);
	}
	
}
