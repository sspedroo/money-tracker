package io.moneytracker.domain.user.controller;

import io.moneytracker.domain.user.dto.CreateUserRequestDTO;
import io.moneytracker.domain.user.dto.UserResponseDTO;
import io.moneytracker.domain.user.model.User;
import io.moneytracker.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
    private final UserService service;


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<UserResponseDTO> saveUser(@ModelAttribute CreateUserRequestDTO dto,
                                         @RequestParam(required = false, value = "image") MultipartFile image){
        try {
            UserResponseDTO savedUser = service.saveUser(dto, image);
            return ResponseEntity.ok(savedUser);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getProfileImage/{id}")
    public ResponseEntity<?> getProfileImage(@PathVariable Long id) throws IOException {
        FileSystemResource profileImage = service.getProfileImage(id);
        if (profileImage == null) {
            return ResponseEntity.notFound().build();
        }
        String contentType = Files.probeContentType(profileImage.getFile().toPath());
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).body(profileImage);
    }
}