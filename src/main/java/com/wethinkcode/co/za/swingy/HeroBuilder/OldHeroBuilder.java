// The concrete builder class that assembles the parts
// of the finished Hero object
package com.wethinkcode.co.za.swingy.HeroBuilder;
public class OldHeroBuilder implements HeroBuilder {

    private Hero Hero;
    private String Hero_name;
    private String Hero_clan_name;
    private int health;
    private int damage;

    public OldHeroBuilder(String name, String clan_name, Integer Hp, int Dp) {
        //instancing the new need object we going to use to carry information
        //or preferred values
        this.Hero = new Hero();
        this.Hero_name = name;
        this.Hero_clan_name = clan_name;
        this.health = Hp;
        this.damage = Dp;
    }


    public void buildHeroName() {

        Hero.setHeroName(Hero_name);

    }

    public void buildHeroHp() {

        Hero.setHeroHp(health);

    }

    public void buildHeroDp() {

        Hero.setHeroDp(damage);

    }

    public void buildHeroClan() {

        Hero.setHeroClan(Hero_clan_name);
    }

    public Hero getHero() {

        return this.Hero;
//return object with needed information to work with
    }

}
