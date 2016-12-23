package br.com.nutriproapp.model;

import br.com.nutriproapp.model.User.Gender;

public enum ActivityLevel {

    SEDENTARY(1.0, 1.0, 1.0, 1.0), 
    LOW_ACTIVE(1.13, 1.16, 1.11, 1.12), 
    ACTIVE(1.26, 1.31, 1.25, 1.27), 
    VERY_ACTIVE(1.42, 1.56, 1.48, 1.45);
    
    
    private double boyCoef;
    private double girlCoef;
    private double manCoef;
    private double womanCoef;

    private ActivityLevel(double boyCoef, double girlCoef, double manCoef, double womanCoef) {
        this.boyCoef = boyCoef;
        this.girlCoef = girlCoef;
        this.manCoef = manCoef;
        this.womanCoef = womanCoef;
    }

    public double getCoefficient(User user) {
        int age = user.getAge();
        if (user.getGender() == Gender.MALE) {
            if (age <= 18) {
                return boyCoef;
            } else { // Adults
                return manCoef;
            }
        } else {
            if (age <= 18) {
                return girlCoef;
            } else { // Adults
                return womanCoef;
            }
        }
    }
}
