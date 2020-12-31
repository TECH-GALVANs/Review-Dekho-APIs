package com.reviewdekho.reportdescription.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reviewdekho.reportdescription.model.ReportDescription;

public interface ReportDescriptionDaoI extends JpaRepository<ReportDescription, Integer > {

}
