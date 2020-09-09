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
        this.length = m;
        this.doubleHashValue = q;
        this.probing = probing;
        this.hashtable = new Item[m];
    }

    private int hash(int key, int iteration){
        int hash = 0;
        switch (this.probing){
            case LINEAR_PROBING:
                return (key % this.length + iteration) % this.length;
            case QUADRATIC_PROBING:
                return (key % this.length + iteration*iteration) % this.length;
            case DOUBLE_PROBING:
                return (key % this.length + iteration * (this.doubleHashValue - (this.length % this.doubleHashValue)) ) % this.length;
            default: return -1;
        }
    }

    private boolean isHashValueAvailable(int hash){
        return this.hashtable[hash] == null;
    }

    @Override
    public Item<V> delete(int key) {
        int hashValue = 0;
        int iteration = 0;
        Item<V> ro_value;
        while(iteration <=this.length && this.hashtable[ hashValue = hash(key, iteration++)] != null){
            if( this.hashtable[hashValue].getKey() == key){
                ro_value = this.hashtable[hashValue];
                this.hashtable[hashValue] = null;
                return ro_value;
            }
        }
        return null;
    }

    @Override
    public int insert(Item<V> item) {
        int hashValue;
        int iteration = 0;
        int key = item.getKey();
        do {
            if (isHashValueAvailable( hashValue = hash(key, iteration++))) {
                this.hashtable[hashValue] = item;
                return hashValue;
            }
        } while (iteration <= this.length );
        return -1;
    }

    @Override
    public Item<V> search(int key) {
        int hashValue = 0;
        int iteration = 0;
        do{
            if(this.hashtable[ hashValue = hash(key, iteration++) ].getKey() == key){
               return this.hashtable[hashValue];
            }
        }
        while(iteration <=this.length || this.hashtable[hashValue] == null);
        return null;
    }

    @Override
    public void print() {
        String str = "";
        Item<V> item;
        for(int i=0; i<this.length; i++){
            if( (item = this.hashtable[i]) != null){
                str += "chave: " + item.getKey() + " - valor: " + item.getValue() + "\n";
            }
        }
        System.out.println( str.equals("") ? "Hashtable is empty" : str );
    }
}
