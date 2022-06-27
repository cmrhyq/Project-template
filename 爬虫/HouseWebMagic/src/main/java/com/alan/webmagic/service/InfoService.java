package com.alan.webmagic.service;

import com.alan.webmagic.domain.CityInfo;
import com.alan.webmagic.domain.HouseInfo;

import java.util.List;

public interface InfoService {

    public void save(HouseInfo houseInfo);

    public List<HouseInfo> findHouseInfo(HouseInfo houseInfo);

    public List<CityInfo> findCityInfoOne();

    public List<CityInfo> findCityInfoTwo();
}
