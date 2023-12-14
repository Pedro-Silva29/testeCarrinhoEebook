package com.poo.aulaspring.repository;
import com.poo.aulaspring.model.CarrinhoDeCompras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarrinhoRepository extends JpaRepository<CarrinhoDeCompras, Long> {

  public List<CarrinhoDeCompras> findByEbooksId(Long ebookId);

}

