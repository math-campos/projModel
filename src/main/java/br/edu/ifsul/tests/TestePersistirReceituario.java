
package br.edu.ifsul.tests;

import br.edu.ifsul.model.Consulta;
import br.edu.ifsul.model.Medicamento;
import br.edu.ifsul.model.Receituario;
import java.util.Calendar;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorgebavaresco@ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class TestePersistirReceituario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaMedicoModelPU");
        EntityManager em = emf.createEntityManager();
        Consulta c = em.find(Consulta.class, 6);
        Receituario r = new Receituario();
        r.setPosologia("Duas vezes ao dia");
        r.setValidade(Calendar.getInstance());
        c.adicionarReceituario(r);
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        
        
    }

}
