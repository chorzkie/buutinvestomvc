package com.buutcamp.machine;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DataFetcher {

    public DataFetcher(){}

    public List<Object> URLReader(String urlpath) throws IOException {
        List emitentData = new ArrayList();
        String inputLine;
        BufferedReader br;
        boolean ROEtoggle = false;
        boolean PBVtoggle = false;
        boolean PERtoggle = false;
        boolean Sales5toggle = false;
        boolean EPS5toggle = false;


        URL url = new URL(urlpath);
        URLConnection urlConnection = url.openConnection();
        InputStreamReader isr = new InputStreamReader(urlConnection.getInputStream());
        br = new BufferedReader(isr);
        br.mark(230000);

        while ((inputLine = br.readLine()) != null) {

            Pattern titleSearch = Pattern.compile("<title>");
            Matcher titleMatch = titleSearch.matcher(inputLine);
            if (titleMatch.find()) {
                String[] tempTitle = inputLine.split("Tbk");
                String[] tempTitle1 = tempTitle[0].split(">");
                emitentData.add(tempTitle1[1].trim());
            }

            Pattern ROEsearch = Pattern.compile("Return\\son\\sEquity\\s\\WT");
            Matcher ROEmatch = ROEsearch.matcher(inputLine);
            String temp;
            if (ROEtoggle) {
                String[] temp0 = inputLine.split(">");
                String[] temp1 = temp0[1].split("<");
                String[] temp2 = temp1[0].split(",");

                if (temp2.length == 2 ) {
                    temp = temp2[0] + temp2[1];
                }
                else temp = temp2[0];

                if (temp.equals("--")){
                    emitentData.add(0); }
                else {
                    emitentData.add(temp);  }
                ROEtoggle = false;
            }
            if (ROEmatch.find()) {
                ROEtoggle = true;
            }
        }
        br.reset();

        while ((inputLine = br.readLine()) != null) {

            Pattern PBVsearch = Pattern.compile("Price\\sto\\sBook\\s\\WM");
            Matcher PBVmatch = PBVsearch.matcher(inputLine);
            String temp;
            if (PBVtoggle) {
                String[] temp0 = inputLine.split(">");
                String[] temp1 = temp0[1].split("<");
                String[] temp2 = temp1[0].split(",");

                if (temp2.length == 2 ) {
                    temp = temp2[0] + temp2[1];
                }
                else temp = temp2[0];

                if (temp.equals("--")){
                    emitentData.add(0); }
                else {
                    emitentData.add(temp);  }
                PBVtoggle = false;
            }
            if (PBVmatch.find()) {
                PBVtoggle = true;
            }
        }
        br.reset();

        while ((inputLine = br.readLine()) != null) {

            Pattern PERsearch = Pattern.compile("P\\WE\\sRatio\\s\\WT");
            Matcher PERmatch = PERsearch.matcher(inputLine);
            String temp;
            if (PERtoggle) {
                System.out.println(inputLine);
                String[] temp0 = inputLine.split(">");
                String[] temp1 = temp0[1].split("<");
                String[] temp2 = temp1[0].split(",");

                if (temp2.length == 2 ) {
                    temp = temp2[0] + temp2[1];
                }
                else temp = temp2[0];

                if (temp.equals("--")){
                    emitentData.add(0); }
                else {
                    emitentData.add(temp);  }
                PERtoggle = false;
            }
            if (PERmatch.find()) {
                PERtoggle = true;
            }
        }
        br.reset();

        while ((inputLine = br.readLine()) != null) {

            Pattern Sales5search = Pattern.compile("Sales\\s\\W\\s");
            Matcher Sales5match = Sales5search.matcher(inputLine);
            String temp;
            if (Sales5toggle) {
                String[] temp0 = inputLine.split(">");
                String[] temp1 = temp0[1].split("<");
                String[] temp2 = temp1[0].split(",");

                if (temp2.length == 2 ) {
                    temp = temp2[0] + temp2[1];
                }
                else temp = temp2[0];

                if (temp.equals("--")){
                    emitentData.add(0); }
                else {
                    emitentData.add(temp);  }
                Sales5toggle = false;
            }
            if (Sales5match.find()) {
                Sales5toggle = true;
            }
        }
        br.reset();

        while ((inputLine = br.readLine()) != null) {

            Pattern EPS5search = Pattern.compile("EPS\\s\\W\\s");
            Matcher EPS5match = EPS5search.matcher(inputLine);
            String temp;
            if (EPS5toggle) {
                String[] temp0 = inputLine.split(">");
                String[] temp1 = temp0[1].split("<");
                String[] temp2 = temp1[0].split(",");

                if (temp2.length == 2 ) {
                    temp = temp2[0] + temp2[1];
                }
                else temp = temp2[0];

                if (temp.equals("--")){
                    emitentData.add(0); }
                else {
                    emitentData.add(temp);  }
                EPS5toggle = false;
            }
            if (EPS5match.find()) {
                EPS5toggle = true;
            }
        }
        br.close();
        return emitentData;
    }
}
