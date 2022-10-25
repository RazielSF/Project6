import java.io.*;
public class testAssembler 
{
    public static void main(String[] args) throws IOException
    {
        File asm;
        File hack;
        asm =  new File("C:\\Java\\Add1.txt");
        hack = new File("C:\\Java\\Add2.txt");

        Assembler assemble = new Assembler(asm, hack);
        assemble.converion();

    }    
}
