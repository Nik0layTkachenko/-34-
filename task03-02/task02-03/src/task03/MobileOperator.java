package task02;



public class MobileOperator {
    private String name;
    private String countryCode;
    private String prefix;
    private String networkName;

    public MobileOperator(String name, String countryCode, String prefix, String networkName) {
        this.name = name;
        this.countryCode = countryCode;
        this.prefix = prefix;
        this.networkName = networkName;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getNetworkName() {
        return networkName;
    }
}