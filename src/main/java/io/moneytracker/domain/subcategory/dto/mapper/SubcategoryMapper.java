package io.moneytracker.domain.subcategory.dto.mapper;

import io.moneytracker.domain.subcategory.dto.SubcategoryResponseDTO;
import io.moneytracker.domain.subcategory.model.Subcategory;

public final class SubcategoryMapper {
    public static SubcategoryResponseDTO toSubcategoryResponseDTO(Subcategory entity){
        return SubcategoryResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .parentCategory(entity.getParentCategory().getName())
                .build();
    }
}
