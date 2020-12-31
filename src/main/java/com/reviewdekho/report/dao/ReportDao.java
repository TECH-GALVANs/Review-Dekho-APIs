package com.reviewdekho.report.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reviewdekho.comment.dao.CommentDaoI;
import com.reviewdekho.comment.model.Comment;
import com.reviewdekho.report.model.Report;
import com.reviewdekho.reviews.dao.ReviewDaoI;
import com.reviewdekho.reviews.model.Review;
import com.reviewdekho.user.dao.UserDaoI;
import com.reviewdekho.user.model.User;

@Repository("report")
public class ReportDao {
	@Autowired
	ReportDaoI reportRepo;
	
	@Autowired
	CommentDaoI commentRepo;
	
	@Autowired
	UserDaoI userRepo;
	
	@Autowired
	ReviewDaoI reviewRepo;
	
	public void add( Report report ) {
		reportRepo.save( report );
	}
	
	public List<Report> get(){
		return reportRepo.findAll();
	}
	
	public Report getById( final Integer report_id ) {
		return reportRepo.findById(report_id).orElse(null);
	}
	
	public Comment getCommentById( Integer commentId ) {
		return commentRepo.findById( commentId ).orElse(null);
	}
	
	public User getUserById( Integer userId ) {
		return userRepo.findById( userId ).orElse( null );
	}
	
	public Review getReviewById( Integer reviewId ) {
		return reviewRepo.findById( reviewId ).orElse(null);
	}
	
//	public void update( Report report, Integer report_id ) {
//		Report reportTo = getById(report_id);
//		reportTo.setReview_id(report.getReview_id());
//		
//		reportRepo.save(reportTo);
//	}
	
//	public void delete( Integer report_id ) {
//		reportRepo.deleteById(report_id);
//	}
}
