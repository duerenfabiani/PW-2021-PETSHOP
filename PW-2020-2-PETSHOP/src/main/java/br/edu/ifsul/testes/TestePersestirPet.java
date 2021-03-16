/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pet;
import br.edu.ifsul.modelo.Raca;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersestirPet {

    public static void main(String[] args) throws ParseException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2020-2-PET-PU");
        EntityManager em = emf.createEntityManager();
        Pet pet = new Pet();
        Raca r = em.find(Raca.class, 3);
        pet.setNome("Cabeçudo");
        pet.setEspecie("Cachorro");
        pet.setRaca(r);
        pet.setPeso(150.2);
        
        String strDate = "28/04/2010";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();     
        c.setTime(sdf.parse(strDate));
        pet.setNacimento(c);
        
        em.getTransaction().begin();
        em.persist(pet);
        em.getTransaction().commit();
        em.close();
        emf.close();
       
       //Teste Alterar
        
       
    }
}
