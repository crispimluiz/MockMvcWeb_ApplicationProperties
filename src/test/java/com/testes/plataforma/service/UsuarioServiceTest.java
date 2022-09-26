package com.testes.plataforma.service;

import com.testes.plataforma.model.UsuarioModel;
import com.testes.plataforma.repository.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest
public class UsuarioServiceTest {

    @Mock
    UsuarioService usuarioService;

    @MockBean
    UsuarioRepository usuarioRepository;

    private UsuarioModel usuarioModel;

    @BeforeEach
    private void inicializadora(){
        MockitoAnnotations.openMocks(this);
        usuarioModel = new UsuarioModel(1L, "Joyce", "1234");
    }

    @Test
    void exibirUsuariosTest(){
        List<UsuarioModel> todosOsUsuarios = usuarioService.todosUsuarios();
        Assertions.assertTrue(todosOsUsuarios.isEmpty());
    }

    @Test
    public void testeCadastroFuncionando(){
        Mockito.when(usuarioRepository.existsById(Mockito.anyLong())).thenReturn(true);
        usuarioRepository.save(usuarioModel);
        Mockito.verify(usuarioRepository, Mockito.times(1)).save(usuarioModel);
    }
}
