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
package za.co.invoketech.store.presentation;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.presentation.customer.CustomerBean;

/**
 * 
 * @author garethc18@gmail.com (Gareth Conry)
 *
 */
@SessionScoped
@ManagedBean
public class LoginBean {
	
	@ManagedProperty(value="#{customerBean}")
	private CustomerBean customerBean;
	
	private String email;
	private String password;
	private boolean remember;
	
	public LoginBean() {
		Goose.getInjector().injectMembers(this);
		
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
		
	public boolean isRemember() {
		return remember;
	}

	public void setRemember(boolean remember) {
		this.remember = remember;
	}

	public String login(){
		String returnAction = "/index?faces-redirect=true";
		
		UsernamePasswordToken token = new UsernamePasswordToken(email, password);
		token.setRememberMe(remember);
		
		Subject currentUser = SecurityUtils.getSubject();

		try {
		    currentUser.login(token);
		}
		catch ( AuthenticationException ae ) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Login Error", "Incorrect Credentials"));
			returnAction="";
		}
		
		return returnAction;
	}
	
	public String logout()
	{
		String returnAction = "/index?faces-redirect=true";
		
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
				
		return returnAction;
	}
}
