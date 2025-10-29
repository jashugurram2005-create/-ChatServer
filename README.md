. Chat Application
a. ChatServer.java
Purpose:
Acts as the central server for chat clients to connect to. It handles multiple clients, receives messages from any client, and broadcasts them to every other client connected.

How it works:

The server listens on a specified port (12345).
When a client connects, the server creates a new thread (ClientHandler) for that client.
Each client thread reads incoming messages from its client and forwards (broadcasts) these messages to all connected clients using a shared set of PrintWriter objects.
If a client disconnects, its writer is removed from the set.
Key Concepts:

ServerSocket/Socket: Core Java classes for network communication.
Multi-threading: Each client gets its own thread, enabling simultaneous communication.
Synchronization: The shared set for client writers (clientWriters) is accessed in a thread-safe way using synchronized blocks.
Benefits:

Multiple clients can connect and chat in real-time.
Messages sent by any client are instantly relayed to all other clients.
b. ChatClient.java
Purpose:
Connects to the chat server, enabling a user to send and receive messages.

How it works:

The client connects to the server’s IP and port.
It starts a background thread to listen for incoming messages from the server and print them to the console.
The main thread waits for user input from the console and sends the entered messages to the server.
All messages typed by the user are broadcast to other clients by the server.
Key Concepts:

Socket: Connects to the server.
PrintWriter/BufferedReader: For sending and receiving messages.
Multi-threading: Ensures incoming messages can be received and printed while the user is typing.
Benefits:

Interactive chat experience.
Real-time message delivery.
