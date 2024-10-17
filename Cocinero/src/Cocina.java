import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cocina {

    public static void main(String[] args) {
        int totalPedidos = 16;
        int numCocineros = 4;
        List<Integer> pedidos = new ArrayList<>();
        for (int i = 1; i <= totalPedidos; i++) {
            pedidos.add(i);
        }

        int pedidosPorCocinero = totalPedidos / numCocineros;

        for (int i = 0; i < numCocineros; i++) {
            List<Integer> subListaPedidos = pedidos.subList(
                    i * pedidosPorCocinero, (i + 1) * pedidosPorCocinero);
            Thread cocinero = new Thread(new Cocinero(i + 1, new ArrayList<>(subListaPedidos)));
            cocinero.start();
        }
    }

    static class Cocinero implements Runnable {
        private final int idCocinero;
        private final List<Integer> pedidos;
        private final Random random = new Random();


        public Cocinero(int idCocinero, List<Integer> pedidos) {
            this.idCocinero = idCocinero;
            this.pedidos = pedidos;
        }

        @Override
        public void run() {
            for (int pedido : pedidos) {
                try {
                    System.out.println("Cocinero #" + idCocinero + " está preparando el pedido #" + pedido);
                    int tiempoPreparacion = random.nextInt(1000) + 500;
                    Thread.sleep(tiempoPreparacion);
                    System.out.println("Cocinero #" + idCocinero + " ha terminado el pedido #"
                            + pedido + " en " + tiempoPreparacion + " ms.");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Cocinero #" + idCocinero + " ha terminado todos sus pedidos.");
        }
    }
}

