/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        int mountain = findTheMountainIndex(0, length - 1, mountainArr);
        if (target == mountainArr.get(mountain)) {
            return mountain;
        }
        int tmp = binarySearch(target, 0, mountain - 1, mountainArr, true);
        if (tmp == -1) {
            tmp = binarySearch(target, mountain + 1, length - 1, mountainArr, false);
        }
        return tmp;
    }

    private int findTheMountainIndex(int start, int end, MountainArray mountainArr) { // find  the mountain peek
        int middle = (start + end) / 2;
        if (middle == start || middle == end) {
            int left = mountainArr.get(start);
            int right = mountainArr.get(end);
            return left > right ? start : end;
        }
        int tmpMiddle = mountainArr.get(middle);
        int left = mountainArr.get(middle - 1);
        int right = mountainArr.get(middle + 1);
        if (tmpMiddle > left && tmpMiddle > right) {
            return middle;
        }
        if (right > left) {
            return findTheMountainIndex(middle + 1, end, mountainArr);
        } else {
            return findTheMountainIndex(start, middle - 1, mountainArr);
        }
    }

    // binary search whith asc or desc order
    private int binarySearch(int target, int left, int right, MountainArray mountainArray, boolean asc) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        int tmp = mountainArray.get(middle);
        if (tmp == target) {
            return middle;
        }
        if (tmp > target) {
            if (asc) {
                return binarySearch(target, left, middle - 1, mountainArray, asc);
            } else {
                return binarySearch(target, middle + 1, right, mountainArray, asc);
            }
        } else {
            if (asc) {
                return binarySearch(target, middle + 1, right, mountainArray, asc);
            } else {
                return binarySearch(target, left, middle - 1, mountainArray, asc);
            }
        }
    }
}
