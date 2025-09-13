package Java_Advanced;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.*;

public class WelcomeUsers {
	public static Locale getMethod(String langCode) {
		Locale locale = null;
		switch (langCode) {
        case "fr":
            locale = Locale.FRANCE;
            break;
        case "hi":
            locale = Locale.forLanguageTag("hi-IN");
            break;
        case "ja":
            locale = Locale.JAPAN;
            break;
        case "ta":
            locale = Locale.forLanguageTag("ta-IN");
            break;
        case "en":
        	locale = Locale.forLanguageTag("en-US");
            break;
		}
		return locale;
	}
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose language code:");
        System.out.println("en - English, fr - French, hi - Hindi, ja - Japanese, ta - Tamil");
        
        Locale locale;
        
       do { 
    	   System.out.print("Enter code: ");
    	   String langCode = scanner.nextLine().trim().toLowerCase();

    	   locale = getMethod(langCode);
    	   if(locale==null) {
    		   System.out.println("Invalid country code");
    	   }
        
       }while(locale==null);

        ResourceBundle messages = ResourceBundle.getBundle("welcome", locale);

        System.out.println(messages.getString("welcome"));

        Date now = new Date();
        DateFormat timeFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale);
        System.out.println(messages.getString("time") + " " + timeFormat.format(now));

        double amount = 12345.67;
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
        System.out.println(messages.getString("currency") + " " + currencyFormat.format(amount));

        scanner.close();
    }
}