package ujfaA.jbMessenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	
	private long id;
	private String mesagge;
	private Date created;
	private String author;
	
	
	public Message() {	
	}
	
	public Message(long id, String message, String author) {
		this.id = id;
		this.mesagge = message;
		this.author = author;
		this.created = new Date();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMesagge() {
		return mesagge;
	}
	public void setMesagge(String mesagge) {
		this.mesagge = mesagge;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
