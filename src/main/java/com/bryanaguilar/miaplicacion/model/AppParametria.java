package com.bryanaguilar.miaplicacion.model;

import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import java.io.Serializable;

@Entity
@Table(name = "app_parametria")
@AttributeOverride(name = "id", column = @Column(name = "id_parametria", precision = 10))
public class AppParametria extends BaseEntity<Integer> {
    private static final long serialVersionUID = 1L;

    // Raw attributes
    
    private Integer id;
    private String modulo;
    private String label;
    private String description;
    
    private String value1;
    
    private String value2;
    
    private String value3;
    private String status;

    // -- [id] ------------------------
    @Column(name = "id_parametria", precision = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_app_parametria")
    @Id
    @SequenceGenerator(name = "seq_app_parametria", sequenceName = "seq_app_parametria")
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public AppParametria id(Integer id) {
        setId(id);
        return this;
    }

    @Transient
    public boolean isIdSet() {
        return id != null;
    }
    // -- [modulo] ------------------------

    @NotEmpty
    @Size(max = 30)
    @Column(name = "modulo", nullable = false, length = 30)
    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public AppParametria modulo(String modulo) {
        setModulo(modulo);
        return this;
    }
    // -- [label] ------------------------

    @NotEmpty
    @Size(max = 100)
    @Column(name = "label", nullable = false, length = 100)
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public AppParametria label(String label) {
        setLabel(label);
        return this;
    }
    // -- [description] ------------------------

    @NotEmpty
    @Size(max = 100)
    @Column(name = "description", nullable = false, length = 100)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AppParametria description(String description) {
        setDescription(description);
        return this;
    }
    // -- [value1] ------------------------

    @NotEmpty
    @Size(max = 255)
    @Column(name = "value_1", nullable = false)
    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public AppParametria value1(String value1) {
        setValue1(value1);
        return this;
    }
    // -- [value2] ------------------------

    @Size(max = 255)
    @Column(name = "value_2")
    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public AppParametria value2(String value2) {
        setValue2(value2);
        return this;
    }
    // -- [value3] ------------------------

    @Size(max = 2147483647)
    @Column(name = "value_3", length = 2147483647)
    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }

    public AppParametria value3(String value3) {
        setValue3(value3);
        return this;
    }
    // -- [status] ------------------------

    @NotEmpty
    @Column(name = "status", nullable = false, length = 1)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AppParametria status(String status) {
        setStatus(status);
        return this;
    }

    public AppParametria withDefaults() {
        return this;
    }

    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof AppParametria && hashCode() == other.hashCode());
    }
}