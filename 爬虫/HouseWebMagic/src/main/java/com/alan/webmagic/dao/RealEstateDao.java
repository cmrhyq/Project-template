package com.alan.webmagic.dao;

import com.alan.webmagic.domain.RealEstate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealEstateDao extends JpaRepository<RealEstate, Long> {
}
