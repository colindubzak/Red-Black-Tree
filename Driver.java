import java.io.*;
import java.util.Scanner;

public class Driver {
    public static void main(String args[]) {
        RedBlackTree tree = new RedBlackTree();
        Scanner scan = new Scanner(System.in);
        String objectType = new String();

        try {
            System.out.print("Enter the name of the input file: ");

            String inputFileName = scan.nextLine();
            File file = new File(inputFileName);
            Scanner scanFile = new Scanner(file);

            System.out.print("Enter the name of the output file: ");

            String outputFileName = scan.nextLine();
            File outFile = new File(outputFileName);
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"));

            writer.write("HI");
            objectType = scanFile.nextLine();


            if(objectType == "Integer") {
                while (scanFile.hasNextLine()) {
                    if (scanFile.nextLine() == "PrintTree") {
                        writer.write(tree.toString());
                    }
                    int newElement = scanFile.nextInt();
                    if (tree.insert(newElement)) {
                        writer.write("True");
                    } else {
                        writer.write("False");
                    }

                }
                scan.close();
            } else if (objectType == "String") {
                while (scanFile.hasNextLine()){
                    if (scanFile.nextLine() == "PrintTree") {
                        writer.write(tree.toString());
                    }
                    String newElement = scanFile.nextLine();
                    if (tree.insert(newElement)) {
                        writer.write("True");
                    } else {
                        writer.write("False");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
