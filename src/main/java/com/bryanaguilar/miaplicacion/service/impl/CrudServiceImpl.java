package com.bryanaguilar.miaplicacion.service.impl;

import com.bryanaguilar.miaplicacion.dto.PageRequestDTO;
import com.bryanaguilar.miaplicacion.dto.PageResponseDTO;
import com.bryanaguilar.miaplicacion.model.BaseEntity;
import com.bryanaguilar.miaplicacion.repository.EntityRepository;
import com.bryanaguilar.miaplicacion.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;

@Component
public abstract class CrudServiceImpl<T extends BaseEntity, S extends Serializable> implements CrudService<T> {

    @Autowired
    protected EntityRepository<T, S> entityRepository;

    @Override
    public Optional<T> findById(Integer id) {
        return null; //this.entityRepository.findById(id);
    }

    @Override
    public List<T> findAll() {
        List<T> lista = this.entityRepository.findAll();
        return lista;
    }

    @Override
    public List<T> find(T bean) {
        //Example<T> example = null;
        //T entity = bean;
        //example = Example.of(entity);
        //List<T> lista = this.entityRepository.findAll(example);
        return null;//lista;
    }

    @Override
    public T save(T bean) {
        //if (bean == null) {
        //    return null;
        //}
        //bean = this.entityRepository.save(bean);
        return null;//bean;
    }

    @Override
    public T create(T bean) {
        //if (bean == null) {
        //    return null;
        //}
        //bean = this.entityRepository.save(bean);
        return null;//bean;
    }

    @Override
    public void delete(Integer id) {
        //if (id == null) {
        //    return;
        //}
        //this.entityRepository.deleteById(id);
    }

    @Override
    public void deleteMasivo(List<T> listaDto) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public PageResponseDTO<T> findPaginated(PageRequestDTO<T> dto) {
        //Example<T> example = null;
        //T entity = dto.getFilter();
//
        //Page<T> page;
        //if (entity != null) {
        //    example = Example.of(entity);
        //}
        //dto.setDefault();
        //Sort sort = Sort.by("id");
        //if (example != null) {
        //    page = this.entityRepository.findAll(example, dto.toPageable(sort));
        //} else {
        //    page = this.entityRepository.findAll(dto.toPageable(sort));
        //}
//
        //List<T> content = page.getContent().stream().map(this::toDTO).collect(Collectors.toList());
        return null;//new PageResponseDTO<>(page.getTotalPages(), page.getTotalElements(), content);
    }

    protected T toDTO(T bean) {
        return bean;
    }
}
