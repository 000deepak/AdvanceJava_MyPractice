import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.InputStream;
import java.util.Comparator;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class StreamConcept {

    static boolean isEven(int i) {
        if ((i & 1) == 0)
            return true;
        else
            return false;
    }

    static int square(int i) {
        return i * i;
    }

    public static int addition(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        // identify even no. -> filter that value

        int sumOfRange = IntStream.range(1, 100).reduce(0, Integer::sum);
        System.out.println(sumOfRange);


// 1.traditional method
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) { // stream handled
            if ((list.get(i) & 1) == 0) { // filter even no
                integerList.add(list.get(i)); // storing the value into list
            }
        }
        System.out.println("1.Output without Using Stream\t" + integerList);

// 2.Stream Concept Filter
        List<Integer> collect = list.stream().filter(a -> (a & 1) == 0).collect(Collectors.toList());
        System.out.println("2.1-Output Using Stream filter\t" + collect);

        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'z', 'k');
        System.out.println("2.2-filtering vowels using filter");
        IntStream.range(97, 123).filter(b -> vowels.contains((char) b)).forEach(c -> System.out.print((char) c + "\t"));
        System.out.println();


// 3.Predicate -> Functional Interface
        Predicate<Integer> predicate = a -> (a & 1) == 0;
        List<Integer> collect2 = list.stream().filter(predicate).collect(Collectors.toList());
        System.out.println("3.Output Using Stream, Predicate declared outside \t" + collect2);


// 4.Method reference
//[::] operator is method reference operator used to call method by its class name.
        List<Integer> collect3 = list.stream().filter(StreamConcept::isEven).collect(Collectors.toList());
        System.out.println("4.1.Output Using Stream, with the help of method reference\t" + collect3);

        List<Integer> collect5 = list.stream().filter(predicate).map(StreamConcept::square).collect(Collectors.toList());
        System.out.println("4.2.Output Using Stream, with the help of Method Reference \t" + collect5);

// 5.Map
        List<Integer> collect1 = list.stream().filter(predicate).map(a -> a * a).collect(Collectors.toList());
        System.out.println("5.Output Using Stream, with the help of map \t" + collect1);


//6.Map using function interface
        Function<Integer, Integer> function = a -> a * a;
        List<Integer> collect4 = list.stream().filter(predicate).map(function).collect(Collectors.toList());
        System.out.println("6.Output Using Stream, with the help of map using Function interface \t" + collect4);


// 7.Optional
        System.out.println("Optionalint concept for sum,max,min,avg,count");
        //including 1
        //excluding 11
        System.out.println("sum is" + IntStream.range(1, 11).sum());
        System.out.println("max is" + IntStream.range(1, 11).max());
        System.out.println("min is" + IntStream.range(1, 11).min());
        System.out.println("average is" + IntStream.range(1, 11).average());
        System.out.println("count of range is" + IntStream.range(1, 11).count());


        OptionalInt max = IntStream.range(1, 11).max();
        if (max.isPresent())
            System.out.println("optional max" + max.getAsInt());

        OptionalDouble average = list.stream().mapToInt(a -> a).average();
        System.out.println("average using optional" + average.getAsDouble());

        //8.use reduce if we need result of last operation to perform current operation
        Integer reduce = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println("8.Use of reduce to get sum" + reduce);

//9.Sorted use
        List<Integer> collect6 = list.stream().sorted().collect(Collectors.toList());
        System.out.println("9.1-Sorted = " + collect6);

        List<Integer> collect7 = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("9.2-Reverse Sorted = " + collect7);

//10.Stream to sort objects
        List<Student> students = new ArrayList<>();
        students.add(new Student("rohani", 33, "RFP03"));
        students.add(new Student("Chandan", 22, "RFP01"));
        students.add(new Student("Chandan", 21, "RFP05"));
        students.add(new Student("Mohan", 19, "RFP04"));
        students.add(new Student("Rohan", 23, "RFP02"));

        System.out.println("10." +
                "" +
                "sorting objects using streams");
        System.out.println(students.stream().sorted(Comparator.comparing(Student::getName).thenComparing(Student::getAge)).collect(Collectors.toList()));

// 11.Consumer -> it will take input, but don't return anything
        list.stream().sorted(Comparator.reverseOrder()).forEach(z -> System.out.print(z + "\t"));
        System.out.println();
        list.forEach(z -> System.out.print(z + "\t"));
        System.out.println();
        list.forEach(System.out::print);
        System.out.println();

        int[] arr = {1, 2, 6, 3, 6, 78, 90, 43, 56};
        int[] arr1 = {1, 1, 2, 2, 6, 3, 6, 78, 78, 90, 90, 43, 43, 56, 56};
        int sum1 = Arrays.stream(arr).sum();
        System.out.println("sum is " + sum1);
        Arrays.stream(arr).filter(a -> (a & 1) == 0).forEach(System.out::println);

// 12.Unique using traditional
        System.out.println("12.1-Unique Number identification using Traditional ");
        int ans = 0;
        for (int i = 0; i < arr1.length; i++) {
            ans = ans ^ arr1[i];
        }
        System.out.println(ans);

//Unique using Stream reduce
        int reduce1 = Arrays.stream(arr1).reduce(0, (a, b) -> a ^ b);
        System.out.println("12.2-Unique number using stream Reduce - " + reduce1);

//Unique using distinct
        System.out.println("12.3-unique using stream distinct");
        Arrays.stream(arr1).distinct().forEach(System.out::println);

//13.Matching
        int[] arr2 = {1, 3, 43};
        boolean b = Arrays.stream(arr2).anyMatch(a -> (a & 1) == 0);
        System.out.println("13.1-any match-" + b);

        int[] arr3 = {2, 1, 3, 43};
        boolean b1 = Arrays.stream(arr3).peek(c -> System.out.println(c)).anyMatch(a -> (a & 1) == 0);
        System.out.println("13.2-any match-" + b1);

        int[] arr4 = {1, 3, 43};
        boolean b2 = Arrays.stream(arr4).peek(c -> System.out.println(c)).allMatch(a -> (a & 1) == 1);
        System.out.println("13.3-all match-" + b2);

        int[] arr5 = {1, 3, 43};
        boolean b3 = Arrays.stream(arr5).peek(c -> System.out.println(c)).noneMatch(a -> (a & 1) == 0);
        System.out.println("13.4-none match-" + b3);

        int[] arr6 = {1, 3, 43};
        int nothing_found = Arrays.stream(arr6).peek(c -> System.out.println(c)).findFirst().orElseThrow(() -> new NullPointerException("Nothing Found"));
        System.out.println("find first-" + nothing_found);

        FunInterf interf = (m, n) -> m + n;
        System.out.println(interf.add(2, 3));
        FunInterf interf2 = StreamConcept::addition;
        FunInterf1 interf3 = StreamConcept::addition;
        System.out.println(interf2.add(3, 3));
    }

}

interface FunInterf {
    int add(int input1, int input2);
}
interface FunInterf1 {
    int add(int input1, int input2);
}


class Student {
    private String name;
    private Integer age;
    private String code;

    public Student(String name, Integer age, String code) {
        this.name = name;
        this.age = age;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", age=" + age + ", code='" + code + '\'' + '}';
    }
}








