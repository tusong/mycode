package com.e_1_4_2;

public class ExampleBean3 {
    private AnotherBean beanOne;

    private YetAnotherBean beanTwo;

    private int i;

    private ExampleBean3(AnotherBean beanOne, YetAnotherBean beanTwo, int i) {
        this.beanOne = beanOne;
        this.beanTwo = beanTwo;
        this.i = i;
    }

    public static ExampleBean3 createInstance(AnotherBean beanOne, YetAnotherBean beanTwo, int i){
        ExampleBean3 exampleBean3 = new ExampleBean3(beanOne,beanTwo,i);

        return exampleBean3;
    }

}
