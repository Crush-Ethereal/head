package buba.com.cn.controller;

import buba.com.cn.entity.Soldier;
import buba.com.cn.servlce.SoldierService;
import buba.com.cn.servlce.impl.SoldierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SoldierServlet extends ViewBaseServlet{
    private SoldierService soldierService = new SoldierServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("utf-8");
        if (req.getParameter("method").equals("findAllSoldiers")){
            this.findAllSoldiers(req, resp);
        }
        if (req.getParameter("method").equals("deleteSoldiers")){
            this.deleteSoldiers(req, resp);
        }
        if (req.getParameter("method").equals("insertSoldiers")){
            this.insertSoldiers(req, resp);
        }
        if (req.getParameter("method").equals("updateSoldier")){
            this.updateSoldier(req, resp);
        }
        if (req.getParameter("method").equals("updateSubmit")){
            this.updateSubmit(req, resp);
        }
    }
    protected void findAllSoldiers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Soldier> list = soldierService.findAllSoldiers();
        req.setAttribute("soldierList",list);
       processTemplate("list",req,resp);
    }
    protected void deleteSoldiers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int name = soldierService.deleteSoldiers(id);
        this.findAllSoldiers(req, resp);

    }
    protected void insertSoldiers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String id = req.getParameter("inp");
       String name = req.getParameter("inp1");
       Soldier soldier = new Soldier(id,name);
       soldierService.insertSoldiers(soldier);
       this.findAllSoldiers(req, resp);

    }
    protected void updateSoldier(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String id = req.getParameter("id");
       String name = req.getParameter("name");
       String weapon = req.getParameter("weapon");
       Soldier soldier = new Soldier(Integer.valueOf(id),name,weapon);
       req.setAttribute("soldier",soldier);
       processTemplate("update",req,resp);
    }
    protected void updateSubmit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("soldierId");
        String name = req.getParameter("soldierName");
        String weapon = req.getParameter("soldierWeapon");
        Soldier soldier = new Soldier(Integer.valueOf(id),name,weapon);
        soldierService.updateSoldier(soldier);
        this.findAllSoldiers(req, resp);
    }
}
