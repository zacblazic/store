package za.co.invoketech.store.service.product;

import java.math.BigDecimal;

public interface ProductPricingService {
	public BigDecimal setStandardMarkupPrice (BigDecimal supplierPrice)  throws Exception;
	public BigDecimal setCustomMarkupPrice (BigDecimal supplierPrice, float ratio)  throws Exception;
}
