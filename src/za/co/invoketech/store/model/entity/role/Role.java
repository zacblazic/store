package za.co.invoketech.store.model.entity.role;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author zacblazic@gmail.com (Zac Blazic)
 * 
 * An entity representing an account's role for authorization purposes.
 */
@Entity
@Table(name = "ROLE")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
   
}
