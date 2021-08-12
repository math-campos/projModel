
package br.edu.ifsul.tests;

import br.edu.ifsul.model.Consulta;
import br.edu.ifsul.model.Exame;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorgebavaresco@ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class TestePersistirExame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaMedicoModelPU");
        EntityManager em = emf.createEntityManager();
        Exame c = new Exame();
        Consulta e = em.find(Consulta.class, 1);
        c.setNome("Ressonancia");
        c.setDescricao("boa sorte");
        e.adicionarExame(c);
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        em.close();
        emf.close();

        
    }

}
