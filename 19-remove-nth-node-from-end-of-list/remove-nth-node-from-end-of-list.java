/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //TC O(N) SC O(N)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //count the total no. of nodes
        int count=0;
        ListNode temp =head;
        if(head==null){
            return null;
        }
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        //step 02-compute where i need to rach
        int reach =count-n;
        if(reach==0){
            return head.next;
        }
         temp=head;
        for(int i=1;i<=reach-1;i++){
            temp= temp.next;

        }
        temp.next=temp.next.next;
        return head;

        
    }
}