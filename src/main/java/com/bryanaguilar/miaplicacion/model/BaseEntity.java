package com.bryanaguilar.miaplicacion.model;

import javax.persistence.*;

@Entity
public abstract class BaseEntity {

    @Id
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
