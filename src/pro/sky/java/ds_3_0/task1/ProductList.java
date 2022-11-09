package pro.sky.java.ds_3_0.task1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class ProductList {

    private final Set<Product> products = new HashSet<>();

    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        if (this.products.contains(product)) {
            throw new ProductException("Продукт '" + product.getName() + "' уже добавлен в список продуктов");
        } else {
            this.products.add(product);
        }
    }

    public void buyProduct(String name) {
        for (Product product : this.products) {
            if (product.getName().equals(name)) {
                product.setPurchased();
                break;
            }
        }
    }

    public void removeProductName(String name) {
        Iterator<Product> productsIterator = this.products.iterator();
        while (productsIterator.hasNext()) {
            if (productsIterator.next().getName().equals(name)) {
                productsIterator.remove();
                break;
            }
        }
    }

    //или удаление по имени объекта
    public void removeProduct(Product product) {
        if (this.products.contains(product) && product != null) {
            this.products.remove(product);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductList that = (ProductList) o;
        return Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список продуктов:").append('\n');
        for (Product product : this.products) {
            stringBuilder.append(product).append("\n");
        }
        return stringBuilder.toString();
    }
}
