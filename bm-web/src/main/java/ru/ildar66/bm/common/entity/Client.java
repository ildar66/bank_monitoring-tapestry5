package ru.ildar66.bm.common.entity;

/**
 * Client entity.
 * 
 * @author Shafigullin Ildar
 * 
 */
public class Client {
	private String id;
	private String name;

	public Client(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
