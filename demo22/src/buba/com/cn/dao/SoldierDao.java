package buba.com.cn.dao;

import buba.com.cn.entity.Soldier;

import java.util.List;

public interface SoldierDao {
    List<Soldier> findAllSoldiers();
    int deleteSoldiers(int soldier);
    int insertSoldiers(Soldier soldier);
    int updateSoldier(Soldier soldier);
}
