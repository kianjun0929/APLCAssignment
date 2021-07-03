/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Classes.Main;
import Classes.Services;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jpl7.Query;
import org.jpl7.Term;

/**
 *
 * @author Kian Jun
 */
public class PrologConnection {

    String filePath;

    //A constructor to assign the file path retrieved.
    public PrologConnection(String filePath) {
        this.filePath = filePath;
        try {
            consult();
        } catch (Exception e) {
        }
    }

    //A function to check if the connection to the prolog file succeeded or not.
    private void consult() throws Exception {
        //Create a query based on the given file path enclosed with single quota which to follow Prolog's syntax
        Query connectionQuery = new Query("consult('" + this.filePath + "')");
        //If the connection is detected no suitable solution
        if (!connectionQuery.hasSolution()) {
            //Throws an exception to the method
            throw new Exception("The connection to the prolog file has failed.");
        }
        //Otherwise, close the Query connection
        connectionQuery.close();
    }

    public double sum(String record) {
        Term term = new Query(sumQuery(record)).oneSolution().get("Total");
        return term.doubleValue();
    }
    
    private String sumQuery(String record) {
        return "addup(" + record + ", Total).";
    }
    
    public Map<String, Double> sort(List<String> record) {
        Term term = new Query(generateQuery(record)).oneSolution().get("SortedCategory");
        return convert(term, new LinkedHashMap<>());
    }
    
    private String generateQuery(List<String> record) {
        return "quickSort(" + record.toString() + ", SortedCategory).";
    }

    //A function to convert the retrieved data from prolog to java data map.
    private Map<String, Double> convert(Term term, Map<String, Double> unformattedExpenditureAndYear) {
        Map<String, Double> formattedExpenditureAndYear = new LinkedHashMap<>(unformattedExpenditureAndYear);
        //Put the variable from term into the Map placeholder
        formattedExpenditureAndYear.put(term.arg(1).arg(1).toString().replace("'", ""), term.arg(1).arg(2).doubleValue());
        //Recursively call the convert method function to map the value into the Map placeholder and return
        return (term.arg(2).arity() == 0) ? formattedExpenditureAndYear : convert(term.arg(2), formattedExpenditureAndYear);
    }
}
