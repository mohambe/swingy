// The director / engineer class creates a Hero using the
// builder interface that is defined (OldHeroBuilder)
package com.wethinkcode.co.za.swingy.HeroBuilder;

public class HeroEngineer {

    private HeroBuilder HeroBuilder;

    // OldHeroBuilder specification is sent to the engineer

    public HeroEngineer(HeroBuilder HeroBuilder) {

        this.HeroBuilder = HeroBuilder;
    }

    // Return the Hero made from the OldHeroBuilder spec

    public Hero getHero() {

        return this.HeroBuilder.getHero();
    }

    // Execute the methods specific to the HeroBuilder
    // that implements HeroBuilder (OldHeroBuilder)

    public void makeHero() {

        this.HeroBuilder.buildHeroName();

        this.HeroBuilder.buildHeroHp();

        this.HeroBuilder.buildHeroDp();

        this.HeroBuilder.buildHeroClan();

    }

}
