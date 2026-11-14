import java.util.Arrays;

public class Assignment01Q04 {

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        int len=array.length;
        move%=len;
        if (direction=='L') // reverse direction if move if necessary
            move*=-1;
        if ((direction!='L'&&direction!='R')||(Math.abs(move)==len)||move==0) //check for cases where we return the same array
            return array;
        if (move<0)
            move=len+move;
        ShiftArrayCyclicHelper(array,move,0,0,array[0],len);
        return array;
    }

    private static void ShiftArrayCyclicHelper(int[] array, int move, int startIndex, int currIndex, int valueToPlace, int remaining){
        if (remaining==0)
            return;
        int nextIndex = (currIndex+move)%array.length;
        int nextValue = array[nextIndex];
        array[nextIndex]=valueToPlace;

        if (nextIndex ==startIndex)
        {
            int newStart=startIndex+1;
            ShiftArrayCyclicHelper(array, move, newStart,newStart,array[newStart],remaining-1);
        }
        else
            ShiftArrayCyclicHelper(array, move, startIndex, nextIndex, nextValue, remaining-1);
        return;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{0, 8, 9, 5, 6}, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{}, 3, 'R'))); // []
    }
}