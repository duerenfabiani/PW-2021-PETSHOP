/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pet;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteAlterarPet {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2020-2-PET-PU");
        EntityManager em = emf.createEntityManager();
        Pet pet = em.find(Pet.class, 4);
        pet.setNome("Japaa do sem dedo");
        pet.setEspecie("Galinha");
        pet.setPeso(180.2);
        Calendar cal = Calendar.getInstance();
        pet.setNacimento(cal);
        em.getTransaction().begin();
        em.merge(pet);
        em.getTransaction().commit();
        em.close();
        emf.close();
       
    }
}
