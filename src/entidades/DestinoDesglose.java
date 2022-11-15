package entidades;

import java.util.ArrayList;

/**
 *
 * @author Edgar Moya
 */
public class DestinoDesglose {
    
    private String destino;
    private ArrayList<Double> importes;
    
    public DestinoDesglose() {
    }

    public DestinoDesglose(String destino, ArrayList<Double> importes) {
        this.destino = destino;
        this.importes = importes;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public ArrayList<Double> getImportes() {
        return importes;
    }

    public void setImportes(ArrayList<Double> importes) {
        this.importes = importes;
    } 
    
    public double importeTotal(){
        double importeTotal = 0.0;
        for (int i = 0; i < importes.size(); i++) {
            importeTotal += importes.get(i);
        }
        return importeTotal;
    }

    @Override
    public String toString() {
        return "DestinoDesglose{" + "destino=" + destino + ", importes=" + importes + '}';
    }
    
}
