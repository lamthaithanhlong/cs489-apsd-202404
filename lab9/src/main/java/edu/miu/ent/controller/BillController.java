package edu.miu.ent.controller;


import edu.miu.ent.model.Bill;
import edu.miu.ent.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
public class BillController {
    @Autowired
    private BillService billService;

    @PostMapping
    public Bill addBill(@RequestBody Bill bill) {
        return billService.addNewBill(bill);
    }

    @GetMapping
    public List<Bill> getAllBills() {
        return billService.getAllBills();
    }

    @PutMapping("/{id}")
    public Bill updateBill(@PathVariable int id, @RequestBody Bill bill) {
        bill.setBillId(id);
        return billService.updateBill(bill);
    }
}