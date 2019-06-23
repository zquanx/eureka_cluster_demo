package com.example.demo;

import java.util.List;

/**
 * @author zhengquan
 */
public interface DepartService {


    boolean saveDepart(Depart depart);

    boolean removeDepartById(int id);

    boolean modifyDepart(Depart depart);

    Depart getDepartById(int id);

    List<Depart> listAllDeparts();
}
