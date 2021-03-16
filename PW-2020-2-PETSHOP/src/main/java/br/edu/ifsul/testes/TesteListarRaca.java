/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Raca;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TesteListarRaca {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2020-2-PET-PU");
        EntityManager em = emf.createEntityManager();
        List<Raca> lista = em.createQuery("from Raca order by id").getResultList();
        for (Raca e : lista){
            System.out.println("ID: " + e.getId() + " Nome: " + e.getNome());
        }
        
        

        em.close();
        emf.close();
        
        
        
    }
}
