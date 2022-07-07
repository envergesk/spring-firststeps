package Spring.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    private List<Product> productsInCart;

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void init(){
        productsInCart = new ArrayList<>();
    }

    public List<Product> getProductsInCart() {
        return productsInCart;
    }

    public void setProductsInCart(List<Product> productsInCart) {
        this.productsInCart = productsInCart;
    }

    public List<Product> addProduct(Long id){
        productsInCart.add(productRepository.findById(id));
        return productsInCart;
    }

    public List<Product> removeProduct(Long id){
        productsInCart.removeIf(p -> p.getId().equals(id));
        return productsInCart;
    }

    public void showProductsInCart(){
        for (Product product : productsInCart) {
            System.out.println(product);
        }
    }
}
