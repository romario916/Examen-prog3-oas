package com.federation.service;

import com.federation.model.Collectivity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CollectivityService {
    public void validateImmutability(Collectivity existing, Collectivity updated) {
        if (!existing.getId_number().equals(updated.getId_number()) ||
                !existing.getName().equals(updated.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID Number and Name are immutable!");
        }
    }
}
