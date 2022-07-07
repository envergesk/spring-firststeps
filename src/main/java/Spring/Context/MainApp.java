package Spring.Context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("Spring.Context");
        OrderService orderService = context.getBean(OrderService.class);
        orderService.createOrderFromProduct(3L);

        Cart cart = context.getBean(Cart.class);
        cart.addProduct(3L);
        cart.showProductsInCart();

        cart.addProduct(2L);
        cart.showProductsInCart();

        cart.addProduct(1L);
        cart.showProductsInCart();

        Scanner sc = new Scanner(System.in);
        String reader = null;
        while (true) {
            reader = sc.nextLine();
            if (reader.equals("/end")){
                break;
            }
            cart.addProduct(Long.valueOf(reader));
            cart.showProductsInCart();
        }
        while (true){
            reader = sc.nextLine();
            if (reader.equals("/end")){
                break;
            }
            cart.removeProduct(Long.valueOf(reader));
            cart.showProductsInCart();
        }

        sc.close();
        context.close();
    }
}
