package pl.javastart.restoffers.category;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/categories")
@RestController
public class CategoryRestController {

    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/names")
    List<String> getCategoriesNamesList() {
        return categoryService.getCategoriesNamesList();
    }

    @GetMapping("")
    List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @PostMapping("")
    public ResponseEntity<CategoryDto> addTask(@RequestBody CategoryDto dto) {
        CategoryDto categoryDto = categoryService.add(dto);
        return ResponseEntity.ok(categoryDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);
    }
}
