package company.controller;

import company.hibernate.DepartmentEntity;
import company.hibernate.EmployeeDepartmentEntity;
import company.hibernate.EmployeeEntity;
import company.service.DepartmentService;
import org.dom4j.bean.BeanAttributeList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/department/{id}", method = RequestMethod.GET)
    public String profilePage(ModelMap map, @PathVariable int id) {
        DepartmentEntity res = departmentService.findById(id);
        map.addAttribute("department", res);
        map.addAttribute("departments", res.getDepartmentsById());
        List<EmployeeDepartmentEntity> employeeDepartmentEntities = res.getEmployeeDepartmentsById();
        map.addAttribute("curDepartmentEmployee", getUniqueEmployee(employeeDepartmentEntities));
        return "department";
    }

    private List<EmployeeEntity> getUniqueEmployee(List<EmployeeDepartmentEntity> ed) {
        HashSet<EmployeeEntity> set = new HashSet<EmployeeEntity>();
        for(EmployeeDepartmentEntity i : ed) {
            set.add(i.getEmployeeByEmployeeId());
        }
        return new LinkedList<EmployeeEntity>(set);
    }
}
