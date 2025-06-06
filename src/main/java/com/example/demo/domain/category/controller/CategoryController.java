package com.example.demo.domain.category.controller;

import com.example.demo.domain.category.dto.*;
import com.example.demo.domain.category.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // REST API 컨트롤러
@RequestMapping("/api/categories") // 카테고리 API 엔드포인트 매핑
@Tag(name = "Category", description = "카테고리 관련 API") // Swagger 설명
@RequiredArgsConstructor // 생성자 주입을 통한 의존성 주입
public class CategoryController {

    private final CategoryService categoryService; // 카테고리 서비스 의존성 주입

    @Operation(summary = "카테고리 생성", description = "카테고리 생성")
    @PostMapping
    public ResponseEntity<CategoryResponse> create(@RequestBody CategoryRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoryService.create(request));
    }

    @Operation(summary = "전체 카테고리 조회", description = "전체 카테고리 조회")
    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }
}