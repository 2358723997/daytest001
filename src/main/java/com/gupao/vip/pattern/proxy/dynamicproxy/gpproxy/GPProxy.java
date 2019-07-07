package com.gupao.vip.pattern.proxy.dynamicproxy.gpproxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * GPProxy类
 * 用于生成源代码的工具类
 *
 * @author wangjixue
 * @date 2019-07-07 20:32
 */
public class GPProxy {
    //
    public static final String ln = "\r\n";

    public static Object newProxyInstance(GPClassLoader loader, Class<?>[] interfaces, GPInvocationHandler h) {
        try {
            // 1.动态生成源代码.java文件
            String src = generateSrc(interfaces);
            System.err.println(src);
            // 2.Java文件输出到磁盘
            File file = outputFile(src);
            // 3.将生成的Java文件编译为.class文件
            compileFile(file);
            // 4.将编译生成的.class文件加载到JVM中
            Constructor constructor = loaderFile(loader, file);
            // 5.返回字节码重组的新对象
            return constructor.newInstance(h);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 将文件加载到JVM中
     *
     * @return
     */
    private static Constructor loaderFile(GPClassLoader loader, File file) throws NoSuchMethodException {
        Class proxyClass = loader.findClass("$Proxy0");
        Constructor constructor = proxyClass.getConstructor(GPInvocationHandler.class);
        file.delete();
        return constructor;
    }

    /**
     * 编译生成的Java文件
     *
     * @param file
     */
    private static void compileFile(File file) throws IOException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
        Iterable iterable = manager.getJavaFileObjects(file);
        JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
        task.call();
        manager.close();
    }

    /**
     * 输出Java文件
     *
     * @param src
     */
    private static File outputFile(String src) throws IOException {
        String filePath = GPProxy.class.getResource("").getPath();
        System.err.println(filePath);
        File file = new File(filePath + "$Proxy0.java");
        FileWriter writer = new FileWriter(file);
        writer.write(src);
        writer.flush();
        writer.close();
        return file;

    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("package com.gupao.vip.pattern.proxy.dynamicproxy.gpproxy;" + ln);
        buffer.append("import com.gupao.vip.pattern.proxy.Person;" + ln);
        buffer.append("import java.lang.reflect.*;" + ln);
        buffer.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + ln);
        buffer.append("GPInvocationHandler h;" + ln);
        buffer.append("public $Proxy0(GPInvocationHandler h){" + ln);
        buffer.append("this.h=h;" + ln);
        buffer.append("}" + ln);
        for (Method method : interfaces[0].getMethods()) {
            Class<?>[] params = method.getParameterTypes();

            StringBuffer paramNames = new StringBuffer();
            StringBuffer paramValues = new StringBuffer();
            StringBuffer paramClasses = new StringBuffer();

            for (int i = 0; i < params.length; i++) {
                Class clazz = params[i];
                String type = clazz.getName();
                String paramName = toLowerFirstCase(clazz.getSimpleName());
                paramNames.append(type + " " + paramName);
                paramValues.append(paramName);
                paramClasses.append(clazz.getName() + ".class");
                if (i > 0 && i < params.length - 1) {
                    paramNames.append(",");
                    paramValues.append(",");
                    paramClasses.append(",");
                }
            }
            buffer.append("public " + method.getReturnType().getName() + " " + method.getName() + "(" + paramNames.toString() + "){" + ln);
            buffer.append("try{" + ln);
                buffer.append("Method method = " + interfaces[0].getName() + ".class.getMethod(\"" + method.getName() + "\",new Class[]{" + paramClasses.toString() + "});" + ln);
                buffer.append((hasReturnValue(method.getReturnType()) ? "return " : "") + getCaseCode("this.h.invoke(this,method,new Object[]{" + paramValues + "})", method.getReturnType())+ ";" + ln);
            buffer.append("}catch(Error _ex){");
            buffer.append("}catch(Throwable e){" + ln);
            buffer.append("throw new UndeclaredThrowableException(e);" + ln);
            buffer.append("}" + ln);
            buffer.append(getReturnEmptyCode(method.getReturnType()));
            buffer.append("}" + ln);

        }
        buffer.append("}" + ln);

        return buffer.toString();
    }

    private static String getCaseCode(String code, Class<?> returnClass) {
        if(mappings.containsKey(returnClass)){
            return "(("+mappings.get(returnClass).getName()+".)"+code+")."+returnClass.getSimpleName()+"Value()";
        }
        return code;
    }

    private static boolean hasReturnValue(Class<?> clazz) {
        return clazz != void.class;
    }

    private static Map<Class,Class> mappings = new HashMap<Class, Class>();
    static {
        mappings.put(int.class,Integer.class);
    }
    private static String getReturnEmptyCode(Class<?> returnclazz) {
        if (mappings.containsKey(returnclazz)){
            return "return 0;";
        }else if(void.class==returnclazz){
            return "";
        }else {
            return "return null";
        }

    }

    private static String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        chars[0]+=32;
        return String.valueOf(chars);
    }
}
