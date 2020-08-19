package com.rdbf.demo.apiauth.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.rdbf.demo.apiauth.domain.People;


@Mapper
public interface OrganizationRepository {
    @Select("SELECT org_id, org_name, people_name FROM organizations WHERE login_id = #{loginId}")
    People findByLoginId(String loginId);

    @Insert("INSERT INTO peoples(login_id,password) VALUES (#{loginId},#{password})")
    void createAccount(People people);
}