class MergeSort {
    // this method splits linked list in two halves by iterating over whole list
    // It returns head pointers of first and 2nd halves of linked lists in first_second
    // Head of 1st half is just the head node of linked list
    public static void split_in_half(
        LinkedListNode head,
        Pair<LinkedListNode,LinkedListNode> first_second) {
  
      if (head == null) {
        return;
      }
  
      // Only one element in the list.
      if (head.next == null) {
      
        first_second.first = head;
        first_second.second = null;
      }
      else {
  
        // Let's use the classic technique of moving two pointers:
        // 'fast' and 'slow'. 'fast' will move two steps in each 
        // iteration where 'slow' will be pointing to middle element
        // at the end of loop.
  
        LinkedListNode slow, fast;
        slow = head;
        fast = head.next;
  
        while (fast != null) {
  
          fast = fast.next;
    
          if (fast != null) {
  
            fast = fast.next;
            slow = slow.next;
          }
        }
  
        first_second.first = head;
        first_second.second = slow.next;
  
        // Terminate first linked list.
        slow.next = null;
      }
    }
  
    public static LinkedListNode merge_sorted_lists(
        LinkedListNode first,
        LinkedListNode second) {
    
      if (first == null) {
        return second;
      }
      else if (second == null) {
        return first;
      }
    
      LinkedListNode new_head;
      if (first.data <= second.data) {
        new_head = first;
        first = first.next;
      }
      else {
        new_head = second;
        second = second.next;
      }
  
     LinkedListNode new_current = new_head;
     while (first != null && second != null) {
       LinkedListNode temp = null;
       if (first.data <= second.data) {
         temp = first;
         first = first.next;
       } else {
         temp = second;
         second = second.next;
       }
  
       new_current.next = temp;
       new_current = temp;
     }
  
     if (first != null) {
       new_current.next = first;
     } else if (second != null) {
       new_current.next = second;
     }
  
     return new_head;
    }
  
    public static LinkedListNode merge_sort(
        LinkedListNode head) {
  
      // No need to sort a single element.
      if (head == null || head.next == null) {
        return head;
      }
  
      Pair<LinkedListNode,LinkedListNode> first_second = 
        new Pair<LinkedListNode,LinkedListNode>(null,null);
    
      // Let's split the list in half, sort the sublists
      // and then merge the sorted lists.
      split_in_half(head, first_second);
  
      first_second.first = merge_sort(first_second.first);
      first_second.second = merge_sort(first_second.second);
  
      return merge_sorted_lists(first_second.first, first_second.second);
    }
    public static void main(String[] args) {
  
      int[] v1 = { 5, 1, 2, 34, 2, 5, 1, 3, 2, 6, 0};
  
      LinkedListNode list_head_1 = LinkedList.create_linked_list(v1);
    
      System.out.println("Unsorted linked list: ");
      LinkedList.display(list_head_1);
          
      list_head_1 = merge_sort(list_head_1);
      System.out.println("After Sorting: ");
      LinkedList.display(list_head_1);
    }
}