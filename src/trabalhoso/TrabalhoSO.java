package trabalhoso;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author ronie
 */
public class TrabalhoSO {
    public static void main(String[] args) {
        //criação do caminhão(fila) com espaço para dois itens(strings)
        BlockingQueue<String> caminhao = new ArrayBlockingQueue<String>(2);
        //criação do executor que lidará com as concoorrencias
        ExecutorService executor = Executors.newCachedThreadPool();
        //foi criado 3 carregadores e 2 entregadores para conseguir demonstrar todos os casos possiveis
        executor.execute(new Carregador(caminhao,"teste1","José"));
        executor.execute(new Entregador(caminhao,"Pedro"));
        executor.execute(new Entregador(caminhao,"Pericles"));
        executor.execute(new Carregador(caminhao,"teste2","Jairo"));
        executor.execute(new Carregador(caminhao,"teste3","Jefferson"));
    }
    
}
