package com.gupao.vip.pattern.prototype.simple;


import com.sun.deploy.util.SessionState;

import java.util.ArrayList;

public class SimplePrototypeTest {
    public static void main(String[] args) {
        //原对象
        ConcretePrototypeA concretePrototype = new ConcretePrototypeA();
        concretePrototype.setAge(1);
        concretePrototype.setHobbies(new ArrayList());
        concretePrototype.setName("原对象");
        System.err.println(concretePrototype);
        System.err.println("=========clone()=========");
        //clone()对象
        SimpleClient client = new SimpleClient(concretePrototype);
        ConcretePrototypeA clone = (ConcretePrototypeA)client.startClone(concretePrototype);
        System.err.println(clone.getAge());
        System.err.println(clone.getHobbies());
        System.err.println(clone.getName());
        System.out.println(clone==concretePrototype);
    }
}