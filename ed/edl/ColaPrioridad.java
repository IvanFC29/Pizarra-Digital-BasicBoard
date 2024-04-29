package ed.edl;


/**
 * Una Cola de Prioridad es aquella en la que se prioriza los datos
 * Al igual que en la vida real, se le da mayor prioridad en las filas a:
 * Personas Mayores, con alguna discapacidad, mujeres embarazadas, niños, adultos y jovenes
 * @author (Ivan FC) 
 * @version (1.01)
 */
public class ColaPrioridad<T extends Comparable<T>> extends Cola<T>
{
    public ColaPrioridad(){
		super();
	}

	//vacia()---> heredado
	//ver()----> heredado
	//decolar()---> heredado

    public void encolarPrioridad(T dato){
        NodoDE<T> nuevo = new NodoDE(dato);
        if(vacia()){
            frente = nuevo;
        }else{
            if(frente.getDato().compareTo(dato) > 0){
                nuevo.setSig(frente);
                frente = nuevo;
            }else{
                NodoDE<T> ant = null;
                NodoDE<T> ult = frente;
                while(ult != null && ult.getDato().compareTo(dato) <= 0){
                    ant = ult;
                    ult = ult.getSig();
                }
                ant.setSig(nuevo);
                nuevo.setSig(ult);
            }
        }
    }
}