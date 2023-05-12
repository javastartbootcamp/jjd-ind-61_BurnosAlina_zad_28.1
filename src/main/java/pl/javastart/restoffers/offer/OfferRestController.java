package pl.javastart.restoffers.offer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/offers")
@RestController
public class OfferRestController {

    private final OfferService offerService;

    public OfferRestController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("")
    List<OfferDto> findOffers(@RequestParam(required = false) String title) {
        List<OfferDto> offers;
        if (title != null) {
            offers = offerService.findOffersContainingText(title);
        } else {
            offers = offerService.findAll();
        }
        return offers;
    }

    @GetMapping("/count")
    long getNumberOfOffers() {
        return offerService.countOffers();
    }

    @PostMapping("")
    public ResponseEntity<OfferDto> addTask(@RequestBody OfferDto dto) {
        OfferDto offerDto = offerService.add(dto);
        return ResponseEntity.ok(offerDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferDto> findById(@PathVariable Long id) {
        Optional<OfferDto> offerOptional = offerService.findById(id);
        return offerOptional
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        offerService.deleteById(id);
    }
}
