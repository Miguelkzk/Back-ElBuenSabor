package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.entities.Producto;
import com.tup.buensabor.servicies.ArticuloInsumoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/articulos")
public class ArticuloInsumoController extends BaseControllerImpl<ArticuloInsumo, ArticuloInsumoImpl> {

    @Autowired
    ArticuloInsumoImpl articuloInsumo;

    @GetMapping(value = "/all")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'EMPLEADO')")
    public ResponseEntity<?> getAllArticuloInsumos(){ return getAll();}

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'EMPLEADO')")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        return super.getOne(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'EMPLEADO')")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return super.delete(id);
    }

    @PostMapping(value = "/create")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'EMPLEADO')")
    public ResponseEntity<?> saveArticuloInsumo(@RequestBody ArticuloInsumo entity){
        return save(entity);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'EMPLEADO')")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ArticuloInsumo entity) {
        return super.update(id, entity);
    }



    @GetMapping("/searchbyalta")
    public ResponseEntity<?> searchbyalta(Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchbyalta(pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @GetMapping("/searchbystock")
    public ResponseEntity<?> searchbystock(Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchbystock(pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
