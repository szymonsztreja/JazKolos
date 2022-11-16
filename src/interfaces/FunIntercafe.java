package interfaces;

public interface FunIntercafe {

    void abstractFun(int x);

    default void normalFun(){
        System.out.println("Hello");
    }
}
