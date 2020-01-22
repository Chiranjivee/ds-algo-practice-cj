class SortByFrequency {
    void sortByFrequency(int arr[], int n) {
        Element [] element = new Element[n];
        for (int i = 0; i<n; i++) {
            element[i].index = i;
            element[i].count = 0;
            element[i].val = arr[i];
        }

        mergeSort(element, element + n, mycomp);
        element[0].count = 1;
   
        /* Count occurrences of remaining elements */
        for (int i = 1; i<n; i++) {
            if (element[i].val == element[i - 1].val) {
                element[i].count += element[i - 1].count + 1;
   
                /* Set count of previous element as -1, we are 
                   doing this because we'll again sort on the 
                   basis of counts (if counts are equal than on 
                   the basis of index)*/
                element[i - 1].count = -1;
   
                /* Retain the first index (Remember first index 
                   is always present in the first duplicate we 
                   used stable sort. */
                element[i].index = element[i - 1].index;
            }
   
            /* Else If previous element is not equal to current 
              so set the count to 1 */
            else
                element[i].count = 1;
        }
   
        /* Now we have counts and first index for each element so now 
           sort on the basis of count and in case of tie use index 
           to sort.*/
        stable_sort(element, element + n, mycomp2);
        for (int i = n - 1, index = 0; i >= 0; i--)
            if (element[i].count != -1)
                for (int j = 0; j<element[i].count; j++)
                    arr[index++] = element[i].val;
    }
}
