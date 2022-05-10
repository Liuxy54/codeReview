package com.liuxy.codeReview.com.lxy.designPattern.node02.simpleFactory;

public class CO2_SimpleFactory {
    public static void main(String[] args) {
        new OrderFood2().createOrderFood("chicken");
    }

}
class OrderFood2 {
    private SimpleFactory simpleFactory = new SimpleFactory();
    public void createOrderFood(String foodName) {
        simpleFactory.createOrderFood(foodName);
    }
}
/**
 * 封装食品的生产流程
 */
class SimpleFactory {
    public Food02 createOrderFood(String foodName) {
        Food02 food = null;
        if (foodName.equals("fish")) {
            food = new Snakehead02();
            food.setName("黑鱼");
        } else if (foodName.equals("chicken")) {
            food = new NativeChicken02();
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
abstract class Food02 {
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

class Snakehead02 extends Food02 {

    @Override
    public void foodMaterial() {
        System.out.println("材料：黑鱼一条");
    }
}

class NativeChicken02 extends Food02 {

    @Override
    public void foodMaterial() {
        System.out.println("材料：土鸡一号");
    }
}
