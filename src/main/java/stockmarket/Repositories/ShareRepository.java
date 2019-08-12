package main.java.stockmarket.Repositories;

import main.java.stockmarket.Entities.Share;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShareRepository extends JpaRepository<Share, String> {

}
