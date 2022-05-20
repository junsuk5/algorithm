public class Exam01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        StringBuilder sb = new StringBuilder("Hello ");
        for (int i = 0; i < n; i++) {
            sb.append(scanner.next()).append(",");
        }
        System.out.println(sb.substring(0, sb.length() - 1) + ".");
    }
}
