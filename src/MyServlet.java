
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.ServerEndpoint;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.apache.catalina.websocket.WebSocketServlet ; 
import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;
import org.apache.catalina.websocket.WsOutbound;

/**
 * Servlet implementation class MyServlet
 */

@WebServlet(urlPatterns = "/servlet")
public class MyServlet extends WebSocketServlet {
    private static final long serialVersionUID = 1L;
    private  static Set<WebSocket> sessions = new HashSet<>() ;
   
    
@Override
public  StreamInbound createWebSocketInbound(String arg0, HttpServletRequest arg1) {
	 
    /*
     * arg1.getRemoteAddr() return the ip address (v4 or v6) of the client
     * 
     * 
     */	
	
	System.out.print("hello");
	WebSocket ws = new WebSocket(arg1.getRemoteAddr());
	return ws ;
   
}

    /*
     * The WebSocket class!!! :D
     * protected* is for testing with JUnit
     */
    protected class WebSocket extends StreamInbound, MessageInbound {

    /*
     * Client stream reference.
     */
    private WsOutbound outbound;
    /*
     * Client IP reference.
     */
        private String ip;

    /*
     * Costructor
     * @param ipAddress
     *  Client ip (v4 or v6).
     */
    protected WebSocket(String ipAddress){
        this.ip = ipAddress;
        
    }

    /*
     * Message sender.
     * @param m
     *  message to client.
     */
    private void sendMessage(String m){
        try{
            outbound.writeTextMessage(CharBuffer.wrap((m).toCharArray()));
        	
        	 
        	
        }
        catch(IOException ioException){
            System.out.println("error opening websocket");
        }
    }

    /*
     * Client open channel.
     * @param o
     *  Client stream reference.
     */
    @Override
    public void onOpen(WsOutbound o){
        this.outbound = o;
        System.out.print(this);
        sessions.add(this);
        System.out.println("socket opened!");
    }
    
   

    /**
     * Client send a char stream to server.
     * @param buffer
     *  Message buffer.
     */
  /*  @Override
    public void onTextMessage(CharBuffer buffer) throws IOException{
    /** 
     * What do you do when client send a message to server.
     * 
     *
    	System.out.print("message received");
    	
    	for (WebSocket temp : sessions) {
    		System.out.print(temp);
    		temp.outbound.writeTextMessage(buffer);
         }
    	
    } */
    
    /**
     * Client send a byte stream to server.
     * @param buffer
     *  Byte buffer.
     */
  /*  @Override
    public void onBinaryMessage(ByteBuffer buffer) throws IOException {
    /**
     * What do you do when client send a byte stream to server.
     *
    } */

	@Override
	protected void onBinaryData(InputStream arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onTextData(Reader arg0) throws IOException {
		// TODO Auto-generated method stub
		
System.out.print("message received");
    	
    	for (WebSocket temp : sessions) {
    		System.out.print(temp);
    		temp.outbound.writeTextMessage(arg0);
    	
         }
		
	}

    } //WebSocket
}//ws