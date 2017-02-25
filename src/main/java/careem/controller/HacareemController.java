package careem.controller;

import careem.DataLayer.DatabaseConnection;
import careem.DataLayer.Partner;
import careem.DataLayer.Shipment;

import careem.Utils.Utils;
import careem.processor.Processor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by bhara on 07-03-2016.
 */
@RestController
@EnableAutoConfiguration
public class HacareemController {

    public Processor processor;

    @PostConstruct
    public void initIt() throws Exception {
       processor = new Processor();
    }

    @RequestMapping(value = "/api/add/get/url/{test}/test", method = RequestMethod.GET)
    @ResponseBody
    public String teast(@PathVariable String test){
        return "Hello";
    }

    //The values will be seperated by $
    @RequestMapping(value = "/api/add/partner", method = RequestMethod.POST)
    @ResponseBody
    public void addPartner(@RequestBody String partner){
        Partner partnerObject = getPartner(partner);
        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.addPartner(partnerObject);

    }

    @RequestMapping(value = "/api/remove/{name}/partner", method = RequestMethod.DELETE)
    @ResponseBody
    public void removePartner(@PathVariable String name){
        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.removePartner(name);
    }
    
    @RequestMapping(value = "/api/add/shipment", method = RequestMethod.POST)
    @ResponseBody
    public String addShipment(@RequestBody String shipment){
    	Shipment shipmentObject = getShipment(shipment);
        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.addShipment(shipmentObject);

        LinkedList<String> hubs = Utils.getHubs();
        int shortest = Integer.MAX_VALUE;
        String bestHub =null ;
        for(String hub : hubs){
            int getPartner = processor.getBestPartner(Utils.getMapppedValue(shipmentObject.getPickupAddress()),
                   Utils.getMapppedValue(shipmentObject.getDeliveryAddress()));
            if(shortest > getPartner){
               bestHub = Utils.getPartnerName(hub);
                shortest = getPartner;
            }
        }
        if(bestHub == null){
            return " NO Best match found";
        }
        else{
            int rate = databaseConnection.getRateForPartner(bestHub);
            int cost = rate * shipmentObject.getQuantity();

            return "Quotation : Partner " + bestHub + "  will be cost effective to delivery shipment at a total cost of " +
                    cost ;
        }
    }

    public Partner getPartner(String partner){
        String[] values = partner.split(",");

        String name = values[0];
        String transportType = values[1];
        int quantity = Integer.parseInt(values[2]);
        int cost = Integer.parseInt(values[3]);
        String outCitySupport = values[4];
        String location = values[5];
        Partner partnerObject = new Partner(name,transportType,quantity,cost,outCitySupport,location);

        return partnerObject;
    }
    
    public Shipment getShipment(String partner){
        String[] values = partner.split(",");

        String name = values[0];
        String Pickup_address = values[1];
        String Delivery_address = values[2];
        String Shipment_type = values[3];
        String Request_date = values[4];
        int quantity = Integer.parseInt(values[5]);
        Shipment shipmentObject = new Shipment(name,Pickup_address,Delivery_address,Shipment_type,Request_date,quantity);

        return shipmentObject;
    }



}
