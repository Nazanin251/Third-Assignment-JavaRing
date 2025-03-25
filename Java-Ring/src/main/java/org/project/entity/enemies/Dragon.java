package main.java.org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.entity.players.Player;
import org.project.object.weapons.Weapon;

import java.util.ArrayList;

public class Dragon extends Enemy {
    public Dragon(String name, int hp, int mp, Weapon weapon) {
        super(name, hp, mp, weapon);
    }

    @Override
    public void attack(Entity target) {
        int damage = weapon.getDamage();
        System.out.println("Dragon breathes fire, bypassing defenses!");
        target.takeDamage(damage);
    }

    public void fireBreath(ArrayList<Player> players) {
        System.out.println("Dragon unleashes a massive fire breath, damaging all players!");
        for (Player player : players) {
            if (player.isAlive()) {
                int damage = weapon.getDamage() + 10;
                player.takeDamage(damage);
            }
        }
    }
}