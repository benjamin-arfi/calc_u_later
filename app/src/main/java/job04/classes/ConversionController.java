package job04.classes;

import javafx.scene.control.TextField;

public class ConversionController {
    private static double operand1;

	
	public static void ResetActualNumber(TextField displayField) {
		displayField.clear();
	}
	
	
	
	// Méthode pour effectuer le calcul et afficher le résultat
	public static void calculateResult(TextField displayField,TextField resultField,String from,String to) {
        operand1 = Double.parseDouble(displayField.getText());
        double result = Double.parseDouble(displayField.getText());
        switch(from){
            case "Kilogrammes":
                switch(to){
                    case "Grammes":
                    result = Math.round((operand1*1000.0)*1000.0)/1000.0;
                    break;
                    case "Onces":
                    result = Math.round((operand1*28.349523*1000.00)*1000.0)/1000.0;
                    break; 
                    case "Livres":
                    result = Math.round((operand1/0.45359237)*1000.0)/1000.0;
                    break;
                }
                break;
            case "Grammes":
                switch(to){
                    case "Kilogrammes":
                    result = Math.round((operand1/1000.0)*1000.0)/1000.0;
                    break;
                    case "Onces":
                    result = Math.round((operand1*28.349523)*1000.0)/1000.0;
                    break; 
                    case "Livres":
                    result = Math.round((operand1/453.59237)*1000.0)/1000.0;
                    break; 
                }
                break;
            case "Livres":
                switch(to){
                    case "Grammes":
                    result = Math.round((operand1*453.59237)*1000.0)/1000.0;
                    break;
                    case "Onces":
                    result = Math.round((operand1*16)*1000.0)/1000.0;
                    break; 
                    case "Kilogrammes":
                    result = Math.round((operand1*0.45359237)*1000.0)/1000.0;
                    break;
                }
                break;
            case "Onces":
                switch(to){
                    case "Grammes":
                    result = Math.round((operand1/28.349523)*1000.0)/1000.0;
                    break;
                    case "Kilogrammes":
                    result = Math.round((operand1/28.349523/1000.00)*1000.0)/1000.0;
                    break; 
                    case "Livres":
                    result = Math.round((operand1/16)*1000.0)/1000.0;
                    break;
                }
                break;
            case "Celsius":
                switch(to){
                    case "Kelvin":
                    result = Math.round((operand1+ 273.15)*1000.0)/1000.0;
                    break;
                    case "Fahrenheit":
                    result = Math.round((operand1* 5F/9F + 32)*1000.0)/1000.0;
                    break; 
                }
                break;
            case "Kelvin":
                switch(to){
                    case "Fahrenheit":
                    result = Math.round(((operand1- 273.15) * 9F/5 + 32)*1000.0)/1000.0;
                    break;
                    case "Celsius":
                    result = Math.round((operand1- 273.15)*1000.0)/1000.0;
                    break; 
                }
                break;
            case "Fahrenheit":
                switch(to){
                    case "Kelvin":
                    result = Math.round(((operand1- 32) * 5/9 + 273.15)*1000.0)/1000.0;
                    break;
                    case "Celsius":
                    result = Math.round(((operand1 - 32) * 5/9)*1000.0)/1000.0;
                    break; 
                }
                break;
            case "Mètres":
                switch(to){
                    case "Centimètres":
                    result = Math.round((operand1*100.0)*1000.0)/1000.0;
                    break;
                    case "Pouces":
                    result = Math.round((operand1*39.37)*1000.0)/1000.0;
                    break; 
                    case "Pieds":
                    result = Math.round((operand1*3.28084)*1000.0)/1000.0;
                    break;
                }
                break;
            case "Centimètres":
                switch(to){
                    case "Mètres":
                    result = Math.round((operand1/100.0)*1000.0)/1000.0;
                    break;
                    case "Pouces":
                    result = Math.round((operand1/2.54)*1000.0)/1000.0;
                    break; 
                    case "Pieds":
                    result = Math.round((operand1/30.48)*1000.0)/1000.0;
                    break; 
                }
                break;
            case "Pouces":
                switch(to){
                    case "Centimètres":
                    result = Math.round((operand1*2.54)*1000.0)/1000.0;
                    break;
                    case "Mètres":
                    result = Math.round((operand1/39.37)*1000.0)/1000.0;
                    break; 
                    case "Pieds":
                    result = Math.round((operand1/12)*1000.0)/1000.0;
                    break;
                }
                break;
            case "Pieds":
                switch(to){
                    case "Centimètres":
                    result = Math.round((operand1*30.48)*1000.0)/1000.0;
                    break;
                    case "Mètres":
                    result = Math.round((operand1/3.28084)*1000.0)/1000.0;
                    break; 
                    case "Pouces":
                    result = Math.round((operand1*12)*1000.0)/1000.0;
                    break;
                }
                break;
            case "Litres":
                switch(to){
                    case "Mètres cubes":
                    result = Math.round((operand1/1000.0)*1000.0)/1000.0;
                    break;
                    case "Gallons":
                    result = Math.round((operand1*0.264)*1000.0)/1000.0;
                    break; 
                    case "Pieds cubes":
                    result = Math.round((operand1/28.317)*1000.0)/1000.0;
                    break;
                }
                break;
            case "Mètres cubes":
                switch(to){
                    case "Litres":
                    result = Math.round((operand1*1000.0)*1000.0)/1000.0;
                    break;
                    case "Gallons":
                    result = Math.round((operand1*264.2)*1000.0)/1000.0;
                    break; 
                    case "Pieds cubes":
                    result = Math.round((operand1*35.315)*1000.0)/1000.0;
                    break; 
                }
                break;
            case "Gallons":
                switch(to){
                    case "Litres":
                    result = Math.round((operand1*2.54)*1000.0)/1000.0;
                    break;
                    case "Mètres cubes":
                    result = Math.round((operand1/264.2)*1000.0)/1000.0;
                    break; 
                    case "Pieds cubes":
                    result = Math.round((operand1/7.48)*1000.0)/1000.0;
                    break;
                }
                break;
            case "Pieds cubes":
                switch(to){
                    case "Litres":
                    result = Math.round((operand1*28.317)*1000.0)/1000.0;
                    break;
                    case "Mètres cubes":
                    result = Math.round((operand1/35.315)*1000.0)/1000.0;
                    break; 
                    case "Gallons":
                    result = Math.round((operand1*7.48)*1000.0)/1000.0;
                    break;
                }
                break;
            default:
                result =Math.round(operand1*CurrencyConverter.getCurrencyValue(from,to)*1000.0)/1000.0;
                break;
        }
		
		resultField.setText(String.valueOf(result));
	}
	
}
