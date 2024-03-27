package com.example.CRU.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.CRU.Model.Usuario;
import com.example.CRU.UsuarioRepository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	 @Autowired
	 private UsuarioRepository usuarioRepository;
    @GetMapping("/assessment")
    public String index() {
        return "index";
    }
    @GetMapping
    public List<Usuario> listarUsuarios() {
    	  return usuarioRepository.findAll();
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
    	return usuarioRepository.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
    	 return usuarioRepository.findById(id)
                 .map(usuario -> {
                     usuario.setNome(usuarioAtualizado.getNome());
                     usuario.setEmail(usuarioAtualizado.getEmail());
                     return usuarioRepository.save(usuario);
                 })
                 .orElseThrow();
    }
    
    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id) {
    	usuarioRepository.deleteById(id);   
    }
}
