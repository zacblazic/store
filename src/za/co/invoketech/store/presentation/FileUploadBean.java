package za.co.invoketech.store.presentation;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import za.co.invoketech.store.application.config.Goose;
import za.co.invoketech.store.service.file.FileUploadService;

import com.google.inject.Inject;

@ManagedBean
public class FileUploadBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FileUploadService fileUploadService;
	private long productId;
	private UploadedFile file;
	
	public FileUploadBean() {
		Goose.getInjector().injectMembers(this);
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public void upload() {

		if(file != null && productId != 0) {
			
			try {
				fileUploadService.uploadImage(file.getInputstream(), productId);
			} catch (IOException e) {
				System.out.println(e);
			}

			FacesMessage msg = new FacesMessage("Succesful, " + file.getFileName() + " has been uploaded.", "");  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
}
