package org.project;

import org.project.entity.players.*;
import org.project.entity.enemies.*;
import org.project.object.armors.KnightArmor;
import org.project.object.weapons.Sword;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String PURPLE = "\u001B[35m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

       System.out.println(CYAN + "WELCOME TO JAVA-RING!");
        System.out.println(BLUE + "Choose your character:\n");
        System.out.println("1. Knight");
        System.out.println("2. Wizard");
        System.out.println("3. Assassin" + RESET);
        int choice = scanner.nextInt();

        Player player = null;
        switch (choice) {
            case 1:
                player = new Knight("Jaime Lannister", 100, 50, new Sword(), new KnightArmor());
                break;
            case 2:
                player = new Wizard("Harry Potter", 80, 100, new Sword(), new KnightArmor());
                break;
            case 3:
                player = new Assassin("Ezio Auditore da Firenze", 90, 60, new Sword(), new KnightArmor());
                break;
            default:
                System.out.println(RED + "Invalid choice. Exiting game." + RESET);
                return;
        }

        System.out.println(PURPLE + "You have chosen " + player.getClass().getSimpleName() + ": " + player.getName() + RESET);

        System.out.println(BLUE + "\nEntering the starting location..." + RESET);

        ArrayList<Enemy> monsters = new ArrayList<>();
        monsters.add(new Goblin("Goblin", 50, 0, new Sword()));
        monsters.add(new Skeleton("Skeleton", 60, 0, new Sword()));
        monsters.add(new Dragon("Dragon", 150, 50, new Sword()));

        Enemy currentMonster = monsters.get(random.nextInt(monsters.size()));
        System.out.println(RED + "A wild " + currentMonster.getName() + " appears!" + RESET);


        while (player.isAlive()) {
            System.out.println("\nChoose an action:");
            System.out.println(RED + "1. Fight the " + currentMonster.getName() + RESET);
            System.out.println(CYAN + "2. Move to another location" + RESET);
            int action = scanner.nextInt();

            if (action == 1) {

                while (player.isAlive() && currentMonster.isAlive()) {

                    System.out.println("\nYour turn!");
                    System.out.println(BLACK + "Choose an action:"+ RESET);
                    System.out.println(RED + "1. Attack");
                    System.out.println(BLUE + "2. Defend");
                    System.out.println(CYAN + "3. Use Special Ability");
                    System.out.println(GREEN + "4. Heal" + RESET);
                    int combatAction = scanner.nextInt();

                    switch (combatAction) {
                        case 1: // Attack
                            player.attack(currentMonster);
                            break;
                        case 2: // Defend
                            player.defend();
                            break;
                        case 3: // Use Special Ability
                            if (player instanceof Wizard) {
                                ((Wizard) player).castSpell(currentMonster);
                            } else if (player instanceof Assassin) {
                                ((Assassin) player).becomeInvisible();
                            } else if (player instanceof Knight) {
                                ((Knight) player).strongKick(currentMonster);
                            }
                            break;
                        case 4: // Heal
                            player.heal(20);
                            break;
                        default:
                            System.out.println("Invalid action. Skipping turn.");
                            break;
                    }


                    if (!currentMonster.isAlive()) {
                        System.out.println(GREEN + currentMonster.getName() + " has been defeated!");
                        System.out.println("You are rewarded with a new weapon!" + RESET);
                        player.setWeapon(new Sword()); // Example reward
                        break;
                    }


                    System.out.println(RED + "\nMonster's turn!" + RESET);
                    if (currentMonster instanceof Dragon) {
                        ArrayList<Player> players = new ArrayList<>();
                        players.add(player);
                        ((Dragon) currentMonster).fireBreath(players);
                    } else {
                        currentMonster.attack(player);
                    }


                    if (!player.isAlive()) {
                        System.out.println(RED + player.getName() + " has been defeated!");
                        System.out.println(RED + "Game over!" + RESET);
                        return;
                    }
                }


                if (!currentMonster.isAlive()) {
                    currentMonster = monsters.get(random.nextInt(monsters.size()));
                    System.out.println(RED + "A wild " + currentMonster.getName() + " appears!" + RESET);
                }
            } else if (action == 2) {

                System.out.println(BLUE + "You move to another location..." + RESET);
                currentMonster = monsters.get(random.nextInt(monsters.size()));
                System.out.println(RED + "A wild " + currentMonster.getName() + " appears!" + RESET);
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        System.out.println("Game over!");
    }
}