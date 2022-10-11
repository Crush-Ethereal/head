package buba.com.cn.dao.impl;

import buba.com.cn.dao.SoldierDao;
import buba.com.cn.entity.Soldier;
import buba.com.cn.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.JdbcUtils;

import java.util.List;

public class SoldierDaoImpl implements SoldierDao {


    @Override
    public List<Soldier> findAllSoldiers() {
        JdbcTemplate jdbcTemplate= new JdbcTemplate(JDBCUtils.getDateSource());
        String sql = "select * from t_soldier";
       List<Soldier> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Soldier.class));
        return list;
    }

    @Override
    public int deleteSoldiers(int soldier) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql ="delete from t_soldier where soldier_id=?";
        int delete =jdbcTemplate.update(sql,soldier);
        return delete;
    }

    @Override
    public int insertSoldiers(Soldier soldier) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql = "insert into t_soldier(soldier_name,soldier_weapon) values(?,?)";
        int insert = jdbcTemplate.update(sql,soldier.getSoldierName(),soldier.getSoldierWeapon());
        return insert;
    }

    @Override
    public int updateSoldier(Soldier soldier) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql ="update t_soldier set soldier_name=?,soldier_weapon=? where soldier_id=?";
        int update =jdbcTemplate.update(sql,soldier.getSoldierName(),soldier.getSoldierWeapon(),soldier.getSoldierId());
        return update;
    }
}
