package gs.codepad;

class LinkedList_Palindrome {
    Node head;

    // A utility function to check if str is palindrome
    // or not
    boolean isPalidromeUtil(String str)
    {
        int length = str.length();

        // Match characters from beginning and
        // end.
        for (int i=0; i<length/2; i++)
            if (str.charAt(i) != str.charAt(length-i-1))
                return false;

        return true;
    }

    // Returns true if string formed by linked
    // list is palindrome
    boolean isPalindrome()
    {
        Node node = head;

        // Append all nodes to form a string
        String str = "";
        while (node != null)
        {
            str = str.concat(node.data);
            node = node.next;
        }

        // Check if the formed string is palindrome
        return isPalidromeUtil(str);
    }

    /* Driver program to test above function*/
    public static void main(String[] args)
    {
        LinkedList_Palindrome list = new LinkedList_Palindrome();
        list.head = new Node("a");
        list.head.next = new Node("bc");
        list.head.next.next = new Node("d");
        list.head.next.next.next = new Node("dcb");
        list.head.next.next.next.next = new Node("asdsdsd");

        System.out.println(list.isPalindrome());

    }
}
class Node
{
    String data;
    Node next;

    Node(String d)
    {
        data = d;
        next = null;
    }
}