import java.util.Hashtable;
public class SymbolTable 
{
    private Hashtable<String, Integer> symTable;

    public SymbolTable()
    {
        symTable = new Hashtable<String, Integer>();

        symTable.put("R0", 0);
        symTable.put("R1", 1);
        symTable.put("R2", 2);
        symTable.put("R3", 3);
        symTable.put("R4", 4);
        symTable.put("R5", 5);
        symTable.put("R6", 6);
        symTable.put("R7", 7);
        symTable.put("R8", 8);
        symTable.put("R9", 9);
        symTable.put("R10", 10);
        symTable.put("R11", 11);
        symTable.put("R12", 12);
        symTable.put("R13", 13);
        symTable.put("R14", 14);
        symTable.put("R15", 15);
        symTable.put("SCREEN", 16384);
        symTable.put("KBD", 24576);
        symTable.put("SP", 0);
        symTable.put("LCL", 1);
        symTable.put("ARG", 2);
        symTable.put("THIS", 3);
        symTable.put("THAT", 4);

    }

    public void addEntry(String symbol, int address)
    {
        symTable.put(symbol, address);
    }

    public boolean contains(String symbol)
    {
        if(symTable.containsKey(symbol))
        {
            return true;
        }

        return false;
    }

    public int getAddress(String symbol)
    {
        return symTable.get(symbol);
    }
}
