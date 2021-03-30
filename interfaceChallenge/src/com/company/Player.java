package com.company;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveFun{
    private String name;
    private int hitPoint;
    private int blood;
    private String weapon;
    public Player(String name, int hitPoint, int blood) {
        this.name = name;
        this.hitPoint = hitPoint;
        this.blood = blood;
        this.weapon = "sword";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hitPoint=" + hitPoint +
                ", blood=" + blood +
                ", weapon='" + weapon + '\'' +
                '}';
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>();
        values.add(0,this.name);
        values.add(1, ""+ this.hitPoint);
        values.add(2,""+this.blood);
        values.add(3,this.weapon);
        return values;
    }

    @Override
    public void read(List<String> value) {
        this.name = value.get(0);
        this.hitPoint = Integer.parseInt(value.get(1));
        this.blood = Integer.parseInt(value.get(2));
        this.weapon = value.get(3);
    }
}
