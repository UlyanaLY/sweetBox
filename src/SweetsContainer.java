interface SweetsContainer {
    SweetsContainer addSweet(Sweet sweet);
    void removeLowestPriceSweet();
    void removeLowestWeightSweet();
    double getTotalWeight();
    double getTotalPrice();
    void displaySweets();
    void displayInformation();
}
