package Spring.Context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("Spring.Context");
        OrderService orderService = context.getBean(OrderService.class);
        orderService.createOrderFromProduct(3L);

        context.close();
    }
}
