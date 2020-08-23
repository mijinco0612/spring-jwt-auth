package com.rdbf.demo.apiauth.controller;

import com.rdbf.demo.apiauth.domain.Applicant;
import com.rdbf.demo.apiauth.repository.ApplicantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicantController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicantController.class);
    private final ApplicantRepository applicantRepository;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    ApplicantController(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }






    @PostMapping(value = "/applicant")
    public void createApplicant( @RequestBody
    @DateTimeFormat(pattern = "yyyy-MM-DD") Applicant creteApplicantData){

        LOGGER.info("createApplicant::::::::::::::::::::::::::" + creteApplicantData.toString());
        applicantRepository.createApplicant(creteApplicantData);


    }









}
