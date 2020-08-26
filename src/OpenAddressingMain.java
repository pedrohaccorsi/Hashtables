public class OpenAddressingMain {
    public static void main(String[] args){
        Hashtable myHashTable_linear    = new HashtableOpenAddressing(11,7, HashtableOpenAddressing.LINEAR_PROBING);
        Hashtable myHashTable_quadratic = new HashtableOpenAddressing(11,7, HashtableOpenAddressing.QUADRATIC_PROBING);
        Hashtable myHashTable_double    = new HashtableOpenAddressing(11,7, HashtableOpenAddressing.DOUBLE_PROBING);

        myHashTable_linear.insert( new Item<String>( 7, "Pedro" ) );
        myHashTable_linear.insert( new Item<String>( 17, "Joao" ) );
        myHashTable_linear.insert( new Item<String>( 36, "Carlos" ) );
        myHashTable_linear.insert( new Item<String>( 100, "Guto" ) );
        myHashTable_linear.insert( new Item<String>( 106, "Rafa" ) );
        myHashTable_linear.insert( new Item<String>( 205, "Nina" ) );

        System.out.println(myHashTable_linear.search(205).getValue());
        System.out.println(myHashTable_linear.search(17).getValue());
        System.out.println(myHashTable_linear.search(106).getValue());

        myHashTable_quadratic.insert( new Item<String>( 7, "Pedro" ) );
        myHashTable_quadratic.insert( new Item<String>( 17, "Joao" ) );
        myHashTable_quadratic.insert( new Item<String>( 36, "Carlos" ) );
        myHashTable_quadratic.insert( new Item<String>( 100, "Guto" ) );
        myHashTable_quadratic.insert( new Item<String>( 106, "Rafa" ) );
        myHashTable_quadratic.insert( new Item<String>( 205, "Nina" ) );

        System.out.println(myHashTable_quadratic.search(205).getValue());
        System.out.println(myHashTable_quadratic.search(17).getValue());
        System.out.println(myHashTable_quadratic.search(106).getValue());

        myHashTable_double.insert( new Item<String>( 7, "Pedro" ) );
        myHashTable_double.insert( new Item<String>( 17, "Joao" ) );
        myHashTable_double.insert( new Item<String>( 36, "Carlos" ) );
        myHashTable_double.insert( new Item<String>( 100, "Guto" ) );
        myHashTable_double.insert( new Item<String>( 106, "Rafa" ) );
        myHashTable_double.insert( new Item<String>( 205, "Nina" ) );

        System.out.println(myHashTable_double.search(205).getValue());
        System.out.println(myHashTable_double.search(17).getValue());
        System.out.println(myHashTable_double.search(106).getValue());

        myHashTable_double.delete(205);
        myHashTable_double.delete(100);
        myHashTable_double.insert( new Item<String>( 100, "Guto" ) );
        myHashTable_double.insert( new Item<String>( 205, "Nina" ) );

        System.out.println("--------------");
        myHashTable_linear.print();
        myHashTable_quadratic.print();
        myHashTable_double.print();

    }
}
