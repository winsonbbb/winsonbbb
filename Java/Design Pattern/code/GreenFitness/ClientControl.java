package GreenFitness;

import java.io.*;
import java.util.*;

public class ClientControl {

    private Vector<Client> clients = new Vector();

    public void addHours(String cid, int hours) {
        Client client = findClient(cid);
        if (client != null) {
            client.addHours(hours);
        }

    }

    public void updateContactNumber(String cid, String newNumber) {
        Client client = findClient(cid);
        if (client != null) {
            client.setContactNumber(newNumber);
        }

    }

    public Client createClient(String cid, String cname) {
        Client client = new Client(cid, cname);
        clients.add(client);
        return client;
    }

    public Client findClient(String cid) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getCid().equals(cid)) {
                return clients.get(i);
            }
        }
        return null;
    }

    public void deductHours(String cid, int hours) {
        Client client = findClient(cid);
        if (client != null) {
            client.deductHours(hours);
        }

    }

    public void deleteClient(String cid) {
        Client client = findClient(cid);
        if (client != null) {
            clients.remove(client);
        }

    }

    public Vector<Client> getClients() {
        return clients;
    }

}
