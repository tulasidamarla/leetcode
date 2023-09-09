class Node:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class ReverseLinkedList:

    def reverseLinkedList(self, head: Node) -> Node:
        if not head:
            return None
        newHead = head
        if head.next:
            newHead = self.reverseLinkedList(head.next)
            head.next.next = head
        head.next = None
        return newHead


def main():
    solution = ReverseLinkedList()
    node3 = Node(4)
    node2 = Node(3, node3)
    node1 = Node(2, node2)
    root = Node(1, node1)
    print('original list')
    first = root
    while first:
        print(first.val)
        first = first.next

    node = solution.reverseLinkedList(root)
    print('reverse')
    while node:
        print(node.val)
        node = node.next


main()
