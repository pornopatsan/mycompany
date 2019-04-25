package company.controller;

import company.hibernate.PersonaldataEntity;
import company.service.PersonaldataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    PersonaldataService service;

    @RequestMapping(value = "/main")
    public String hello(ModelMap map) {
        List<PersonaldataEntity> list = service.findAll();
        map.addAttribute("list", list);
        return "index";
    }

    @RequestMapping(value = "/form")
    public ModelAndView registerFormShow() {
        ModelAndView modelAndView = new ModelAndView("form");
        modelAndView.getModelMap().addAttribute("newPersonaldata", new PersonaldataEntity());
        return modelAndView;
    }

    @RequestMapping(value = "/submit")
    public String registerSubmit(@ModelAttribute PersonaldataEntity newPersonaldataEntity) {
        service.save(newPersonaldataEntity);
        return "index";
    }
}
