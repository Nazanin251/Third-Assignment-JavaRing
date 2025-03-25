package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.weapons.Weapon;
import org.project.object.armors.Armor;

public class Knight extends Player {
    private int kickCooldown = 0;

    public Knight(String name, int hp, int mp, Weapon weapon, Armor armor) {
        super(name, hp, mp, weapon, armor);
    }

    public void strongKick(Entity target) {
        if (kickCooldown <= 0) {
            int damage = weapon.getDamage() + 10;
            target.takeDamage(damage);
            kickCooldown = 3;
            System.out.println(name + " performed a strong kick on " + target.getClass().getSimpleName() + " for " + damage + " damage!");
        } else {
            System.out.println(name + " cannot perform a strong kick yet. Cooldown: " + kickCooldown);
        }
    }

    @Override
    public void attack(Entity target) {
        super.attack(target);
        if (kickCooldown > 0) kickCooldown--;
    }
}