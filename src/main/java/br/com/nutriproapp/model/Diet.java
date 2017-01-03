package br.com.nutriproapp.model;

import br.com.nutriproapp.model.User.Gender;

public class Diet {

    private double energy;

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }
    

    public static Diet getDiet(User user) {
        Diet diet = new Diet();
        diet.setEnergy(getEnergyRequeriment(user));

        return diet;
    }

    protected static double getEnergyRequeriment(User user) {

        int age = user.getAge();
        double weight = user.getWeight();
        int height = user.getHeight();
        double pa = user.getActivityLevel().getCoefficient(user);

        if (user.getGender() == Gender.MALE) {
            if (age <= 8) {
                return 88.5 - 61.9 * age + pa * (26.7 * weight + 9.03 * height) + 20;
            } else if (age <= 18) {
                return 88.5 - 61.9 * age + pa * (26.7 * weight + 9.03 * height) + 25;
            } else { // Adults
                return 662 - 9.53 * age + pa * (15.91 * weight + 5.396 * height);
            }
        } else {
            if (age <= 8) {
                return 135.3 - 30.8 * age + pa * (10.0 * weight + 9.34 * height) + 20;
            } else if (age <= 18) {
                return 135.3 - 30.8 * age + pa * (10.0 * weight + 9.34 * height) + 25;
            } else { // Adults
                return 354 - 6.91 * age + pa * (9.36 * weight + 7.26 * height);
            }
        }
    }

}
