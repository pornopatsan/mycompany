package company.controller;

import company.dao.JobsDao;
import company.hibernate.EmployeeEntity;
import company.hibernate.EmployeejobsHistoryEntity;
import company.hibernate.JobsEntity;
import company.hibernate.PersonaldataEntity;
import company.service.*;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.PersistenceException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    EmployeeService service;

    @Autowired
    PersonaldataService pService;

    @Autowired
    JobService jService;

    @Autowired
    DepartmentService dService;

    @Autowired
    EmployeeJobsHistoryService ejhService;

    @RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
    public String profilePage(ModelMap map, @PathVariable int id) {
        try {
            EmployeeEntity res = service.findById(id);
            map.addAttribute("employee", res);
            map.addAttribute("personaldata", res.getPersonaldataByPersonalId());

            List<EmployeejobsHistoryEntity> jh = res.getEmployeejobsHistoriesById();
            map.addAttribute("jobsHistory", jh);
            return "profile";
        } catch (Exception e) {
            return "redirect:/company/main";
        }
    }

    @RequestMapping(value = "/profile_update_form")
    public ModelAndView updateProfilePage(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("profile_update_form");
        modelAndView.getModelMap().addAttribute("personalData", pService.findById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/profile_update")
    public ModelAndView updateProfilePage(@ModelAttribute PersonaldataEntity personaldataInput) {
        try {
            PersonaldataEntity personaldata = pService.findById(personaldataInput.getId());

            personaldata.setFirstName(personaldataInput.getFirstName());
            personaldata.setLastName(personaldataInput.getLastName());
            personaldata.setAddress(personaldataInput.getAddress());
            personaldata.setEmail(personaldataInput.getEmail());
            personaldata.setPhone(personaldataInput.getPhone());
            personaldata.setEducation(personaldataInput.getEducation());
            personaldata.setSelfDescription(personaldataInput.getSelfDescription());
            pService.update(personaldata);

            return new ModelAndView("redirect:profile/" + personaldata.getEmployeesById().get(0).getId().toString());
        } catch (PersistenceException e) {
            return new ModelAndView("redirect:main");
        }
    }

    @RequestMapping(value = "/employee_promote_form")
    public ModelAndView promoteEmployeeForm(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("employee_promote_form");
        modelAndView.getModelMap().addAttribute("employee", service.findById(id));
        modelAndView.getModelMap().addAttribute("jobsList", jService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/employee_promote")
    public ModelAndView promoteEmployee(@ModelAttribute EmployeeEntity employeeInput) {
        try {
            EmployeeEntity employee = service.findById(employeeInput.getId());
            Date date = new Date(Calendar.getInstance().getTime().getTime());

            EmployeejobsHistoryEntity newEjhEntity = new EmployeejobsHistoryEntity();
            newEjhEntity.setSalary(employee.getSalary());
            newEjhEntity.setEmployeeByEmployeeId(employee);
            newEjhEntity.setJobsByJobId(employee.getJobsByJobId());
            newEjhEntity.setAppointment(employee.getHireDate());
            newEjhEntity.setRemoval(date);
            ejhService.save(newEjhEntity);

            employee.setHireDate(date);
            employee.setJobsByJobId(jService.findById(employeeInput.getTmpJobId()));
            employee.setSalary(employeeInput.getSalary());
            service.update(employee);

            return new ModelAndView("redirect:profile/" + employee.getId().toString());
        } catch (Exception e) {
            return new ModelAndView("redirect:main");
        }
    }

    @RequestMapping(value = "/new_employee_form")
    public ModelAndView addNewEmployeeForm() {
        ModelAndView modelAndView = new ModelAndView("new_employee_form");
        modelAndView.getModelMap().addAttribute("personaldata", new PersonaldataEntity());
        return modelAndView;
    }

    @RequestMapping(value = "/new_employee_personaldata")
    public ModelAndView addNewEmployee(@ModelAttribute PersonaldataEntity personaldataInput) {
        try {
            PersonaldataEntity personaldata = new PersonaldataEntity();
            personaldata.setFirstName(personaldataInput.getFirstName());
            personaldata.setLastName(personaldataInput.getLastName());
            personaldata.setAddress(personaldataInput.getAddress());
            personaldata.setEmail(personaldataInput.getEmail());
            personaldata.setPhone(personaldataInput.getPhone());
            personaldata.setEducation(personaldataInput.getEducation());
            personaldata.setSelfDescription(personaldataInput.getSelfDescription());
            pService.save(personaldata);

            EmployeeEntity newEmployee = new EmployeeEntity();
            newEmployee.setTmpPersonalId(personaldata.getId());

            ModelAndView modelAndView = new ModelAndView("new_employee_personaldata_form");
            modelAndView.getModelMap().addAttribute("employee", newEmployee);
            modelAndView.getModelMap().addAttribute("jobsList", jService.findAll());
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("redirect:main");
        }
    }

    @RequestMapping(value = "/new_employee")
    public ModelAndView addNewEmployee(@ModelAttribute EmployeeEntity employeeInput) {
        try {
            EmployeeEntity employee = new EmployeeEntity();
            employee.setHireDate(new Date(Calendar.getInstance().getTime().getTime()));
            employee.setJobsByJobId(jService.findById(employeeInput.getTmpJobId()));
            employee.setPersonaldataByPersonalId(pService.findById(employeeInput.getTmpPersonalId()));
            service.save(employee);
            return new ModelAndView("redirect:profile/" + employee.getId().toString());
        } catch (Exception e) {
            return new ModelAndView("redirect:main");
        }
    }
}
