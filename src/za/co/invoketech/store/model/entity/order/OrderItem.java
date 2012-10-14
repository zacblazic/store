package za.co.invoketech.store.model.entity.order;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import za.co.invoketech.store.model.entity.product.Product;

@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_QUANTITY = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ITEM_ID")
	private long id;
	
	@OneToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;
	
	@Column(name = "QUANTITY")
	private int quantity;
	
	@Column(name = "UNIT_PRICE")
	private BigDecimal unitPrice;
	
	@Column(name = "DELETED")
	private boolean deleted;
	
	public static OrderItem getInstance(Product product, BigDecimal unitPrice) {
		return getInstance(product, DEFAULT_QUANTITY, unitPrice);
	}
	
	public static OrderItem getInstance(Product product, int quantity, BigDecimal unitPrice) {
		if(quantity <= 0) {
			// TODO: Handle invalid quantity
		}
		
		if(unitPrice.compareTo(BigDecimal.ZERO) < 0) {
			// TODO: Handle invalid unit price
		}
		
		OrderItem item = new OrderItem();
		item.product = product;
		item.quantity = quantity;
		item.unitPrice = unitPrice;
		
		return item;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if(quantity <= 0) {
			// TODO: Handle invalid quantity
		}
		
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		if(unitPrice.compareTo(BigDecimal.ZERO) < 0) {
			// TODO: Handle invalid unit price
		}
		
		this.unitPrice = unitPrice;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
