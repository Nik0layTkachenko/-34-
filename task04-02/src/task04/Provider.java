package task04;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * The class that implements the main functionality of the program can also be serialized
 */
public class Provider implements Serializable {

    private static final Map<String, String[]> PROVIDERS = new TreeMap<String, String[]>() {{
        put("Vodafone", new String[]{"050", "066", "095", "099"});
        put("Kyivstar", new String[]{"039", "067", "068", "096", "097", "098"});
        put("Lifecell", new String[]{"063", "073", "093"});
    }};

    private String provider;
    private String number;

    /**
     * Basic constructor without parameters
     */
    public Provider() {
        provider = "-";
        number = "-";
    }

    /**
     * A constructor that calls a method to determine the provider by phone number
     *
     * @param number the number
     */
    public Provider(String number) {
        this.provider = findProvider(number);
        setNumber(number);
    }

    /**
     * Getter for the provider attribute
     *
     * @return the provider
     */
    public String getProvider() {
        return provider;
    }

    /**
     * Setter for the provider attribute
     *
     * @param provider the provider
     */
    public void setProvider(String provider) {
        this.provider = provider;
    }

    /**
     * Getter for the phone number attribute
     *
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * Setter for the phone number attribute
     *
     * @param number the number
     */
    public void setNumber(String number) {
        if (number.length() == 17) {
            this.number = number;
        } else {
            this.number = "Invalid number";
        }
    }

    /**
     * A method that finds a provider by phone number using a constant array of data
     *
     * @param number the number
     * @return String
     */
    public static String findProvider(String number) {
        String code = number.charAt(4) + String.valueOf(number.charAt(5)) + (number.charAt(6));
        String result;

        for (Map.Entry<String, String[]> provider : PROVIDERS.entrySet()) {
            if (Arrays.asList(provider.getValue()).contains(code)) {
                result = provider.getKey();
                return result;
            }
        }

        result = "Seems we don`t know your provider yet...";
        return result;
    }

    /**
     * A method to cast an instance of a class to a string
     *
     * @return String
     */
    @Override
    public String toString() {
        return this.number + " - " + this.provider;
    }
}
