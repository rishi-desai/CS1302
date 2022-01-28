import cs1302.adt.StringList;
import cs1302.adt.FancyStringList;
import cs1302.adt.Node;
import cs1302.oracle.FancyOracleStringList;
import cs1302.p2.BaseStringList;
import cs1302.p2.ArrayStringList;
import cs1302.p2.LinkedStringList;

public class Driver {

    public static void main(String[] args) {
        FancyStringList fsl;
        StringList sl;

        //fsl = new FancyOracleStringList();
        fsl = new ArrayStringList();
        //fsl = new LinkedStringList();

        sl = new ArrayStringList();
        //sl = new LinkedStringList();

        fsl.add(0, "a");
        fsl.add(1, "b");

        sl.add(0, "1");

        System.out.println("Test 1: reverse method");
        System.out.println(fsl.toString());
        System.out.println(fsl.reverse());
        System.out.println();

        System.out.println("Test 2: slice method");
        System.out.println(fsl.toString());
        System.out.println(fsl.slice(0, 1, 2));
        System.out.println();

        System.out.println("Test 3: add method");
        System.out.println(fsl.toString());
        fsl.add(2, sl);
        System.out.println(fsl.toString());
        System.out.println();

        System.out.println("Test 4: add method (self-reference)");
        System.out.println(fsl.toString());
        fsl.add(2, fsl);
        System.out.println(fsl.toString());
        System.out.println();

        System.out.println("Test 5: append method");
        System.out.println(fsl.toString());
        fsl.append(sl);
        System.out.println(fsl.toString());
        System.out.println();

        System.out.println("Test 6: append method (self-reference)");
        System.out.println(fsl.toString());
        fsl.append(fsl);
        System.out.println(fsl.toString());
        System.out.println();

        System.out.println("Test 7: prepend method");
        System.out.println(fsl.toString());
        fsl.prepend(sl);
        System.out.println(fsl.toString());
        System.out.println();

        System.out.println("Test 8: prepend method (self-reference)");
        System.out.println(fsl.toString());
        fsl.prepend(fsl);
        System.out.println(fsl.toString());
        System.out.println();

        System.out.println("Test 9: contains method");
        System.out.println(fsl.toString());
        String target = "a";
        int index = 27;
        System.out.println("The list contains '" + target + "' on or after " + index + ": "
                            + fsl.contains(index, target));
        System.out.println();

        System.out.println("Test 10: indexOf method");
        System.out.println(fsl.toString());
        String str = "1";
        int in = 1;
        System.out.println("The index of '" + str + "' on or after " + in + ": "
                            + fsl.indexOf(in, str));
        System.out.println();

    } // main

} // Driver
