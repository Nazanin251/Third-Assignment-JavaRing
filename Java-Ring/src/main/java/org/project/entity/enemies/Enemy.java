package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.weapons.Weapon;

public abstract class Enemy implements Entity {
    protected Weapon weapon;
    protected int hp;
    protected int mp;
    protected int maxHP;
    protected int maxMP;
    protected String name; // Add a name field

    public Enemy(String name, int hp, int mp, Weapon weapon) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.maxHP = hp;
        this.maxMP = mp;
        this.weapon = weapon;
    }

    @Override
    public String getName() {
        return name; // Implement getName()
    }

    @Override
    public void attack(Entity target) {
        int damage = weapon.getDamage();
        System.out.println(name + " attacked " + target.getClass().getSimpleName() + "!");
        target.takeDamage(damage);
    }

    @Override
    public void defend() {
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
        hp -= damage;
        System.out.println(name + " took " + damage + " damage!");
        System.out.println(name + " has " + hp + " health remaining.");
    }

    @Override
    public int getMaxHP() {
        return maxHP;
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }
}