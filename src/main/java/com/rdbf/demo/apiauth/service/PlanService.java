package com.rdbf.demo.apiauth.service;

import com.rdbf.demo.apiauth.controller.SampleController;
import com.rdbf.demo.apiauth.domain.People;
import com.rdbf.demo.apiauth.domain.Plan;
import com.rdbf.demo.apiauth.repository.PeopleRepository;
import com.rdbf.demo.apiauth.repository.PlanRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.security.core.context.SecurityContextHolder;
import java.text.SimpleDateFormat;

@Service
public class PlanService {

        private static final Logger LOGGER = LoggerFactory.getLogger(PlanService.class);
        private final PlanRepository planRepository;

        @Autowired
        @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
        public PlanService(PlanRepository planRepository) {
            this.planRepository = planRepository;
        }

        public void createPlan(String title, SimpleDateFormat start_date,SimpleDateFormat end_date,String place,String label,String body,Boolean share) {

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();

            UserDetails principal = (UserDetails) auth.getPrincipal();

            LOGGER.info("プリンシパルの中身は？:::::" +principal.toString());

            //Plan plan = new Plan(title,start_date,end_date,place,label,body,share);
            //planRepository.createPlan(plan);

        }

        public People getUser(String loginId) {

            return planRepository.findByLoginId(loginId);
        }

}


