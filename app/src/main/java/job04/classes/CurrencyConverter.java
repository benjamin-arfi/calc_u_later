package job04.classes;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CurrencyConverter {
    private static final String DEVISE_FILE = "src\\main\\java\\job04\\classes\\ressources\\devise.json";

    public static String[] readCurrency() {
        Map<String, Object> test = null;
        List<String> currencyCouple= new ArrayList<String>();
        try (FileReader reader = new FileReader(DEVISE_FILE)) {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            test = (Map<String, Object>) jsonObject;
            test.forEach((k, v) -> {
                    currencyCouple.add(k);
                });    
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        String[] currencyName = new String[currencyCouple.size()+1];
        currencyName[0]="doll";
        for (int i = 1; i < currencyCouple.size()+1; i++) {
            currencyName[i] = currencyCouple.get(i-1).substring(4);
        }
        return currencyName;
    }

    public static double getCurrencyValue(String from,String to) {
        Map<String, Object> test = null;
        List<Double> result= new ArrayList<Double>();
        try (FileReader reader = new FileReader(DEVISE_FILE)) {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            test = (Map<String, Object>) jsonObject;
            test.forEach((k, v) -> {
                    if(k.equals(from+to)){
                        result.add((double)v);
                    }else if(k.equals(to+from)){
                        result.add(1/((double)v));
                    }
                });    
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return result.get(0);
    }
    
}
