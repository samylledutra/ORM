package com.example.query.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.query.model.Pedido;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByDesconto(int desconto);
    
    List<Pedido> findByDescontoGreaterThan(int desconto);
    
    List<Pedido> findAllByOrderByValorUnitDesc();
    
    @Query("SELECT p.codProd FROM Pedido p WHERE p.idNf = :idNf GROUP BY p.codProd ORDER BY SUM(p.quantidade) DESC")
    Integer findTopProductInNf(int idNf);
    
    @Query("SELECT DISTINCT p.idNf FROM Pedido p WHERE p.quantidade > 10")
    List<Integer> findNfsWithProductQuantityGreaterThan(int quantidade);
 
    @Query("SELECT p.idNf, SUM(p.valorUnit * p.quantidade - p.desconto) AS total FROM Pedido p GROUP BY p.idNf HAVING SUM(p.valorUnit * p.quantidade - p.desconto) > :total ORDER BY total DESC")
List<Object[]> findNfsWithTotalValueGreaterThan(@Param("total") double total);

}
