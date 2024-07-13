public class Caesar {

/*
This code implements a Caesar cipher
 */
    private int shift;
    final String lettersU ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final String lettersL ="abcdefghijklnmopqrstuvwxyz";

    private String ciphertext;

    public Caesar(String plaintext){
        shift=0;
        this.ciphertext=plaintext;
    }

    public String toString(){

        return ciphertext;
    }

    public String encrypt(int shift){
        this.shift=shift;
        ciphertext= encryptionAlg(ciphertext, shift);
        return ciphertext;
    }

    private char getEncryptedChar(char c, int shift){
        if (c==' ') return ' ';
        if (lettersU.indexOf(c)==-1 && lettersL.indexOf(c)==-1){return c;}
        if (Character.isLowerCase(c)){
            int index = lettersL.indexOf(c);
            int newIdx=(index+shift)%26;
            return lettersL.charAt(newIdx);
        }else {
            int index = lettersU.indexOf(c);
            int newIdx = (index + shift) % 26;
            return lettersU.charAt(newIdx);
        }
    }
    private String encryptionAlg(String a, int shift){
        if (a.length()==1)return getEncryptedChar(a.charAt(0), shift)+"";
        return getEncryptedChar(a.charAt(0), shift) + encryptionAlg(a.substring(1), shift);
    }
    public String decrypt(){
            return encryptionAlg(ciphertext, 26 - shift%26);
    }
}
