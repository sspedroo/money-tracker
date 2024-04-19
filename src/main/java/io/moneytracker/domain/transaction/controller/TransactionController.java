package io.moneytracker.domain.transaction.controller;

import io.moneytracker.domain.transaction.dto.CreateTransactionRequestDTO;
import io.moneytracker.domain.transaction.dto.TransactionResponseDTO;
import io.moneytracker.domain.transaction.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TransactionController {
    private final TransactionService service;


    @PostMapping
    public ResponseEntity<TransactionResponseDTO> createTransaction(@RequestBody @Valid CreateTransactionRequestDTO dto){
        TransactionResponseDTO transactionResponseDTO = service.addTransaction(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(transactionResponseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(transactionResponseDTO);
    }
}
