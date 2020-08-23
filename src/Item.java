public class Item<V> {

    private int key;
    private V value;

    public Item(int key, V value){
        this.key = key;
        this.value = value;
    }

    public int getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }
}
