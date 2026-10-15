package com.huertos.api.controller;

import com.huertos.api.model.Parcel;
import com.huertos.api.service.ParcelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/parcels")
public class ParcelController {

    private final ParcelService parcelService;

    public ParcelController(ParcelService parcelService) {
        this.parcelService = parcelService;
    }

    // POST /api/v1/parcels: Registrar una nueva parcela (con validaciones)
    @PostMapping
    public ResponseEntity<Parcel> createParcel(@Valid @RequestBody Parcel parcel) {
        Parcel savedParcel = parcelService.saveParcel(parcel);
        return new ResponseEntity<>(savedParcel, HttpStatus.CREATED);
    }

    // GET /api/v1/parcels: Listar todas las parcelas registradas
    @GetMapping
    public ResponseEntity<List<Parcel>> getAllParcels() {
        List<Parcel> parcels = parcelService.getAllParcels();
        return ResponseEntity.ok(parcels);
    }

    // GET /api/v1/parcels/{id}: Consultar el detalle de una parcela por ID
    @GetMapping("/{id}")
    public ResponseEntity<Parcel> getParcelById(@PathVariable String id) {
        Parcel parcel = parcelService.getParcelById(id);
        return ResponseEntity.ok(parcel);
    }
}