public class PartitionList86 {
          public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }
     //下面写的第一个方法我写的有些太复杂了，还顺便把比x小的部分排序插入，应该不需要这样
//    public ListNode partition(ListNode head, int x) {
//        if(head==null){
//            return head;
//        }
//        ListNode present_node=head;
//        // int present_max;
//        while(present_node!=null){//找到target为x的结点
//            if(present_node.val>=x){
//                break;
//            }
//            present_node=present_node.next;
//            // present_max
//        }
//        // System.out.println("present_node:"+present_node.val);
//        if(present_node==null||present_node.next==null||present_node.val<x){
//            return head;
//        }
//        // System.out.println("present_node:"+present_node.val);
//        ListNode alter_node;
//        ListNode deposite_node;
//        ListNode alter_head=head;
//
//        while (present_node.next!=null){
//            if(present_node.next.val<x){
//                deposite_node=present_node.next;
//                if(present_node.next.next==null){
//                    present_node.next=null;
//                }else{
//                    present_node.next=present_node.next.next;
//                }
//                // System.out.println("deposite:"+deposite_node.val);
//                alter_node=alter_head;
//                if(alter_node.next==null){
//                    deposite_node.next=alter_node;
//                    alter_head=deposite_node;
//                }else{
//                    while(alter_node.next!=null){
//                        if(deposite_node.val<=alter_node.val){
//                            deposite_node.next=alter_node;
//                            alter_head=deposite_node;
//                            break;
//                        }else if(deposite_node.val<=alter_node.next.val){
//                            deposite_node.next=alter_node.next;
//                            alter_node.next=deposite_node;
//                            break;
//                        }else{
//                            alter_node=alter_node.next;
//                            // if(alter_node.next==null){
//                            //     return null;
//                            // }
//                        }
//                    }
//                }
//            }
//            present_node=present_node.next;
//            if(present_node==null){
//                break;
//            }
//
//        }
//        return alter_head;
//    }

//    2019.09.08的凌晨终于做出来了
//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Partition List.
//    Memory Usage: 36 MB, less than 100.00% of Java online submissions for Partition List.
     public ListNode partition(ListNode head, int x) {
         if(head==null){
             return head;
         }
         ListNode present_node=head;
         // int present_max;
         ListNode left_node=null;
         ListNode max_node=null;
         while(present_node.next!=null){//找到target为x的结点
             if(head.val>=x){
                 max_node=head;
                 break;
             }else if(present_node.next.val>=x){
                 left_node=present_node;
                 max_node=present_node.next;
                 present_node=present_node.next;
                 break;
             }
             present_node=present_node.next;
             // present_max
         }
         if(present_node==null||present_node.next==null||present_node.val<x){
             return head;
         }
         // System.out.println("present_node:"+present_node.val);
         // System.out.println("present_node:"+present_node.val);
//         ListNode alter_node;
         ListNode deposite_node=null;
         ListNode alter_head=head;
         while (present_node.next!=null){
             // System.out.println("present_node:"+present_node.val);
             if(present_node.next.val<x){
                 // System.out.println("dsggasdga");
                 deposite_node=present_node.next;
                 if(present_node.next.next==null){
                     present_node.next=null;
                 }else{
                     present_node.next=present_node.next.next;
                 }
                 // System.out.println("deposite_node:"+deposite_node.val);
                 if(left_node==null){
                     deposite_node.next=max_node;
                     left_node=deposite_node;
                     alter_head=left_node;

                 }else{
                     deposite_node.next=max_node;
                     left_node.next=deposite_node;
                     left_node=deposite_node;
                 }
             }else{
                 present_node=present_node.next;
                 if(present_node==null){
                     break;
                 }
             }
         }
         if(present_node!=null){
             if(present_node.val<x){
                 deposite_node.next=max_node;
                 left_node.next=deposite_node;
             }
         }
         return alter_head;
     }
}
