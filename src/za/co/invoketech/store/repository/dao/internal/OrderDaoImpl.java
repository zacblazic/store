package za.co.invoketech.store.repository.dao.internal;

import za.co.invoketech.store.model.entity.order.Order;
import za.co.invoketech.store.service.dao.OrderDao;

import com.google.inject.persist.Transactional;

@Transactional
class OrderDaoImpl extends GenericDaoImpl<Order, Long> implements OrderDao {
	
	public OrderDaoImpl() {
		super(Order.class);
	}
}
