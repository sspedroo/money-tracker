package io.moneytracker.domain.subcategory.service;

import io.moneytracker.domain.subcategory.repository.SubcategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubcategoryService {
    private final SubcategoryRepository repository;
}
