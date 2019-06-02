package com.gupao.vip.pattern.prototype.deep;


public class DeepCloneTest {
    public static void main(String[] args) {
        QiTianDaSheng daSheng = new QiTianDaSheng();
        QiTianDaSheng deepClone =(QiTianDaSheng) daSheng.deepClone();
        System.err.println("深度Clone : "+(daSheng.jinGuBang==deepClone.jinGuBang));

        System.err.println("================");

        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();
        QiTianDaSheng clone = qiTianDaSheng.shallowClone(qiTianDaSheng);
        System.err.println("浅clone : "+(clone.jinGuBang==qiTianDaSheng.jinGuBang));
    }
}