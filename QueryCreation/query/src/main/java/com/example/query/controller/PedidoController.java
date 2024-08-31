package com.example.query.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.query.model.Pedido;
import com.example.query.service.PedidoService;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/sem-desconto")
    public ResponseEntity<List<Pedido>> getPedidosSemDesconto() {
        return ResponseEntity.ok(pedidoService.findAllWithoutDiscount());
    }

    @GetMapping("/com-desconto")
    public ResponseEntity<List<Pedido>> getPedidosComDesconto() {
        return ResponseEntity.ok(pedidoService.findAllWithDiscount());
    }

    @GetMapping("/ordenado-por-valor")
    public ResponseEntity<List<Pedido>> getPedidosOrdenadosPorValor() {
        return ResponseEntity.ok(pedidoService.findAllSortedByValorUnit());
    }

    @GetMapping("/top-produto-nf/{idNf}")
    public ResponseEntity<Integer> getTopProductInNf(@PathVariable int idNf) {
        return ResponseEntity.ok(pedidoService.findTopProductInNf(idNf));
    }

    @GetMapping("/nf-quantidade-maior-que-10")
    public ResponseEntity<List<Integer>> getNfsWithProductQuantityGreaterThan() {
        return ResponseEntity.ok(pedidoService.findNfsWithProductQuantityGreaterThan(10));
    }

    @GetMapping("/nf-valor-maior-que-500")
    public ResponseEntity<List<Object[]>> getNfsWithTotalValueGreaterThan() {
        return ResponseEntity.ok(pedidoService.findNfsWithTotalValueGreaterThan(500));
    }
}

