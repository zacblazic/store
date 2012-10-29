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

package za.co.invoketech.store.domain.model.order;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonStreamParser;
import com.google.gson.annotations.Expose;

import za.co.invoketech.store.application.util.Constants;
import za.co.invoketech.store.application.util.Dates;
import za.co.invoketech.store.domain.model.customer.Customer;
import za.co.invoketech.store.domain.model.invoice.Invoice;

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
	@Expose
	private long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS", nullable = false)
	@Expose
	private OrderStatus status;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ORDER_ID")
	@Expose
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
	@Expose
	private Invoice invoice;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE", nullable = false)
	@Expose
	private Date createdDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CANCELLED_DATE")
	@Expose
	private Date cancelledDate;
	
	/**
	 * @deprecated
	 * Default constructor should only be used by the persistence mechanism.
	 */
	public Order() {}
	
	public Order(Customer customer, Payment payment, Delivery delivery) {
		this(customer, new ArrayList<OrderItem>(), payment, delivery);
	}
	
	public Order(Customer customer, List<OrderItem> items, Payment payment, Delivery delivery) {
		checkCustomer(customer);
		checkItems(items);
		checkPayment(payment);
		checkDelivery(delivery);
		this.status = OrderStatus.OUTSTANDING;
		this.customer = customer;
		this.items = OrderItem.copyAll(items);
		this.payment = Payment.copy(payment);
		this.delivery = Delivery.copy(delivery);
		this.createdDate = Dates.now();
	}
	
	public String toJson() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		return gson.toJson(this);
	}

	public long getId() {
		return id;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		checkStatus(status);
		this.status = status;
	}
	
	public int getItemCount() {
		return items.size();
	}

	public List<OrderItem> getItems() {
		return OrderItem.copyAll(items);
	}

	public void setItems(List<OrderItem> items) {
		checkItems(items);
		this.items = OrderItem.copyAll(items);
	}

	public Payment getPayment() {
		return Payment.copy(payment);
	}

	public void setPayment(Payment payment) {
		checkPayment(payment);
		this.payment = Payment.copy(payment);
	}

	public Delivery getDelivery() {
		return Delivery.copy(delivery);
	}

	public void setDelivery(Delivery delivery) {
		checkDelivery(delivery);
		this.delivery = Delivery.copy(delivery);
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		checkCustomer(customer);
		this.customer = customer;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		checkInvoice(invoice);
		this.invoice = invoice;
	}

	public Date getCreatedDate() {
		return Dates.copy(createdDate);
	}

	public Date getCancelledDate() {
		return Dates.copy(cancelledDate);
	}
	
	public boolean isCancelled() {
		return cancelledDate != null ? true : false;
	}
	
	public void setCancelled(boolean cancelled) {
		if(cancelled) {
			cancelledDate = Dates.now();
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
	
	private void checkStatus(OrderStatus status) {
		checkNotNull(status, "status cannot be null");
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
