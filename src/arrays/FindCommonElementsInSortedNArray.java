package arrays;

/**
 * Created by Deepankit on 10/13/2016.
 */
public class FindCommonElementsInSortedNArray {
    public static void main(String[] args) throws Exception {
        FindCommonElementsInSortedNArray findCommonElementsInSortedNArray = new FindCommonElementsInSortedNArray();
        int[] inputOne = new int[]{1, 5, 10, 20, 40, 80};
        int[] inputTwo = new int[]{6, 7, 20, 80, 100};
        int[] inputThree = new int[]{3, 4, 15, 20, 30, 70, 80, 120};
        findCommonElementsInSortedNArray.validateInput(inputOne, inputTwo, inputThree);
        findCommonElementsInSortedNArray.commonElementsMethodOne(inputOne, inputTwo, inputThree);
        findCommonElementsInSortedNArray.commonElementsMethodTwo(inputOne, inputTwo, inputThree);
    }

    private void commonElementsMethodOne(int[] inputOne, int[] inputTwo, int[] inputThree) {
        int firstInputIndex = 0;
        int secondInputIndex = 0;
        int thirdInputIndex = 0;
        printCommonElementsMethodOne(inputOne, inputTwo, inputThree, firstInputIndex, secondInputIndex, thirdInputIndex);
    }

    private void commonElementsMethodTwo(int[] inputOne, int[] inputTwo, int[] inputThree) {
        int firstInputIndex = 0;
        int secondInputIndex = 0;
        int thirdInputIndex = 0;
        printCommonElementsMethodTwo(inputOne, inputTwo, inputThree, firstInputIndex, secondInputIndex, thirdInputIndex);
    }

    private void printCommonElementsMethodTwo(int[] inputOne, int[] inputTwo, int[] inputThree, int firstInputIndex, int secondInputIndex, int thirdInputIndex) {
        while (firstInputIndex < inputOne.length && secondInputIndex < inputTwo.length && thirdInputIndex < inputThree.length) {
            if (inputOne[firstInputIndex] == inputTwo[secondInputIndex] && inputTwo[secondInputIndex] == inputThree[thirdInputIndex]) {
                System.out.println(inputOne[firstInputIndex]);
                firstInputIndex++;
                secondInputIndex++;
                thirdInputIndex++;
            } else {
                if (inputOne[firstInputIndex] < inputTwo[secondInputIndex])
                    firstInputIndex++;
                else if (inputTwo[secondInputIndex] < inputThree[thirdInputIndex])
                    secondInputIndex++;
                else
                    thirdInputIndex++;
            }
        }
    }

    private void printCommonElementsMethodOne(int[] inputOne, int[] inputTwo, int[] inputThree, int firstInputIndex, int secondInputIndex, int thirdInputIndex) {
        while (firstInputIndex < inputOne.length && secondInputIndex < inputTwo.length && thirdInputIndex < inputThree.length) {
            if (inputOne[firstInputIndex] == inputTwo[secondInputIndex] && inputTwo[secondInputIndex] == inputThree[thirdInputIndex]) {
                System.out.println(inputOne[firstInputIndex]);
                firstInputIndex++;
                secondInputIndex++;
                thirdInputIndex++;
            } else {
                boolean areDistinctElements = areDistinctElements(inputOne[firstInputIndex], inputTwo[secondInputIndex], inputThree[thirdInputIndex]);
                if (areDistinctElements) {
                    int arrayId = findArrayIdContainigMaxAmongThreeElements(inputOne, inputTwo, inputThree, firstInputIndex, secondInputIndex, thirdInputIndex);
                    if (arrayId == 1) {
                        secondInputIndex++;
                        thirdInputIndex++;
                    } else if (arrayId == 2) {
                        firstInputIndex++;
                        thirdInputIndex++;
                    } else {
                        firstInputIndex++;
                        secondInputIndex++;
                    }
                } else {
                    int dissimilarArrayId = findDissimilarArrayId(inputOne, inputTwo, inputThree, firstInputIndex, secondInputIndex, thirdInputIndex);
                    if (dissimilarArrayId == 1) {
                        if (inputOne[firstInputIndex] > inputTwo[secondInputIndex]) {
                            secondInputIndex++;
                            thirdInputIndex++;
                        } else
                            firstInputIndex++;
                    } else if (dissimilarArrayId == 2) {
                        if (inputTwo[secondInputIndex] > inputThree[thirdInputIndex]) {
                            thirdInputIndex++;
                            firstInputIndex++;
                        } else
                            secondInputIndex++;
                    } else {
                        if (inputThree[thirdInputIndex] > inputOne[firstInputIndex]) {
                            firstInputIndex++;
                            secondInputIndex++;
                        } else
                            thirdInputIndex++;
                    }
                }
            }
        }
    }

    private int findDissimilarArrayId(int[] inputOne, int[] inputTwo, int[] inputThree, int firstInputIndex, int secondInputIndex, int thirdInputIndex) {
        if (inputOne[firstInputIndex] == inputTwo[secondInputIndex])
            return 3;
        else if (inputTwo[secondInputIndex] == inputThree[thirdInputIndex])
            return 1;
        else
            return 2;
    }

    private int findArrayIdContainigMaxAmongThreeElements(int[] inputOne, int[] inputTwo, int[] inputThree, int firstInputIndex, int secondInputIndex, int thirdInputIndex) {
        if (inputOne[firstInputIndex] > inputTwo[secondInputIndex]) {
            if (inputOne[firstInputIndex] > inputThree[thirdInputIndex])
                return 1;
            else
                return 3;
        } else {
            return inputTwo[secondInputIndex] > inputThree[thirdInputIndex] ? 2 : 3;
        }
    }

    private boolean areDistinctElements(int firstNumber, int secondNumber, int thirdNumber) {
        return firstNumber != secondNumber && secondNumber != thirdNumber;
    }

    private void validateInput(int[] inputOne, int[] inputTwo, int[] inputThree) throws Exception {
        if (inputOne == null || inputOne.length == 0 || inputTwo == null || inputTwo.length == 0 || inputThree == null || inputThree.length == 0)
            throw new Exception("invalid input");

    }
}
