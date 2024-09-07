/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kenierdean.seminario.imc.rmi.net;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kenierdean.seminario.imc.rmi.lib.ICalculoRemotoImc;
import net.sf.lipermi.exception.LipeRMIException;
import net.sf.lipermi.handler.CallHandler;
import net.sf.lipermi.net.Server;

/**
 *
 * @author USUARIO
 */
public class Servidor {

    private int puerto = 8080;
    private CallHandler invocador;
    private Server servidor;
    private CalculoRmiImcImplem calculo;
    private ICalculoRemotoImc calculoRemoto;

    public Servidor() {
        invocador = new CallHandler();
        servidor = new Server();
        calculo = new CalculoRmiImcImplem();
    }

    public void iniciar() throws Exception {
        try {
            invocador.registerGlobal(ICalculoRemotoImc.class, calculo);
            try {
                servidor.bind(puerto, invocador);
            } catch (IOException ex) {
                throw new Exception("Error: No es posible invocar metodos remotos.");
            }
        } catch (LipeRMIException ex) {
            throw new Exception("Error: I/O.");
        }

    }

    public void detener() {
        servidor.close();
    }
}
