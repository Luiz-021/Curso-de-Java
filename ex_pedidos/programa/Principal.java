package ex_pedidos.programa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import ex_pedidos.entidades.Client;
import ex_pedidos.entidades.Order;
import ex_pedidos.entidades.OrderItens;
import ex_pedidos.entidades.Products;
import ex_pedidos.entidades_enum.OrderStatus;

public class Principal {
    public static void main(String args[]) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());

		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order? ");
		int N = sc.nextInt();
		for (int i=1; i<=N; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			Products product = new Products(productName, productPrice);
			
			OrderItens it = new OrderItens(quantity, productPrice, product);
			
			order.addItem(it);			
		}
		
		System.out.println();
		System.out.println(order);
        
        sc.close();
    }
}
