package services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PaymentFinder {
    public static boolean findPayment(String userName){
        //TODO
        JSONParser parser = new JSONParser();
        Boolean paid = false;
        try{
            File file = new File("");
            String path = file.getAbsolutePath() + File.separator + "files" + File.separator + "Payments.json";
            System.out.println("Se buscan Pagos en: " + path);

            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(path));
            for(Object jsonEntry : jsonArray){
                JSONObject person = (JSONObject) jsonEntry;

                if(person.get("username").toString().equals(userName)){
                    paid = (Boolean) person.get("payment");
                }
            }

        } catch (IOException | ParseException e) {
            System.out.println("error al obtener pagos: " + e.getMessage());
        }
        return paid;
    }
}