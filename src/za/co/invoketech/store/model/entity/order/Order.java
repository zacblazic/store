package za.co.invoketech.store.model.entity.order;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import za.co.invoketech.store.model.entity.invoice.Invoice;

/**
 * Entity implementation class for Entity: Order
 *
 */
@Entity
@Table(name = "ORDERS")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ORDER_ID")
	private long id;
   
	@Temporal(TemporalType.DATE)
	@Column(name = "ORDER_DATE", nullable = false)
	private Date orderDate;
	
	@Column(name = "AMOUNT", nullable = false)
	private BigDecimal amount;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS", nullable = false)
	private OrderStatus status;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INVOICE_ID")
	private Invoice invoice;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ORDER_ID", nullable = false)
	private List<OrderItem> orderItems;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAYMENT_ID", nullable = false)
	private Payment payment;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DELIVERY_ID", nullable = false)
	private Delivery delivery;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		if(amount.compareTo(BigDecimal.ZERO) < 0) {
			// TODO: Handle invalid amount
		}
		
		this.amount = amount;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
}
