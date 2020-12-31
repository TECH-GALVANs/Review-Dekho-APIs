package com.reviewdekho.report.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.reviewdekho.comment.model.Comment;
import com.reviewdekho.report.dao.ReportDao;
import com.reviewdekho.report.model.Report;
import com.reviewdekho.reviews.model.Review;
import com.reviewdekho.user.model.User;

@Service
public class ReportService {
	private ReportDao dao;
	
	@Autowired
	public ReportService( @Qualifier("report") ReportDao dao ) {
		this.dao = dao;
	}
	
	public void add( Report report ) {
		dao.add(report);
	}
	
	public List<Report> get() {
		return dao.get();
	}
	
	public Report getById( Integer report_id ) {
		return dao.getById(report_id);
	}
	
	public Comment getCommentById( Integer commentId ) {
		return dao.getCommentById(commentId);
	}
	
	public User getUserById( Integer userId ) {
		return dao.getUserById(userId);
	}
	
	public Review getReviewById( Integer reviewId ) {
		return dao.getReviewById(reviewId);
	}
	
//	public void update( Report report, Integer report_id ) { 
//		dao.update(report, report_id);
//	}
//	
//	public void delete( Integer report_id ) {
//		dao.delete(report_id);
//	}
}
