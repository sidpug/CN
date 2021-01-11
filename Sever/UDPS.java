import java.io.*;
import java.net.*;

class UDPS
{
public static void main(String args[])throws Exception
{
DatagramSocket serverSocket = new DatagramSocket(9876);
byte[] rData=new byte[1024];
byte[] sData=new byte[1024];
while(true)
{
System.out.println("Server is Up");
DatagramPacket rPacket=new  DatagramPacket(rData,rData.length);
serverSocket.receive(rPacket);
String sentence=new String(rPacket.getData());
System.out.println("RECEIVED:"+sentence);
InetAddress IPAddress=rPacket.getAddress();
int port=rPacket.getPort();
String capitalizedSentence=sentence.toUpperCase();
sData=capitalizedSentence.getBytes();
DatagramPacket sendPacket=new DatagramPacket(sData,sData.length,IPAddress,port);
serverSocket.send(sendPacket);
}
}
}
