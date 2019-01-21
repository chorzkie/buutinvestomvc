package com.buutcamp.controller;

import com.buutcamp.database.DAOImplementor;
import com.buutcamp.emitents.Emitent;
import com.buutcamp.emitents.GoodEmitents;
import com.buutcamp.emitents.TopRecommendedEmit;
import com.buutcamp.machine.EmitentInputProcess;
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
public class Management {

    @Autowired
    private DAOImplementor daoImplementor;

    @Autowired
    private EmitentInputProcess emitentInputProcess;

    @Autowired
    private Recommender recommender;

    @GetMapping("/")
    public String managementPageGET(Model model){
        Emitent emitent = new Emitent();
        model.addAttribute("emitent", emitent);
        return "management";
    }

    @PostMapping("/add-emitent")
    public String toSearchEmitent(@ModelAttribute("emitent") Emitent emitent, Model model){
        //EmitentInputProcess emitentInputProcess = new EmitentInputProcess();
        emitentInputProcess.addEmitent(emitent.getEmitentName(),emitent.getEmitentURL());
        return "management";
    }

    @PostMapping("/search-manage-emitent")
    public String toSearchEmitent(@ModelAttribute("emitent") Emitent emitent,
                                  @RequestParam("searchValue") String searchVal, Model model){
        List<Emitent> emitentsList = daoImplementor.searchEmitent(searchVal);
        model.addAttribute("emitentsList", emitentsList);
        return "management";
    }

    @GetMapping("/update-all-emitent")
    public String toUpdateAllEmitent(@ModelAttribute("emitent") Emitent emitent, Model model){
        List<Emitent> emitentsList = daoImplementor.listEmitent();
        for (int i=0; i < emitentsList.size(); i++){
            emitentInputProcess.updateEmitent(emitentsList.get(i));
        }
        return "management";
    }

    @GetMapping("/update-all-recommendation")
    public String toUpdateAllRecommendation(@ModelAttribute("emitent") Emitent emitent, Model model){
        daoImplementor.sqlAddTopEmitent(new TopRecommendedEmit("Updating data..","Updating data.."));
        daoImplementor.sqlAddGoodEmitent(new GoodEmitents("Updating data..","Updating data.."));
        daoImplementor.delTopRecom();
        daoImplementor.delGoodRecom();
        recommender.updateRecommendation();
        return "management";
    }

    @GetMapping("/list-emitent")
    public String toListAllEmitent(@ModelAttribute("emitent") Emitent emitent, Model model){
        List<Emitent> emitentsList = daoImplementor.listEmitent();
        model.addAttribute("emitentsList" , emitentsList);
        return "management";
    }


}
