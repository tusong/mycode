package generic;

import java.util.ArrayList;
import java.util.List;

public class MianTest {
    public static void main(String[] args) {

        Shape shape = new Shape();
        Shape ssquar = new Squar();
        Squar squar = new Squar();

        a(shape);
        a(ssquar);
        a(squar);

//        b(shape);
//        b(ssquar);
        b(squar);

        c(shape);
        c(ssquar);
        c(squar);

        d(shape);
        d(ssquar);
        d(squar);

        e(new ArrayList<Shape>());
        e(new ArrayList<Shape>());
//        e(new ArrayList<Squar>());

        f(new ArrayList<Shape>());
        f(new ArrayList<Shape>());
        f(new ArrayList<Squar>());

//        g(new ArrayList<Shape>());
//        g(new ArrayList<Shape>());
        g(new ArrayList<Squar>());
    }

    public static void a(Shape e){

    }

    public static void b(Squar e){

    }

    public static <T> void c(T e){

    }

    public static <T extends Shape> void d(T e){

    }

    public static <T extends Squar> void d(T e){

    }

    public static void e(List<Shape> e){

    }

    public static void f(List<? extends Shape> e){

    }

    public static void g(List<Squar> e){

    }

    public static void h(List<? extends Squar> e){

    }
}
