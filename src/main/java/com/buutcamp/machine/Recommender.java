package com.buutcamp.machine;

import com.buutcamp.database.DAOImplementor;
import com.buutcamp.emitents.Emitent;
import com.buutcamp.emitents.GoodEmitents;
import com.buutcamp.emitents.TopRecommendedEmit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Recommender {

    public Recommender(){}

    @Autowired
    private DAOImplementor daoImplementor;

    List<Emitent> recEmitentList = new ArrayList<>();

    public void updateRecommendation() {

        recEmitentList = daoImplementor.listEmitent();

        List <TopRecommendedEmit> topRecommendedEmitent = new ArrayList<>();
        List <GoodEmitents> goodRecommendedEmitent = new ArrayList<>();

        for (int i = 0; i < recEmitentList.size(); i++) {
            float emitentROE = recEmitentList.get(i).getFundamental().getRoe();
            float emitentPBV = recEmitentList.get(i).getFundamental().getPbv();
            float emitentPER = recEmitentList.get(i).getFundamental().getPer();
            float emitentSales5 = recEmitentList.get(i).getFundamental().getSales5();
            float emitentEPS5 = recEmitentList.get(i).getFundamental().getEps5();

            if ((emitentROE >= 14.50) && (emitentPBV <= 4) && (emitentPER <= 15) && (emitentSales5 >= 2.50) && (emitentEPS5 >= 2.50)) {
                topRecommendedEmitent.add(new TopRecommendedEmit(recEmitentList.get(i).getEmitentName(),
                        recEmitentList.get(i).getEmitentFullName()));
            }
            else if ((emitentROE >= 10) && (emitentPBV <= 5) && (emitentPER <= 20) && (emitentSales5 >= 1.50) && (emitentEPS5 >= -1.50)) {
                goodRecommendedEmitent.add(new GoodEmitents(recEmitentList.get(i).getEmitentName(),
                        recEmitentList.get(i).getEmitentFullName()));
            }
        }

        for (int i = 0; i < topRecommendedEmitent.size(); i++) {
            daoImplementor.sqlAddTopEmitent(topRecommendedEmitent.get(i));
        }

        for (int i = 0; i < goodRecommendedEmitent.size(); i++) {
            daoImplementor.sqlAddGoodEmitent(goodRecommendedEmitent.get(i));
        }
    }


    List<TopRecommendedEmit> RecTopEmitentList = new ArrayList<>();

    public List<Emitent> getTopRecommendation() {

        RecTopEmitentList = daoImplementor.listTopRecomEmitent();

        List <Emitent> FinalTopEmitent = new ArrayList<>();

        for (int i = 0; i < RecTopEmitentList.size(); i++) {
            String ticker = RecTopEmitentList.get(i).getEmitentName();
            FinalTopEmitent.add(daoImplementor.getEmitentByTicker(ticker));
        }
        return FinalTopEmitent;
    }


    List<GoodEmitents> RecGoodEmitentList = new ArrayList<>();

    public List<Emitent> getGoodRecommendation() {

        RecGoodEmitentList = daoImplementor.listGoodRecomEmitent();

        List <Emitent> FinalGoodEmitent = new ArrayList<>();

        for (int i = 0; i < RecGoodEmitentList.size(); i++) {
            String ticker = RecGoodEmitentList.get(i).getEmitentName();
            FinalGoodEmitent.add(daoImplementor.getEmitentByTicker(ticker));
        }

        return FinalGoodEmitent;
    }

}
