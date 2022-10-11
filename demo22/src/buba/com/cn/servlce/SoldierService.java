package buba.com.cn.servlce;

import buba.com.cn.entity.Soldier;

import java.util.List;

public interface SoldierService {
    List<Soldier> findAllSoldiers();
    int deleteSoldiers(int soldier);
    int insertSoldiers(Soldier soldier);
    int updateSoldier(Soldier soldier);
}
