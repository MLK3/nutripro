package br.com.nutriproapp.model;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.nutriproapp.model.ActivityLevel;
import br.com.nutriproapp.model.Diet;
import br.com.nutriproapp.model.User;
import br.com.nutriproapp.model.User.Gender;

public class DietTest {

    
    
    @Test
    public void testEnergyRequeriments() {
        User MAS = new User("Marcelo", 29, Gender.MALE, 173, 73.4, ActivityLevel.SEDENTARY);
        User MCL = new User("Matheus", 15, Gender.MALE, 170, 65.0, ActivityLevel.LOW_ACTIVE);
        User FCV = new User("Fernanda", 13, Gender.FEMALE, 151, 47.5, ActivityLevel.VERY_ACTIVE);
        User FAA = new User("Leticia", 23, Gender.FEMALE, 160, 52.1, ActivityLevel.ACTIVE);
              
        
        assertEquals(2486.9, Diet.getEnergyRequeriment(MAS), 0.1);
        assertEquals(2880.8, Diet.getEnergyRequeriment(MCL), 0.1);
        assertEquals(2701.0, Diet.getEnergyRequeriment(FCV), 0.1);
        assertEquals(2289.6, Diet.getEnergyRequeriment(FAA), 0.1);
    }
    
}
