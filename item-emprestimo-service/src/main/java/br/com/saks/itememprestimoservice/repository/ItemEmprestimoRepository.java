package br.com.saks.itememprestimoservice.repository;

import br.com.saks.itememprestimoservice.model.ItemEmprestimo;
import br.com.saks.itememprestimoservice.model.ItemEmprestimoIdentity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemEmprestimoRepository extends JpaRepository<ItemEmprestimo, ItemEmprestimoIdentity>{
    
    public Optional <ItemEmprestimo> findByItemEmprestimoIdentityIdEmprestimo(Long idEmprestimo);

}
