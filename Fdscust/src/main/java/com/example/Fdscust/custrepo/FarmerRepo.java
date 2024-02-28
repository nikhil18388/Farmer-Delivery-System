package com.example.Fdscust.custrepo;

import com.example.Fdscust.entity.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerRepo extends JpaRepository<Farmer,Long> {
}
