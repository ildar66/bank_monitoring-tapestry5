package ru.ildar66.bm.common.entity;

/**
 * NotificationRecipient entity.
 * 
 * @author Shafigullin Ildar
 * 
 */
public class NotificationRecipient {
	private String id;
	private String name;
	private String email;

	public NotificationRecipient() {
		super();
	}

	public NotificationRecipient(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
