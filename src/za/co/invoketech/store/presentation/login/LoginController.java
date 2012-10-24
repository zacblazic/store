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
package za.co.invoketech.store.presentation.login;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.domain.model.customer.Customer;
import za.co.invoketech.store.presentation.customer.CustomerBean;
import za.co.invoketech.store.service.customer.CustomerService;

import com.google.inject.Inject;

/**
 * @author garethc18@gmail.com (Gareth Conry)
 * @author zacblazic@gmail.com (Zac Blazic)
 */
@RequestScoped
@ManagedBean
public class LoginController {
	
	@Inject CustomerService customerService;
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	@ManagedProperty(value="#{customerBean}")
	private CustomerBean customerBean;
	
	public LoginController() {
		Goose.guicify(this);
	}
	
	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public CustomerBean getCustomerBean() {
		return customerBean;
	}

	public void setCustomerBean(CustomerBean customerBean) {
		this.customerBean = customerBean;
	}

	public String login() {
		String action = "";
		
		UsernamePasswordToken token = new UsernamePasswordToken(loginBean.getEmail(), loginBean.getPassword());
		token.setRememberMe(loginBean.isRemember());
		
		Subject currentUser = SecurityUtils.getSubject();

		try {
		    currentUser.login(token);
		    String email = (String)currentUser.getPrincipal();
		    
		    //Customer customer = customerService.findCustomerByEmail(email);
		    //System.out.println(customer.getFirstName() + " has just logged in.");
		    
		    action = "/index?faces-redirect=true";
		}
		catch(AuthenticationException ae) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Login Error", "Incorrect Credentials"));
		}
		
		return action;
	}
	
	public String logout() {
		String action = "/index?faces-redirect=true";
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		return action;
	}
}
