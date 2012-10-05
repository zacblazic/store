package za.co.invoketech.store.service.product.internal;

import java.math.BigDecimal;

import za.co.invoketech.store.application.exception.InvalidMarkupException;
import za.co.invoketech.store.application.exception.InvalidSupplierPriceException;
import za.co.invoketech.store.service.product.ProductPricingService;

public class ProductPricingServiceImpl implements ProductPricingService {
	private final float CHEAP_ITEM_MARKUP = 0.35f;
	private final float MIDCOST_ITEM_MARKUP = 0.2f;
	private final float EXPENSIVE_ITEM_MARKUP = 0.1f;
	
	@Override
	public BigDecimal setStandardMarkupPrice(BigDecimal supplierPrice) throws Exception{
		if (supplierPrice.compareTo(new BigDecimal(0)) == -1 || supplierPrice.compareTo(new BigDecimal(0)) == 0 )
		{
			throw new InvalidSupplierPriceException();
		}
		
		float returnMarkup = 0f;
			
		if (supplierPrice.compareTo(new BigDecimal(200.0)) == -1 )
		{
			returnMarkup = CHEAP_ITEM_MARKUP;
		}
		else if (supplierPrice.compareTo(new BigDecimal(1000.0)) == -1 )
		{
			returnMarkup = MIDCOST_ITEM_MARKUP;
		}
		else if (supplierPrice.compareTo(new BigDecimal(1000.0)) == 0 || supplierPrice.compareTo(new BigDecimal(1000.0)) == 1)
		{
			returnMarkup = EXPENSIVE_ITEM_MARKUP;
		}
		
		return supplierPrice.multiply(new BigDecimal(returnMarkup));
	}

	@Override
	public BigDecimal setCustomMarkupPrice(BigDecimal supplierPrice, float ratio) throws Exception {
		if (supplierPrice.compareTo(new BigDecimal(0)) == -1 || supplierPrice.compareTo(new BigDecimal(0)) == 0 )
		{
			throw new InvalidSupplierPriceException();
		}
		
		if (ratio <= 0 || ratio > 1)
		{
			throw new InvalidMarkupException();
		}
		
		return supplierPrice.multiply(new BigDecimal(ratio));
	}

}
