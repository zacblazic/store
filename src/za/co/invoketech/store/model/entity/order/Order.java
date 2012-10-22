/**
 * Copyright (c) 2012 Invoke Tech
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package za.co.invoketech.store.model.entity.order;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static za.co.invoketech.store.application.util.DefensiveDate.copyDate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import za.co.invoketech.store.application.util.Constants;
import za.co.invoketech.store.model.entity.customer.Customer;
import za.co.invoketech.store.model.entity.invoice.Invoice;

/**
 * @author zacblazic@gmail.com (Zac Blazic)
 */
@Entity
@Table(name = "ORDERS")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ORDER_ID")
	private long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS", nullable = false)
	private OrderStatus status;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ORDER_ID", nullable = false)
	private List<OrderItem> items;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PAYMENT_ID", nullable = false)
	private Payment payment;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "DELIVERY_ID", nullable = false)
	private Delivery delivery;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID", nullable = false)
	private Customer customer;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INVOICE_ID")
	private Invoice invoice;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE", nullable = false)
	private Date createdDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CANCELLED_DATE", nullable = false)
	private Date cancelledDate;
	
	/**
	 * @deprecated
	 * Default constructor should only be used by the persistence mechanism.
	 */
	public Order() {}
	
	public Order(OrderStatus status, Payment payment, Delivery delivery, Customer customer) {
		this(status, payment, delivery, customer, new ArrayList<OrderItem>());
	}
	
	public Order(OrderStatus status, Payment payment, Delivery delivery, Customer customer, List<OrderItem> items) {
		checkStatus(status);
		checkPayment(payment);
		checkDelivery(delivery);
		checkCustomer(customer);
		checkItems(items);
		this.status = status;
		this.items = copyItems(items);
		this.payment = new Payment(payment);
		this.delivery = new Delivery(delivery);
		this.customer = Customer.copy(customer);
		this.createdDate = Calendar.getInstance().getTime();
	}
	
	public Order(Order order) {
		checkOrder(order);
		this.id = order.id;
		this.status = order.status;
		this.items = copyItems(order.items);
		this.payment = new Payment(order.payment);
		this.delivery = new Delivery(order.delivery);
		this.customer = Customer.copy(order.customer);
		this.invoice = new Invoice(order.invoice);
		this.createdDate = copyDate(order.createdDate);
		this.cancelledDate = copyDate(order.cancelledDate);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		checkStatus(status);
		this.status = status;
	}
	
	public void addItem(OrderItem item) {
		checkItem(item);
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		checkItem(item);
		items.remove(item);
	}
	
	public boolean hasItem(OrderItem item) {
		checkItem(item);
		return items.contains(item);
	}
	
	public int getItemCount() {
		return items.size();
	}
	
	public void removeAllItems() {
		items = new ArrayList<OrderItem>();
	}

	public List<OrderItem> getItems() {
		return copyItems(items);
	}

	public void setItems(List<OrderItem> items) {
		checkItems(items);
		this.items = copyItems(items);
	}

	public Payment getPayment() {
		return new Payment(payment);
	}

	public void setPayment(Payment payment) {
		checkPayment(payment);
		this.payment = new Payment(payment);
	}

	public Delivery getDelivery() {
		return new Delivery(delivery);
	}

	public void setDelivery(Delivery delivery) {
		checkDelivery(delivery);
		this.delivery = new Delivery(delivery);
	}
	
	public Customer getCustomer() {
		return Customer.copy(customer);
	}

	public void setCustomer(Customer customer) {
		checkCustomer(customer);
		this.customer = Customer.copy(customer);
	}

	public Invoice getInvoice() {
		return new Invoice(invoice);
	}

	public void setInvoice(Invoice invoice) {
		checkInvoice(invoice);
		this.invoice = new Invoice(invoice);
	}

	public Date getCreatedDate() {
		return copyDate(createdDate);
	}

	public Date getCancelledDate() {
		return copyDate(cancelledDate);
	}
	
	public boolean isCancelled() {
		return cancelledDate != null ? true : false;
	}
	
	public void setCancelled(boolean cancelled) {
		if(cancelled) {
			cancelledDate = Calendar.getInstance().getTime();
		} else {
			cancelledDate = null;
		}
	}
	
	public BigDecimal getAmount() {
		BigDecimal amount = new BigDecimal(0);
		
		for(OrderItem item : items) {
			BigDecimal unitPrice = item.getUnitPrice();
			BigDecimal quantity = BigDecimal.valueOf(item.getQuantity());
			amount = amount.add(unitPrice.multiply(quantity));
		}
		
		return amount;
	}
	
	public BigDecimal getTax() {
		BigDecimal tax = new BigDecimal(Constants.TAX);
		return getAmount().multiply(tax);
	}
	
	public BigDecimal getAmountWithTax() {
		return getAmount().add(getTax());
	}
	
	private List<OrderItem> copyItems(List<OrderItem> items) {
		List<OrderItem> copiedItems = new ArrayList<OrderItem>();
		
		for(OrderItem item : items) {
			copiedItems.add(new OrderItem(item));
		}
		
		return copiedItems;
	}
	
	private void checkOrder(Order order) {
		checkNotNull(order, "order cannot be null");
	}
	
	private void checkStatus(OrderStatus status) {
		checkNotNull(status, "status cannot be null");
	}
	
	private void checkItem(OrderItem item) {
		checkNotNull(item, "item cannot be null");
	}
	
	private void checkItems(List<OrderItem> items) {
		checkNotNull(items, "items cannot be null");
		checkArgument(!items.contains(null), "items cannot contain nulls");
	}
	
	private void checkInvoice(Invoice invoice) {
		checkNotNull(invoice, "invoice cannot be null");
	}
	
	private void checkPayment(Payment payment) {
		checkNotNull(payment, "payment cannot be null");
	}
	
	private void checkDelivery(Delivery delivery) {
		checkNotNull(delivery, "delivery cannot be null");
	}
	
	private void checkCustomer(Customer customer) {
		checkNotNull(customer, "customer cannot be null");
	}
}
