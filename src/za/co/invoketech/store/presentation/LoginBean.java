package za.co.invoketech.store.presentation;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

@SessionScoped
@ManagedBean
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String email;
	private String password;
	private boolean remember;
	
	public LoginBean() {
		System.out.println("LOGIN_BEAN_CONSTRUCTOR");
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
		String returnAction = "admin/admin?faces-redirect=true";
		
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
		String returnAction = "./?faces-redirect=true";
		
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		
		return returnAction;
	}
}
