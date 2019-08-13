package main.java.stockmarket.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import main.java.stockmarket.Entities.UserShare;
import main.java.stockmarket.Entities.UserShareKey;

public interface UserShareRepository extends JpaRepository<UserShare, UserShareKey> {

}
