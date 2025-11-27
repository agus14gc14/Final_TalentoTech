package com.taltech.ecomm;

import com.taltech.ecomm.modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
