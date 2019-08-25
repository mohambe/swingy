// The concrete Hero class based on the HeroPlan interface
package com.wethinkcode.co.za.swingy.HeroBuilder;


public class Hero implements HeroPlan{

    private String HeroName;

    private Integer HeroHp;

    private Integer HeroDp;

    private String HeroClan;

    public void setHeroName(String Name) {

        HeroName = Name;
    }
    public String getHeroName(){ return HeroName; }

    public void setHeroHp(Integer Hp) {

        HeroHp = Hp;
    }

    public Integer getHeroHp(){ return HeroHp; }

    public void setHeroDp(Integer Dp) {

        HeroDp = Dp;
    }

    public Integer getHeroDp(){ return HeroDp; }

    public void setHeroClan(String Clan) {

        HeroClan = Clan;
    }
    public String getHeroClan(){ return HeroClan; }

}
