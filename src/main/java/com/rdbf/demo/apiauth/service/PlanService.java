package com.rdbf.demo.apiauth.service;

import com.rdbf.demo.apiauth.domain.People;
import com.rdbf.demo.apiauth.domain.Plan;
import com.rdbf.demo.apiauth.repository.PeopleRepository;
import com.rdbf.demo.apiauth.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

public class PlanService {

    @Service
    public class PlanService {

        private final PlanRepository planRepository;

        @Autowired
        @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
        public PlanService(PlanRepository peopleRepository) {
            this.planRepository = planRepository;
        }

        public void createPlan(String title, SimpleDateFormat start_date,SimpleDateFormat end_date,String place,String label,String body,Boolean share) {

            Plan plan = new Plan(title,start_date,end_date,place,label,body,share);
            planRepository.createPlan(plan);

        }

        public People getUser(String loginId) {

            return planRepository.findByLoginId(loginId);
        }
    }

}


