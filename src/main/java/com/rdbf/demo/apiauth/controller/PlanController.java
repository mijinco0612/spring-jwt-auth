package com.rdbf.demo.apiauth.controller;

import com.rdbf.demo.apiauth.controller.form.UserForm;
import com.rdbf.demo.apiauth.domain.Plan;
import com.rdbf.demo.apiauth.repository.PlanRepository;
import com.rdbf.demo.apiauth.service.SampleService;
import com.rdbf.demo.apiauth.support.SecurityConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PlanController {

    private final PlanRepository repository;

    PlanController(PlanRepository repository){
        this.repository = repository;
    }

    @GetMapping("/top")
    List<Plan> all() {
        return repository.findAll();
    }

    @PostMapping("/top")
    Plan newPlan(@RequestBody Plan newPlan) {
        return repository.save(newPlan);
    }

}
