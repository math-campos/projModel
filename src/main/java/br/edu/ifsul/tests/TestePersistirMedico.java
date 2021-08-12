package br.edu.ifsul.tests;

import br.edu.ifsul.model.Especialidade;
import br.edu.ifsul.model.Medico;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorgebavaresco@ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class TestePersistirMedico {

    /**
     * @param args the command line arguments
     */
    //ja extends paciente, entao nao preciso testar persistencia de paciente
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaMedicoModelPU");
        EntityManager em = emf.createEntityManager();
        Medico c = new Medico();
        c.setAltura(10.0);
        c.setHistorico("historico de sei la oq");
        c.setNascimento(Calendar.getInstance());
        c.setNome("paulao");
        c.setPeso(12.0);
        c.setSexo("masc");
        c.setTelefone("32434343");
        c.setEspecialidade(em.find(Especialidade.class, 1));
        c.setCrm("3421344444");
        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

}
