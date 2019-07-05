class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int i1 = arr1.length - 1, i2 = arr2.length - 1, carry = 0;
        List<Integer> resultList = new ArrayList<Integer>();

        // 1. calculate sum of arr1 and arr2
        while (i1 >= 0 || i2 >= 0 || carry != 0) {
            int n1 = i1 >= 0 ? arr1[i1--] : 0;
            int n2 = i2 >= 0 ? arr2[i2--] : 0;
            int sum = n1 + n2 + carry;
            int result = sum & 1;
            carry = -1 * (sum >> 1) ;
            resultList.add(0, result);        
        }

        // 2. remove leading zero
        int beginIndex = 0;
        while (beginIndex < resultList.size() && resultList.get(beginIndex) == 0)
            beginIndex++;

        if (beginIndex == resultList.size())
            return new int[]{0};
        int resultArray[] = new int[resultList.size() - beginIndex];
        for (int i = 0; i < resultArray.length; i++)
            resultArray[i] = resultList.get(i + beginIndex);
        return resultArray;
    }
}
