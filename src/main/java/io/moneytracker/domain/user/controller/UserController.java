package io.moneytracker.domain.user.controller;

import io.moneytracker.domain.user.dto.CreateUserRequestDTO;
import io.moneytracker.domain.user.dto.UserResponseDTO;
import io.moneytracker.domain.user.model.User;
import io.moneytracker.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Encoding;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
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
    //Isso daqui é para o swagger entender que o dto é um application/json, senao da erro
    @RequestBody(content = @Content(encoding = @Encoding(name = "dto", contentType = "application/json")))
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "User Processed Successfully",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))}),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request", content = {@Content(schema = @Schema(hidden = true))}),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Un-authorized", content = {@Content(schema = @Schema(hidden = true))}),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal Server Error", content = {@Content(schema = @Schema(hidden = true))})})
    public ResponseEntity<UserResponseDTO> saveUser (@RequestPart(value = "dto") final CreateUserRequestDTO dto,
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