package com.alan.webmagic.dao;

import com.alan.webmagic.domain.HouseInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseInfoDao extends JpaRepository<HouseInfo, Long> {
}
