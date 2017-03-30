package edu.hm.cs.swa.projekt_1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Renderer {

    private Object o;

    public Renderer(Object o) {
        this.o = o;
    }

    public String render() {

        StringBuilder builder = new StringBuilder("Instance of " + o.getClass().getCanonicalName() + ":\n");

        for (Field field : this.o.getClass().getDeclaredFields()) {

            RenderMe annotation = field.getAnnotation(RenderMe.class);

            if (annotation != null) {

                field.setAccessible(true);

                builder.append(field.getName()).append(" (Type ").append(field.getType().getCanonicalName()).append(") ");

                try {
                    /* ****************************************************/
                    /* primitive datentypen*/
                    if (field.getType().equals(int.class)) {
                        builder.append(field.getInt(o));
                    } else if (field.getType().equals(char.class)) {
                        builder.append(field.getChar(o));
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
                        } else {
                            builder.append(field.get(o));
                        }
                    }
                } catch (IllegalAccessException eae) {
                    builder.append("no access");
                } catch (ClassNotFoundException e) {
                    builder.append("no renderer class found");
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (SecurityException e) {
                    e.printStackTrace();
                }

                builder.append("\n");

            }
        }

        return builder.toString();
    }
}
