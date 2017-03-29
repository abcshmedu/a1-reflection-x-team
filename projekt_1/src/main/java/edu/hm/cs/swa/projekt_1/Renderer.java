package edu.hm.cs.swa.projekt_1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Renderer {

    private Object o;

    public Renderer(Object o) {
        this.o = o;
    }

    public String render() {

        StringBuilder builder = new StringBuilder("Instance of " + o.getClass().getCanonicalName() + "\n");

        for (Field field : this.o.getClass().getDeclaredFields()) {

            RenderMe annotation = field.getAnnotation(RenderMe.class);

            if (annotation != null) {

                field.setAccessible(true);

                builder.append(field.getName() + "(Type " + field.getType().getCanonicalName() + ") ");

                try {
                    /* ****************************************************/
                    /* primitive datentypen*/
                    if (field.getType().equals(int.class)) {
                        builder.append(field.getInt(o));
                    } else if (field.getType().equals(boolean.class)) {
                        builder.append(field.getBoolean(o));
                    } else {

						/* ****************************************************/
                        /* custom renderer*/
                        String customRenderer = annotation.with();

                        if (customRenderer.length() > 0) {

                            Class<?> renderer = Class.forName(customRenderer);

                            Object renderObj = renderer.getConstructor().newInstance();

                            if (renderObj instanceof AnnotationRenderer) {
                                builder.append(((AnnotationRenderer) renderObj).render(field, o));
                            }


                        }

                    }

                } catch (IllegalAccessException eae) {
                    builder.append("no access");
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    builder.append("no renderer class found");
                } catch (InstantiationException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                builder.append("\n");

            }
        }

        return builder.toString();
    }
}
