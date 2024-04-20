package io.moneytracker.domain.user.service;

import io.moneytracker.domain.paymentMethods.model.PaymentMethod;
import io.moneytracker.domain.user.dto.CreateUserRequestDTO;
import io.moneytracker.domain.user.dto.UserMapper.UserMapper;
import io.moneytracker.domain.user.dto.UserResponseDTO;
import io.moneytracker.domain.user.model.User;
import io.moneytracker.domain.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository repository;
    private static final String UPLOAD_DIRECTORY = "C:\\FACULDADE\\JAVA\\MoneyTracker\\src\\main\\webapp\\images";


    @Transactional
    public UserResponseDTO saveUser(CreateUserRequestDTO dto, MultipartFile image) throws IOException {
        log.info("saving new user in database");
        User user = User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .isActive(1)
                .build();

        if (image != null && !image.isEmpty()){
            String originalFilename = getOriginalFilename(image);
            user.setProfileImage(originalFilename);
        }

        repository.save(user);

        log.info("User saved successfully");
        return UserMapper.toUserResponseDTO(user);
    }

    private static String getOriginalFilename(MultipartFile image){
        String originalFilename = image.getOriginalFilename();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, originalFilename);
        try {
            Files.write(fileNameAndPath, image.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return originalFilename;
    }

    public FileSystemResource getProfileImage(Long userId) {
        log.info("retrieving profile image from user ID: {}", userId);
        User user = repository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        if (user.getProfileImage() == null){
            return null;
        }
        Path imagePath = Paths.get(UPLOAD_DIRECTORY, user.getProfileImage());

        return new FileSystemResource(imagePath.toFile());
    }

    @Transactional
    public void removePaymentMethodFromUser(User user, PaymentMethod paymentMethod){
        user.getPaymentMethods().remove(paymentMethod);
        repository.save(user);
    }
}
