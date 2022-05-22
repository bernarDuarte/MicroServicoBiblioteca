package br.com.saks.itememprestimoservice.controller;

import br.com.saks.itememprestimoservice.model.ItemEmprestimo;
import br.com.saks.itememprestimoservice.model.ItemEmprestimoIdentity;
import br.com.saks.itememprestimoservice.repository.ItemEmprestimoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/itemEmprestimo")
public class ItemEmprestimoController {
    
    
    @Autowired
    private ItemEmprestimoRepository itemEmprestimoRepository;
    
    @GetMapping
    public List<ItemEmprestimo> listarTodos() {
        return itemEmprestimoRepository.findAll();
    }
    
    @GetMapping(value = "/{idEmprestimo}")
    public Optional<ItemEmprestimo> listarPeloIdEmprestimo(@PathVariable Long idEmprestimo) {
    return itemEmprestimoRepository.findByItemEmprestimoIdentityIdEmprestimo(idEmprestimo);
    }

    @GetMapping(value = "/{idEmprestimo}/{idLivro}")
    public Optional<ItemEmprestimo> findByEmprestimoLivro(@PathVariable Long idEmprestimo,
    @PathVariable Long idLivro) {
    final ItemEmprestimoIdentity identity = new ItemEmprestimoIdentity(idEmprestimo, idLivro);
    return itemEmprestimoRepository.findById(identity);
}

    
    @PostMapping
    public ItemEmprestimo adicionar(@RequestBody ItemEmprestimo emprestimo) {
        return itemEmprestimoRepository.save(emprestimo);
    }
    
    
    @DeleteMapping(value="/{idEmprestimo}/{idLivro}")
        public ResponseEntity deletar(@PathVariable Long idEmprestimo, @PathVariable Long idLivro) {
        final ItemEmprestimoIdentity identity = new ItemEmprestimoIdentity(idEmprestimo, idLivro);
        return itemEmprestimoRepository.findById(identity)
        .map(record-> {
        itemEmprestimoRepository.deleteById(identity);
        return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
    
}
