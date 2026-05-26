package com.cms.repository;
import com.cms.model.Officer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OfficerRepository extends JpaRepository<Officer,Integer> {

    Officer findByUserUsername(String username);

    @Query("""
            select o
            from Officer o
            where o.station.stationHead.user.username=?1
            """)
    List<Officer> getOfficersByStationHead(String stationHeadUsername);
}
// select o from Officer o where o.user.username=?1