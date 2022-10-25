import java.io.*;
import java.util.Scanner;
public class Assembler 
{
    private int programAddress = 0;
    private int dataAddress = 16;
    private File asmFile;
    private BufferedWriter writer;
    private SymbolTable symbTable;

    public Assembler(File inputFile, File hackFile) throws IOException
    {
        //Take a file
        this.asmFile = inputFile;

        //Ready to write into a file
        FileWriter fileWrite = new FileWriter(hackFile);
        this.writer = new BufferedWriter(fileWrite);

        //Initialize SymbolTable
        this.symbTable = new SymbolTable();
    }

    //Translate Process??
    public void converion() throws IOException
    {
        this.symbolFinder();
        this.convert();
    }


    //If L Instructions, AddEntry(Symbol, findAddress), Adds new symbols to table?
    private void symbolFinder() throws IOException
    {
        Parser parser1 = new Parser(asmFile);
        while(parser1.hasMoreLines() == true)
        {
            parser1.advance();
            if(parser1.instructionType() == "L_INSTRUCTION")
            {
                String symbol = parser1.symbol();
                int address = this.programAddress;
                this.symbTable.addEntry(symbol, address);
            }

            programAddress++;
        }
    }

    //Converts to binary?
    private void convert() throws IOException
    {
        Parser parser2 = new Parser(asmFile);

        while(parser2.hasMoreLines() == true)
        {
            parser2.advance();

            String instruction = null;

            //C Instruction
            if(parser2.instructionType() == "C_INSTRUCTION")
            {
                String comp = parser2.comp();
                String dest = parser2.dest();
                String jump = parser2.jump();
                
                StringWriter cInstruction = new StringWriter();
                cInstruction.append("111");
                cInstruction.append(Code.comp(comp));
                cInstruction.append(Code.dest(dest));
                cInstruction.append(Code.jump(jump));
                instruction = cInstruction.toString();
            }

            //A Instruction
            else if(parser2.instructionType() == "A_INSTRUCTION")
            {
                String symbol = parser2.symbol();
                Character char1 = symbol.charAt(0);
                boolean symbolCheck = (!Character.isDigit(char1));
                String address = null;

                //Unsure
                symbol = address;


            }

            if(parser2.instructionType() != "L_INSTRUCTION")
            {
                this.writer.write(instruction);
                this.writer.newLine();
            }

        }
    }


      
}
