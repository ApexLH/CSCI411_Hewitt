/* Create a external process in Java -- process with input */
import java.io.*;
import java.util.*;

public class createprocess {
    public static void main(String args[]) {
        String previous = null;
        while (true){
            try {
                //print the bash symbol
                System.out.print("bash--->");
                //read input from the keyboard - input is a command
                Scanner input = new Scanner(System.in);
                String command = input.nextLine();

                String[] split = command.split("\\s+");

                if(split[0].equals ("exit")){
                    System.out.println("Exiting...");
                    break;
                }
                else if(split[0].equals ("ls")){
                    split[0] = "dir";
                    command = "";
                    for(int i=0; i < split.length; i++){
                        command = command + split[i] + " ";
                    }
                }
                else if(split[0].equals ("pwd")){
                    split[0] = "cd";
                    command = "";
                    for(int i=0; i < split.length; i++){
                        command = command + split[i] + " ";
                    }
                }
                else if(split[0].equals ("cp")){
                    split[0] = "copy";
                    command = "";
                    for(int i=0; i < split.length; i++){
                        command = command + split[i] + " ";
                    }
                }
                else if(split[0].equals ("rm")){
                    split[0] = "del";
                    command = "";
                    for(int i=0; i < split.length; i++){
                        command = command + split[i] + " ";
                    }
                }
                else if(split[0].equals ("man")){
                    split[0] = "help";
                    command = "";
                    for(int i=0; i < split.length; i++){
                        command = command + split[i] + " ";
                    }
                }
                else if(split[0].equals ("nano")){
                    split[0] = "notepad";
                    command = "";
                    for(int i=0; i < split.length; i++){
                        command = command + split[i] + " ";
                    }
                }
                else if(split[0].equals ("grep")){
                    split[0] = "find";
                    command = "";
                    for(int i=0; i < split.length; i++){
                        command = command + split[i] + " ";
                    }
                }
                else if(split[0].equals ("uname")){
                    split[0] = "ver";
                    command = "";
                    for(int i=0; i < split.length; i++){
                        command = command + split[i] + " ";
                    }
                }
                else if(split[0].equals ("which")){
                    split[0] = "where";
                    command = "";
                    for(int i=0; i < split.length; i++){
                        command = command + split[i] + " ";
                    };
                }
                else if(split[0].equals ("env")){
                    split[0] = "set";
                    command = "";
                    for(int i=0; i < split.length; i++){
                        command = command + split[i] + " ";
                    };
                }
                else if(split[0].equals ("ifconfig")){
                    split[0] = "ipconfig";
                    command = "";
                    for(int i=0; i < split.length; i++){
                        command = command + split[i] + " ";
                    };
                }
                else if (command.equals ("last")){
                    command = previous;
                }
                else if (!split[0].equals("dir") && !split[0].equals("cd") && !split[0].equals("copy") && 
                         !split[0].equals("del") && !split[0].equals("type") && !split[0].equals("help") && 
                         !split[0].equals("notepad") && !split[0].equals("find") && !split[0].equals("ver") && 
                         !split[0].equals("date") && !split[0].equals("where") && !split[0].equals("set") && 
                         !split[0].equals("whoami") && !split[0].equals("ipconfig")){
                    System.out.println("This command is not supported by this shell");
                }
                previous = command;

                //create a new process using ProcessBuilder
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", command);
                //start the processls

                Process process = pb.start();

                //Obtain the input stream
                Scanner inputfromprocess = new Scanner(process.getInputStream());
                //display the information from the process
                while (inputfromprocess.hasNext()) {
                    System.out.println(inputfromprocess.nextLine());
                }

                //wait for the process to finish
                process.waitFor();
        
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
    }
}
