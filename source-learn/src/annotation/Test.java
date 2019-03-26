package annotation;

public class Test {

    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("annotation.Fox");
        FruitAnnotation fruitAnnotation = (FruitAnnotation) cls.getAnnotation(FruitAnnotation.class);
        fruitAnnotation.annotationType();

    }
}
