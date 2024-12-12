import java.util.concurrent.ThreadLocalRandom;

public class Lollipop extends Sweet{
    public Lollipop() {
        super("Лединец", 20.00, 20.00, generateUniqueParameter());
    }

    private static String generateUniqueParameter() {
        String[] parameters = {"мятный", "кислый", "новогодний" };
        return parameters[ThreadLocalRandom.current().nextInt(parameters.length)];
    }
}
