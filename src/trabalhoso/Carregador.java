package trabalhoso;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author ronie
 */
public class Carregador extends Thread{
    //o carregador terá uma fila que não pode ser modificada para representar o caminhão
    private final BlockingQueue<String> caminhao;
    //o atributo produto serve para identificar o item na fila
    private final String produto;
    //o atributo nome identifica o carregador
    private final String nome;
    //coonstrutor que recebe a fila em uso,o nome do produto que este carregador utiliza e o nome para identificar o mesmo
    public Carregador(BlockingQueue<String> c,String p,String n) {
        this.caminhao = c;
        this.produto=p;
        this.nome=n;
    }
    
    @Override
     public void run() {
      while (true) {
        try {
            //testa se a fila tem a capacidade de receber um produto se não tiver avisa o usuario e entra em modo de espera
            if(caminhao.remainingCapacity()==0){
                System.out.println("O Carregador "+nome+" está esperando o caminhão ter espaço");
            }
            //se tiver coloca o produto na fila
            else{
                System.out.println("O Carregador "+nome+" está colocando "+this.produto+" no caminhão");
                this.caminhao.put(produto);
            }
            //aguarda um tempo para realizar uma nova entrega
            Carregador.sleep(10000);
            //sinaliza o fim do tempo
            System.out.println("O Carregador "+nome+" irá fazer outra entrega");
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
      }
    }
}
