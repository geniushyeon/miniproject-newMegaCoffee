package megaCoffee.entities;

public class Option {
    private String optionName;
    private int optionPrice;

    public Option(String optionName, int optionPrice) {
        this.optionName = optionName;
        this.optionPrice = optionPrice;
    }

    public String getOptionName() {
        return optionName;
    }

    public int getOptionPrice() {
        return optionPrice;
    }

    @Override
    public String toString() {
        return "Option{" +
                "optionName='" + optionName + '\'' +
                ", optionPrice=" + optionPrice +
                '}';
    }
}
