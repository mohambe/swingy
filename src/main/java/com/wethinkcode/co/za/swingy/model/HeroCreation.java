package com.wethinkcode.co.za.swingy.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class HeroCreation {

    @NotNull
    @Size(min = 3, max = 15)
    private String name;
    private String clan;
    private int Hp;
    private int Dp;

    public void setName(String Name) {
        this.name = Name;
    }

    public void setClan(String Clan) {
        this.clan = Clan;
    }

    public void setHp(Integer health) {
        this.Hp = health;
    }

    public void setDp(int damage) {
        this.Dp = damage;
    }

    public int getDp() {
        return Dp;
    }

    public int getHp() {
        return Hp;
    }

    public String getName() {
        return this.name;
    }

    public String getClan() {
        return this.clan;
    }

    public void HeroCreation(String Name, String clan) {

        if (clan.toLowerCase().equals("ninja")) {
            setDp(30);
            setHp(80);
        } else if (clan.toLowerCase().equals("pirate")) {
            setDp(20);
            setHp(90);
        }else
        {
            System.out.println("Incorrect clan name");
            System.exit(0);
        }
        setClan(clan);
        setName(Name);
    }
}
