package com.gupao.vip.pattern.prototype.simple;

import lombok.Data;

import java.util.List;

/**
 * ConcretePrototypeA类
 *
 * @author wangjixue
 * @date 2019-06-02 11:43
 */
@Data
public class ConcretePrototypeA implements Prototype{
    private String name;
    private Integer age;
    private List hobbies;
    @Override
    public Prototype clone() {
        Prototype result = new ConcretePrototypeA();
        ((ConcretePrototypeA) result).setAge(this.age);
        ((ConcretePrototypeA) result).setName(this.name);
        ((ConcretePrototypeA) result).setHobbies(this.hobbies);
        return result;
    }
}
