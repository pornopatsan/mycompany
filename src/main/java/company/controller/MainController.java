package company.controller;

import company.hibernate.PersonaldataEntity;
import company.service.EmployeeService;
import company.service.OfficeService;
import company.service.PersonaldataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    PersonaldataService personaldataService;

    @Autowired
    OfficeService officeService;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainPage(ModelMap map) {
        map.addAttribute("persons", personaldataService.findAll());
        map.addAttribute("employee", employeeService.findAll());
        map.addAttribute("offices", officeService.findAll());
        return "index";
    }

//    @RequestMapping(value = "/main", method = RequestMethod.POST)
//    public ModelAndView registerRedirect(ModelMap map) {
//        return new ModelAndView("redirect:register");
//    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView registerFormShow() {
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.getModelMap().addAttribute("newPersonaldata", new PersonaldataEntity());
        return modelAndView;
    }

    @RequestMapping(value = "/registersubmit", method = RequestMethod.POST)
    public ModelAndView registerSubmit(@ModelAttribute PersonaldataEntity newPersonaldataEntity) {
        try {
            if (newPersonaldataEntity.getFirstName().length() < 1) {
                throw new Exception();
            }
            if (newPersonaldataEntity.getLastName().length() < 1) {
                throw new Exception();
            }
            personaldataService.save(newPersonaldataEntity);
            return new ModelAndView("redirect:main");
        } catch (Exception ex) {
            return new ModelAndView("redirect:register");
        }

    }
}
