package edu.miu.ent.service;

import edu.miu.ent.model.Bill;

import java.util.List;

public interface BillService {
    Bill addNewBill(Bill bill);
    Bill getBillById(int id);
    List<Bill> getAllBills();
    Bill updateBill(Bill bill);
    void deleteBillById(int id);
}