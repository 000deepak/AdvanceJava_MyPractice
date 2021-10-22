import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args) {
// regular expression

        Pattern pattern = Pattern.compile("^[1-4][2-9]{2}[0-8]{3}$");
        Matcher matcher = pattern.matcher("+91987654321");
        if (matcher.find())
            System.out.println("Pattern matched");
        else
            System.out.println("Pattern not matched");

        Pattern p = Pattern.compile("^[0|91]?[6789][0-9]{9}$"); // 9876543210 09876543210
        Matcher m = p.matcher("+91987654321");
        if (m.find())
            System.out.println("p.Pattern matched");
        else
            System.out.println("m.Pattern not matched");

/*
        919876543210 + 919876543210 ->p1 ? Matcher m1 = pattern.matcher("0123002000000");
        Matcher m1 = pattern.matcher("+91987654321");
        if (matcher.find())
            System.out.println("Pattern matched");
        else
            System.out.println("Pattern not matched");*/


        Pattern p2 = Pattern.compile("[A-Za-z]+");
        Matcher m2 = p2.matcher("Chandan");
        if (m2.find())
            System.out.println("2.Pattern matched");
        else
            System.out.println("2.Pattern not matched");

        Pattern p3 = Pattern.compile("[A-Z]+"); // atleast1
        Matcher m3 = p3.matcher("CHANDAN");
        if (m3.find())
            System.out.println("3.Pattern matched");
        else
            System.out.println("3.Pattern not matched");

        Pattern p4 = Pattern.compile("^[A-Z]+[a-z]*$"); // ? -> 0 0r 1 -> * 0 or more than 1
        Matcher m4 = p4.matcher("CHANDANaaa");
        if (m4.find())
            System.out.println("4.Pattern matched");
        else
            System.out.println("4.Pattern not matched");

        Pattern p5 = Pattern.compile("^[A-Z]+[a-z]?$"); // ? -> 0 0r 1 -> * 0 or more than 1
        Matcher m5 = p5.matcher("CHANDANaa");
        if (m5.find())
            System.out.println("5.Pattern matched");
        else
            System.out.println("5.Pattern not matched");

        Pattern p6 = Pattern.compile("^\\D$"); // ? -> 0 0r 1 -> * 0 or more than 1
        Matcher m6 = p6.matcher("@");
        if (m6.find())
            System.out.println("6.Pattern matched");
        else
            System.out.println("6.Pattern not matched");

        Pattern p7 = Pattern.compile("^\\w$"); // ? -> 0 0r 1 -> * 0 or more than 1 [a-zA-Z0-9]
        Matcher m7 = p7.matcher("@");
        if (m7.find())
            System.out.println("7.Pattern matched");
        else
            System.out.println("7.Pattern not matched");


        Pattern p8 = Pattern.compile("rana"); // i am avinash rana -> rana
        Matcher m8 = p8.matcher("0123002000000");
        if (m8.find())
            System.out.println("8.Pattern matched");
        else
            System.out.println("8.Pattern not matched");

        Pattern p9 = Pattern.compile("rana"); // i am avinash rana -> rana
        String s = "i am avinash rana";
        Matcher m9 = p9.matcher(s); // 13, 16
        if (matcher.find())
            System.out.println(matcher.start() + " " + matcher.end());
        else
            System.out.println("9.Pattern not matched");

    }
}
