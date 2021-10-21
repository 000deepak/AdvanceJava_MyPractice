import java.util.*;

class Collection {

    public static void main(String[] args) {

        list();
        linkedList();
        display();
        hashMap();
        linkedHashMap();
        treeMap();
        hashSet();
        linkedHashSet();

        treeSet();

    }

    static void list() {
        List list = new ArrayList();

        list.add(1);
        list.add("Avinash");
        System.out.println("1."+list);

        List list1 = new ArrayList();
        list1.addAll(list);
        System.out.println("2."+list1);
        System.out.println(list.size());

        List list2 = new ArrayList<>(list1);
        System.out.println("3."+list2);

        Integer[] arr = {1, 2, 3, 4, 5};
        Arrays.asList(arr); // collection

        List<Integer> list3 = new ArrayList(Arrays.asList(arr));
        list3.add(1);
        System.out.println("4."+list3);

        //List<Integer> list4 = Arrays.asList(arr); // we can't modify
        List<Integer> list4 = new ArrayList(Arrays.asList(arr));
        list4.add(1);
        System.out.println("5."+list4.get(0));
        System.out.println("6."+list4);
        list3.forEach(System.out::println);

        System.out.println("7."+list4.contains(0));
        System.out.println("8."+list3.remove(1));
        System.out.println("9."+list3);
    }

    static void linkedList() {
        LinkedList<Integer> link = new LinkedList<>();
        //link.addAll(list2);
        link.addFirst(1001);
        link.addLast(1001);
        link.addFirst(1002);
        link.removeLast();

        link.remove(new Integer(1));
        System.out.println(link);
    }

    static void display() {
        LinkedList<Integer> link = new LinkedList<>();
        System.out.println("Iterator Concept");
        Iterator<Integer> iterator = link.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    static void hashMap() {
        Map<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put("123", "123456");
        stringStringMap.put("124", "123456");
        stringStringMap.put("125", "123456");
        stringStringMap.put("126", "123456");
        stringStringMap.put(null, "123444444");

        System.out.println(stringStringMap);
        //modifying key 123
        stringStringMap.put("123", "123456789");
        System.out.println(stringStringMap);
    }

    static void linkedHashMap() {

        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("123", "123456");
        linkedHashMap.put("124", "123456");
        linkedHashMap.put("125", "123456");
        linkedHashMap.put("126", "123456");
        linkedHashMap.put(null, "123444444");

        System.out.println(linkedHashMap);
        linkedHashMap.put("123", "123456789");

        System.out.println(linkedHashMap);
        System.out.println(linkedHashMap.get(null));
        System.out.println(linkedHashMap.containsKey("125"));
        System.out.println(linkedHashMap.keySet());
        System.out.println(linkedHashMap.isEmpty());
        System.out.println(linkedHashMap.size());
        linkedHashMap.putIfAbsent("127", "123456789"); // it will check
        linkedHashMap.remove("127");

        System.out.println(linkedHashMap);

        for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    static void treeMap() {
        TreeMap<Abc, String> treeMap = new TreeMap<>(Comparator.reverseOrder());

        //treeMap.put(null, ""); // NullPointerException
        treeMap.put(new Abc(), "");
        treeMap.put(new Abc(), "");
        treeMap.put(new Abc(), "");

        System.out.println(treeMap);
    }
    static class Abc implements Comparable {
        @Override
        public int compareTo(Object o) {
            return 0;
        }

    }

    static void hashSet() {
        Set<Employee> integerSet = new HashSet<>(); //
        integerSet.add(new

                Employee("Abc", "9898989898989"));
        integerSet.add(new

                Employee("Abc1", "9898989898989"));
        integerSet.add(new

                Employee("Abc2", "9898989898989"));
        integerSet.add(new

                Employee("Abc3", "9898989898989"));
        integerSet.add(new

                Employee("Abc4", "9898989898989"));


        for (Employee employee : integerSet)
            System.out.println(employee.toString());
    }


    static void linkedHashSet() {
        Set<Employee> linkedHashSet = new LinkedHashSet<>(); // equals(), ==
        linkedHashSet.add(new

                Employee("Abc", "9898989898989"));
        linkedHashSet.add(new

                Employee("Abc", "9898989898989"));
        linkedHashSet.add(new

                Employee("Abc1", "9898989898989"));
        linkedHashSet.add(new

                Employee("Abc2", "9898989898989"));
        linkedHashSet.add(new

                Employee("Abc3", "9898989898989"));
        linkedHashSet.add(new

                Employee("Abc4", "9898989898989"));


        for (
                Employee employee : linkedHashSet)
            System.out.println(employee.toString());
    }

    static void treeSet() {
        TreeSet<Integer> integerTreeSet = new TreeSet<>(Comparator.reverseOrder());
        integerTreeSet.add(1);
        integerTreeSet.add(2);
        integerTreeSet.add(3);
        integerTreeSet.add(4);

        System.out.println(integerTreeSet);

        TreeSet<Employee> integerTreeSet1 = new TreeSet<>();

        integerTreeSet1.add(new
                Employee("Abc", "9898989898989"));

        integerTreeSet1.add(new
                Employee("Abc1", "9898989898989"));

        integerTreeSet1.add(new
                Employee("Abc2", "9898989898989"));

        System.out.println(integerTreeSet1);
    }
}

class Employee implements Comparable {
    private String name;
    private String mob;

    public Employee(String name, String mob) {
        this.name = name;
        this.mob = mob;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(mob, employee.mob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mob);
    }

    @Override
    public String toString() {
        return "Employee{" + "name='" + name + '\'' + ", mob='" + mob + '\'' + '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

