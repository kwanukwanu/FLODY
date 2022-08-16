package com.ssafy.flody.domain.flowers.gardens;

import com.ssafy.flody.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GardensRepository extends JpaRepository<Gardens, Long> {
    List<Gardens> findAllByUser(Users user);
}
