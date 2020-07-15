package 数据结构系列.二叉堆实现优先级队列;

public class PriorityQueue {

    private int key[];
    private int N = 0;

    public PriorityQueue(int N) {
        key = new int[N];
    }

    private int parent(int k) {
        return k / 2;
    }

    private int leftChild(int k) {
        return k * 2;
    }

    private int rightChild(int k) {
        return k * 2 + 1;
    }

    private void swap(int a, int b) {
        int temp = key[a];
        key[a] = key[b];
        key[b] = temp;
    }

    /**
     * 上浮
     *
     * @param k
     */
    private void swim(int k) {
        if (k > N) {
            return;
        }
        while (k >= 0 && key[k] > key[parent(k)]) {
            swap(k,parent(k));
            k = parent(k);
        }
    }


}
