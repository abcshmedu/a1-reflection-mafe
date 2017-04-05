package edu.hm.renderer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Renderer {

    private Object toRender;

    public Renderer(Object toRender) {
        this.toRender = toRender;
    }

    public String render() {
        String result = "";
        Class<?> cls = toRender.getClass();
        result += "Instance of " + cls.getName() + ":\n";
        Field[] flds = cls.getDeclaredFields();
        for (Field fld : flds) {
            RenderMe annot = fld.getAnnotation(edu.hm.renderer.RenderMe.class);
            if (annot != null) {
                fld.setAccessible(true);
                result += fld.getName() + " (Type ";
                if (annot.with().equals("")) {
                    try {
                        result += fld.getType().getName() + "): " + fld.get(toRender) + "\n";
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Class<?> renderer = Class.forName(annot.with());
                        Method render = renderer.getMethod("render", fld.getType());
                        result += render.invoke(renderer.newInstance(), fld.get(toRender));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        }
        Method[] mtds = cls.getMethods();
        for (Method mtd : mtds) {
            RenderMe annot = mtd.getAnnotation(edu.hm.renderer.RenderMe.class);
            if (annot != null) {
                mtd.setAccessible(true);
                result += mtd.getName() + "() (ReturnType ";
                if (annot.with().equals("")) {
                    try {
                        result += mtd.getReturnType().getName() + "): " + mtd.invoke(toRender) + "\n";
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    
                    try {
                        Class<?> renderer = Class.forName(annot.with());
                        Method render = renderer.getMethod("render", mtd.getReturnType());
                        result += render.invoke(renderer.newInstance(), mtd.invoke(toRender));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }
        return result;
    }

}
