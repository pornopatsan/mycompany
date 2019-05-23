package company.controller;

import company.hibernate.EmployeeDepartmentEntity;
import company.hibernate.EmployeeEntity;
import company.service.DepartmentService;
import company.service.EmployeeService;
import company.service.EmployeedepartmentService;
import company.utils.SearchParamsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Controller
public class EmployeeSearchController {

    @Autowired
    EmployeeService service;

    @Autowired
    EmployeedepartmentService edeService;

    @Autowired
    DepartmentService dService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView searchEmployee() {
        try {
            ModelAndView modelAndView = new ModelAndView("search");
            modelAndView.getModelMap().addAttribute("params", new SearchParamsBean());
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("redirect:main");
        }
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView searchResultsCompile(@ModelAttribute SearchParamsBean params) {
        try {
            ModelAndView modelAndView = new ModelAndView("redirect:search_results?");
            modelAndView.setViewName(modelAndView.getViewName() + "&id=" + params.getId().toString());
            modelAndView.setViewName(modelAndView.getViewName() + "&jobId=" + params.getJobId().toString());
            modelAndView.setViewName(modelAndView.getViewName() + "&departmentId=" + params.getDepartmentId().toString());
            modelAndView.setViewName(modelAndView.getViewName() + "&salaryDownLimit=" + params.getSalaryDownLimit().toString());
            modelAndView.setViewName(modelAndView.getViewName() + "&salaryUpLimit=" + params.getSalaryUpLimit().toString());
            modelAndView.setViewName(modelAndView.getViewName() + "&firstName=" + params.getFirstName());
            modelAndView.setViewName(modelAndView.getViewName() + "&lastName=" + params.getLastName());
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("redirect:main");
        }
    }

    @RequestMapping(value = "/search_results", method = RequestMethod.GET)
    public ModelAndView searchResults(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) Integer jobId,
            @RequestParam(required = false) Integer departmentId,
            @RequestParam(required = false) Double salaryDownLimit,
            @RequestParam(required = false) Double salaryUpLimit,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName
    ) {
        Set<EmployeeEntity> result = new HashSet<EmployeeEntity>(service.findAll());
        do {
            if (id != null && id != -1) {
                result.removeIf(x -> !Objects.equals(x.getId(), id));
                break;
            }
            if (jobId != null && jobId != -1) {
                result.removeIf(x -> !Objects.equals(x.getJobsByJobId().getId(), jobId));
            }
            if (departmentId != null && departmentId != -1) {
                List<EmployeeDepartmentEntity> byDepartment = edeService.findByDepartment(dService.findById(departmentId));
                Set<EmployeeEntity> tmpRes = new HashSet<>();
                for (EmployeeDepartmentEntity ede : byDepartment) {
                    for (EmployeeEntity e: result) {
                        if (e.getId() == ede.getEmployeeByEmployeeId().getId()) {
                            tmpRes.add(ede.getEmployeeByEmployeeId());
                        }
                    }
                }
                result = tmpRes;
            }

            if (salaryDownLimit != null && salaryDownLimit > 0.0) {
                result.removeIf(x -> x.getSalary() < salaryDownLimit);
            }
            if (salaryUpLimit != null && salaryUpLimit < 999999.0) {
                result.removeIf(x -> x.getSalary() > salaryUpLimit);
            }

            if (firstName != null && !firstName.equals("")) {
                result.removeIf(x -> !x.getPersonaldataByPersonalId().getFirstName().equals(firstName));
            }
            if (lastName != null && !lastName.equals("")) {
                result.removeIf(x -> !x.getPersonaldataByPersonalId().getLastName().equals(lastName));
            }
        } while (false);

        ModelAndView modelAndView = new ModelAndView("search_results");
        modelAndView.getModelMap().addAttribute("resList", result);
        return modelAndView;
    }
}
