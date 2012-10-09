package za.co.invoketech.store.model.wishlist;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import za.co.invoketech.store.model.product.Product;

/**
 * @author zacblazic@gmail.com (Zac Blazic)
 */

@Entity
@Table(name = "WISH_LIST_ITEM")
public class WishListItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "WISH_LIST_ITEM_ID")
	private long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "ADDED_DATE")
	private Date addedDate;
	
	@OneToOne
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	private Product product;
	
	@Column(name = "DELETED")
	private boolean deleted;

	public WishListItem() {
		
	}
	
	
	
	public WishListItem(WishListItem item) {
		this.id = item.id;
		this.addedDate = item.addedDate;
		this.product = item.product;
		this.deleted = item.deleted;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getAddedDate() {
		return new Date(addedDate.getTime());
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = new Date(addedDate.getTime());
	}

	public Product getProduct() {
		return new Product(product);
	}

	public void setProduct(Product product) {
		this.product = new Product(product);
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
