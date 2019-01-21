package com.buutcamp.controller;

import com.buutcamp.database.DAOImplementor;
import com.buutcamp.emitents.Emitent;
import com.buutcamp.machine.Recommender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchPage {

    @Autowired
    private DAOImplementor daoImplementor;

    @Autowired
    private Recommender recommender;

    @GetMapping("/search")
    public String searchOrRecomPageGET(@ModelAttribute("emitent") Emitent emitent, Model model){
        return "search";
    }

    @PostMapping("/search-emitent")
    public String toSearchEmitent(@ModelAttribute("emitent") Emitent emitent,
                                  @RequestParam("searchValue") String searchVal, Model model){
        List<Emitent> emitentsList = daoImplementor.searchEmitent(searchVal);
        model.addAttribute("emitentsList", emitentsList);
        return "search";
    }

}
