package libros;


/**
 * Test de gestion de la biblioteca
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class Biblioteca
{
   public static void main ( String argv[]){
       
       ListaLibros disponibles = new ListaLibros();
       ListaLibros prestados =   new ListaLibros();
       Scanner sc = new Scanner(System.in);
       
       // Rellenar las listas con valores de prueba
       Libro nuevo = new Libro(19,"El Quijote"," Cervantes", Genero.NOVELA, 2012);
       
       disponibles.pon(nuevo);
       disponibles.pon(new Libro(20,"El Buscón","Quevedo",Genero.NOVELA,1997));
       disponibles.pon(new Libro(21,"Romeo y Julieta","Shakespeare ",Genero.TEATRO,1997));
       disponibles.pon(new Libro(22,"Mio Cid","Anónimo",Genero.POESIA,1989));
   
       prestados.pon( new Libro(30,"Harry Potter I", "J. K. Rowling", Genero.NOVELA,1998));
       prestados.pon( new Libro(34,"Guerra y Paz","León Tolstói",Genero.NOVELA,1975));
       prestados.pon( new Libro(19,"El Decamerón","Giovanni Boccaccio",Genero.CUENTOS,1992));
      
       // Muestro ambas listas
       System.out.println(" Libros Disponibles:");
       disponibles.verCatalogo();
       System.out.println(" Libros Prestados:");
       prestados.verCatalogo();
       
       
       // Pedir datos al usuarios y probar el método prestarLibro
       System.out.println(" Prestamo de libros:");
       System.out.println(" ¿Que libro desea?:");
       String titulo = sc.nextLine();
       int resu = prestarLibro(titulo,prestados,disponibles);
       
       switch ( resu ){
          case  0:  System.out.println("El libro no está en el catalogo");break;
          case -1:  System.out.println("El libro está prestado"); break;
          case  1:  System.out.println("Su pestamo ha sido anotado"); break;
        }
        
        
       // Muestro ambas listas de nuevo
       System.out.println(" Libros Disponibles:");
       disponibles.verCatalogo();
       System.out.println(" Libros Prestados:");
       prestados.verCatalogo();
                
    }
   
   /*   Realiza el prestamos pasado un libro de la lista de libros disponibles a la lista de libros prestados
    * Devuelve:
    *  0 si no existe el libro en niguna de la listas
    *  1 Si puede prestarlo, el libro pasa de ldisponibles a lprestados
    * -1 Si ya esta prestado.
    */
   public static int prestarLibro ( String titulo, ListaLibros lprestados, ListaLibros ldisponibles){
   
      int idprestado    = lprestados.buscarId(titulo);
      int iddisponible  = ldisponibles.buscarId(titulo);
      
      if ( idprestado == -1 && iddisponible == -1) return 0; // No esta en catalogo
      if ( idprestado !=  -1)  return -1; // Esta prestado
      
      Libro libroaPrestar = ldisponibles.quitar(iddisponible);
      lprestados.pon(libroaPrestar);
      return 1;
    }
      
 } 