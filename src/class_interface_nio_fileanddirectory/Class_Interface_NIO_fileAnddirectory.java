package class_interface_nio_fileanddirectory;

import java.nio.file.*;

// file and directory information - output in console 
public class Class_Interface_NIO_fileAnddirectory {
                                            /* event Exception method "io"*/
    public static void main(String[] args)  throws java.io.IOException { 
        
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        System.out.println("Information file and directory (c)\n"
                + "Enter file or directory name.");
        
        // create the object Path for input of user
        Path path = Paths.get(scanner.nextLine());
        
        if(Files.exists(path)) { /* if the site exist, generate 
                                    one output of the information */
            // display of the information about file (or directory)
            System.out.printf("%n%s exists%n", path.getFileName());
            System.out.printf("%s a directory%n", Files.isDirectory(path) ? "Is":"Is not");
            System.out.printf("%s an absolute path%n", path.isAbsolute()? "Is":"Is not");
            System.out.printf("Last modified: %s%n", Files.getLastModifiedTime(path));
            System.out.printf("Size: %s%n", Files.size(path));
            System.out.printf("Path: %s%n", path);
            System.out.printf("Absolute path: %s%n", path.toAbsolutePath());
            
            if (Files.isDirectory(path)) { // listing output directory
                
                System.out.printf("%nDirectory contents:%n");
                
                // obejct for iteration by content a directory
                DirectoryStream<Path> directory = Files.newDirectoryStream(path);
                
                for (Path pth : directory)
                    System.out.println(pth);
            }    
        }
        else { // output of message error case not per file or directory 
            System.out.printf("%s does not exist%n", path);
        }    
    } // end of class main
} // end of class Class_Interface_NIO_fileAnddirectory
