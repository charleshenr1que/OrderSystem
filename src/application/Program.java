package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.ietf.jgss.Oid;

import entities.Cliente;
import entities.Order;
import entities.OrderItem;
import entities.enums.OrderStatus;
import entities.Product;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Cliente c1 = new Cliente();
		Order order = new Order();
		Product product = new Product();
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		System.out.println("Enter clente data:");
		System.out.print("Name: ");
		c1.setName(sc.next());
		System.out.print("Email: ");
		c1.setEmail(sc.next());
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date dataFormatada = format.parse(sc.next());
		c1.setBirthDate(dataFormatada);

		System.out.println("Enter order data: ");
		System.out.print("Status:");
		OrderStatus os = OrderStatus.valueOf(sc.next());
		order.setStatus(os);
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Enter #" + (i + 1) + " item data:");
			System.out.print("Product name:");
			String name = sc.next();
			System.out.printf("Product price:");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			product = new Product(name, price);
			OrderItem ord = new OrderItem(quantity, product);
			orderItems.add(ord);
		}
		order = new Order(new Date(), os, orderItems, c1);
		sc.close();
		System.out.println(order.toString());
	}

}
