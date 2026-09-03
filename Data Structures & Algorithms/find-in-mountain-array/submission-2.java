/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int t, MountainArray arr) {
        int peak = findPeak(arr);
        int i = binarySearch(arr, t, 0, peak, true);
        if (i != -1) {
            return i;
        }
        return binarySearch(arr, t, peak, arr.length()-1, false);
    }

    private int findPeak(MountainArray arr) {
        int l = 0, r = arr.length()-1;
        while (l < r) {
            int m = l + (r-l)/2;
            if (arr.get(m) < arr.get(m+1)) l = m + 1;
            else r = m;
        }
        return l;
    }

    private int binarySearch(MountainArray arr, int t, int l, int r, boolean asc) {
        while (l <= r) {
            int m = l + (r-l)/2;
            int v = arr.get(m);
            if (v == t) return m;
            if (asc) {
                if (t > v) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                if (t > v) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }
}