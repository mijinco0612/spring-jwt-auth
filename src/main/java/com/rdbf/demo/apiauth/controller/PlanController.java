package com.rdbf.demo.apiauth.controller;

import com.rdbf.demo.apiauth.controller.form.UserForm;
import com.rdbf.demo.apiauth.domain.Plan;
import com.rdbf.demo.apiauth.repository.PlanRepository;
import com.rdbf.demo.apiauth.service.PlanService;
import com.rdbf.demo.apiauth.service.SampleService;
import com.rdbf.demo.apiauth.support.SecurityConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PlanController {

    private final PlanRepository planRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(PlanController.class);

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    PlanController(PlanRepository planRepository){
        this.planRepository = planRepository;
    }

    @GetMapping("/plan")
    List<Plan> allOwnPlan() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        LOGGER.info("プリンシパルの中身は？:::::" +principal.toString());
        return planRepository.findAllOwnPlan(principal.toString());
    }

    @GetMapping("/org-plan")
    List<Plan> allOrgPlan() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails principal = (UserDetails) auth.getPrincipal();
        LOGGER.info("プリンシパルの中身は？:::::" +principal.toString());

        return planRepository.findAllOwnPlan(principal.getUsername());
    }

    @PostMapping("/plan")
    void newPlan(@RequestBody Plan newPlan) {
        planRepository.createPlan(newPlan);
    }

}
