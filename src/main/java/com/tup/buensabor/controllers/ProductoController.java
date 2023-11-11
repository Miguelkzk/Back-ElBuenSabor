package com.tup.buensabor.controllers;

import com.tup.buensabor.DTO.BuscarEntreFechasDTO;
import com.tup.buensabor.entities.Producto;
import com.tup.buensabor.servicies.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/productos")
public class ProductoController extends BaseControllerImpl<Producto, ProductoServiceImpl> {
    @Autowired
    ProductoServiceImpl productoService;
    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllProductos(){
        return getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        return super.getOne(id);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return super.delete(id);
    }

    @PostMapping(value = "/create")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> saveProducto(@RequestBody Producto entity){
        return save(entity);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Producto entity) {
        return super.update(id, entity);
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro,pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @GetMapping(path = "/rankingProductos")
    public ResponseEntity<?> traerRankingProductos(@RequestBody BuscarEntreFechasDTO buscarEntreFechasDTO){
        try {
            return  ResponseEntity.status(HttpStatus.OK).body(productoService.traerRankingProductos(buscarEntreFechasDTO));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));
        }
    }

}
