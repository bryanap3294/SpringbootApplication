package com.bryanaguilar.miaplicacion.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageRequestDTO<T> {

    private T filter;

    private int first;

    private int rows;

    private String sortField;

    private int sortOrder = 1;

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public PageRequestDTO() {
    }

    public PageRequestDTO(T filter, int first, int rows, String sortField) {
        this.filter = filter;
        this.first = first;
        this.rows = rows;
        this.sortField = sortField;
    }

    public T getFilter() {
        return filter;
    }

    public void setFilter(T filter) {
        this.filter = filter;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public Pageable toPageable() {
        if (sortField != null) {
            return PageRequest.of(toPageIndex(), rows, toSortDirection(), sortField);
        } else {
            return PageRequest.of(toPageIndex(), rows);
        }
    }

    public Pageable toPageable(Sort sortAvanzado) {
        return PageRequest.of(toPageIndex(), rows, sortAvanzado);

    }

    public void setDefault() {
       this.first = 0;
       this.rows = 1000;
    }

    public int toPageIndex() {
        return (first + rows) / rows - 1;
    }

    public Sort.Direction toSortDirection() {
        return sortOrder == 1 ? Sort.Direction.ASC : Sort.Direction.DESC;
    }
}
