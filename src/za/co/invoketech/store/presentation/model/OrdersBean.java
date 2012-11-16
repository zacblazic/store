package za.co.invoketech.store.presentation.model;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.domain.model.order.Order;
import za.co.invoketech.store.service.repository.OrderRepository;

import com.google.inject.Inject;

@ViewScoped
@ManagedBean
public class OrdersBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private OrderRepository orderRepository;
	
	private long orderId;
	
	private List<Order> orders;
	
	private Order selectedOrder;
	
	private boolean viewDisabled;
	
	
	public OrdersBean() {
		Goose.guicify(this);
		orders = orderRepository.findAll();
		hideButton();
	}

	
	public void showButton() {
		setViewDisabled(false);
	}
	
	public void hideButton() {
		setViewDisabled(true);
	}
	
	public String viewOrder() {
		orderId = selectedOrder.getId();
		return "order?faces-redirect=true&includeViewParams=true";
	}

	public OrderRepository getOrderRepository() {
		return orderRepository;
	}


	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}


	public long getOrderId() {
		return orderId;
	}


	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}


	public List<Order> getOrders() {
		return orders;
	}


	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	public Order getSelectedOrder() {
		return selectedOrder;
	}


	public void setSelectedOrder(Order selectedOrder) {
		this.selectedOrder = selectedOrder;
	}


	public boolean isViewDisabled() {
		return viewDisabled;
	}


	public void setViewDisabled(boolean viewDisabled) {
		this.viewDisabled = viewDisabled;
	}
	
}
