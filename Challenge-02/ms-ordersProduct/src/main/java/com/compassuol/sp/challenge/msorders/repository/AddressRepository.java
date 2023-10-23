package com.compassuol.sp.challenge.msorders.repository;

import com.compassuol.sp.challenge.msorders.model.services.AddressClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressClient, Long> {
}
