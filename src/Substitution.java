public class Substitution {
    /*
    This code implements Substitution cipher.
     */
    final String alphabet =" abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ,./?<>[]{}|;:()*&^%$#@!`~'\"\\1234567890";
    private String key=" abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ,./?<>[]{}|;:()*&^%$#@!`~'\"\\1234567890";
    private String plaintext;
    private String ciphertext;

    public Substitution(String message){
        plaintext=message;
        ciphertext="";



    }
    private String shuffle(String b){
        char[] a=b.toCharArray();
        for (int i=a.length-1; i>0; i--){
            int j = (int)(Math.random()*(i+1));
            char c = a[j];
            a[j]=a[i];
            a[i]=c;
        }
        b="";
        for (int i=0; i<a.length; i++){
            b+=a[i];
        }
        return b;

    }
    public String encrypt(){
        key=shuffle(key);

        for (int i=0; i<plaintext.length(); i++){
            int index=alphabet.indexOf(plaintext.charAt(i));
            if (index==-1){
                System.err.println("Error: Invalid input");
                System.exit(1);
            }
            ciphertext+=key.charAt(index);
        }

        plaintext="";



        return ciphertext;
    }
    public String decrypt(){
        for (int i=0; i<ciphertext.length(); i++){
            int index = key.indexOf(ciphertext.charAt(i));
            plaintext+=alphabet.toCharArray()[index];
        }
        ciphertext="";
        return plaintext;
    }
}
