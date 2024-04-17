package io.moneytracker.domain.subcategory.controller;

import io.moneytracker.domain.subcategory.dto.CreateSubcategoryRequestDTO;
import io.moneytracker.domain.subcategory.dto.SubcategoryResponseDTO;
import io.moneytracker.domain.subcategory.service.SubcategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/subcategory")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SubcategoryController {
    private final SubcategoryService service;

    @PostMapping
    public ResponseEntity<SubcategoryResponseDTO> createSubcategory(@RequestBody @Valid CreateSubcategoryRequestDTO dto){
        SubcategoryResponseDTO subcategoryResponseDTO = service.createSubcategory(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(subcategoryResponseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(subcategoryResponseDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSubcategory(@PathVariable("id") Long id){
        service.deleteSubcategoryById(id);
        return ResponseEntity.noContent().build();
    }
}
