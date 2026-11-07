package org.cuatrovientos.Tamagochi;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Tamagochi implements Runnable {

    private AtomicInteger tiempoVida;
    private byte id;
    private String nombre;
    private volatile boolean vivo = true;
    
    int TIEMPO_DE_VIDA_EN_SEGUNDOS = 300;
    
    public Tamagochi(String nombre, int i) {
        this.nombre = nombre;
        this.id = (byte) i;
        this.tiempoVida = new AtomicInteger(0);
    }
    public boolean estaVivo() {
        return vivo;
    }

    public void asesinar() {

        vivo = false;

        System.out.println(
            nombre + " ha sido asesinado."
        );
    }
    public AtomicInteger getTiempoVida() {
        return tiempoVida;
    }

    public void setTiempoVida(AtomicInteger tiempoVida) {
        this.tiempoVida = tiempoVida;
    }

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void comer(String comida) {
        System.out.println(nombre + " está comiendo " + comida +"....");
        
            int tiempo = ThreadLocalRandom.current().nextInt(100, 10001);
            try {
				Thread.sleep(tiempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            System.out.println(nombre + " se ha zampado " + comida);
    }

    public void jugar() {
        System.out.println(nombre + " está jugando.");
    }

    public void limpiar() {
        System.out.println(nombre + " está limpio.");
    }

    @Override
    public void run() {

        while (tiempoVida.get() < TIEMPO_DE_VIDA_EN_SEGUNDOS) {

            try {
                Thread.sleep(1000);
                tiempoVida.set(tiempoVida.get() + 1);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println(
            nombre + " ha cumplido " + TIEMPO_DE_VIDA_EN_SEGUNDOS + " segundos de vida."
        );

        System.out.println(
          nombre + " ha muerto."
        );
    }
}
