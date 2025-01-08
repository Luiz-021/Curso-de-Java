package ex_pedidos.entidades;
public class Products {
    private String name;
    private double price;
    
    public Products() {

    }

    public Products(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    


}
