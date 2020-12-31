package com.reviewdekho.reviewer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reviewdekho.reviewer.model.Reviewer;

public interface ReviewerDaoI extends JpaRepository<Reviewer, Integer> {

}
