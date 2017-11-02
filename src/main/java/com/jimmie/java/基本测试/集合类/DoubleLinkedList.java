package com.jimmie.java.基本测试.集合类;

//有些地方还可以优化，比如查找时可以判断索引是否大于size的一半，如果是的话，就从另一头开始迭代。
public class DoubleLinkedList
{
  // 节点类Node

  private static class Node
  {
    Object value;
    Node prev = this;
    Node next = this;
    

    Node (Object v){
    	value = v;
    }

    public String toString()
    {
      return value.toString();
    }
  }
  private Node head = new Node(null); // 头节点
  private int size; // 链表大小
  // 以下是接口方法

  public boolean addFirst(Object o)
  {
    addAfter(new Node(o), head);
    return true;
  }

  public boolean addLast(Object o)
  {
    addBefore(new Node(o), head);
    return true;
  }

  public boolean add(Object o)
  {
    return addLast(o);
  }

  public boolean add(int index, Object o)
  {
    addBefore(new Node(o), getNode(index));
    return true;
  }

  public boolean remove(int index)
  {
    removeNode(getNode(index));
    return true;
  }

  public boolean removeFirst()
  {
    removeNode(head.next);
    return true;
  }

  public boolean removeLast()
  {
    removeNode(head.prev);
    return true;
  }

  public Object get(int index)
  {
    return getNode(index).value;
  }

  public int size()
  {
    return size;
  }

  public String toString()
  {
    StringBuffer s = new StringBuffer("[");
    Node node = head;
    for (int i = 0; i < size; i++)
    {
      node = node.next;
      if (i > 0)
        s.append(", ");
      s.append(node.value);
    }
    s.append("]");
    return s.toString();
  }
  //以下是实现方法

  /*private Node getNode(int index)
  {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException();
    Node node = head.next;
    for (int i = 0; i < index; i++)
      node = node.next;
    return node;
  }*/
  
  private Node getNode(int index)
  {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException();
    
    if(index<=size/2){
    	 Node node = head.next;
    	    for (int i = 0; i < index; i++)
    	      node = node.next;
    	    return node;
    }else{
    	Node node = head;
    	 for (int i = size; i > index; i--)
   	      node = node.prev;
   	    return node;
    }
    
   
  }
  
  private void addBefore(Node newNode, Node node)
  {
    newNode.next = node;
    newNode.prev = node.prev;
    newNode.next.prev = newNode;
    newNode.prev.next = newNode;
    size++;
  }

  private void addAfter(Node newNode, Node node)
  {
    newNode.prev = node;
    newNode.next = node.next;
    newNode.next.prev = newNode;
    newNode.prev.next = newNode;
    size++;
  }

  private void removeNode(Node node)
  {
    node.prev.next = node.next;
    node.next.prev = node.prev;
    node.prev = null;
    node.next = null;
    size--;
  }
  
  
  
  
  //测试=========
  public static void main(String[] args)
  {
    DoubleLinkedList doubleLinkList = new DoubleLinkedList();
    /*//添加
    dll.add("张曼玉");
    dll.add("钟楚红");
    dll.add("刘嘉玲");
    System.out.println(dll);

    //添加到最前
    dll.addFirst("林青霞");
    System.out.println(dll);

    //添加到最后，同添加
    dll.addLast("梅艳芳");
    System.out.println(dll);

    //添加到指定位置
    dll.add(4, "王祖贤");
    System.out.println(dll);

    //移除最前的
    dll.removeFirst();
    System.out.println(dll);

    //移除最后的
    dll.removeLast();
    System.out.println(dll);

    //移除指定位置上的
    dll.remove(2);
    System.out.println(dll);

    //返回指定位置上的元素
    System.out.println(dll.get(1));
*/
    
    int n = 1000000;

    long begin = 0;
    long end = 0;
    try

    {

 	   begin = System.currentTimeMillis();
        for(int i = 0;i<n;i++)

        {

           doubleLinkList.add(new Integer(i+1));

        }

        end = System.currentTimeMillis();
        System.out.println("insert耗时：======"+(end-begin));
        System.out.println("总长度：======"+doubleLinkList.size);
//        doubleLinkList.remove(4);

        begin = System.currentTimeMillis();
        for(int i = 0;i<doubleLinkList.size;i++)

        {
        	doubleLinkList.get(i);
//           System.out.print(doubleLinkList.get(i)+" ->");

        }
        System.out.println("========="+doubleLinkList.toString());
        System.out.println(doubleLinkList.get(5));
        end = System.currentTimeMillis();

        System.out.println("show耗时：======"+(end-begin));
    }

    catch(Exception e)

    {

        System.out.println(e.getMessage());

    }  
  }
}


//可以用这个类测试一下：

