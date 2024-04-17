package io.moneytracker.domain.subcategory.service;

import io.moneytracker.domain.category.repository.CategoryRepository;
import io.moneytracker.domain.subcategory.dto.CreateSubcategoryRequestDTO;
import io.moneytracker.domain.subcategory.dto.SubcategoryResponseDTO;
import io.moneytracker.domain.subcategory.dto.mapper.SubcategoryMapper;
import io.moneytracker.domain.subcategory.model.Subcategory;
import io.moneytracker.domain.subcategory.repository.SubcategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class SubcategoryService {
    private final SubcategoryRepository subcategoryRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public SubcategoryResponseDTO createSubcategory(CreateSubcategoryRequestDTO dto){
        Subcategory subcategory = Subcategory.builder()
                .name(dto.getName())
                .parentCategory(categoryRepository.findById(dto.getParentCategoryId())
                        .orElseThrow(() -> new EntityNotFoundException("Category not found.")))
                .build();
        addSubcategoryInCategorySet(subcategory);

        subcategoryRepository.save(subcategory);
        return SubcategoryMapper.toSubcategoryResponseDTO(subcategory);
    }

    private void addSubcategoryInCategorySet(Subcategory subcategory){
        Set<Subcategory> parentSubcategories = subcategory.getParentCategory().getSubcategories();
        parentSubcategories.add(subcategory);
    }
}
