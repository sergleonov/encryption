public class RSA {

    /*
    This code implements the RSA cipher. I was able to expand program's capabilities, so now the user can type in actual
    words to be encrypted. The max length is about 4-5 characters depending on the word, but it is a lot better that
    what I started with.
     */
    final long[] primeList = {3,7,11, 13, 17, 19,23,29,31,37,41,43,47,53,59,61,67, 71, 73,79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149,
            151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293,
            307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397,
            401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499,
            503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599,
            601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797,
            809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 	907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997,
            1009, 1013, 1019, 1021, 1031, 1033, 1039, 1049, 1051, 1061, 1063, 1069, 1087, 1091, 1093, 1097, 1103, 1109, 1117, 1123, 1129, 1151, 1153, 1163, 1171, 1181,
            1187, 1193, 1201, 1213, 1217, 1223, 1229, 1231, 1237, 1249, 1259, 1277, 1279, 1283, 1289, 1291, 1297, 1301, 1303, 1307, 1319, 1321, 1327, 1361, 1367, 1373,
            1381, 1399, 1409, 1423, 1427, 1429, 1433, 1439, 1447, 1451, 1453, 1459, 1471, 1481, 1483, 1487, 1489, 1493, 1499, 1511, 1523, 1531, 1543, 1549, 1553, 1559, 1567,
            1571, 1579, 1583, 1597, 1601, 1607, 1609, 1613, 1619, 1621, 1627, 1637, 1657, 1663, 1667, 1669, 1693, 1697, 1699, 1709,
            1721, 1723, 1733, 1741, 1747, 1753, 1759, 1777, 1783, 1787, 1789, 1801, 1811, 1823, 1831, 1847, 1861, 1867, 1871, 1873, 1877, 1879, 1889, 1901, 1907, 1913, 1931, 1933,
            1949, 1951, 1973, 1979, 1987, 1993, 1997, 1999, 2003, 2011, 2017, 2027, 2029, 2039, 2053, 2063, 2069, 2081, 2083, 2087, 2089, 2099, 2111, 2113, 2129, 2131, 2137, 2141, 2143,
            2153, 2161, 2179, 2203, 2207, 2213, 2221, 2237, 2239, 2243, 2251, 2267, 2269, 2273, 2281, 2287, 2293, 2297, 2309, 2311, 2333, 2339, 2341, 2347, 2351, 2357, 2371, 2377, 2381,
            2383, 2389, 2393, 2399, 2411, 2417, 2423, 2437, 2441, 2447, 2459, 2467, 2473, 2477, 2503, 2521, 2531, 2539, 2543, 2549, 2551, 2557, 2579, 2591, 2593, 2609, 2617, 2621, 2633, 2647,
            2657, 2659, 2663, 2671, 2677, 2683, 2687, 2689, 2693, 2699, 2707, 2711, 2713, 2719, 2729, 2731, 2741, 2749, 2753, 2767, 2777, 2789, 2791, 2797, 2801, 2803, 2819, 2833, 2837, 2843,
            2851, 2857, 2861, 2879, 2887, 2897, 2903, 2909, 2917, 2927, 2939, 2953, 2957, 2963, 2969, 2971, 2999, 3001, 3011, 3019, 3023, 3037, 3041, 3049, 3061, 3067, 3079, 3083, 3089, 3109,
            3119, 3121, 3137, 3163, 3167, 3169, 3181, 3187, 3191, 3203, 3209, 3217, 3221, 3229, 3251, 3253, 3257, 3259, 3271, 3299, 3301, 3307, 3313, 3319, 3323, 3329, 3331, 3343, 3347, 3359,
            3361, 3371, 3373, 3389, 3391, 3407, 3413, 3433, 3449, 3457, 3461, 3463, 3467, 3469, 3491, 3499, 3511, 3517, 3527, 3529, 3533, 3539, 3541, 3547, 3557, 3559, 3571, 3581, 3583, 3593,
            3607, 3613, 3617, 3623, 3631, 3637, 3643, 3659, 3671, 3673, 3677, 3691, 3697, 3701, 3709, 3719, 3727, 3733, 3739, 3761, 3767, 3769, 3779, 3793, 3797, 3803, 3821, 3823, 3833, 3847,
            3851, 3853, 3863, 3877, 3881, 3889, 3907, 3911, 3917, 3919, 3923, 3929, 3931, 3943, 3947, 3967, 3989, 4001, 4003, 4007, 4013, 4019, 4021, 4027, 4049, 4051, 4057, 4073, 4079, 4091,
            4093, 4099, 4111, 4127, 4129, 4133, 4139, 4153, 4157, 4159, 4177, 4201, 4211, 4217, 4219, 4229, 4231, 4241, 4243, 4253, 4259, 4261, 4271, 4273, 4283, 4289, 4297, 4327, 4337, 4339,
            4349, 4357, 4363, 4373, 4391, 4397, 4409, 4421, 4423, 4441, 4447, 4451, 4457, 4463, 4481, 4483, 4493, 4507, 4513, 4517, 4519, 4523, 4547, 4549, 4561, 4567, 4583, 4591, 4597, 4603,
            4621, 4637, 4639, 4643, 4649, 4651, 4657, 4663, 4673, 4679, 4691, 4703, 4721, 4723, 4729, 4733, 4751, 4759, 4783, 4787, 4789, 4793, 4799, 4801, 4813, 4817, 4831, 4861, 4871, 4877,
            4889, 4903, 4909, 4919, 4931, 4933, 4937, 4943, 4951, 4957, 4967, 4969, 4973, 4987, 4993, 4999,5003, 5009, 5011, 5021, 5023, 5039, 5051, 5059, 5077, 5081, 5087, 5099, 5101, 5107,
            5113, 5119, 5147, 5153, 5167, 5171, 5179, 5189, 5197, 5209, 5227, 5231, 5233, 5237, 5261, 5273, 5279, 5281, 5297, 5303, 5309, 5323, 5333, 5347, 5351, 5381, 5387, 5393, 5399, 5407,
            5413, 5417, 5419, 5431, 5437, 5441, 5443, 5449, 5471, 5477, 5479, 5483, 5501, 5503, 5507, 5519, 5521, 5527, 5531, 5557, 5563, 5569, 5573, 5581, 5591, 5623, 5639, 5641, 5647, 5651,
            5653, 5657, 5659, 5669, 5683, 5689, 5693, 5701, 5711, 5717, 5737, 5741, 5743, 5749, 5779, 5783, 5791, 5801, 5807, 5813, 5821, 5827, 5839, 5843, 5849, 5851, 5857, 5861, 5867, 5869,
            5879, 5881, 5897, 5903, 5923, 5927, 5939, 5953, 5981, 5987 };
    private long[] publicKey = new long[2]; //first element is n, second is exponent
    private long privateKey;
    private String plaintext = "";
    private String ciphertext;
    final String alphabet = "          ABCDEFGHIJKLMNOPQRSTUVWXYZ!?.,():-[]*&^%$#@><_=+";
    private long phi;

    public RSA(String message) {
        if (message.isEmpty()){
            System.err.println("Error: No input value");
            System.exit(1);
        }
        message = message.toUpperCase();
        //convert message into char value sequence
        long[] charValues = new long[message.length()];
        //we rescale the char values instead of using ASCII table to avoid overflow
        for (int i = 0; i < charValues.length; i++) {
            charValues[i] = alphabet.indexOf(message.charAt(i));
        }

        for (int i = 0; i < charValues.length; i++) {
            plaintext += charValues[i];
        }



        long p1 = primeList[(int) (Math.random() * (primeList.length))];
        long p2 = primeList[(int) (Math.random() * (primeList.length))];

        if (primeList[primeList.length-1]*primeList[primeList.length-2]<Long.parseLong(plaintext)){
            System.err.println("Error: the input is too long");
            System.exit(1);
        }



            while ((p2 == p1) || p2*p1<Long.parseLong(plaintext)) {
                p1 = primeList[(int) (Math.random() * (primeList.length))];
                p2 = primeList[(int) (Math.random() * (primeList.length))];
            }


        //System.out.println("p1: " + p1 + "p2: "+p2);
        phi = (p1 - 1) * (p2 - 1);

        publicKey = getPublicKey(p1, p2);
        while (publicKey[0]< Long.parseLong(plaintext)){
                p1 = primeList[(int) (Math.random() * (primeList.length))];
                p2 = primeList[(int) (Math.random() * (primeList.length))];
            phi = (p1 - 1) * (p2 - 1);
        }
    }






    private long[] getPublicKey(long p1, long p2) {
        long[] a = new long[2];
        a[0] = (p1 * p2); //computes an n
        a[1] = getExponent(); //stores the exponent

        return a;


    }

    private int getExponent() {
        int e = 3; //gets us the smallest prime exponent that is not a factor of phi
        while (gcd(e,phi)!=1) {
            e++;
        }
        return e;
    }

    private long gcd(long a, long b){
        if (b==0) return a;
        return gcd(b,a%b);
    }
    private String getResult(String a){
        String result ="";
        for (int i =0; i<a.length()-1; i+=2){
            int currCharIdx=Integer.parseInt(a.charAt(i)+"")*10+Integer.parseInt(a.charAt(i+1)+"");
            result += alphabet.charAt(currCharIdx);
        }
        return result;
    }
    public String encrypt() {
        long power=1;
        if (plaintext.length()>10){
            System.err.println("Error: The input is too long");
            System.exit(1);
        }
        for(int i=0; i<publicKey[1]; i++){
            power*=Long.parseLong(plaintext);
            power=power%publicKey[0];
        }

        ciphertext = Long.toString(power);
        return ciphertext;
    }

    //method below is for debugging and checking for overflow
    public void encryptTest(){
        for (int i=primeList.length/2+primeList.length/4; i< primeList.length; i++){
            for(int j=primeList.length/2+primeList.length/4; j<primeList.length;j++){
                if (primeList[i]==primeList[j]) continue;
                phi= (primeList[i]-1)*(primeList[j]-1);
                System.out.println("p1 = "+primeList[i] + " p2 = "+primeList[j]);
                publicKey = getPublicKey(primeList[i], primeList[j]);
                encrypt();
                System.out.println("Phi value: "+phi);
                System.out.println("Exponent: " +publicKey[1]);
                System.out.println("N value: "+publicKey[0]);
                System.out.println("Final message: "+decrypt());
                System.out.println();

            }
        }
    }


    public String decrypt() {
        privateKey=getPrivateKey(publicKey[1]);
        long power=1;
        for (int i=0; i<privateKey; i++){
            power*=Long.parseLong(ciphertext);
            power=power%publicKey[0];


        }

        ciphertext = Long.toString(power);

        ciphertext=getResult(ciphertext);
        ciphertext=ciphertext.toLowerCase();

        return ciphertext;

    }
    private long getPrivateKey(long e) {
        long key=1;
        for (int i=1; key%e!=0; i++){
            key=((phi*i)+1);
        }
        privateKey=key/e;

        //System.out.println("The private key: "+ privateKey);
        return key/e;
    }
    public String publicKeytoString(){
        return "The public key is: (" + publicKey[0] + ", " + publicKey[1] + ")";

    }
}



