package homework.h3.proxy;



public class RealDocument implements Document {
    private String fileName;

    public RealDocument(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading file: "+ fileName + "from disk...");
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        System.out.println(fileName + " loaded.");
    }

    @Override
    public void display() {
        System.out.println("Visualising document: " + fileName);
    }
}
