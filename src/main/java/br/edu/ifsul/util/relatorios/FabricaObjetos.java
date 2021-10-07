package br.edu.ifsul.util.relatorios;


import br.edu.ifsul.model.Paciente;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorgebavaresco@ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class FabricaObjetos {
    
    public static List<Paciente> carregaPacientes(){
        List<Paciente> lista = new ArrayList<>();
        Paciente t = new Paciente();
        t.setId(1);
        t.setAltura(2.4);
        t.setHistorico("<h1>Gaucho de passo fundo</h1>");
        t.setNascimento(Calendar.getInstance());
        t.setNome("Sérgio");
        t.setPeso(10.3);
        t.setSexo("Masculino");
        t.setTelefone("88888888");
        lista.add(t);
        return lista;
    }

}
