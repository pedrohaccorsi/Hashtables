import java.util.LinkedList;
import java.util.List;

public class HashtableSeparateChaining<V> implements Hashtable<V> {

    private LinkedList<Item<V>>[] hashtable;
    private int m;

    public HashtableSeparateChaining(int m) {
        this.m = m;
        this.hashtable = new LinkedList[m];
        for(int i=0; i<this.m; i++){
            this.hashtable[i] = new LinkedList<Item<V>>();
        }
    }

    private int hash(int key){
        return (key % this.m );
    }

    @Override
    public Item<V> delete(int key) {
        int hashValue = hash(key);
        for( Item<V> item : this.hashtable[hashValue]){
            if(item.getKey() == key){
                return item;
            }
        }
        return null;
    }

    @Override
    public int insert(Item<V> item) {
        int hashValue;
        this.hashtable[hashValue = ( hash(item.getKey()) )].add(item);
        return hashValue;
    }

    @Override
    public Item<V> search(int key) {
        return null;
    }

    @Override
    public void print() {

    }
}
