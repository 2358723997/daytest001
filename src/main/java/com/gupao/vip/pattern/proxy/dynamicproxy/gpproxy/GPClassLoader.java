package com.gupao.vip.pattern.proxy.dynamicproxy.gpproxy;

import java.io.*;

/**
 * GPClassLoader类
 *
 * @author wangjixue
 * @date 2019-07-07 20:38
 */
public class GPClassLoader extends ClassLoader {
    private File classPathFile;

    public GPClassLoader() {
        String classPath = GPClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }

    public Class findClass(String name) {
        String className = GPClassLoader.class.getPackage().getName() + "." + name;
        if (classPathFile != null) {
            File classFile = new File(classPathFile, name.replaceAll("\\.", "/") + ".class");
            if (classFile.exists()) {
                FileInputStream in = null;
                ByteArrayOutputStream out = null;
                try {
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int length;
                    while ((length = in.read(buff)) != -1) {
                        out.write(buff, 0, length);
                    }
                    return defineClass(className, out.toByteArray(), 0, out.size());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (null != in) {
                            in.close();
                        }
                        if (null != out) {
                            out.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

        }
        return null;
    }
}