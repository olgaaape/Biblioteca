package libros;

/**
 * Lista de libro de una biblioteca
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaLibros
{
   
    Libro primero;

    /**
     * Constructor for objects of class ListaNodos
     */
    public ListaLibros()
    {
       
        primero = null;
    }

   
    // Completar los metodos
    
    // Incluye un nuevo libro en la lista
    public void pon( Libro valor){
    
        valor.siguiente = primero;
        primero = valor;
    	
        
    }
    
    public boolean estaVacia(){
       return ( primero == null );    
        
    }
    
    // Devuelve un libro que es eliminado de la lista o null si no exite
    public Libro quitar ( int id ) {
    	    Libro aux = null;
    	
            if ( estaVacia() ) return null;
            if (primero.id==id){
            	aux = primero;
            	primero = primero.siguiente; 
            	return aux;
                
            }
            
            Libro paux1 = primero;
            Libro paux2 = primero.siguiente;
            while ( paux2 != null){
                if ( paux2.id==id){
                   // Lo salto
                   paux1.siguiente = paux2.siguiente;
                   aux= paux2;
                   break;
                }
                paux1 = paux2;
                paux2 = paux2.siguiente;
            }
            
            return aux;
        }
  
       
  
    // Devuelve el id del libro o -1 si no esta
    public int buscarId ( String titulo ){
    	int aux = -1;
        if ( estaVacia() ) return aux;
        if (primero.titulo.equals(titulo)){
        	aux =  primero.id;
        	return aux;
            
        }
        
        Libro paux1 = primero;
        while ( paux1 != null){
            if (paux1.titulo.equals(titulo)){
            	aux = paux1.id;
               break;
            }
            paux1 = paux1.siguiente;
        }
        
        return aux;
   }
    // Muestra los libros almacenados
    public void verCatalogo (){
    	 int numNodos = 0;
         Libro aux = primero;
         System.out.println("------------------------");
         while ( aux != null ){
             numNodos++;
             System.out.println( numNodos + " : " + aux.toString());
             aux = aux.siguiente;
         }
         System.out.println("------------------------");
    }
         
    

}