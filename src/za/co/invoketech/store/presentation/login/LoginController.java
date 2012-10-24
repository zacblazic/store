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
import javax.faces.context.FacesContext;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import com.google.inject.servlet.RequestScoped;

/**
 * @author garethc18@gmail.com (Gareth Conry)
 * @author zacblazic@gmail.com (Zac Blazic)
 */
@RequestScoped
@ManagedBean
public class LoginController {
	
	private static final String indexPage = "/index?faces-redirect=true";
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	private Subject currentUser;
	
	public LoginController() {
		currentUser = SecurityUtils.getSubject();
	}
	
	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public String login() {
		UsernamePasswordToken token = new UsernamePasswordToken(loginBean.getEmail(), loginBean.getPassword());
		token.setRememberMe(loginBean.isRemember());
		
		try {
		    currentUser.login(token);
		    return indexPage;
		}
		catch(AuthenticationException ae) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Login Error", "Incorrect Credentials"));
		}
		
		return "";
	}
	
	public String logout() {
		currentUser.logout();
		return indexPage;
	}
}
