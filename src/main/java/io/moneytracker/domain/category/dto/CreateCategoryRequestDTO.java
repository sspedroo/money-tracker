package io.moneytracker.domain.category.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryRequestDTO {
    @NotBlank(message = "Name cannot be empty.")
    @Size(min = 3, max = 50, message = "Name must have at least 3 letters and 50 letters at the most.")
    private String name;
}
