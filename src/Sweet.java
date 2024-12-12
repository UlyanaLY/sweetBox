public abstract class Sweet {
    private final String name;
    private final double weight;
    private final double price;
    private final String uniqueParameter;

    public Sweet(String name, double weight, double price, String uniqueParameter) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.uniqueParameter = uniqueParameter;
    }

    public String getUniqueParameter() {
        return uniqueParameter;
    }


    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
