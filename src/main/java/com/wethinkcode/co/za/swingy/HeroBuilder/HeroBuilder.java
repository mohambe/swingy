// Defines the methods needed for creating parts
// for the Hero

// so the the Hero should call these methods for it to be 
// considered properly built a Hero
package com.wethinkcode.co.za.swingy.HeroBuilder;
public interface HeroBuilder {

    public void buildHeroName();

    public void buildHeroHp();

    public void buildHeroDp();

    public void buildHeroClan();

    public Hero getHero();

}
