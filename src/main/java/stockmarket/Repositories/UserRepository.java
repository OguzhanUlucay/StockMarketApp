package main.java.stockmarket.Repositories;

import main.java.stockmarket.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
