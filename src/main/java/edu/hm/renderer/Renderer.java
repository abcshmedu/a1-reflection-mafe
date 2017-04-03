package edu.hm.renderer;

import java.lang.reflect.Field;

public class Renderer {

    private Object toRender;

    public Renderer(Object toRender) {
        this.toRender = toRender;
    }

    public String render() {
        String result = "";
        Class<?> cls = toRender.getClass();
        result += "Instance of: " + cls.getName() + "\n";
        Field[] flds = cls.getDeclaredFields();
        for (Field fld: flds) {
            if (fld.getAnnotationsByType(edu.hm.renderer.RenderMe.class) != null) {
                try {
                	fld.setAccessible(true);
					result += fld.getName()
							+ " (Type " + fld.getType() + "): "
							+ fld.get(toRender) + "\n";
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
        }
        return result;
    }

}
