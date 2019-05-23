package company.controller;

import company.hibernate.EmployeeEntity;
import company.hibernate.PersonaldataEntity;
import company.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    PersonaldataService personaldataService;

    @Autowired
    OfficeService officeService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    JobService jobService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainPage(ModelMap map) {
        map.addAttribute("persons", personaldataService.findAll());
        map.addAttribute("employee", employeeService.findAll());
        map.addAttribute("offices", officeService.findAll());
        map.addAttribute("departments", departmentService.findAll());
        map.addAttribute("presidents", getPresidents(employeeService.findAll()));
        return "index";
    }

    public List<EmployeeEntity> getPresidents(List<EmployeeEntity> entityList){
        List<EmployeeEntity> result = new LinkedList<EmployeeEntity>(entityList);
        result.removeIf(x -> !x.getJobsByJobId().getFunction().equals("President"));
        return result;
    }

}
