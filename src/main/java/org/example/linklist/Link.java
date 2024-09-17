package org.example.linklist;

public class Link {
    public ListNode reverseList(ListNode head) {
        ListNode p,head1;
        head1=null;
        p=head;
        while (head!=null)
        {
            head=p.next;
            p.next=head1;
            head1=p;
            p=head;
        }
        return head1;


    }
}
