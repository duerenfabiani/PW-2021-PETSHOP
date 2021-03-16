
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TesteExcluirPet {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2020-2-PET-PU");
        EntityManager em = emf.createEntityManager();
        Pet e = em.find(Pet.class, 4);
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        
        
    }

}
