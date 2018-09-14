package com.bryanaguilar.miaplicacion.service;

import com.bryanaguilar.miaplicacion.dto.PageRequestDTO;
import com.bryanaguilar.miaplicacion.dto.PageResponseDTO;
import com.bryanaguilar.miaplicacion.model.AppParametria;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {

    public Optional<T> findById(Integer id);

    public List<T> findAll();

    public List<T> find(T req);

    public T save(T bean);

    public T create(T bean);

    public void delete(Integer id);

    public void deleteMasivo(List<T> listaDto);

    public void deleteAll();

    public PageResponseDTO<T> findPaginated(PageRequestDTO<T> req);

}
