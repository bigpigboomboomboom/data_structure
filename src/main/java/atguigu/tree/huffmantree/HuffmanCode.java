package atguigu.tree.huffmantree;

import java.util.*;

/**霍夫曼编码的实现
 * @author zhu @create 2021-04-24 10:26
 */
public class HuffmanCode {
    public static void main(String[] args) {
        String str = "When you find real friends,hold on to them, treasure them,spend time with them, be kind to them, love them" ;
        byte[] bytes = str.getBytes();
        List<HuffmanNode> huffmanList = getHuffmanList(bytes);
        System.out.println(huffmanList);
        HuffmanNode huffmanNode = createHuffmanTree(huffmanList);
        System.out.println(huffmanNode);
        System.out.println("***********");
        huffmanNode.preOrder();
    }


    public static List<HuffmanNode> getHuffmanList(byte[] bytes){
        List<HuffmanNode> list = new ArrayList<>();
        Map<Byte,Integer> map =new HashMap<>();

        for (byte b: bytes){
        if (! map.containsKey(b)){
            map.put(b,1);
        }else {
            map.put(b,map.get(b)+1);
        }
        }

        for(Map.Entry<Byte,Integer> entry:map.entrySet()){
                list.add(new HuffmanNode(entry.getKey(),entry.getValue()));
        }
        return list;

    }

    public static HuffmanNode createHuffmanTree(List<HuffmanNode> list){

        while( list.size()> 1){
            Collections.sort(list);
            HuffmanNode node1 = list.remove(0);
            HuffmanNode node2 = list.remove(0);

            HuffmanNode parent = new HuffmanNode(null, node1.weight + node2.weight);

            parent.left = node1 ;
            parent.right = node2;
            list.add(parent);

        }

        return list.get(0);
    }
}



class HuffmanNode implements Comparable<HuffmanNode>{
    Byte bytes ; //最后用以存放此字符的二进制数组
    int weight ; //字符串中每个字符出现的次数
    HuffmanNode left ;
    HuffmanNode right ;


    public HuffmanNode(Byte bytes, int weight) {
        this.bytes = bytes;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "bytes=" + bytes+
                ", weight=" + weight +
                '}';
    }


    @Override
    public int compareTo( HuffmanNode o) {
        return this.weight - o.weight ;
    }


    public void preOrder(){
        System.out.println(this);

        if (this.left != null){
            this.left.preOrder();
        }

        if (this.right != null){
            this.right.preOrder();
        }

    }
}