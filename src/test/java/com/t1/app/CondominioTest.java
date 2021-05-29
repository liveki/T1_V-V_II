package com.t1.app;

import java.util.Random;

import com.t1.app.exceptions.OperadorComRegistrosException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CondominioTest {
    @Test
    public void excluiOperadorComEntregaVinculadaTest() {
        Condominio c = new Condominio();
        c.definirOperadorAtual(c.getOperadores().get(1));

        Entrega e1 = new Entrega(c.getOperadorAtual(), "Test", 101);
        c.registrarEntrega(e1);

        Assertions.assertThrows(OperadorComRegistrosException.class, () -> {
            c.excluirOperador(c.getOperadorAtual());
        });
    }
    
    @Test
    public void excluiOperadorSemEntregaVinculadaTest(){
        Condominio c = new Condominio();

        Operador op = new Operador("Operador");
        c.incluirOperador(op);

        int expected = c.getOperadores().size() - 1;
        
        try {
            c.excluirOperador(op);
        } catch (OperadorComRegistrosException e) {
            e.printStackTrace();
        }

        Assertions.assertTrue(expected == c.getOperadores().size());
    }

    @Test
    public void excluiOperadorInexistenteTest(){
        Condominio c = new Condominio();

        Operador op = new Operador("Operador");
        
        int expected = c.getOperadores().size();
        
        try {
            c.excluirOperador(op);
        } catch (OperadorComRegistrosException e) {
            e.printStackTrace();
        }

        Assertions.assertTrue(expected == c.getOperadores().size());
    }

    @Test
    public void marcaMoradorInativoExistenteTest(){
        Random r = new Random();
        Condominio c = new Condominio();

        Morador m = c.listarMoradores().get(r.nextInt(c.listarMoradores().size()));
        c.marcarMoradorInativo(m);

        Assertions.assertTrue(m.isAtivo() == false);
    }

    @Test
    public void marcaMoradorInativoNaoExistenteTest(){
        Condominio c = new Condominio();
        Morador m = new Morador("nome", "rG", 1000, true);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            c.marcarMoradorInativo(m);
        });
    }

    @Test
    public void marcaMoradorInativoJaInativoTest(){
        Random r = new Random();
        Condominio c = new Condominio();

        Morador m = c.listarMoradores().stream().filter(mr-> mr.isAtivo() == false).findAny().orElse(c.listarMoradores().get(r.nextInt(c.listarMoradores().size())));

        c.marcarMoradorInativo(m);

        Assertions.assertTrue(m.isAtivo() == false);
    }
    
    class marcarMoradorInativoTest {

    }

    class encontrarMoradorTest {

    }

    class retirarEntregaTest {

    }

    class encontrarEntregaTest {

    }

    class procurarEntregaPorDescricaoTest {

    }

    class carregarOperadoresTest {

    }

    class carregarMoradoresTest {

    }

    class carregarEntregasTest {

    }

    class procurarMoradorPorRGTest {

    }
}
