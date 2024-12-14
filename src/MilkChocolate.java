import java.util.concurrent.ThreadLocalRandom;

public class MilkChocolate extends Sweet {
    public MilkChocolate() {
        super("Молочный шоколад", 100.00, 2.00, generateUniqueParameter());
    }

    private static String generateUniqueParameter() {
        String[] parameters = {"с орехами", "с изюмом", "с кокосом"};
        return parameters[ThreadLocalRandom.current().nextInt(parameters.length)];
    }
}
