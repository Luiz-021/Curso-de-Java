package ex_pedidos.entidades;
public class OrderItens {
    private int quantity;
    private double price;

    private Products product;

    public OrderItens (){

    }

    public OrderItens(int quantity, double price, Products product) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public Products getProduct() {
        return product;
    }

    public double subTotal(){
        return price * quantity;
    }

    @Override
    public String toString() {
        return getProduct().getName()
                +", $"
                + String.format("%.2f",price)
                +", Quantity:"
                + quantity
                +", Subtotal: $"
                + String.format("%.2f",subTotal());
    }

    
    
}
