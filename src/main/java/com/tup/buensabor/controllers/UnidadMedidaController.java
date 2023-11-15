package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.UnidadMedida;
import com.tup.buensabor.servicies.UnidadMedidaServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/unidadMedidas")

public class UnidadMedidaController extends BaseControllerImpl<UnidadMedida, UnidadMedidaServiceImpl> {
    public ResponseEntity<?> getAll() {
        return super.getAll();
    }

    public ResponseEntity<?> getOne(Long id) {
        return super.getOne(id);
    }

    public ResponseEntity<?> save(UnidadMedida entity) {
        return super.save(entity);
    }

    public ResponseEntity<?> update(Long id, UnidadMedida entity) {
        return super.update(id, entity);
    }

    public ResponseEntity<?> delete(Long id) {
        return super.delete(id);
    }
}
