package buba.com.cn.servlce.impl;

import buba.com.cn.dao.SoldierDao;
import buba.com.cn.dao.impl.SoldierDaoImpl;
import buba.com.cn.entity.Soldier;
import buba.com.cn.servlce.SoldierService;

import java.util.List;

public class SoldierServiceImpl implements SoldierService {
    private SoldierDao soldierDao = new SoldierDaoImpl();

    @Override
    public List<Soldier> findAllSoldiers() {
        return soldierDao.findAllSoldiers();
    }

    @Override
    public int deleteSoldiers(int soldier) {
        return soldierDao.deleteSoldiers(soldier);
    }

    @Override
    public int insertSoldiers(Soldier soldier) {
        return soldierDao.insertSoldiers(soldier);
    }

    @Override
    public int updateSoldier(Soldier soldier) {
        return soldierDao.updateSoldier(soldier);
    }
}
