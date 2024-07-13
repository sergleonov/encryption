public class RSAtest {
    public static void main(String[] args) {
        /*
        This program uses RSA cipher algorithm to encrypt short messages. Instead of using ASCII table, I rescaled
        the letters to match their position in the alphabet so that A =1, B = 2, and so on until Z = 26
        I used type long for the calculations and tried to expand the maximum length of the message by using more
        efficient algorithms to compute remainders.
         */


        RSA message = new RSA("bust");
        System.out.println(message.encrypt());
        System.out.println(message.decrypt());

//        message.encryptTest();

    }
}
