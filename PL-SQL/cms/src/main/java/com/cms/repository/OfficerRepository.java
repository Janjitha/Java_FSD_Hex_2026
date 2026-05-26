package com.cms.repository;

import com.cms.model.Officer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficerRepository extends JpaRepository<Officer,Integer> {

    Officer findByUserUsername(String username);
}
// select o from Officer o where o.user.username=?1