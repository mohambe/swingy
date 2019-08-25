package com.wethinkcode.co.za.swingy.HeroBuilder;
public class TestHeroBuilder {

    public static void main(String[] args) {

        // Get a HeroBuilder of type OldHeroBuilder

        HeroBuilder oldStyleHero = new OldHeroBuilder("Kerane","Ninja", 120,23);

        // Pass the OldHeroBuilder specification to the engineer
        HeroEngineer HeroEngineer = new HeroEngineer(oldStyleHero);

        // Tell the engineer to make the Hero using the specifications

        // of the OldHeroBuilder class

        HeroEngineer.makeHero();

        // The engineer returns the right Hero based off of the spec

        // sent to it on line 11

        Hero firstHero = HeroEngineer.getHero();
        System.out.println("Hero Built");

        System.out.println("Hero Name Type: " + firstHero.getHeroName());

        System.out.println("Hero Hp Type: " + firstHero.getHeroHp());

        System.out.println("Hero Dp Type: " + firstHero.getHeroDp());

        System.out.println("Hero clan Type: " + firstHero.getHeroClan());

    }

}
