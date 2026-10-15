package com.huertos.api.service;

import com.huertos.api.exception.ResourceNotFoundException;
import com.huertos.api.model.Parcel;
import com.huertos.api.repository.ParcelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcelService {

    private final ParcelRepository parcelRepository;

    public ParcelService(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }

    // Registrar una nueva parcela
    public Parcel saveParcel(Parcel parcel) {
        return parcelRepository.save(parcel);
    }

    // Listar todas las parcelas
    public List<Parcel> getAllParcels() {
        return parcelRepository.findAll();
    }

    // Consultar el detalle de una parcela por ID (lanza excepción si no existe)
    public Parcel getParcelById(String id) {
        return parcelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Parcela no encontrada con el ID: " + id));
    }
}