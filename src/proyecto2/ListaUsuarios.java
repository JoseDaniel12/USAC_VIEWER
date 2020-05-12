package proyecto2;

public class ListaUsuarios extends EstructuraDeDatos {
    private NodoUsuario cabeza;
    public void ListaUsuarios(){
        cabeza = null;
        index = 0;
    }    
    
    
    // imprime en consola en una linea todos los nombres de los usuarios
    public void listarNombres() {
        NodoUsuario aux = cabeza;
        if (index > 0) {
           for (int i = 0; i < index; i++) {
                System.out.print(aux.getValue().nombre + " -> ");
                aux = aux.getNext();
           }        
        }
        System.out.print("\n");
    }
    
    @Override // agrega un usuario, reciviendo como parametro el usuario
    public void add(Object e) {
        Usuario valor = (Usuario)(e);
        NodoUsuario newNodo = new NodoUsuario();
        newNodo.setValue(valor);
        if (find(valor.nombre) == null) {
            if (getSize() == 0) {
                cabeza = newNodo;
            } else{
                NodoUsuario copia = cabeza;
                while(copia.getNext() != null){
                    copia = copia.getNext();
                }
                copia.setNext(newNodo);
            }
            index++;
        }
    }

    @Override // retorana el usuario que tenga el nombre que se recibe como parametro
    public Object find(Object userName) {   
        NodoUsuario aux = cabeza;
        if (index > 0) {
           for (int i = 0; i < index; i++) {
               if (aux.getValue().nombre.equals(userName.toString())) {
                   return aux.getValue();
               }
               aux = aux.getNext();
           }        
        }  
        return null;
    }

    @Override // retorna el tamño de la lista
    public int getSize() {
        return index;
    }

    @Override
    public Object peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(int i) {
        NodoUsuario aux = cabeza;
        if (i >= 0 && i < index) {
            for (int c = 0; c < i; c++) {
                aux = aux.getNext();
            } 
            return aux.getValue();
        }  
        return null;         
    }

    @Override
    public Object pop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
