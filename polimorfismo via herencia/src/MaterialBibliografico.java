import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    private List<MaterialBibliografico> materiales;

    public Biblioteca() {
        this.materiales = new ArrayList<>();
    }

    public void agregarMaterial() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del material bibliográfico:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la editorial del material bibliográfico:");
        String editorial = scanner.nextLine();

        System.out.println("Ingrese el año de publicación del material bibliográfico:");
        int añoPublicacion = Integer.parseInt(scanner.nextLine());

        System.out.println("Ingrese el tipo de material bibliográfico:");
        String tipo = scanner.nextLine();

        System.out.println("Ingrese el autor del material bibliográfico:");
        String autor = scanner.nextLine();

        MaterialBibliografico material = new MaterialBibliografico(nombre, editorial, añoPublicacion, tipo, autor);

        this.materiales.add(material);
    }

    public void generarReferenciasBibliograficas() {
        for (MaterialBibliografico material : this.materiales) {
            System.out.println(material.generarReferenciaBibliografica());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca();

        biblioteca.agregarMaterial();
        biblioteca.agregarMaterial();
        biblioteca.agregarMaterial();

        biblioteca.generarReferenciasBibliograficas();
    }

}

class MaterialBibliografico {

    private String nombre;
    private String editorial;
    private int añoPublicacion;
    private String genero;
    private String autor;
    private String tipo;

    public MaterialBibliografico(String nombre, String editorial, int añoPublicacion, String genero, String autor, String tipo) {
        this.nombre = nombre;
        this.editorial = editorial;
        this.añoPublicacion = añoPublicacion;
        this.genero = genero;
        this.autor = autor;
        this.tipo = tipo;
    }

    public String generarReferenciaBibliografica() {
        switch (this.tipo) {
            case "libro":
                return this.autor + ". " + this.añoPublicacion + ". " + this.nombre + ". " + this.editorial;
            case "DVD":
                return this.autor + ". (Director). " + this.añoPublicacion + ". " + this.nombre + ". [Formato]. " + this.paisOrigen + ": " + this.estudio;
            case "artículo científico":
                return this.autor + ". " + this.añoPublicacion + ". " + this.nombre + ". " + this.revista + ", " + this.volumen + "(" + this.numero + "), " + this.paginas;
            case "periódico":
                return this.autor + ". " + this.año + ", " + this.mes + " " + this.dia + ". " + this.nombre + ". " + this.paginas;
            case "tesis":
                return this.autor + ". " + this.añoPublicacion + ". " + this.nombre + ". (Tesis doctoral o Tesis de maestría). " + this.institucion;
            default:
                return null;
        }
    }

}
