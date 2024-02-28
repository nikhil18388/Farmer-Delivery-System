package com.example.Fdscust.custrepo;
import com.example.Fdscust.entity.Crop;
import com.example.Fdscust.entity.Customer;
import com.example.Fdscust.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PaymentRepo extends JpaRepository<Payment,Long> {

}