package com.example.query.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.query.exception.PedidoNotFoundException;
import com.example.query.model.Pedido;
import com.example.query.repository.PedidoRepository;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> findAllWithoutDiscount() {
        return pedidoRepository.findByDesconto(0);
    }

    public List<Pedido> findAllWithDiscount() {
        return pedidoRepository.findByDescontoGreaterThan(0);
    }

    public List<Pedido> findAllSortedByValorUnit() {
        return pedidoRepository.findAllByOrderByValorUnitDesc();
    }

    public Integer findTopProductInNf(int idNf) {
        return pedidoRepository.findTopProductInNf(idNf);
    }

    public List<Integer> findNfsWithProductQuantityGreaterThan(int quantidade) {
        return pedidoRepository.findNfsWithProductQuantityGreaterThan(quantidade);
    }

    public List<Object[]> findNfsWithTotalValueGreaterThan(double total) {
        return pedidoRepository.findNfsWithTotalValueGreaterThan(total);
    }

    public Pedido findById(int id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new PedidoNotFoundException("Pedido not found with id: " + id));
    }
}
