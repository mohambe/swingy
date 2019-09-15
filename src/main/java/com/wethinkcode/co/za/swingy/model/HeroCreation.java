package com.wethinkcode.co.za.swingy.model;

public class HeroCreation {

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
        }
        setClan(clan);
        setName(Name);
    }
}
