/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.TrainerDao;
import entities.Trainer;
import java.util.List;

/**
 *
 * @author giorgos
 */
public class TrainerService {
    
    TrainerDao tdao = new TrainerDao();
    
    public boolean addTrainer(Trainer t) {
        return tdao.addTrainerJPA(t);
    }
    
    public Trainer getTrainer(long id) {
        return tdao.getTrainerById(id);
    }
    
    public List<Trainer> getTrainers(){
        return tdao.getTrainers();
    }
    
    public boolean updateTrainer(Trainer t){
        return tdao.updateTrainer(t);
    }
    
    public boolean deleteTrainer(long id){
        return tdao.deleteTrainer(id);
    }
    
}
