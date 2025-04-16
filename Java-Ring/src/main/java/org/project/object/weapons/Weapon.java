package org.project.object.weapons;

import org.project.entity.Entity;

public abstract class Weapon {
    private int damage;
    private int manaCost;

    public Weapon(int damage, int manaCost) {
        this.damage = damage;
        this.manaCost = manaCost;
    }

    public int getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void use(Entity target) {
        target.takeDamage(damage);
    }
}