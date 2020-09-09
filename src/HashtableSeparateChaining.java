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
        int index = -1;
        for( Item<V> item : this.hashtable[hashValue]){
            index++;
            if(item.getKey() == key){
                return this.hashtable[hashValue].remove(index);
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
        int hash = hash(key);
        for(Item<V> item : this.hashtable[hash]){
            if(item.getKey() == key )
                return item;
        }
        return null;
    }

    @Override
    public void print() {
        String str = "";
        for(int i=0; i<this.m; i++){
            for(Item<V> item: this.hashtable[i]){
                str += "Key: " + item.getKey() + ", Value: " + item.getValue() + "\n";
            }
        }
        System.out.println( str.equals("") ? "Hashtable is empty" : str );
    }
}
