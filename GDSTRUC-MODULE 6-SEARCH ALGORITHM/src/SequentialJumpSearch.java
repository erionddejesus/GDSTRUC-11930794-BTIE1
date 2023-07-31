public class SequentialJumpSearch {
    public int jumpSearch(int[] arr, int target, int jumpSize) {

        int n = arr.length;
        int i = 0;

        while (i < n) {
            if (arr[i] == target) {
                return i; // Element found at index i
            } else if (arr[i] < target) {
                // Jump forward by jumpSize
                i += jumpSize;
            } else {
                // Perform regular sequential search between previous and current jump position
                for (int j = i - jumpSize + 1; j < i; j++) {
                    if (arr[j] == target) {
                        return j; // Element found at index j
                    }
                }
                return -1;
            }
        }

        // Perform final check for the target element
        for (int j = i - jumpSize + 1; j < n; j++) {
            if (arr[j] == target) {
                return j; // Element found at index j
            }
        }

        return -1;
    }

}
