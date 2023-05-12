package pl.javastart.restoffers.offer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {

    @Query(value = "SELECT * FROM offer WHERE LOWER(title) LIKE %:text%", nativeQuery = true)
    List<Offer> findOfferByTitle(@Param("text") String text);
}
