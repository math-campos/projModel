
package br.edu.ifsul.tests;

import br.edu.ifsul.model.Medicamento;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorgebavaresco@ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class TestePersistirMedicamento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaMedicoModelPU");
        EntityManager em = emf.createEntityManager();
        Medicamento c = new Medicamento();
        c.setNome("Ibuprofeno");

        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        
        
    }

}
