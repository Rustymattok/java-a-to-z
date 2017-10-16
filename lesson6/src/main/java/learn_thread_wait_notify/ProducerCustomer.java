package learn_thread_wait_notify;

public class ProducerCustomer {

    final Object lock = new Object();
    private boolean blockCustomer = true;

    public void takeData(){
        synchronized (this.lock){
            while(blockCustomer){
                try {
                    System.out.println("Заблокирован основной поставщик");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("что то делает");
        }
    }

    public void removeBlock(boolean enable){
        synchronized (this.lock){
            blockCustomer = enable;
            System.out.println("Разблокирован");
            lock.notify();
        }
    }

    public static void main(String[] args) {
        final ProducerCustomer producerCustomer = new ProducerCustomer();
        Thread threadProducer = new Thread(){
            @Override
            public void run() {
                producerCustomer.takeData();
            }
        };
        Thread threadCustomer = new Thread(){
            @Override
            public void run() {
                producerCustomer.removeBlock(false);
            }
        };
        threadProducer.start();
        threadCustomer.start();
    }
}
