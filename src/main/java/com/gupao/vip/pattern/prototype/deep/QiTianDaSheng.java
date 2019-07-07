package com.gupao.vip.pattern.prototype.deep;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * QiTianDaSheng类
 *
 * @author wangjixue
 * @date 2019-06-02 13:01
 */
public class QiTianDaSheng extends Monkey implements Serializable, Cloneable {
    private static final Object INACTIVE = new QiTianDaSheng();
    public JinGuBang jinGuBang;

    public QiTianDaSheng() {
        //init()
        this.jinGuBang = new JinGuBang();
        this.birthday = new Date();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //return INACTIVE;
        //深度clone单例会被破坏；
        return this.deepClone();
    }

    /**
     * 深度clone方法一
     * @return
     */
    public Object deepClone() {

        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            QiTianDaSheng result = (QiTianDaSheng) ois.readObject();
            result.birthday = new Date();
            return result;

        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 深度clone方法二
     * @return
     */
    public <T,M> void deepNewClone(T fromObject , Class<? extends T> fromClazz,M destObject,Class<? extends M> destClazz) {
        List<Field> destFileds = getAllFields(destClazz);
        for (Field field : destFileds) {
            field.setAccessible(true);
            try {
                Field fromField = fromClazz.getDeclaredField(field.getName());
                fromField.setAccessible(true);
                field.set(destObject,fromField.get(fromObject));
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }

    private <M> List<Field> getAllFields(Class<? extends M> destClazz) {
        Field[] fields = destClazz.getDeclaredFields();
        List<Field> resultFields = new ArrayList<Field>();

        if(fields!=null && fields.length>0){
            //获取本类的成员属性
            resultFields  = Arrays.asList(fields);
        }
        if(destClazz.getSuperclass() !=null){
            //获取父类的成员属性
            List<Field> superFields = this.getAllFields(destClazz.getSuperclass());
            resultFields.addAll(superFields);
        }

        return resultFields;
    }

    public QiTianDaSheng shallowClone(QiTianDaSheng target){
       QiTianDaSheng result = new QiTianDaSheng();
       result.height = target.height;
       result.weight = target.weight;
       result.jinGuBang = target.jinGuBang;
       result.birthday = target.birthday;
        return result;
    }
}
