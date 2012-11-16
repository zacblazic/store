package za.co.invoketech.store.presentation.model;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.domain.model.order.Order;
import za.co.invoketech.store.domain.model.order.OrderItem;

@ViewScoped
@ManagedBean
public class OrderBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Order order;

	private List<OrderItem> items;
	
	public OrderBean() {
		Goose.guicify(this);
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
	
}
