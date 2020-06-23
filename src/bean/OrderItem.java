package bean;

public class OrderItem {
    private int id;
    private  Product product;
    private int num;
    private  Order order;

    public int getId() {
        return id;
    }

    public int getNum() {
        return num;
    }

    public Product getProduct() {
        return product;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
