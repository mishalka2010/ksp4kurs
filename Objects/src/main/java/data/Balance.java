package data;

public class Balance
{
    public Balance() { }
    public Balance(int money){
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
    public void setMoney(int money) { this.money = money; }

    private int money;
}
