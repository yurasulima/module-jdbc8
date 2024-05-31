package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {


    public long create(String name) {
        String query = "INSERT INTO client (name) VALUES (?)";
        try {
            Connection connection = Database.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, name);
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getLong(1);
            } else {
                throw new SQLException("Creating client failed, no ID obtained.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getById(long id) {
        String query = "SELECT name FROM client WHERE id = ?";
        try {
            Connection connection = Database.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("name");
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setName(long id, String name) {
        String query = "UPDATE client SET name = ? WHERE id = ?";
        try {
            Connection connection = Database.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setLong(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(long id) {
        String query = "DELETE FROM client WHERE id = ?";
        try {
            Connection connection = Database.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Client> listAll() {
        List<Client> clients = new ArrayList<>();
        String query = "SELECT id, name FROM client";
        try {
            Connection connection = Database.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getLong("id"));
                client.setName(resultSet.getString("name"));
                clients.add(client);
            }
            return clients;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        ClientService clientService = new ClientService();

        long clientId = clientService.create("test");
        System.out.println("result = " + clientId);

        String resultGetById = clientService.getById(clientId);
        System.out.println("resultGetById = " + resultGetById);

        clientService.setName(clientId, "Test2");

        String resultGetById2 = clientService.getById(clientId);
        System.out.println("resultGetById2 = " + resultGetById2);

        List<Client> clients = clientService.listAll();
        System.out.println("clients = " + clients);

        clientService.deleteById(clientId);

        List<Client> clients2 = clientService.listAll();
        System.out.println("clients2 = " + clients2);
    }
}
