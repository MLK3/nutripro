package br.com.nutriproapp.model;

public class User {

    private String username;
    private int age;
    private Gender gender;
    private int height;
    private double weight;
    private ActivityLevel activityLevel;


    public enum Gender {
        MALE, FEMALE;
    }
    
    
	public User(String username, int age, Gender gender, int height, double weight, ActivityLevel activityLevel) {
        this.username = username;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.activityLevel = activityLevel;
    }

    public String getUsername() {
        return username;
    }


    public int getAge() {
        return age;
    }


    public Gender getGender() {
        return gender;
    }


    public int getHeight() {
        return height;
    }


    public double getWeight() {
        return weight;
    }


    public ActivityLevel getActivityLevel() {
        return activityLevel;
    }
    
    
}
