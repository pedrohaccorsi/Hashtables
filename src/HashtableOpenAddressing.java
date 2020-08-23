import java.util.List;

public class HashtableOpenAddressing<V> implements Hashtable<V> {

    public static final int LINEAR_PROBING = 0;
    public static final int QUADRATIC_PROBING = 1;
    public static final int DOUBLE_PROBING = 2;

    private Item<V>[] hashtable;
    private int doubleHashValue;
    private int probing;
    private int length;

    public HashtableOpenAddressing(int m, int q, int probing){
        this.doubleHashValue = q;
        this.probing = probing;
        this.length = m;
        this.hashtable = new Item[m];
    }

    private int hash(int key){
        return key % this.length;
    }

    private boolean isHashvalueAvailable(int hash){
        return true;
    }

    @Override
    public Item<V> delete(int key) {
        return null;
    }

    @Override
    public int insert(Item<V> item) {
        int hashValue = hash(item.getKey());

        while(!isHashvalueAvailable( hashValue = hash(item.getKey()) )){
            int a = 1;
        }

        if( this.hashtable[hashValue] == null ){
            this.hashtable[hashValue] = item;
        }

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
