package com.bryanaguilar.miaplicacion.custom.rest;

import com.bryanaguilar.miaplicacion.custom.repository.AppParametriaRepository;
import com.bryanaguilar.miaplicacion.model.AppParametria;
import com.bryanaguilar.miaplicacion.rest.CrudRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppParametriaRest extends CrudRest<AppParametria> {

    @Autowired
    protected AppParametriaRepository appParametriaRepository;

}
