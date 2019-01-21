package com.buutcamp.machine;

import com.buutcamp.database.DAOImplementor;
import com.buutcamp.emitents.Emitent;
import com.buutcamp.emitents.Fundamental;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmitentInputProcess {

    public EmitentInputProcess(){}

    @Autowired
    private DAOImplementor daoImplementor;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private DataFetcher dataFetcher;

    public void addEmitent(String ticker, String urlpath) {
        List<Object> emitentData = new ArrayList<>();
        try {
            emitentData = dataFetcher.URLReader(urlpath);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        String emitentFullName = emitentData.get(0).toString();

        float emitentRoe = Float.valueOf(emitentData.get(1).toString());

        float emitentPbv = Float.valueOf(emitentData.get(2).toString());

        float emitentPer = Float.valueOf(emitentData.get(3).toString());

        float emitentSales5 = Float.valueOf(emitentData.get(4).toString());

        float emitentEps5 = Float.valueOf(emitentData.get(5).toString());

        Boolean emitentChecker = daoImplementor.checkExistingEmitentByTicker(ticker);

        if (emitentChecker) {
            Fundamental fundamental = new Fundamental(emitentRoe, emitentPbv, emitentPer, emitentSales5, emitentEps5);
            Emitent emitent = new Emitent(ticker, urlpath, emitentFullName, fundamental);

            daoImplementor.sqlAddEmitent(emitent);
        }
    }

    public void updateEmitent(Emitent emitent) {
        String urlpath = emitent.getEmitentURL();
        List<Object> emitentData = new ArrayList<>();
        try {
            emitentData = dataFetcher.URLReader(urlpath);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        String emitentFullName = emitentData.get(0).toString();

        float emitentRoe = Float.valueOf(emitentData.get(1).toString());

        float emitentPbv = Float.valueOf(emitentData.get(2).toString());

        float emitentPer = Float.valueOf(emitentData.get(3).toString());

        float emitentSales5 = Float.valueOf(emitentData.get(4).toString());

        float emitentEps5 = Float.valueOf(emitentData.get(5).toString());

        emitent.setEmitentFullName(emitentFullName);
        emitent.getFundamental().setRoe(emitentRoe);
        emitent.getFundamental().setPbv(emitentPbv);
        emitent.getFundamental().setPer(emitentPer);
        emitent.getFundamental().setSales5(emitentSales5);
        emitent.getFundamental().setEps5(emitentEps5);

        daoImplementor.sqlUpdateEmitent(emitent);
    }
}
