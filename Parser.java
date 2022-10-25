import java.io.*;
import java.util.Scanner;
public class Parser 
{
    private Scanner scan;
    private String nextLine;
    private String currentLine;
    
    public Parser(File f) throws IOException
    {
        scan = new Scanner(System.in);
        currentLine = null;
        nextLine = getNextLine();
    }

    private String getNextLine() throws IOException
    {
        String nextLine = this.scan.nextLine();

        //Checks if is a comment or it is empty
        while(nextLine.trim().startsWith("//") || nextLine.trim().isEmpty())
        {
            nextLine = scan.nextLine();
        }
        
        //Checks if there is a comment after the inital instruction
        int commentStart = nextLine.indexOf("//");
        if(commentStart >= 0)
        {
            //Cuts out the comment
            nextLine = nextLine.substring(0, commentStart - 1);
        }

        return nextLine;
    }

    public boolean hasMoreLines()
    {
        if(this.nextLine == null)
        {
            return false;
        }
        
        return true;
    }

    public void advance() throws IOException
    {
        this.currentLine = this.nextLine;
        this.nextLine = this.getNextLine();
    }

    public String instructionType()
    {
        if(nextLine.startsWith("@"))
        {
            return "A_INSTRUCTION";
        }

        else if(nextLine.startsWith("("))
        {
            return "L_INSTRUCTION";
        }

        else
        {
            return "C_INSTRUCTION";
        }
    }

    public String symbol()
    {
        
        if(this.instructionType() == "A_INSTRUCTION")
        {
            currentLine = currentLine.substring(1);
            return currentLine;
        }

        else if(this.instructionType() == "L_INSTRUCTION")
        {
            currentLine = currentLine.substring(1, currentLine.length() - 1);
            return currentLine;
        }

        else
        {
            return null;
        }
    }

    //String between start and equal sign
    public String dest()
    {
        String line = currentLine.trim();
        int equalSpot = currentLine.indexOf("=");

        return line.substring(0, equalSpot - 1);
    }

    //String between equal sign and semicolon sign
    public String comp()
    {
        String line = currentLine.trim();
        int equalSpot = currentLine.indexOf("=");
        int semiSpot = currentLine.indexOf(";");
        //If ';' not found
        if(semiSpot < 0)
        {
            return line.substring(equalSpot + 1);
        }

        else
        {
            return line.substring(equalSpot + 1, semiSpot - 1);
        }

    }

    //String between semicolon sign and end
    public String jump()
    {
        String line = currentLine.trim();
        int semiSpot = currentLine.indexOf(";");
        //If ';' not found
        if(semiSpot < 0)
        {
            return null;
        }

        else
        {
            return line.substring(semiSpot + 1);
        }
    }

}
