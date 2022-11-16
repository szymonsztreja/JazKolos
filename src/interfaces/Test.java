package interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Test {
    public static void main(String[] args) {
        GenericClass<Integer> genericObj = new GenericClass<>(15);
        System.out.println(genericObj.getObj());

//        List<Integer> nubmers = Arrays.asList(2,4,6,77,57,8);
        List<Integer> numbers = new ArrayList<>(Arrays.asList(3,5,7,8));
//        numbers.forEach( n -> System.out.println(n));
        Consumer<Integer> method = n -> System.out.println(n);
        numbers.forEach(method);

        FunIntercafe funIntercafe = x -> System.out.println(2*x);
        funIntercafe.abstractFun(5);

        FunInter1 add = (int x, int y) -> x + y;

        FunInter1 multiply = (x, y) -> x * y;

        Test testObj = new Test();

        System.out.println("Addition is " + testObj.operate(6, 3 ,add));

        System.out.println("Mul is " + testObj.operate(6,3, multiply));

        FuncInter2 fobj = message -> System.out.println("Hello " + message);
        fobj.sayMessage("Geek");
    }
    private int operate(int a, int b, FunInter1 fobj){
        return fobj.operation(a, b);
    }
}
