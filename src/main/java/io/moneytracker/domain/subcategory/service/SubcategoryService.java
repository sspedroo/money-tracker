package io.moneytracker.domain.subcategory.service;

import io.moneytracker.domain.category.repository.CategoryRepository;
import io.moneytracker.domain.subcategory.dto.CreateSubcategoryRequestDTO;
import io.moneytracker.domain.subcategory.dto.SubcategoryResponseDTO;
import io.moneytracker.domain.subcategory.dto.mapper.SubcategoryMapper;
import io.moneytracker.domain.subcategory.model.Subcategory;
import io.moneytracker.domain.subcategory.repository.SubcategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubcategoryService {
    private final SubcategoryRepository subcategoryRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public SubcategoryResponseDTO createSubcategory(CreateSubcategoryRequestDTO dto){
        log.info("Creating a new subcategory...");

        Subcategory subcategory = Subcategory.builder()
                .name(dto.getName())
                .parentCategory(categoryRepository.findById(dto.getParentCategoryId())
                        .orElseThrow(() -> new EntityNotFoundException("Category not found.")))
                .build();
        addSubcategoryInCategorySet(subcategory);

        subcategoryRepository.save(subcategory);
        log.info("new subcategory created with ID: {}", subcategory.getId());
        return SubcategoryMapper.toSubcategoryResponseDTO(subcategory);
    }


    @Transactional
    public void deleteSubcategoryById(Long id){
        log.info("Deleting a subcategory with ID: {}", id);

        Subcategory subcategory = subcategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found."));
        removeSubcategoryInCategorySet(subcategory);
        subcategoryRepository.delete(subcategory);
        log.info("Deleted successfully");
    }

    private void addSubcategoryInCategorySet(Subcategory subcategory){
        Set<Subcategory> parentSubcategories = subcategory.getParentCategory().getSubcategories();
        parentSubcategories.add(subcategory);
    }
    private void removeSubcategoryInCategorySet(Subcategory subcategory){
        Set<Subcategory> parentSubcategories = subcategory.getParentCategory().getSubcategories();
        parentSubcategories.remove(subcategory);
    }

}
