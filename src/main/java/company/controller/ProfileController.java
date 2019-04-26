package company.controller;

import company.hibernate.EmployeeEntity;
import company.hibernate.EmployeejobsHistoryEntity;
import company.hibernate.PersonaldataEntity;
import company.service.EmployeeService;
import company.service.PersonaldataService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    EmployeeService service;

    @RequestMapping(value = "/profile",  method = RequestMethod.GET)
    public String profilePage(ModelMap map) {
        EmployeeEntity res = service.findById(1);
        map.addAttribute("employee", res);
        map.addAttribute("personaldata", res.getPersonaldataByPersonalId());

//        Hibernate.initialize(res.getEmployeejobsHistoriesById());
//        List<EmployeejobsHistoryEntity> jh = res.getEmployeejobsHistoriesById();
//        map.addAttribute("jobsHistory", jh);
        return "profile";
    }
}
