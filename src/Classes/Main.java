/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import GUI.Home;
import Helpers.CSVReader;
import Helpers.PrologConnection;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javafx.util.Pair;
//import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author kianjun
 */
public class Main {

    public static DecimalFormat df = new DecimalFormat("#.##");

    static Map<String, Double> listServicesForTotal = new HashMap<>();

    //Lambda Function to find the higher
    static BiFunction<Double, Double, Integer> findHigher = (x, y) -> x > y ? 1 : -1;

    //Currying application to find the lower
    static Function<Double, Function<Double, Integer>> findLower = x -> y -> x < y ? 1 : -1;
    
    //To filter the same year or category
    static BiPredicate<Services, Integer> sameYear = (service, year) -> Objects.equals(service.getYear(), year);
    static BiPredicate<Services, Services> sameCategory = (listService, service) -> listService.getClass().isInstance(service);

    private static List<Services> listServices;
    
    //Currying application to get list of String grouping by year
    static Function<Integer, Function<List<? extends Services>, List<String>>> merge
            = year
            -> listExpenditure
            -> listExpenditure
                    .stream()
                    .filter(elem -> elem.getYear().equals(year))
                    .map(elem -> elem.getExpenditure())
                    .map(elem -> "RM " + numberWithCommas(elem))
                    .collect(Collectors.toList());
    
    private static String numberWithCommas(Double num) {
        NumberFormat myFormat = NumberFormat.getInstance();
        return myFormat.format(Double.parseDouble(df.format(num)));
    }

    //To get the list of Services
    public static List<Services> getListServices() {
        return listServices;
    }

    //To set the list of Services
    public static void setListServices(List<Services> listServices) {
        Main.listServices = listServices;
    }

    public static Map<String, Double> getListServicesForTotal() {
        return listServicesForTotal;
    }

    public static void setListServicesForTotal(Map<String, Double> listServicesForTotal) {
        Main.listServicesForTotal = listServicesForTotal;
    }

    //To get list of Services and grouping them based on the same year
    public static Map<Integer, List<String>> populateToTableModel(List<? extends Services> listServices) {
        List<Integer> years = IntStream.range(2005, 2019).boxed().collect(Collectors.toList());
        Map<Integer, List<String>> categoryByYear = new TreeMap<>();
        years.stream().forEach(year -> categoryByYear.put(year, Main.merge.apply(year).apply(listServices)));
        return categoryByYear;
    }

    public static Entry<String, Double> getHighestOrLowestByCategory(List<? extends Services> listServices, boolean high) {
        Map<String, Double> map = listServices
                .stream()
                .collect(groupingBy(elem -> elem.getClass().toString(), summingDouble(Services::getExpenditure)));
        if (high) {
            return map.entrySet().stream().max((entry1, entry2) -> Main.findHigher.apply(entry1.getValue(), entry2.getValue())).get();
        } else {
            return map.entrySet().stream().max((entry1, entry2) -> Main.findLower.apply(entry1.getValue()).apply(entry2.getValue())).get();
        }
    }
    public static String getString(String text) {
        return text.substring(14, text.length()).replaceAll("\\d+", "").replaceAll("(.)([A-Z])", "$1 $2");
    }
    public static Pair<String, Double> getCategoryAndExpenditureBasedOnYear(List<? extends Services> listServices, int year, String high) {
        Services s = listServices
                .stream()
                .filter(service -> Main.sameYear.test(service, year))
                .max((entry1, entry2) -> high.equals("High")
                ? Main.findHigher.apply(entry1.getExpenditure(), entry2.getExpenditure())
                : Main.findLower.apply(entry1.getExpenditure()).apply(entry2.getExpenditure())).get();
        return new Pair<>(getString(s.getClass().toString()), s.getExpenditure());
    }
    public static Entry<Integer, Double> getYearAndExpenditureByCategory(List<? extends Services> listServices, Services service, boolean high) {
        if (high) {
            return getHighestBasedOnCategory(
                    listServices
                            .stream()
                            .filter(services -> Main.sameCategory.test(services, service))
                            .collect(groupingBy(Services::getYear, summingDouble(Services::getExpenditure))));
        } else {
            return getLowestBasedOnCategory(
                    listServices
                            .stream()
                            .filter(services -> Main.sameCategory.test(services, service))
                            .collect(groupingBy(Services::getYear, summingDouble(Services::getExpenditure))));
        }
    }
    private static Entry<Integer, Double> getHighestBasedOnCategory(Map<Integer, Double> map) {
        return map
                .entrySet()
                .stream()
                .max((entry1, entry2) -> Main.findHigher.apply(entry1.getValue(), entry2.getValue()))
                .get();
    }
    private static Entry<Integer, Double> getLowestBasedOnCategory(Map<Integer, Double> map) {
        return map
                .entrySet()
                .stream()
                .max((entry1, entry2) -> Main.findLower.apply(entry1.getValue()).apply(entry2.getValue()))
                .get();

    }
    public static Entry<Integer, Double> getHighestOrLowestByYear(List<? extends Services> listServices, boolean high) {
        Map<Integer, Double> list = listServices.stream().collect(groupingBy(Services::getYear, summingDouble(Services::getExpenditure)));
        if (high) {
            return list.entrySet().stream().max((entry1, entry2) -> Main.findHigher.apply(entry1.getValue(), entry2.getValue())).get();
        } else {
            return list.entrySet().stream().max((entry1, entry2) -> Main.findLower.apply(entry1.getValue()).apply(entry2.getValue())).get();
        }
    }
    public static String calculateAverageBasedOnYear(List<? extends Services> listServices, int year) {
        return numberWithCommas(listServices
                                .stream()
                                .filter(obj -> Main.sameYear.test(obj, year))
                                .map(obj -> obj.getExpenditure())
                                .mapToDouble(Number::doubleValue)
                                .average()
                                .getAsDouble());
    }

    
    
    public static String calculateAverageBasedOnCategory(List<? extends Services> listServices, Services services) {
        return numberWithCommas(listServices
                                .stream()
                                .filter(obj -> Main.sameCategory.test(obj, services))
                                .map(obj -> obj.getExpenditure())
                                .mapToDouble(Number::doubleValue)
                                .average()
                                .getAsDouble());
    }

    
    
    public static List<String> FilterExpenditureByCategory(List<? extends Services> listServices, Services services, String order) {
        Comparator<Services> expenditureComparator = Comparator.comparing(Services::getExpenditure);
        if (order.equals("ori")) {
            return listServices
                    .stream()
                    .filter(obj -> Main.sameCategory.test(obj, services))
                    .map(elem -> {
                        String line = String.join("|", Integer.toString(elem.getYear()), numberWithCommas(elem.getExpenditure()));
                        return line;
                    })
                    .collect(Collectors.toList());
        }

        if (order.equals("Ascending")) {
            return listServices
                    .stream()
                    .filter(obj -> Main.sameCategory.test(obj, services))
                    .sorted(expenditureComparator)
                    .map(elem -> {
                        String line = String.join("|", Integer.toString(elem.getYear()), numberWithCommas(elem.getExpenditure()));
                        return line;
                    })
                    .collect(Collectors.toList());
        } else {
            return listServices
                    .stream()
                    .filter(obj -> Main.sameCategory.test(obj, services))
                    .sorted(expenditureComparator.reversed())
                    .map(elem -> {
                        String line = String.join("|", Integer.toString(elem.getYear()), numberWithCommas(elem.getExpenditure()));
                        return line;
                    })
                    .collect(Collectors.toList());
        }
    }
    
    
    
    public static String getTotalExpenditure(List <? extends Services> listServices, Services services) {
        return numberWithCommas(listServices
                            .stream()
                            .filter(listService -> Main.sameCategory.test(listService, services))
                            .map(listService -> listService.getExpenditure())
                            .mapToDouble(Number::doubleValue)
                            .reduce(0.0, (x, y) -> x + y));
    }

    public static Map<String, Double> listForCategory(List <? extends Services> listServices) {
        PrologConnection prologConnection = new PrologConnection("quicksortAsc.pl");
        //Declare all the services into a list for streaming later
        List<Services> service = Arrays.asList(ServicesFactory.getServices("Accommodation"),
                ServicesFactory.getServices("Food and Beverage"),
                ServicesFactory.getServices("Passenger Transport"),
                ServicesFactory.getServices("Travel Agencies and Other Reservation"),
                ServicesFactory.getServices("Cultural, Sports, and Recreational"),
                ServicesFactory.getServices("Country-Specific Tourism Characteristic Goods"),
                ServicesFactory.getServices("Country-Specific Tourism Characteristics")
        );
        
        //Create Map to place each of the record after getting the sum
        Map<String, Double> pairsOfCategory = new HashMap<>();
        //Create a List collection to convert the Map to List which maps to Prolog Sorting function
        List<String> listStringForCategory = new ArrayList();
        
        //Put all the data into the Map while calling Prolog to get Sum to calculate the total expenditure of each category
        service
                .stream()
                .forEach(category
                        -> pairsOfCategory.put(
                        getString(category.getClass().toString()),
                        prologConnection.sum(getAnnualExpenditureCategory(listServices, category).toString()))
                );
        
        //Put the record into a list of String, as the sort method in PrologConnection is accepting List<String>
        pairsOfCategory.entrySet().stream().forEach(pair -> listStringForCategory.add("('" + pair.getKey() + "', " + df.format(pair.getValue()) + ")"));
        //Return to the function while calling sort method in prolog connection for Sorting
        return prologConnection.sort(listStringForCategory);
    }
    
    public static Map<String, Double> listForYear(List <? extends Services> listServices) {
        PrologConnection prologConnection = new PrologConnection("quicksortAsc.pl");
        //Declare all the years into a list for streaming purpose
        List<Integer> years = Arrays.asList(2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018);
        //Create a Map to place each of the record after getting the sum
        Map<Integer, Double> pairsOfYear = new HashMap<>();
        //Create a List collection to convert the Map to List which maps to Prolog Sorting function
        List<String> listStringForYear = new ArrayList();
        years
                .stream()
                .forEach(year -> pairsOfYear.put(
                        year, 
                        prologConnection.sum(getAnnualExpenditureYear(listServices, year).toString()))
                );
        //Put the record into a list of String, as the sort method in PrologConnection is accepting List<String>
        pairsOfYear.entrySet().stream().forEach(pair -> listStringForYear.add("('" + pair.getKey() + "', " + df.format(pair.getValue()) + ")"));
        //Return to the function while calling sort method in prolog connection for Sorting
        return prologConnection.sort(listStringForYear);
    }

    private static List<Double> getAnnualExpenditureYear(List<? extends Services> listServices, int year) {
        return listServices
                .stream()
                .filter(service -> Main.sameYear.test(service, year))
                .map(service -> service.getExpenditure())
                .collect(Collectors.toList());
    }

    private static List<Double> getAnnualExpenditureCategory(List<? extends Services> listServices, Services services) {
        return listServices
                .stream()
                .filter(service -> Main.sameCategory.test(service, services))
                .map(service -> service.getExpenditure())
                .collect(Collectors.toList());
    }

    public static void totalAnnual(List<? extends Services> listServices, Services services, int year) {
        listServices
                .stream()
                .filter(service -> Main.sameCategory.test(service, services) && Main.sameYear.test(service, year))
                .map(service -> {
                    listServicesForTotal.put(getString(service.getClass().toString()), service.getExpenditure());
                    return listServicesForTotal;
                });
    }

    /**
     * Maybe can be used in the future
     */
//    public static Entry<String, Double> getHighestByCategory(List <? extends Services> listServices) {
//        Map<String, Double> map = listServices
//                                        .stream()
//                                        .collect(groupingBy(elem -> elem.getClass().toString(), summingDouble(Services::getExpenditure)));
//        return map.entrySet().stream().max((entry1, entry2) -> Main.findHigher.apply(entry1.getValue(), entry2.getValue())).get();
//    }
//    
//    public static Entry<String, Double> getLowestByCategory(List <? extends Services> listServices) {
//        Map<String, Double> map = listServices
//                                        .stream()
//                                        .collect(groupingBy(elem -> elem.getClass().toString(), summingDouble(Services::getExpenditure)));
//        return map.entrySet().stream().max((entry1, entry2) -> Main.findLower.apply(entry1.getValue()).apply(entry2.getValue())).get();
//    }
//    public static Pair<Integer, Double> getHighestByYear(List <? extends Services> listServices) {
//        //Categories all the year together by summing its expenditure into a Map
//        Map<Integer, Double> list = listServices.stream().collect(groupingBy(Services::getYear, summingDouble(Services::getExpenditure)));
//        //Stream the Map to find the entry of minimum expenditure
//        Entry<Integer, Double> highExpenditureEntry = list.entrySet().stream().max((entry1, entry2) -> Main.findHigher.apply(entry1.getValue(), entry2.getValue())).get();
//        //Make both value as a pair and return to method
//        return new Pair<>(highExpenditureEntry.getKey(), highExpenditureEntry.getValue());
//    }
//    
//    public static Pair<Integer, Double> getLowestByYear(List <? extends Services> listServices) {
//        //Categories all the year together by summing its expenditure into a Map
//        Map<Integer, Double> list = listServices.stream().collect(groupingBy(Services::getYear, summingDouble(Services::getExpenditure)));
//        //Stream the Map to find the entry of minimum expenditure
//        Entry<Integer, Double> lowExpenditureEntry = list.entrySet().stream().max((entry1, entry2) -> Main.findLower.apply(entry1.getValue()).apply(entry2.getValue())).get();
//        //Make both value as a pair and return to method
//        return new Pair<>(lowExpenditureEntry.getKey(), lowExpenditureEntry.getValue());
//    }
}
