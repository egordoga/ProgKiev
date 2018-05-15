package homeWork.week2Day2Annotations.taskAnnotation;

class Test {

    @MyAnnotation(name = "Vasya", age = 30)
    void printUser(String name, int age){
        System.out.println("Name: " + name + " age: " + age);
    }
}
