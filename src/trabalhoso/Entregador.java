package trabalhoso;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author ronie
 */
public class Entregador extends Thread{
    //o entregador terá uma fila que não pode ser modificada para representar o caminhão
    private final BlockingQueue<String> caminhao;
    //produto para questões de identificação
    private String produto;
    //nome para questões de identificação(será recebido da fila)
    private final String nome;
    
    //construtor que receberá a fila em questão e o nome para identificar o mesmo
    public Entregador(BlockingQueue<String> c,String n) {
        this.caminhao = c;
        this.nome = n;
    }
    @Override
    public void run() {
      while (true) {
        try {
            //representa que o entregador está apto a pegar um produto do caminhão
            System.out.println("O Entregador "+nome+" está na espera do caminhão");
            //entregador pega o primeiro produto da fila
            this.produto = caminhao.take();
            //sinaliza que o produto foi pego
            System.out.println("O Entregador "+nome+" pegou do caminhão o produto: "+ produto);
            //aguarda um tempo para poder retirar outro produto da fila
            Entregador.sleep(10000);
            //sinaliza o fim do tempo
            System.out.println("O Entregador "+nome+" entregou o produto: "+produto);
            
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
      }
    }
}
