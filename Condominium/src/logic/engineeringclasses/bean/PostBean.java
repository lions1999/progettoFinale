package logic.engineeringclasses.bean;

import logic.model.Role;

import java.io.InputStream;

public class PostBean {

	private String id;
	private String usr;
	private Role role;
	private InputStream img;
	private String text;
	
	public String getPostId() {
		return this.id;
	}

	public void setPostId(String id) {
		this.id = id;
	}

	public void setPostUser(String usr) {
		this.usr = usr;
	}
	
	public String getPostUser() {
		return this.usr;
	}

	public void setPostRole(Role role){this.role = role;}

	public Role getPostRole(){return this.role;}
	
	public void setPostImage(InputStream img) {
		this.img = img;
	}
	
	public InputStream getPostImage() {
		return this.img;
	}	

	public String getPostText() {
		return text;
	}

	public void setPostText(String text) {
		this.text = text;
	}
}
