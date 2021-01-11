import java.io.*;
import java.net.*;
import java.net.InetAddress;
import java.util.Scanner;
class UDPC
{
public static void main(String[] args)throws Exception
{
BufferedReader inFromUser=new BufferedReader(new InputStreamReader(System.in));
Scanner sc = new Scanner(System.in);
DatagramSocket clientSocket=new DatagramSocket();
InetAddress IPAddress=InetAddress.getByName("localhost");
byte[] sendData=new byte[1024];
byte[] receiveData=new byte[1024];
System.out.println("Enter the sting to be converted in to Upper case");
String sentence=sc.nextLine();
sendData=sentence.getBytes();
DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IPAddress,9876);
clientSocket.send(sendPacket);
DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
clientSocket.receive(receivePacket);
String modifiedSentence=new String(receivePacket.getData());
System.out.println("FROM SERVER:"+modifiedSentence);
clientSocket.close();
sc.close();
}
}
