package data;

public class Staff
{
    public Staff() { }
    public Staff(int id, double price, String name)
    {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public int getID() {
        return id;
    }
    public void setID(int id) {
        this.id = id;
    }

    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private int id;
    private double price;
    private String name;
}
