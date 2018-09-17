package com.bryanaguilar.miaplicacion.model;

import javax.persistence.*;
import java.io.Serializable;


@MappedSuperclass
@SuppressWarnings("serial")
public abstract class BaseEntity<T> {

    
    private T id;
 
    @Id
	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

}
