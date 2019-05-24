package company.controller;

import company.dao.OfficeDao;
import company.hibernate.DepartmentEntity;
import company.hibernate.EmployeeDepartmentEntity;
import company.hibernate.EmployeeEntity;
import company.service.DepartmentService;
import company.service.EmployeeService;
import company.service.EmployeedepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeedepartmentService edeService;

    @Autowired
    OfficeDao oService;

    @RequestMapping(value = "/department/{id}", method = RequestMethod.GET)
    public String profilePage(ModelMap map, @PathVariable int id) {
        DepartmentEntity res = departmentService.findById(id);
        map.addAttribute("department", res);
        map.addAttribute("departments", departmentService.findByHead(res));
        List<EmployeeEntity> employee = employeeService.findByDepartment(res);
        map.addAttribute("employee", employee);
        return "department";
    }

    @RequestMapping(value = "/add_department_form")
    public ModelAndView addDepartmentForm(@RequestParam Integer headId) {
        try {
            ModelAndView modelAndView =  new ModelAndView("add_department_form");
            modelAndView.getModelMap().addAttribute("department", new DepartmentEntity());
            modelAndView.getModelMap().addAttribute("headId", headId);
            modelAndView.getModelMap().addAttribute("offices", oService.findAll());
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("redirect:main");
        }
    }

    @RequestMapping(value = "/add_department")
    public ModelAndView addDepartment(@ModelAttribute DepartmentEntity department,  @RequestParam Integer headId) {
        try {
            department.setOfficeByOfficeId(oService.findById(department.getTmpOfficeId()));
            department.setDepartmentByHeadId(departmentService.findById(headId));
            departmentService.save(department);
            return new ModelAndView("redirect:department/" + department.getId().toString());
        } catch (Exception e) {
            return new ModelAndView("redirect:department/" + headId.toString());
        }
    }

    @RequestMapping(value = "/delete_department")
    public ModelAndView deleteDepartment(@RequestParam Integer id) {
        try {
            ModelAndView modelAndView = new ModelAndView("redirect:department/");
            DepartmentEntity department = departmentService.findById(id);
            DepartmentEntity head = department.getDepartmentByHeadId();
            if (head == null || department.getId() == 1) {
                throw new Exception("Try to delete main head");
            }
            for (DepartmentEntity d: departmentService.findByHead(department)) {
                d.setDepartmentByHeadId(head);
                departmentService.update(d);
            }
            for (EmployeeDepartmentEntity ede: edeService.findByDepartment(department)) {
                edeService.delete(ede);
            }
            departmentService.delete(department);
            modelAndView.setViewName(modelAndView.getViewName() + head.getId().toString());
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("redirect:main");
        }
    }


}
