package cn.melman.learn;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.stream.Stream;

public class Test {


    public void testReflect() throws Exception {
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();
        UserService userService = new UserService();
        Field serviceField = clazz.getDeclaredField("userService");
        serviceField.setAccessible(true);
        String name = serviceField.getName();
        String setMethodName = "setUserService";

        Method method = clazz.getMethod(setMethodName, UserService.class);
        method.invoke(userController, userService);

        Stream.of(clazz.getFields()).forEach(field -> {
            String fieldName = field.getName();
            Autowired annotation = field.getAnnotation(Autowired.class);
            if (annotation != null) {
                field.setAccessible(true);
                Class<?> type = field.getType();
                try {
                    Object o = type.newInstance();
                    field.set(userController, o);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
