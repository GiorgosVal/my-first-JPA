/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Trainer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author giorgos
 */
public class TrainerDao {
    
    public boolean addTrainerJPA(Trainer t){
        boolean completed = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrainersJPAPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        try {
            em.persist(t);
            em.getTransaction().commit();
            completed = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
        return completed;
    }
    
    public Trainer getTrainerById(long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrainersJPAPU");
        EntityManager em = emf.createEntityManager();
        
        Trainer trainer = null;
        try {
            trainer = em.find(Trainer.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
        return trainer;
    }
    
    public List<Trainer> getTrainers(){
        List<Trainer> list = new ArrayList();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrainersJPAPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        try {
            Query query = em.createQuery("Select t from Trainer t");
            list = query.getResultList();
            
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
        return list;
    }
    
    public boolean updateTrainer(Trainer t){
        boolean completed = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrainersJPAPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        try {
            Trainer trainer = em.find(Trainer.class, t.getId());
            em.persist(trainer);
            trainer.setTfname(t.getTfname());
            trainer.setTlname(t.getTlname());
            trainer.setTsubject(t.getTsubject());
            em.getTransaction().commit();
            completed = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
        return completed;
    }
    
    
    public boolean deleteTrainer(long id){
        boolean completed = false;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrainersJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Trainer t = em.find(Trainer.class, id);
        
/*
 Σημαντική σημείωση!
Αρχικά στον παραπάνω κώδικα καλούσα την getTrainerById, δηλαδή
Trainer t = getTrainerById(id);
Αυτό δεν δούλευε! Ο server εμφάνιζε ένα error του τύπου
java.lang.IllegalArgumentException: Removing a detached instance
Η remove() μέθοδος δουλεύει μόνο με entities που διαχειρίζονται από την τρέχουσα transaction.
Ίσως δηλαδή παίρνουμε την entity σε προηγούμενο transaction, και αποθηκεύεται στην HTTP session
και μετά προσπαθούμε να ρο αφαιρέσουμε σε μία διαφορετική transaction. Αυτό απλά δεν δουλεύει.
        Reference:
https://stackoverflow.com/questions/17027398/java-lang-illegalargumentexception-removing-a-detached-instance-com-test-user5        
        
*/
        try {
            em.persist(t);
            em.remove(t);
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            System.out.println();
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            em.getTransaction().commit();
            completed = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
        
        return completed;
    }
    
    
    
    
    
}
