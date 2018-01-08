
public class HashProgram {
    public static void main (String [] args) {
        /*
        * Reading a file
        * */

        /*
        * The end
        * */
        HashProgram hashTable = new HashProgram(97);

        hashTable.insert("Dolinin");
        hashTable.insert("man");
        hashTable.insert("computer");


        Item item = hashTable.find("holly");

        if(item != null)
            System.out.println("Элемент найден!");
        else
            System.out.println("Элемент не найден!");

        //hashTable.print();

    }
    //массив для хранения элементов
    private Item[] table;
    //количество элементов в таблице
    private int count;
    //размер таблицы
    private int size;

    public HashProgram(int size) {
        this.size = size;
        table = new Item[size];
    }

    private int hash(String key)
    {
        int hash = 0;

        for(int i = 0; i < key.length(); i++)
            hash = (31 * hash + key.charAt(i)) % size;

        return hash;
    }

    public void insert(String key)
    {
        Item item = new Item(key);
        int hash = hash(key);
        while(table[hash] != null)
        {
            hash++;
            hash %= size;
        }
        table[hash] = item;
    }

    public void print()
    {
        for(int i = 0; i < size; i++)
            if(table[i] != null)
                System.out.println(i + " " + table[i].getKey());
    }

    public Item find(String key)
    {
        int hash = hash(key);
        while(table[hash] != null)
        {
            if(table[hash].getKey().equals(key))
                return table[hash];
            hash++;
            hash = hash % size;
        }

        return null;
    }
}
class Item{

    private String key;

    public Item(String key)
    {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

