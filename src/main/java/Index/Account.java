package Index;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
  
   private String name;
   @Column(unique=true)
   @Id
   private String email;
   @Column(unique=true)
   private String cno;
   @Column(nullable = false)
   private String pass;
   @Column(nullable = false)
   private String cpass;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCno() {
	return cno;
}
public void setCno(String cno2) {
	this.cno = cno2;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getCpass() {
	return cpass;
}
public void setCpass(String cpass) {
	this.cpass = cpass;
}
   
   
   
}
