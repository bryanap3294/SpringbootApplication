package com.bryanaguilar.miaplicacion.rest;

import com.bryanaguilar.miaplicacion.dto.PageRequestDTO;
import com.bryanaguilar.miaplicacion.dto.PageResponseDTO;
import com.bryanaguilar.miaplicacion.service.CrudService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public abstract class CrudRest<T> {

    @Autowired
    protected CrudService<T> entityService;

    @GetMapping("/prueba")
    public String holaMundo() {
        try {
            return "Hola Mundo";
        } catch (Exception e) {
            return null;
            //throw new RuntimeException(e);
        }
    }

    @ApiOperation(value = "Devuelve lista de registros de tipo AppParametria", produces = "application/json")
    @GetMapping("/findAll")
    public ResponseEntity<List<T>> findAll() {
        try {
            return Optional.of(this.entityService.findAll()).map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            return null;
            //throw new RuntimeException(e);
        }
    }

    @ApiOperation(value = "Busca registro de tipo AppParametria en base al id enviado", produces = "application/json")
    @GetMapping("/findById/{id}")
    public ResponseEntity<T> findById(@PathVariable Integer id){
        try {
            return Optional.ofNullable(this.entityService.findById(id).get())
                    .map(appParametria -> new ResponseEntity<>(appParametria, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return null;
            //throw new RuntimeException(e);
        }
    }

    @ApiOperation(value = "Devuelve lista de registros de tipo AppParametria en base a los parámetros ingresados", produces = "application/json")
    @PostMapping("/find")
    public ResponseEntity<List<T>> find(@RequestBody T bean){
        try {
            return Optional.of(this.entityService.find(bean)).map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            return null;
            //throw new RuntimeException(e);
        }
    }

    @ApiOperation(value = "Modifica o crea registro de tipo AppParametria", produces = "application/json")
    @PostMapping("/save")
    public ResponseEntity<T> save(@RequestBody T bean) {
        try {
            T result = this.entityService.save(bean);
            return Optional.of(result).map(l -> new ResponseEntity<>(l, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            return null;
            //throw new RuntimeException(e);
        }
    }

    @ApiOperation(value = "Crea un nuevo registro de tipo AppParametria", produces = "application/json")
    @PostMapping("/create")
    public ResponseEntity<T> create(@RequestBody T bean){
        try {
            return Optional.of(this.entityService.create(bean)).map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            return null;
            //throw new RuntimeException(e);
        }
    }

    @ApiOperation(value = "Elimina registro de tipo AppParametria en base al Id enviado", produces = "application/json")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            this.entityService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return null;
            //throw new RuntimeException(e);
        }
    }

    @ApiOperation(value = "Devuelve lista de registros paginados de tipo AppParametria", produces = "application/json")
    @PostMapping("/findPaginated")
    public ResponseEntity<PageResponseDTO<T>> findPaginated(@RequestBody PageRequestDTO<T> prbe) {
        try {
            PageResponseDTO<T> pageResponseDTO = this.entityService.findPaginated(prbe);
            return new ResponseEntity<>(pageResponseDTO, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
