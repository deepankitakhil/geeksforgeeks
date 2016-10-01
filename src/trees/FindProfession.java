package trees;

/**
 * Created by Deepankit on 9/24/2016.
 */
public class FindProfession {
    public static void main(String[] args) {
        FindProfession findProfession = new FindProfession();
        int position = 4;
        int level = 3;
        System.out.println(findProfession.getProfession(level, position) == 1 ? "Engineer" : "Doctor");
    }

    /*
    true for Engineer
    false for Doctor
     */

    private int getProfession(int level, int position) {
        boolean childProfession = true;
        int childPosition = (int) (Math.pow(2, level - 1) + position - 2);
        while (childPosition > 0) {
            if (childPosition % 2 == 0) {
                childProfession = !childProfession;
            }
            childPosition = (int) Math.ceil((childPosition - 2) / 2.0);
        }
        return childProfession != true ? 0 : 1;

    }
}
