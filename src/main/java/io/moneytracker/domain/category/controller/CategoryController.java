package io.moneytracker.domain.category.controller;

import io.moneytracker.domain.category.dto.CategoryResponseDTO;
import io.moneytracker.domain.category.dto.CreateCategoryRequestDTO;
import io.moneytracker.domain.category.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CategoryController {
    private final CategoryService service;

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody @Valid CreateCategoryRequestDTO dto) {
        CategoryResponseDTO categoryResponseDTO = service.createCategory(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(categoryResponseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(categoryResponseDTO);
    }
}
