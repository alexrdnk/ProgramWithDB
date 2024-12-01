package pwr.jp.radionenko.model;

public class Offer {

    private int id;
    private final String name;
    private final String description;
    private final double price;

    public Offer(int id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public String toString(){
        return "Offer [ " +
                "(id - " + id +
                ") (name - " + name +
                ") (description - " + description +
                ") (price - " + price +
                ") ]";
    }

}
