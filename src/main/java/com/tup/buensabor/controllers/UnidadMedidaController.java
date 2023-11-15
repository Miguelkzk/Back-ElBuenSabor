package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.UnidadMedida;
import com.tup.buensabor.servicies.UnidadMedidaServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/unidadMedidas")

public class UnidadMedidaController extends BaseControllerImpl<UnidadMedida, UnidadMedidaServiceImpl> {
    @GetMapping(value = "/all")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> getAllUnidadMedida(){
        return getAll();
    }
}
