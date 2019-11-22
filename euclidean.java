import java.util.*;

class Euclidean
{
    public static void main(String[] args)
    {

        ArrayList<Integer> as = new ArrayList<>();
        ArrayList<Integer> bs = new ArrayList<>();
        ArrayList<Integer> divs = new ArrayList<>();
        ArrayList<Integer> mods = new ArrayList<>();
        ArrayList<Integer> ss = new ArrayList<>();
        ArrayList<Integer> ts = new ArrayList<>();

        int a,b,div,mod,d,s,t = 0;
        a = 99;
        b = 78;
        as.add(a);
        bs.add(b);
        while (b != 0)
        {
            div = a/b;
            mod = a % b;

            divs.add(div);
            mods.add(mod);

            a = b;
            b = mod;

            as.add(a);
            bs.add(b);
        }
        System.out.printf("The GCD is %d\n", a);
        d = a;
        System.out.println(as.toString());
        System.out.println(bs.toString());
        System.out.println(divs.toString());
        System.out.println(mods.toString());

        s = 1;
        t = 0;
        ss.add(s);
        ts.add(t);
        while (!bezout_identity(99, 78, s, t, d))
        {
            s = t;
            t = ss.get(ss.size()-1) - (divs.get(divs.size() - 1) * ts.get(ts.size()-1));
            ss.add(s);
            ts.add(t);
            divs.remove(divs.size()-1);
        }
        s = ss.get(ss.size()-1);
        t = ts.get(ts.size()-1);
        System.out.printf("Bezout numbers, s: %d, t: %d\n", s, t);

    }

    public static Boolean
    bezout_identity(int a, int b, int s, int t, int d)
    {
        return ( (a*s) + (b*t)) == d;
    }

}
