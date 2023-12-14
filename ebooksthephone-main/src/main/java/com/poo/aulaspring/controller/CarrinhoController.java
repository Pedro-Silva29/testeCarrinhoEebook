package com.poo.aulaspring.controller;
import com.poo.aulaspring.model.CarrinhoDeCompras;
import com.poo.aulaspring.service.CarrinhoDeComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.poo.aulaspring.model.Ebook;
import java.util.List;

@RestController  
@RequestMapping("/carrinho")  
public class CarrinhoController {

    @Autowired  
    private com.poo.aulaspring.service.CarrinhoDeComprasService carrinhoDeComprasService;

    @Autowired
    public CarrinhoDeComprasController(CarrinhoDeComprasService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @GetMapping("/{ebookId}")
    public ResponseEntity<CarrinhoDeCompras> mostrarCarrinhoPorEbookId(@PathVariable Long ebookId) {
        CarrinhoDeCompras carrinho = carrinhoService.encontrarCarrinhoPorIdDoEbook(ebookId);

        if (carrinho != null) {
            return ResponseEntity.ok(carrinho);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/por-ebook/{ebookId}")
    public List<CarrinhoDeCompras> encontrarCarrinhosPorIdDoEbook(@PathVariable Long ebookId) {
        return carrinhoDeComprasService.encontrarCarrinhosPorIdDoEbook(ebookId);
    }

    @PostMapping("/adicionar")
    public void adicionarAoCarrinho(@RequestBody Ebook ebook) {
        carrinhoDeComprasService.addAoCarrinho(ebook);
    }

    @PostMapping("/remover")
    public void removerDoCarrinho(@RequestBody Ebook ebook) {
        carrinhoDeComprasService.removerDoCarrinho(ebook);
    }

    @PostMapping("/pagar")
    public void realizarPagamento() {
        carrinhoDeComprasService.realizarPagamento();
    }
}

