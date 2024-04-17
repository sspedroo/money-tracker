package io.moneytracker.domain.category.service;

import io.moneytracker.domain.category.dto.CategoryResponseDTO;
import io.moneytracker.domain.category.dto.CreateCategoryRequestDTO;
import io.moneytracker.domain.category.model.Category;
import io.moneytracker.domain.category.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {
    private final CategoryRepository repository;

    @Transactional
    public CategoryResponseDTO createCategory(CreateCategoryRequestDTO dto){
        log.info("Creating a new category");

        Category category = Category.builder()
                .name(dto.getName())
                .build();
        repository.save(category);

        log.info("new category created with ID: {}", category.getId());
        return CategoryResponseDTO.toCategoryResponseDTO(category);
    }

    @Transactional(readOnly = true)
    public CategoryResponseDTO findCategoryById(Long id){
        log.info("Finding category by ID: {}", id);

        Category category = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found."));
        return CategoryResponseDTO.toCategoryResponseDTO(category);
    }

    @Transactional(readOnly = true)
    public List<CategoryResponseDTO> findAllCategory(){
        log.info("Finding all categories...");
        List<Category> categories = repository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        return categories.stream().map(CategoryResponseDTO::toCategoryResponseDTO).toList();
    }

    @Transactional
    public void deleteById(Long id){
        log.info("Deleting category by ID: {}", id);

        if (repository.existsById(id)) {
            repository.deleteById(id);

            log.info("Category with ID {} deleted successfully", id);
        } else {
            log.warn("Category with ID {} not found", id);

            throw new EntityNotFoundException("Category not found");
        }
    }
}
