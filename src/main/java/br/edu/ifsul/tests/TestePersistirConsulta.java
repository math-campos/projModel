
package br.edu.ifsul.tests;

import br.edu.ifsul.model.Consulta;
import br.edu.ifsul.model.Medico;
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
public class TestePersistirConsulta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaMedicoModelPU");
        EntityManager em = emf.createEntityManager();
        Consulta c = new Consulta();
        
        c.setDataConsulta(Calendar.getInstance());
        c.setHora(Calendar.getInstance());
        c.setPosconsulta("sei la");
        c.setPreconsulta("teste testes");
        c.setMedico(em.find(Medico.class, 1));
        c.setPaciente(em.find(Paciente.class, 2));
        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }

}
