package pl.javastart.restoffers.offer;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.javastart.restoffers.category.Category;
import pl.javastart.restoffers.category.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final CategoryRepository categoryRepository;

    public OfferService(OfferRepository offerRepository, CategoryRepository categoryRepository) {
        this.offerRepository = offerRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<OfferDto> findAll() {
        Iterable<Offer> offers = offerRepository.findAll();
        return convertOffersToDtoList(offers);
    }

    public long countOffers() {
        return offerRepository.count();
    }

    public List<OfferDto> findOffersContainingText(String text) {
        List<Offer> offers = offerRepository.findOfferByTitle(text);
        return convertOffersToDtoList(offers);
    }

    private List<OfferDto> convertOffersToDtoList(Iterable<Offer> offers) {
        List<OfferDto> offersDto = new ArrayList<>();
        for (Offer offer : offers) {
            OfferDto offerDto = new OfferDto(offer.getId(), offer.getTitle(), offer.getDescription(),
                    offer.getImgUrl(), offer.getPrice(), offer.getCategory().getName());
            offersDto.add(offerDto);
        }
        return offersDto;
    }

    public OfferDto add(OfferDto dto) {
        Offer offer = new Offer();
        offer.setTitle(dto.getTitle());
        offer.setDescription(dto.getDescription());
        offer.setImgUrl(dto.getImgUrl());
        offer.setPrice(dto.getPrice());
        Category category = categoryRepository.findByName(dto.getCategory());
        offer.setCategory(category);
        offerRepository.save(offer);
        OfferDto offerDto = toDto(offer);
        return offerDto;
    }

    public Optional<OfferDto> findById(Long id) {
        return offerRepository.findById(id).map(this::toDto);
    }

    private OfferDto toDto(Offer offer) {
        OfferDto dto = new OfferDto(offer.getId(), offer.getTitle(), offer.getDescription(),
                offer.getImgUrl(), offer.getPrice(), offer.getCategory().getName());
        return dto;
    }

    public ResponseEntity<Void> deleteById(Long id) {
        try {
            offerRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
