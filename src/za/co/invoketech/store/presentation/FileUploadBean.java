package za.co.invoketech.store.presentation;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

@ManagedBean
public class FileUploadBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private UploadedFile file;
	
	public FileUploadBean() {
		System.out.println("FILE_UPLOAD_BEAN_CONSTRUCTOR");
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void upload() {
		
		System.out.println("Trying....");
		
		if(file != null) {
			FacesMessage msg = new FacesMessage("Succesful, " + file.getFileName() + " has been uploaded.");  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  
		} else {
			System.out.println("failed....");
		}
	}
}
