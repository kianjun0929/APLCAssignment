/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author kianjun
 */
public class ServicesFactory {
    public static Services getServices(String services) {
        if(services.equals("Accommodation"))
            return new Accommodation();
        if(services.equals("Food and Beverage"))
            return new FoodAndBeverage();
        if(services.equals("Passenger Transport"))
            return new PassengerTransport();
        if(services.equals("Travel Agencies and Other Reservation"))
            return new TravelAgenciesAndOtherReservation();
        if(services.equals("Cultural, Sports, and Recreational"))
            return new CulturalSportsAndRecreational();
        if(services.equals("Country-Specific Tourism Characteristic Goods"))
            return new CountrySpecificTourismCharacteristicGoods();
        if(services.equals("Country-Specific Tourism Characteristics"))
            return new CountrySpecificTourismCharacteristics();
        return null;
    }
}
