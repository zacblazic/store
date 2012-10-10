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
	
	@OneToOne
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	private Product product;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "ADDED_DATE")
	private Date addedDate;
	
	@Column(name = "DELETED")
	private boolean deleted;

	public WishListItem() {
		
	}
	
	public static WishListItem getInstance (Product product) {
		// TODO: Check that this is the best way to get current date
		return getInstance(product, new Date());
	}
	
	public static WishListItem getInstance(Product product, Date addedDate) {
		WishListItem item = new WishListItem();
		item.product = product;
		item.addedDate = addedDate;
		
		return item;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
