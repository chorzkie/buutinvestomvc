package com.buutcamp.controller;

import com.buutcamp.database.DAOImplementor;
import com.buutcamp.emitents.Emitent;
import com.buutcamp.emitents.Fundamental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Update {

    @Autowired
    private DAOImplementor daoImplementor;

    @GetMapping("/get-update-form")
    public String toGetDetailForm(@RequestParam("emitentId") int id, Model model){
        Emitent emitent = daoImplementor.getEmitent(id);
        Fundamental fundamental = emitent.getFundamental();
        model.addAttribute("emitent", emitent);
        model.addAttribute("fundamental", fundamental);
        return "update";
    }

    @PostMapping("/updateEmitent")
    public String toUpdateEmitent(@ModelAttribute("emitent") Emitent emitent, Model model){
        //model.addAttribute("fundamental", fundamental);
        daoImplementor.sqlUpdateEmitent(emitent);
        return "update";
    }

    @PostMapping("/deleteEmitent")
    public String toDeleteEmitent(@ModelAttribute("emitent") Emitent emitent,
                                  @RequestParam("delete") int id, Model model){
        daoImplementor.delEmitent(id);
        return "management";
    }
}
