package interfaces;

public class GenericClass<T> {
    //typ pola w klasie
    T obj;

    public GenericClass(T object) {
        this.obj = object;
    }

    //typ wyniku metody
    public T getObj(){
        return this.obj;
    }

    //typ parametru metody
    public <T> void printObject(T genericObject){
        System.out.println(genericObject);
    }


}
