
package br.edu.ifsul.tests;

import br.edu.ifsul.model.Paciente;

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
public class TestePersistirPaciente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaMedicoModelPU");
        EntityManager em = emf.createEntityManager();
        Paciente c = new Paciente();

        c.setAltura(11.0);
        c.setHistorico("historico dfdsde sei la oq");
        c.setNascimento(Calendar.getInstance());
        c.setNome("ana");
        c.setPeso(122.0);
        c.setSexo("fem");
        c.setTelefone("32434343");
     
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        
    }

}
