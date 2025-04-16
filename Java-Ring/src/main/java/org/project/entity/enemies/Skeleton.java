package org.project.entity.enemies;

import org.project.object.weapons.Weapon;

public class Skeleton extends Enemy {
    private boolean hasResurrected = false;

    public Skeleton(String name, int hp, int mp, Weapon weapon) {
        super(name, hp, mp, weapon);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (hp <= 0 && !hasResurrected) {
            hp = maxHP / 2; // Resurrect with half health
            hasResurrected = true;
            System.out.println("Skeleton has resurrected with " + hp + " health!");
        }
    }
}