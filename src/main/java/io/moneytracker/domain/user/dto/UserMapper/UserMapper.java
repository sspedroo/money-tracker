package io.moneytracker.domain.user.dto.UserMapper;

import io.moneytracker.domain.user.dto.UserResponseDTO;
import io.moneytracker.domain.user.model.User;

public final class UserMapper {

    public static UserResponseDTO toUserResponseDTO(User entity){
        return UserResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .isActive(entity.getIsActive())
                .build();
    }
}
