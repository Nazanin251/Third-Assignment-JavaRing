package org.project.object.armors;

public abstract class Armor {
    protected int defense;
    protected int maxDefense;
    protected int durability;
    protected int maxDurability;
    protected boolean isBroke;

    public Armor(int defense, int durability) {
        this.defense = defense;
        this.durability = durability;
        this.maxDefense = defense;
        this.maxDurability = durability;
        this.isBroke = false;
    }

    public void checkBreak() {
        if (durability <= 0) {
            isBroke = true;
            defense = 0;
        }
    }

    public void repair() {
        isBroke = false;
        defense = maxDefense;
        durability = maxDurability;
    }

    public int getDefense() {
        return defense;
    }

    public int getDurability() {
        return durability;
    }

    public boolean isBroke() {
        return isBroke;
    }
}