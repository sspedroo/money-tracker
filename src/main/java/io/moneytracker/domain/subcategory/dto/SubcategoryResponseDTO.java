package io.moneytracker.domain.subcategory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubcategoryResponseDTO {
    private Long id;
    private String name;
    private String parentCategory;
}
