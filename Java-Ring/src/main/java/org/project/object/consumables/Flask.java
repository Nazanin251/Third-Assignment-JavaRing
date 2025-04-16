package org.project.object.consumables;

import org.project.entity.Entity;

public class Flask extends Consumable {
    @Override
    public void use(Entity target) {
        target.heal(target.getMaxHP() / 10);  
    }
}
