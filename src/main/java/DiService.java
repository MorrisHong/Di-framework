import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class DiService {

    public static <T> T getObject(Class<T> classType) {
        T instance = createInstance(classType);

        Arrays.stream(classType.getDeclaredFields()).forEach(field -> {
            if (field.getAnnotation(Di.class) != null) {
                Object fieldInstance = createInstance(field.getType());
                field.setAccessible(true);
                try {
                    field.set(instance, fieldInstance);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

        return instance;
    }

    private static <T> T createInstance(Class<T> classType) {
        try {
            System.out.println(classType.getClass().toString() + "타입의 인스턴스를 생성합니다");
            return classType.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }
}
