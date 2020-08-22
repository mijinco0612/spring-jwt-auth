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
import java.util.ArrayList;
import java.util.List;

@Service
public class PlanService {

        private static final Logger LOGGER = LoggerFactory.getLogger(PlanService.class);
        private final PlanRepository planRepository;
        private final PeopleRepository peopleRepository;


        @Autowired
        @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
        public PlanService(PlanRepository planRepository,PeopleRepository peopleRepository) {
            this.planRepository = planRepository;
            this.peopleRepository = peopleRepository;
        }

        public void createPlan(String title, SimpleDateFormat start_date,SimpleDateFormat end_date,String place,String label,String body,Boolean share) {

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();

            UserDetails principal = (UserDetails) auth.getPrincipal();

            LOGGER.info("プリンシパルの中身は？:::::" +principal.toString());

//            Plan plan = new Plan(title,start_date,end_date,label,body,share,place);
//            planRepository.createPlan(plan);

        }

        public People getUser(String loginId) {
            return planRepository.findByLoginId(loginId);
        }

        public List<Plan> findOrg(String loginId){
            People people = peopleRepository.findByLoginId(loginId);
            List<People> memberList =  peopleRepository.findbyOrgnizationId(people);
            ArrayList<String> loginIdList = new ArrayList<String>();
            String idList = "";
            for(People peopleTemp : memberList){
                loginIdList.add(peopleTemp.getLoginId());
                String loginList = "'" + peopleTemp.getLoginId() + "'";
                idList =  idList +"," + loginList;
            }
            LOGGER.info("idListの中身は？:::::" +idList.substring(1,idList.length()));
            return planRepository.findByLoginIdList(idList.substring(1,idList.length()));
        }
}


