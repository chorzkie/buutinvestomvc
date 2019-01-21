package com.buutcamp.controller;

import com.buutcamp.database.DAOImplementor;
import com.buutcamp.emitents.Emitent;
import com.buutcamp.emitents.Fundamental;
import com.buutcamp.machine.Assessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UnitDetail {

    @Autowired
    private DAOImplementor daoImplementor;

    @Autowired
    private Assessor assessor;

    @GetMapping("/unit-detail")
    public String toGetDetailForm(@RequestParam("emitentId") int id, Model model){
        Emitent emitent = daoImplementor.getEmitent(id);
        Fundamental fundamental = emitent.getFundamental();
        model.addAttribute("emitent", emitent);
        model.addAttribute("fundamental", fundamental);
        model.addAttribute("recommendation",assessor.toAssess(emitent,fundamental));
        return "unit-detail";
    }

}
