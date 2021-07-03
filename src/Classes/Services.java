/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Optional;
import javafx.util.Pair;

/**
 *
 * @author kianjun
 */
public class Services {
    protected Optional<Integer> year;
    protected Optional<Double> expenditure;
    
    public Services() {}
    
    public Services(Pair<String, String> pair) {
        this.year = Optional.of(Integer.parseInt(pair.getKey()));
        this.expenditure = Optional.of(Double.parseDouble(pair.getValue()));
    }

    public Integer getYear() {
        return year.get();
    }

    public void setYear(Optional<Integer> year) {
        this.year = year;
    }

    public Double getExpenditure() {
        return expenditure.get();
    }

    public void setExpenditure(Optional<Double> expenditure) {
        this.expenditure = expenditure;
    }
}
