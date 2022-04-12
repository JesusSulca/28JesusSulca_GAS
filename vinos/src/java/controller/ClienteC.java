/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteImpl;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;

import javax.enterprise.context.SessionScoped;
import model.Cliente;


@Named(value = "clienteC")
@SessionScoped
public class ClienteC implements Serializable {

    private Cliente cliente;
    private List<Cliente> listaCliente;
    private ClienteImpl dao;
    public ClienteC() {
        cliente = new Cliente();
        listaCliente = new ArrayList<>();
        dao = new ClienteImpl();
    }
    public void registrar() throws Exception {
        try {
            dao.registrar(cliente);
            listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(cliente);
            listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminar() throws Exception{
        try {
            dao.eliminar(cliente);
        } catch (Exception e) {
            System.out.println("Error en eliminar PacienteC/modificar: " + e.getMessage());
        }
    }

    public void listar() throws Exception {
        try {
            listaCliente = dao.listarTodos();
            System.out.println("listado" + listaCliente);
        } catch (Exception e) {
            System.out.println("Error en ClienteC/listar: " + e.getMessage());
        }
    }

    public ClienteImpl getDao() {
        return dao;
    }

    public void setDao(ClienteImpl dao) {
        this.dao = dao;
    }

    /*Getter and Setter*/
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }
}
