package ru.ildar66.bm.common.entity;

/**
 * Contractor entity.
 * 
 * @author Shafigullin Ildar
 * 
 */
public class Contractor {
	private String id;
	private String name;

	public Contractor(String name) {
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
