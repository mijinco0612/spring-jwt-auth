package com.rdbf.demo.apiauth.repository;

import com.rdbf.demo.apiauth.domain.Applicant;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApplicantRepository {


    @Insert("INSERT INTO applicants(applicant_id,occupation,applicant_name,applicant_name_ruby,birth_day,gender,e_mail,phone_number,inquiry)" +
                         "VALUES(#{applicantId},#{occupation},#{applicantName},#{applicantNameRuby},#{birthDay},#{gender},#{eMail},#{phoneNumber},#{inquiry})"
    )
    void createApplicant(Applicant createApplicantData);

}
