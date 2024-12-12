import java.util.concurrent.ThreadLocalRandom;

class Caramel extends Sweet {
    public Caramel() {
        super("Карамель", 11.00, 10.00, generateUniqueParameter());
    }

    private static String generateUniqueParameter() {
        String[] parameters = {"солёная", "кислая", "сладкая"};
        return parameters[ThreadLocalRandom.current().nextInt(parameters.length)];
    }
}
