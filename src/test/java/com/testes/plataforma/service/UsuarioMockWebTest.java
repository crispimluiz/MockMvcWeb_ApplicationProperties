package com.testes.plataforma.service;

import com.testes.plataforma.controller.UsuarioController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc //anotação necessária para ajduar o Mock a ser gerenciável pelo @Autowired
public class UsuarioMockWebTest {
    @LocalServerPort //verificar porta
     private int port;//procura por ela sendo 8080 ou 8081
    @Autowired
    private UsuarioController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void verificaSeVemVazio() throws Exception{
        Assertions.assertThat(controller).isNotNull();
    }

        @Test
        public void retornarMensagem() throws Exception {
            assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/usuarios",
                    String.class)).contains("");//não ha nada no controller
        }

    @MockBean
    private UsuarioService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void mensagemUsuario() throws Exception {
            when(service.informar()).thenReturn("Ola, mundo");
            this.mockMvc.perform(get("/usuarios/informar"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("Ola, mundo")));
    }
}
