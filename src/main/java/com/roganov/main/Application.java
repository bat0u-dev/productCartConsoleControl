package com.roganov.main;

import com.roganov.config.ApplicationConfig;
import com.roganov.entities.Cart;
import com.roganov.entities.Product;
import com.roganov.repositories.ProductRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

//@SpringBootApplication
public class Application {
    private static final Scanner scanner = new Scanner(System.in);
    ;

    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ProductRepository repository = (ProductRepository) context.getBean("repository");
        Cart cart = (Cart) context.getBean("cart");
        cart.setRepository(repository);
        try {
            new Init(repository).run();
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    String command = scanner.nextLine();
                    String[] values = command.split("-");
                    if (values[0].equals("/add")) {
                        int id = Integer.parseInt(values[1]);
                        String title = values[2];
                        double coast = Double.parseDouble(values[3]);
                        repository.addProduct(new Product(id, title, coast));
                        System.out.println("Товар добавлен");
                        repository.printProdList();
                    } else if (values[0].equals("/del")) {
                        int id = Integer.parseInt(values[1]);
                        if (repository.delProduct(id)) {
                            System.out.println("Товар удален");
                        } else {
                            System.out.println("Нет такого id");
                        }
                        repository.printProdList();
                    }
                }
            }
        }).start();

        repository.printProdList();
    }
}
// /add-8-newProd1-200.00
// /del-8