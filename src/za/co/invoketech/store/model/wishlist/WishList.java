package za.co.invoketech.store.model.wishlist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author zacblazic@gmail.com (Zac Blazic)
 */
@Entity
@Table(name = "WISH_LIST")
public class WishList implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "WISH_LIST_ID")
	private long id;
	
	@Column(name = "LABEL")
	private String label;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATION_DATE")
	private Date creationDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "WISH_LIST_ID", nullable = false)
	private List<WishListItem> itemList;
	
	@Column(name = "DELETED")
	private boolean deleted;
	
	public static WishList getInstance (String label) {
		WishList list = new WishList();
		list.label = label;
		
		// TODO: Check that this is the best way to get current date
		list.creationDate = new Date();
		list.itemList = new ArrayList<WishListItem>();
		
		return list;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Date getCreationDate() {
		return new Date(creationDate.getTime());
	}
	
	public void addItem(WishListItem item) {
		itemList.add(item);
	}
	
	public void removeItem(WishListItem item) {
		itemList.remove(item);
	}
	
	public void removeAllItems() {
		// Used instead of clear to remove unused memory
		itemList = new ArrayList<WishListItem>();
	}
	
	public List<WishListItem> getItems() {
		return itemList;
	}
	
	// TODO: Should we allow setItems()?
	
	public int getItemCount() {
		return itemList.size();
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
