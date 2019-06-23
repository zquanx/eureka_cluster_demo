package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhengquan
 */
@RestController
@RequestMapping("/provider/depart")
public class DepartController {

    @Autowired
    private DepartService departService;

    @PostMapping("/save")
    public boolean saveHandle(@RequestBody Depart depart) {
        return departService.saveDepart(depart);
    }

    @DeleteMapping("/del/{id}")
    public boolean deleteHandle(@PathVariable("id") int id) {
        return departService.removeDepartById(id);
    }

    @PutMapping("/update")
    public boolean updateHandle(@RequestBody Depart depart) {
        return departService.modifyDepart(depart);
    }

    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") int id) {
        return departService.getDepartById(id);
    }

    @GetMapping("/list")
    public List<Depart> listHandle() {
        return departService.listAllDeparts();
    }

}
