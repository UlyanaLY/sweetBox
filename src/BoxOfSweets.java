import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BoxOfSweets implements SweetsContainer {
    private List<Sweet> sweets;

    public double getHighestPriceSweet() {
        return sweets.stream().mapToDouble(Sweet::getPrice).max().orElse(0);
    }

    public double getHighestWeightSweet() {
        return sweets.stream().mapToDouble(Sweet::getWeight).max().orElse(0);
    }

    public BoxOfSweets() {
        this.sweets = new ArrayList<>();
    }

    @Override
    public BoxOfSweets addSweet(Sweet sweet) {
        sweets.add(sweet);
        return this;
    }

    public Boolean isEmpty() {
        return sweets.isEmpty();
    }

    @Override
    public void removeLowestPriceSweet() {
        if (this.sweets.isEmpty()) {
            System.out.println("Коробка пустая. Удалять нечего.");
            return;
        }

        List<Sweet> sweets = this.sweets;
        Sweet lowestPriceSweet = sweets.get(0);

        for (Sweet sweet : sweets) {
            if (sweet.getPrice() < lowestPriceSweet.getPrice()) {
                lowestPriceSweet = sweet;
            }
        }

        sweets.remove(lowestPriceSweet);
    }

    @Override
    public void removeLowestWeightSweet() {
        if (this.sweets.isEmpty()) {
            System.out.println("Коробка пустая. Удалять нечего.");
            return;
        }

        List<Sweet> sweets = this.sweets;
        Sweet lowestWeightSweet = sweets.get(0);

        for (Sweet sweet : sweets) {
            if (sweet.getWeight() < lowestWeightSweet.getWeight()) {
                lowestWeightSweet = sweet;
            }
        }

        sweets.remove(lowestWeightSweet);
    }

    @Override
    public double getTotalWeight() {
        return sweets.stream().mapToDouble(Sweet::getWeight).sum();
    }

    @Override
    public double getTotalPrice() {
        return sweets.stream().mapToDouble(Sweet::getPrice).sum();
    }

    @Override
    public void displaySweets() {
        System.out.println("Состав коробки:");
        AtomicInteger i = new AtomicInteger(1);
        sweets.forEach(sweet -> System.out.println(
                i.getAndIncrement() + ". " + sweet.getName() + " - " + sweet.getWeight() + "g - $" + sweet.getPrice() + " - " + sweet.getUniqueParameter()
        ));
    }

    @Override
    public void displayInformation() {
        displaySweets();
        System.out.println("Общая цена: " + getTotalPrice());
        System.out.println("Общий вес: " + getTotalWeight());
    }
}
