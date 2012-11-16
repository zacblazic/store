package za.co.invoketech.store.presentation.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.domain.model.order.Order;
import za.co.invoketech.store.presentation.model.OrderBean;
import za.co.invoketech.store.service.repository.OrderRepository;

import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;

@RequestScoped
@ManagedBean
public class OrderController {

	@Inject
	private OrderRepository orderRepository;
	
	@ManagedProperty(value = "#{orderBean}")
	private OrderBean orderBean;
	
	@ManagedProperty(value = "#{param.id}")
	private long orderId;
	
	private Order order;
	
	
	public OrderController() {
		Goose.guicify(this);		
	}
	
	public void populate() {
		order = orderRepository.findById(orderId);
		orderBean.setOrder(order);
		orderBean.setItems(order.getItems());
	}

	public OrderBean getOrderBean() {
		return orderBean;
	}

	public void setOrderBean(OrderBean orderBean) {
		this.orderBean = orderBean;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
