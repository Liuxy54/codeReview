package com.liuxy.codeReview.com.lxy.designPattern.node02.simpleFactory;

public class CO1_SimpleFactory {
    public static void main(String[] args) {
        OrderFood orderFood = new OrderFood();
        orderFood.orderFood("fish");
        orderFood.orderFood("chicken");
    }
}

/**
 * 订餐流程
 */
class OrderFood {
    public Food orderFood(String foodName) {
        Food food = null;
        if (foodName.equals("fish")) {
            food = new Snakehead();
            food.setName("黑鱼");
        } else if (foodName.equals("chicken")) {
            food = new NativeChicken();
            food.setName("土鸡");
        }
        if (food != null) {
            food.foodMaterial();
            food.cookFood();
            return food;
        } else {
            return null;
        }
    }
}


abstract class Food {
    protected String name;

    public abstract void foodMaterial();

    public void cookFood() {
        System.out.println("食品烹饪：" + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Snakehead extends Food {

    @Override
    public void foodMaterial() {
        System.out.println("材料：黑鱼一条");
    }
}

class NativeChicken extends Food {

    @Override
    public void foodMaterial() {
        System.out.println("材料：土鸡一号");
    }
}