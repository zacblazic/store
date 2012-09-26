package za.co.invoketech.store.model.productsystem.software;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Entity implementation class for Entity: Game
 *
 */
@Entity
@PrimaryKeyJoinColumn(name = "PRODUCT_ID")
public class Game extends Software implements Serializable {
	
	private String publisher;
	private static final long serialVersionUID = 1L;

	public Game() {
		super();
	} 
	
	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
   
}
