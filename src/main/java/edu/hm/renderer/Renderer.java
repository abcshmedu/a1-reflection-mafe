package edu.hm.renderer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Class for rendering objects.
 */
public class Renderer {

    private Object toRender;

    /**
     * Creates a Renderer.
     * 
     * @param toRender
     *            the object to render
     */
    public Renderer(Object toRender) {
        this.toRender = toRender;
    }

    /**
     * Method to render objects.
     * 
     * @return string representation of the object
     * @throws ClassNotFoundException
     *             if class to render with does not exist
     * @throws NoSuchMethodException
     *             if render-method does not exist
     */
    public String render() throws ClassNotFoundException, NoSuchMethodException {
        String result = "";
        Class< ? > cls = toRender.getClass();
        result += "Instance of " + cls.getName() + ":\n";
        Field[] flds = cls.getDeclaredFields();
        for (Field fld : flds) {
            RenderMe annot = fld.getAnnotation(edu.hm.renderer.RenderMe.class);
            if (annot != null) {
                fld.setAccessible(true);
                result += fld.getName() + " (Type ";
                try {
                    if (annot.with().equals("")) {
                        result += fld.getType().getName() + "): " + fld.get(toRender) + "\n";
                    } else {
                        Class< ? > renderer = Class.forName(annot.with());
                        Method render = renderer.getMethod("render", fld.getType());
                        result += render.invoke(renderer.newInstance(), fld.get(toRender));
                    }
                } catch (ClassNotFoundException e) {
                    throw e;
                } catch (NoSuchMethodException e) {
                    throw e;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        Method[] mtds = cls.getMethods();
        for (Method mtd : mtds) {
            RenderMe annot = mtd.getAnnotation(edu.hm.renderer.RenderMe.class);
            if (annot != null) {
                mtd.setAccessible(true);
                result += mtd.getName() + "() (ReturnType ";
                try {
                    if (annot.with().equals("")) {
                        result += mtd.getReturnType().getName() + "): " + mtd.invoke(toRender) + "\n";
                    } else {
                        Class< ? > renderer = Class.forName(annot.with());
                        Method render = renderer.getMethod("render", mtd.getReturnType());
                        result += render.invoke(renderer.newInstance(), mtd.invoke(toRender));
                    }
                } catch (ClassNotFoundException e) {
                    throw e;
                } catch (NoSuchMethodException e) {
                    throw e;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

}
