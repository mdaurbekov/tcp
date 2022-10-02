package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    static BufferedReader reader;

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("localhost", 8085);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                reader = new BufferedReader(new InputStreamReader(System.in));
                String word = reader.readLine();
                out.write(word + "\n");
                out.flush();
                String serverWord = in.readLine();
                System.out.println(serverWord);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}