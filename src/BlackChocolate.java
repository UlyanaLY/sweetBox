import java.util.concurrent.ThreadLocalRandom;

public class BlackChocolate extends Sweet {
    public BlackChocolate() {
        super("Тёмный шоколад", 98.00, 99.00, generateUniqueParameter());
    }

    private static String generateUniqueParameter() {
        String[] parameters = {"с орехами", "швейцарский", "горький"};
        return parameters[ThreadLocalRandom.current().nextInt(parameters.length)];
    }
}
