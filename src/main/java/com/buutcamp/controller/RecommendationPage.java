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
public class RecommendationPage {

    @Autowired
    private DAOImplementor daoImplementor;

    @Autowired
    private Recommender recommender;

    @PostMapping("/get-recommendation")
    public String toGetRecommendation(@ModelAttribute("emitent") Emitent emitent, Model model){
        List<Emitent> topEmitentsList = recommender.getTopRecommendation();
        model.addAttribute("topEmitentsList" , topEmitentsList);
        List<Emitent> goodEmitentsList = recommender.getGoodRecommendation();
        model.addAttribute("goodEmitentsList" , goodEmitentsList);
        return "recommendation";
    }

}
