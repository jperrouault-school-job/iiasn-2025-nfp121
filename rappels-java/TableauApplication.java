public class TableauApplication {
    public static void main(String[] args) {
        int[] tab = new int[5];
        System.out.println(tab[0]);

        // System.out.println(tab[5]); // Exception

        int[] tab2 = { 5, 4, 3 };

        tab2[1] = 7;

        int[][] tab3 = new int[5][5];
        int[][][] tab4 = new int[5][5][8];

        System.out.println(tab.getClass().getSimpleName());
    }
}
