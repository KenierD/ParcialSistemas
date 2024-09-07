/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kenierdean.seminario.imc.rmi.net;

import kenierdean.seminario.imc.rmi.lib.DatosImc;
import kenierdean.seminario.imc.rmi.lib.ICalculoRemotoImc;

/**
 *
 * @author USUARIO
 */
public class CalculoRmiImcImplem implements ICalculoRemotoImc {

    private DatosImc datos;

    public CalculoRmiImcImplem() {
    }

    @Override
    public DatosImc calcularImc(DatosImc datos) {
        float resultado = 0;
        if (datos.getPeso() <= 0 || datos.getAltura() <= 0) {
            datos.setInterpretación("Error: el peso y la altura deben ser mayores que 0.");
            return datos;
        } else {
            resultado = datos.getPeso() / (datos.getAltura() * datos.getAltura());
            datos.setResultado(resultado);
            if (resultado < 18.5) {
                datos.setInterpretación("Debe consultar un Doctor, tu peso es muy bajo.");
            } else if (resultado >= 18.5 && resultado <= 24.9) {
                datos.setInterpretación("Estas entre el peso correcto.");
            } else if (resultado >= 24.9 && resultado <= 29.9) {
                datos.setInterpretación("Debes bajar un poco de peso.");
            } else {
                datos.setInterpretación("Debe consultar un Doctor, tu peso es muy alto.");
            }
            return datos;
        }

    }

}
