package homework.h3.proxy;



public class DocumentProxy implements Document {
    private String fileName;
    private RealDocument realDocument;
    private String userRole;

    public DocumentProxy(String fileName, String userRole) {
        this.fileName = fileName;
        this.userRole = userRole;
    }

    @Override
    public void display() {
        if ("admin".equalsIgnoreCase(userRole) || "editor".equalsIgnoreCase(userRole)){
            if (realDocument == null){
                realDocument = new RealDocument(fileName);
            }
            realDocument.display();
        } else {
            System.out.println("Access denied " + userRole + " no rights to view document");
        }
    }
}
