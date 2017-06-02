package ness.edu.xmlandfirebase;


import org.jsoup.Jsoup;

import java.io.InputStream;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.net.URL;

public class CurrencyDataSource {
    //<uses-permission INTERNET
    //TODO: Listener
    public static void getCurrencies(/*Listener*/){
        //Async
        ExecutorService service = Executors.newSingleThreadExecutor();

        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    //URL url = new URL("....");
                    URL url = new URL("http://www.boi.org.il/currency.xml");
                    //con = url.openConnection()
                    URLConnection con = url.openConnection();
                    //in  = con.getInputStream (BINARY)
                    InputStream in = con.getInputStream();
                    //String xml = IO.read(in) // Convert the binary to String
                    String xml = IO.read(in);
                    //Method that parses the xml into Currency. Jsoup.parse()
                }
                catch (Exception e){
                    e.printStackTrace();
                    //TODO: Handle the error with listener.
                }
            }
        });

        service.shutdown();
        //Currency?
    }

    //static is Simpler no reference to the outer class
    public static class Currency{
        private final String name;
        private final int unit;
        private final String currencyCode;
        private final String country;
        private final double rate;
        private final double change;

        //Constructor
        public Currency(String name, int unit, String currencyCode, String country, double rate, double change) {
            this.name = name;
            this.unit = unit;
            this.currencyCode = currencyCode;
            this.country = country;
            this.rate = rate;
            this.change = change;
        }

        //Getters
        public String getName() {
            return name;
        }
        public int getUnit() {
            return unit;
        }
        public String getCurrencyCode() {
            return currencyCode;
        }
        public String getCountry() {
            return country;
        }
        public double getRate() {
            return rate;
        }
        public double getChange() {
            return change;
        }

        //toString
        @Override
        public String toString() {
            return "Currency{" +
                    "name='" + name + '\'' +
                    ", unit=" + unit +
                    ", currencyCode='" + currencyCode + '\'' +
                    ", country='" + country + '\'' +
                    ", rate=" + rate +
                    ", change=" + change +
                    '}';
        }
    }
}
