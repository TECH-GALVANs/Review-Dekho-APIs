package com.reviewdekho.report.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reviewdekho.report.model.Report;

public interface ReportDaoI extends JpaRepository<Report, Integer> {

}
