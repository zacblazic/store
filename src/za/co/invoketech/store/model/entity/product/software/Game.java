package za.co.invoketech.store.model.entity.product.software;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Game
 *
 */
@Entity
@Table (name = "GAME")
@PrimaryKeyJoinColumn(name = "PRODUCT_ID")
public class Game extends Software {

	private static final long serialVersionUID = 1L;
	
	private String publisher;
	
	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
   
}
