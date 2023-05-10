package kg.mega.rent_cars.repository;

import kg.mega.rent_cars.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderDetailsDao extends JpaRepository<OrderDetails, Long> {
    @Query("SELECT o.dateTimeFrom FROM OrderDetails o WHERE o.id = :id AND o.dateTimeTo BETWEEN :dateTimeFrom AND :dateTimeTo")
    List<LocalDate> findStartDatesBetween(Long id, LocalDate dateTimeFrom, LocalDate dateTimeTo);

    @Query("SELECT o.dateTimeTo FROM OrderDetails o WHERE o.id = :id AND o.dateTimeFrom BETWEEN :dateTimeFrom AND :dateTimeTo")
    List<LocalDate> findEndDatesBetween(Long id, LocalDate dateTimeFrom, LocalDate dateTimeTo);
}
