- You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
- You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Examples:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Input: l1 = [0], l2 = [0]
Output: [0]

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.

Solution:

Java
```
static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // creating an dummy list
        ListNode curr = dummy; // initialising an pointer
        int carry = 0; // initialising carry with 0 initial value
        // while loop will run, until l1 OR l2 not reaches null OR if they both reaches null.
        // If carry has some value then iterate
        while(l1 != null || l2 != null || carry == 1){
            int sum = 0; // initialising sum
            if(l1 != null){ // adding l1 to our sum & moving l1
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){ // adding l2 to our sum & moving l2
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry; // if we have carry then add it into our sum
            carry = sum/10; // if we get carry, then divide it by 10 to get the carry
            ListNode node = new ListNode(sum % 10); // the value we'll get by modulo it, will become as new node. So, add it to the list
            curr.next = node; // curr will point to that new node if we get
            curr = curr.next; // update the current every time
        }
        return dummy.next; // return dummy.next bcz, we don't want to send the initial node with 0 value!!
    }
```
Python
```python
def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        d = n = ListNode(0)
        num1 = num2 = ""
        while l1:
            num1 += str(l1.val)
            l1 = l1.next
        while l2:
            num2 += str(l2.val)
            l2 = l2.next
        res = str(int(num1[::-1]) + int(num2[::-1]))[::-1]
        for i in res:
            d.next = ListNode(i)
            d = d.next
        return n.next 
```
```python
def addTwoNumbers(self, l1, l2):
        head = ListNode()
        current = head
        carry = 0
        while (l1 != None or l2 != None or carry != 0):
            l1_value = l1.val if l1 else 0
            l2_value = l2.val if l2 else 0
            total = l1_value + l2_value + carry
            current.next = ListNode(total % 10)
            carry = total // 10
            # Move list pointers forward
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
            current = current.next
        return head.next
```