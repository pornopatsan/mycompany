package company.controller;

import company.hibernate.PersonaldataEntity;
import company.service.PersonaldataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
