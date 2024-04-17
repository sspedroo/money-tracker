package io.moneytracker.domain.category.service;

import io.moneytracker.domain.category.dto.CategoryResponseDTO;
import io.moneytracker.domain.category.dto.CreateCategoryRequestDTO;
import io.moneytracker.domain.category.model.Category;
import io.moneytracker.domain.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;

    public CategoryResponseDTO createCategory(CreateCategoryRequestDTO dto){
        Category category = Category.builder()
                .name(dto.getName())
                .build();
        repository.save(category);
        return CategoryResponseDTO.toCategoryResponseDTO(category);
    }
}
