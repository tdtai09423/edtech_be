package com.example.edtech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.edtech.entities.Resource;
import com.example.edtech.repositories.ResourceRepository;

@Service
public class ResouceService {
    @Autowired
    private ResourceRepository resourceRepository;

    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    public Optional<Resource> getResourceById(Long id) {
        return resourceRepository.findById(id);
    }

    public Resource saveResource(Resource resouce) {
        return resourceRepository.save(resouce);
    }

    public void deleteResource(Long id) {
        resourceRepository.deleteById(id);
    }
}
