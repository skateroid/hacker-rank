package week4;

public class SeparateTheNumbers {

    public static void main(String[] args) {
        separateNumbers("1234");
        separateNumbers("91011");
        separateNumbers("99100");
        separateNumbers("275318353275318354275318355");
        separateNumbers("275318353275318354275317355");
        separateNumbers("185702657185702658185702659");
        separateNumbers("185702657185702658185792659");
        separateNumbers("728720208728720209728720210");
        separateNumbers("728720208728720209728620210");
        separateNumbers("719298122719298123719298124");
        separateNumbers("719298122719298123718298124");
        separateNumbers("640412479640412480640412481");
        separateNumbers("640412479640412480630412481");
    }

    public static void separateNumbers(String s) {
        int stringLength = s.length();
        int currentLength = 1;
        while (currentLength <= stringLength / 2) {
            long firstValue = Long.parseLong(s.substring(0, currentLength));
            int counter = 0;
            StringBuilder builder = new StringBuilder();
            builder.append(firstValue);
            while (builder.length() < stringLength) {
                builder.append(firstValue + ++counter);
            }
            if (builder.toString().equals(s)) {
                System.out.printf("YES %s\n", firstValue);
                return;
            }
            currentLength++;
        }
        System.out.println("NO");
    }
}
