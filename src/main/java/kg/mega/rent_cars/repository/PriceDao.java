package kg.mega.rent_cars.repository;

import kg.mega.rent_cars.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceDao extends JpaRepository<Price, Long> {
    @Query(value = "select * from tb_price where now() < tb_price.end_date and car_id =:carId order by id desc limit 1",
            nativeQuery = true)
    Price findByCar_Id(Long carId);
}

