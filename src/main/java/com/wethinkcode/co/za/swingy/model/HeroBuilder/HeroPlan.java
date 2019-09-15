// This is the interface that will be returned from the builder
//carries the genaral needed setting of what should be made for Heroclass
package com.wethinkcode.co.za.swingy.model.HeroBuilder;

public interface HeroPlan{

    public void setHeroName(String Name);

    public void setHeroHp(Integer Hp);

    public void setHeroDp(Integer Dp);

    public void setHeroClan(String Clan);

}
