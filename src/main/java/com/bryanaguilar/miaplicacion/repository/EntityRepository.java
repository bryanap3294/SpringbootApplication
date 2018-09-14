package com.bryanaguilar.miaplicacion.repository;

import com.bryanaguilar.miaplicacion.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface EntityRepository<T extends BaseEntity, IdType extends Serializable> extends JpaRepository<T, IdType> {


}
