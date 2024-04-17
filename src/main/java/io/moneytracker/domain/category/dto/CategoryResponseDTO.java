package io.moneytracker.domain.category.dto;

import io.moneytracker.domain.category.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class CategoryResponseDTO {
    private Long id;
    private String name;
    private Set<String> subCategories = new HashSet<>();

    public static CategoryResponseDTO toCategoryResponseDTO(Category entity){
        return CategoryResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
