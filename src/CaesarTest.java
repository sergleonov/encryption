public class CaesarTest {
    public static void main(String[] args) {
        Caesar message = new Caesar("That's");
        System.out.println(message.toString());
        System.out.println(message.encrypt(3));
        System.out.println(message.decrypt());


    }
}
