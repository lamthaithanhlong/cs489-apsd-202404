package edu.miu.ent.service.impl;

import edu.miu.ent.model.Bill;
import edu.miu.ent.repository.BillRepository;
import edu.miu.ent.service.BillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    private final BillRepository billRepository;

    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public Bill addNewBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public Bill getBillById(int id) {
        return billRepository.findById(id).orElse(null);
    }

    @Override
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    @Override
    public Bill updateBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public void deleteBillById(int id) {
        billRepository.deleteById(id);
    }
}