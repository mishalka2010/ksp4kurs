package data;

public class Pet
{
    public Pet() { }
    public Pet(int id , double price, String name)
    {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public int getID() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
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
