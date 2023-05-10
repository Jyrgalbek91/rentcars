package kg.mega.rent_cars.repository;

import kg.mega.rent_cars.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountDao extends JpaRepository<Discount, Long> {
    @Query(value = "select * from tb_discount where now() < tb_discount.end_date and car_id =:carId",
            nativeQuery = true)
    List<Discount> findByCar_Id(Long carId);
}
