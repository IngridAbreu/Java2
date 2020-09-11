package org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.services;

public class DataNotFoundException extends Exception {

	private Integer id;
	public  DataNotFoundException(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
}
