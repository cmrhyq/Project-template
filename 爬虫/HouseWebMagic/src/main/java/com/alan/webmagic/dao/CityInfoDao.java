package com.alan.webmagic.dao;

import com.alan.webmagic.domain.CityInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityInfoDao extends JpaRepository<CityInfo,Long> {
    /**
     * 查询数据库中的地址中不包含fang和i的地址，即为二手房的所有地址
     */
    @Query(value = "select city_url from hsir_graduation_project.city_info where city_url not like '%fang%' and city_url not like '%i%'",nativeQuery = true)
    List<CityInfo> findCityUrlOne();

    /**
     * 查询数据库中的地址中不包含fang和i的地址，即为二手房的所有地址
     */
    @Query(value = "select city_url from hsir_graduation_project.city_info where city_url not like '%i%'",nativeQuery = true)
    List<String> findCityUrlTwo();
}
