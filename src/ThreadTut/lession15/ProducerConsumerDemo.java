package ThreadTut.lession15;

// producer, consumer, product, buffer
public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        new Producer(buffer).start();
        new Consumer(buffer).start();
    }
}

class Producer extends Thread
{
    Buffer buffer;

    public Producer(Buffer buffer)
    {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("produced " + i + " products");
            buffer.push(new Product(i));
        }
    }
}

class Consumer extends Thread
{
    Buffer buffer;

    public Consumer(Buffer buffer)
    {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("consumed " + i + " products");
            buffer.pop();
        }
    }
}

class Product
{
    int id;

    public Product(int id) {
        this.id = id;
    }
}

class Buffer
{
    // size of buffer
    Product[] products = new Product[10];

    int count = 0;
    // producer push products
    public synchronized void push(Product product)
    {
        // if the buffer is plenty, this should wait for consumer to consume
        if (count == products.length)
        {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // otherwise we need to push products
        products[count] = product;
        count++;

        this.notifyAll();
    }

    public synchronized Product pop()
    {
        if (count==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        count--;
        Product product = products[count];

        this.notifyAll();
        return product;
    }
}

