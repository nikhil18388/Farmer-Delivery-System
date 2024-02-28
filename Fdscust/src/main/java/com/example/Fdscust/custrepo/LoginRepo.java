package com.example.Fdscust.custrepo;

import com.example.Fdscust.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<Login,Long> {
}
