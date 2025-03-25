package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.armors.Armor;
import org.project.object.weapons.Weapon;

public abstract class Player implements Entity {
    protected String name;
    protected Weapon weapon;
    protected Armor armor;
    protected int hp;
    protected int maxHP;
    protected int mp;
    protected int maxMP;
    protected boolean isDefending = false;

    public Player(String name, int hp, int mp, Weapon weapon, Armor armor) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.maxHP = hp;
        this.maxMP = mp;
        this.weapon = weapon;
        this.armor = armor;
    }

    @Override
    public void attack(Entity target) {
        int damage = weapon.getDamage();
        System.out.println(name + " (" + this.getClass().getSimpleName() + ") attacked " + target.getClass().getSimpleName() + "!");
        target.takeDamage(damage);
    }

    @Override
    public void defend() {
        isDefending = true;
        System.out.println(name + " is defending!");
    }

    @Override
    public void heal(int health) {
        hp += health;
        if (hp > maxHP) hp = maxHP;
        System.out.println(name + " healed for " + health + " health!");
    }

    @Override
    public void fillMana(int mana) {
        mp += mana;
        if (mp > maxMP) mp = maxMP;
        System.out.println(name + " restored " + mana + " mana!");
    }

    @Override
    public void takeDamage(int damage) {
        if (isDefending) {
            damage = Math.max(0, damage - armor.getDefense());
            isDefending = false;
        }
        hp -= damage;
        System.out.println(name + " took " + damage + " damage!");
        System.out.println(name + " has " + hp + " health remaining.");
    }

    @Override
    public int getMaxHP() {
        return maxHP;
    }

    public int getMaxMP() {
        return maxMP;
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}