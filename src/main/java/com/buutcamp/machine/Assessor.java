package com.buutcamp.machine;

import com.buutcamp.emitents.Emitent;
import com.buutcamp.emitents.Fundamental;
import org.springframework.stereotype.Service;

@Service
public class Assessor {
    public Assessor(){}

    public String toAssess(Emitent emitent, Fundamental fundamental){
        float emitentROE = fundamental.getRoe();
        float emitentPBV = fundamental.getPbv();
        float emitentPER = fundamental.getPer();
        float emitentSales5 = fundamental.getSales5();
        float emitentEPS5 = fundamental.getEps5();


        if((emitentROE >= 14.50) && (emitentPBV <= 4) && (emitentPER <= 15) && (emitentSales5 >= 2.50) && (emitentEPS5 >= 2.50)) {
            return "This company, " + emitent.getEmitentFullName() + " has really solid fundamental."
                    +"  Excellent. Strong Buy.";
        }
        else if((emitentROE >= 10) && (emitentPBV <= 5) && (emitentPER <= 20) && (emitentSales5 >= 1.50) && (emitentEPS5 >= -1.50)) {
            return "This company, " + emitent.getEmitentFullName() + " has good fundamental."
                    +"  Our recommendation for this stock is to Buy.";
        }
        else if((emitentROE >= 5) && (emitentPBV <= 6) && (emitentPER <= 25) && (emitentSales5 >= 2.50) && (emitentEPS5 >= -5)) {
            return "This company, " + emitent.getEmitentFullName() + " has quite decent fundamental."
                    +"  Our preference for this stock is Neutral.";
        }
        else {
            return "The fundamental of this company, " + emitent.getEmitentFullName() + " is not good enough."
                    +"  Our preference for this stock is to Sell.";
        }
    }
}
