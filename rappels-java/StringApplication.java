public class StringApplication {
    public static void main(String[] args) {
        String a = "Hello world!";
        String b = "Hello" + " " + "world!";
        
        System.out.println(a == b);
        System.out.println("---");
        
        String aa = "Hello world!";
        String bb = new String("Hello world!");
        
        System.out.println(aa == bb);
        System.out.println(aa.equals(bb));
    }
}
