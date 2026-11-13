public class Assignment01Q02 {
    public static void main(String[] args) {
        double actualPi = Math.PI;
        double approxPi = 0;

        /////////////////////////////////////////////
        int summands=Integer.parseInt(args[0]);
        for (double i=0;i<summands;i++) {
            double curr = 1/(1+(i*2));
            if (i%2==0)
                approxPi+=curr;
            else
                approxPi-=curr;
        }
        approxPi*=4;
        /////////////////////////////////////////////
        
        System.out.println(approxPi + " " + actualPi);
    }
}

