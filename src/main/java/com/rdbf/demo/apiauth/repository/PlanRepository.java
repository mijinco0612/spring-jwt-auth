package com.rdbf.demo.apiauth.repository;

import com.rdbf.demo.apiauth.domain.Plan;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.rdbf.demo.apiauth.domain.People;
import java.util.List;

@Mapper
public interface PlanRepository {
    @Select("SELECT title, start_date, end_date, place, body, label FROM plans WHERE login_id= #{loginId}")
    People findByLoginId(String loginId);

    @Insert("INSERT INTO plans(title,start_date,end_date,place,label,body) VALUES (#{title},#{start_date},#{end_date},#{place},${label},${body})")
    void createPlan(Plan plan);

    @Select("SELECT plan_id,login_id,title, start_date, end_date, label,body,private,place FROM plans WHERE login_id = #{loginId}")
    List<Plan> findAllOwnPlan(String loginId);

//    @Select("SELECT * FROM plans WHERE org_id = #{orgId}")
//    List<Plan> findAllOwnOrganization(String orgId);
}
