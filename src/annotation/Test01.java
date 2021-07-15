package annotation;

import java.util.ArrayList;
import java.util.List;

public class Test01 extends Object {
    // override annotation
    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public static void OldMethod()
    {
        System.out.println("this is an old method.");
    }

    @SuppressWarnings("rawtypes")
    public void Method02()
    {
        List list = new ArrayList();
    }

    public static void main(String[] args) {
        OldMethod();
    }
}
