package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        var list = new ArrayList<Integer>(Arrays.stream(arr).boxed().toList());
        Collections.sort(list);
        System.out.println(binarySearch(list, 0));
        System.out.println(binarySearch(list, 1));
        System.out.println(binarySearch(list, 2));
        System.out.println(binarySearch(list, 3));
        System.out.println(binarySearch(list, 4));
        System.out.println(binarySearch(list, 5));
        System.out.println(binarySearch(list, 6));
        System.out.println(binarySearch(list, 7));
    }

    static int binarySearch(List<Integer> list, int findElem) {
        System.out.print("binarySearch()");
        System.out.print(list);
        System.out.println(findElem);

        if(findElem< list.get(0) || findElem>list.get(list.size()-1))
            return -1;

        int indexResult = 0;

        while (list.size() > 0) {

            int middleIndex = list.size() / 2;
            int middleElem = list.get(middleIndex);

            if (middleElem == findElem)
                return indexResult + middleIndex;
            else if (findElem < middleElem)
                list = list.subList(0, middleIndex);
            else if (findElem > middleElem) {
                list = list.subList(middleIndex, list.size());
                indexResult += middleIndex;
            }
        }

        return -1;
    }

}
