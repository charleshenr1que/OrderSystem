package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Date moment;
	private OrderStatus status;

	private List<OrderItem> orderItem;
	private Cliente cliente;

	SimpleDateFormat sdFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	SimpleDateFormat sdFormatBirth = new SimpleDateFormat("(dd/MM/yyyy)");

	public Order() {

	}

	public Order(Date moment, OrderStatus status, List<OrderItem> orderItem, Cliente cliente) {
		super();
		this.moment = moment;
		this.status = status;
		this.orderItem = orderItem;
		this.cliente = cliente;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void addItem(OrderItem item) {
		orderItem.add(item);
	}

	public void removeItem(OrderItem item) {
		orderItem.remove(item);
	}

	public double total() {
		double total = 0;
		for (OrderItem o : orderItem) {
			total += o.subTotal();
		}
		return total;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: " + sdFormat.format(moment) + "\n");
		sb.append("Order staus: " + status + "\n");
		sb.append("Cliente: " + cliente.getName() +" "+ sdFormatBirth.format(cliente.getBirthDate()) + " - " + cliente.getEmail() + "\n");
		sb.append("Order items: \n");
		for (OrderItem o : orderItem) {
		sb.append(o.getProduct().getName()+","+"Quantity:"+ o.getQuantity()+","+" Subtotal: $"+ o.subTotal()+"\n");
		}
		sb.append("Total price: "+total());
		return sb.toString();
	}

}
