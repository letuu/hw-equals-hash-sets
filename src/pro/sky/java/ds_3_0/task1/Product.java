package pro.sky.java.ds_3_0.task1;

import java.util.Objects;

public class Product {

    private final String name;
    private float price;
    private int quantity;
    private boolean purchased;


    public Product(String name, float price, int quantity) {
        if (name == null || name.isBlank() || price < 0 || quantity < 0) {
            throw new IllegalArgumentException("Заполните карточку товара полностью");
        }
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.purchased = false;
    }


    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int amount) {
        this.quantity = amount;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased() {
        this.purchased = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        String purchasedString = this.isPurchased() ? "Да" : "Нет";
        return String.format(
                "Продукт: %s," +
                        " Цена: %s, " +
                        " Количество: %s," +
                        " Продукт куплен: %s",
                this.name, this.price, this.quantity, purchasedString);
    }
}
