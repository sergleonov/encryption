public class SubstitutionTest {
    public static void main(String[] args) {
        Substitution message =new Substitution("Hello World! How are you doing?");
        System.out.println(message.encrypt());
        System.out.println(message.decrypt());

    }
}
