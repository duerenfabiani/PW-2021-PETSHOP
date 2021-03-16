/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pet;
import br.edu.ifsul.modelo.Produto;
import br.edu.ifsul.modelo.Raca;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirProduto {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2020-2-PET-PU");
        EntityManager em = emf.createEntityManager();
        Produto r = new Produto();
        r.setNome("Pitboll");
        r.setValor(12.0);
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        em.close();
        emf.close();
       
    }
}
