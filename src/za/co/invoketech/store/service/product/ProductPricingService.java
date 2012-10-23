/**
 * Copyright (c) 2012 Invoke Tech
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package za.co.invoketech.store.service.product;

import java.math.BigDecimal;
/**
 * 
 * @author garethc18@gmail.com (Gareth Conry)
 *
 */
public interface ProductPricingService {
	public BigDecimal setStandardMarkupPrice (BigDecimal supplierPrice)  throws Exception;
	public BigDecimal setCustomMarkupPrice (BigDecimal supplierPrice, float ratio)  throws Exception;
	public BigDecimal calculateVat (BigDecimal productPrice);
	public BigDecimal addVat (BigDecimal productPrice);
}
