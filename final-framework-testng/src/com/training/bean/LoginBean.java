package com.training.bean;

public class LoginBean {
	//private String userName;
	//private String password;
	private String name;
	private String email;
	private String subject;
	private String message;
	
	public LoginBean() {
	}

	//public LoginBean(String userName, String password) {
	  public LoginBean(String name, String email, String subject, String message) {	
	    super();
		//this.userName = userName;
		//this.password = password;
	    this.name = name;
	    this.email = email;
	    this.subject = subject;
	    this.message = message;
	}
	  
	  public String getName() {
		  return name;
	  }
	  
	  public void setName(String name) {
		  this.name=name;
	  }
	  
	  public String getEmail() {
		  return email;
	  }
	  
	  public void setEmail(String email) {
		  this.email=email;
	  }
	  
	  public String getSubject() {
		  return subject;
	  }
	  
	  public void setSubject(String subject) {
		  this.subject=subject;
	  }
	  
	  public String getMessage() {
		  return message;
	  }
	  
	  public void setMessage(String message) {
		  this.message=message;
	  }
	  
	  @Override
		public String toString() {
			return "LoginBean [name=" + name + ", email=" + email + ", subject=" + subject + ", message=" + message +"]";
		}
}

	/*public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginBean [userName=" + userName + ", password=" + password + "]";
	}

}*/
