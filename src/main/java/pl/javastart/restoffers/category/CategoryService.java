package pl.javastart.restoffers.category;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDto> findAll() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoriesDto = new ArrayList<>();
        for (Category category : categories) {
            CategoryDto categoryDto = new CategoryDto(category.getName(), category.getDescription());
            categoryDto.setOffers(category.getOffers().size());
            categoriesDto.add(categoryDto);
        }
        return categoriesDto;
    }

    public List<String> getCategoriesNamesList() {
        List<String> categoriesNames = new ArrayList<>();
        List<Category> categories = categoryRepository.findAll();
        for (Category category : categories) {
            categoriesNames.add(category.getName());
        }
        return categoriesNames;
    }

    public CategoryDto add(CategoryDto dto) {
        Category category = new Category();
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        categoryRepository.save(category);
        dto.setOffers(0);
        return dto;
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
