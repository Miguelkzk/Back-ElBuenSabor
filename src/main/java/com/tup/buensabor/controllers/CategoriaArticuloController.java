package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.CategoriaArticulo;
import com.tup.buensabor.servicies.CategoriaArticuloServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/categorias")

public class CategoriaArticuloController extends BaseControllerImpl<CategoriaArticulo, CategoriaArticuloServiceImpl> {
    @GetMapping(value = "/all")
   // @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> getAllCategoria(){
        return getAll();
    }
    @GetMapping("/searchbyalta")
    public ResponseEntity<?> searchbyalta(Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchbyalta(pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    public ResponseEntity<?> getAll() {
        return super.getAll();
    }


    public ResponseEntity<?> getAll(Pageable pageable) {
        return super.getAll(pageable);
    }


    public ResponseEntity<?> getOne(Long id) {
        return super.getOne(id);
    }


    public ResponseEntity<?> save(CategoriaArticulo entity) {
        return super.save(entity);
    }


    public ResponseEntity<?> update(Long id, CategoriaArticulo entity) {
        return super.update(id, entity);
    }


    public ResponseEntity<?> delete(Long id) {
        return super.delete(id);
    }

}