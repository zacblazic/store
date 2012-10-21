package za.co.invoketech.store.model.entity.order;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Delivery
 *
 */
@Entity
@Table(name = "DELIVERY")
public class Delivery implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "DELIVERY_METHOD", nullable = false)
	private DeliveryMethod method;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "DELIVERY_ADDRESS_ID", nullable = false)
	private DeliveryAddress address;
	
	@Column(name = "COST", nullable = false)
	private BigDecimal cost;
	
	@Column(name = "INSTRUCTIONS")
	private String instructions;
	
	/**
	 * @deprecated
	 * Default constructor should only be used by the persistence mechanism.
	 */
	public Delivery() {}
	
	public Delivery(DeliveryMethod method, DeliveryAddress address, BigDecimal cost) {
		checkMethod(method);
		checkAddress(address);
		checkCost(cost);
		this.method = method;
		this.address = new DeliveryAddress(address);
		this.cost = cost;
	}
	
	public Delivery(Delivery delivery) {
		checkDelivery(delivery);
		this.id = delivery.id;
		this.method = delivery.method;
		this.address = new DeliveryAddress(delivery.address);
		this.cost = delivery.cost;
		this.instructions = delivery.instructions;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DeliveryMethod getMethod() {
		return method;
	}

	public void setMethod(DeliveryMethod method) {
		checkMethod(method);
		this.method = method;
	}
	
	public DeliveryAddress getAddress() {
		return new DeliveryAddress(address);
	}

	public void setAddress(DeliveryAddress address) {
		checkAddress(address);
		this.address = new DeliveryAddress(address);
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		checkCost(cost);
		this.cost = cost;
	}
	
	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	
	private void checkDelivery(Delivery delivery) {
		checkNotNull(delivery, "delivery cannot be null");
	}
	
	private void checkMethod(DeliveryMethod method) {
		checkNotNull(method, "method cannot be null");
	}
	
	private void checkAddress(DeliveryAddress address) {
		checkNotNull(address, "address cannot be null");
	}
	
	private void checkCost(BigDecimal cost) {
		checkNotNull(cost, "cost cannot be null");
		checkArgument(cost.compareTo(BigDecimal.ZERO) >= 0, "cost cannot be less than 0");
	}
}
