
package lab6p1_tatianagarcia;
import java.util.Scanner; 
import java.util.Random;
/**
 *
 * @author tatig
 */
public class Lab6P1_TatianaGarcia {
    static Scanner leer = new Scanner (System.in);
    static Random aleatorio = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int opcion;
        do 
        {
            System.out.println();
            System.out.println("--> Menu <--");
            System.out.println("1 -> Turing");
            System.out.println("2 -> Constante de Kaprekar");
            System.out.println("3 -> Salida");
            
            System.out.println();
            System.out.println(">> Ingrese una opcion: ");
            opcion = leer.nextInt();
            
            switch (opcion)
            {
                
                case 1: 
                {
                    System.out.println();
                    System.out.println(">> Turing <<");
                    System.out.println();
                    
                    System.out.print("Ingrese el tamaño del arreglo: ");
                    int tam = leer.nextInt();
                    
                    int [] array = lecturaRandom(tam);
                    
                    System.out.print("Arreglo generado: ");
                    imprimir(array);
                    System.out.println("");
                    
                    System.out.print("Ingrese la cadena de instrucciones: ");
                    String cadena = leer.next();
                    
                    String cadenafinal = instrucciones(cadena,array);
                    
                    System.out.print("Cadena generada: " + cadenafinal);
                    
                    System.out.println("");
                    //valor de k
                    break; 
                }
                case 2:
                {
                    System.out.println();
                    System.out.println(">> Turing <<");
                    System.out.println();
                    
                    System.out.print("Ingrese un numero de 4 digitos: ");
                    int num = leer.nextInt();
                    
                    System.out.println("Numero original"+num);
                    
                    
                    System.out.println(Kaprekar(num));
                }
                default: 
                {
                    System.out.println();
                    System.out.println(">> Salida...");
                    break; 
                }
            }
        }while (opcion < 3);
    }//Fin del main
    
    //Metodo para hacer lectura de numeros aleatorios
    public static int[] lecturaRandom (int tam)
    {
        int [] random = new int [tam];
        
        for (int i = 0; i < random.length; i++)
        {
            random[i] = aleatorio.nextInt(10);
        }
        
        return random; 
    }//Fin del metodo 
    
    //imprimir arreglos 
    public static void imprimir(int [] arreglo)
    {
        for (int i = 0; i < arreglo.length; i++)
        {
            System.out.print("["+arreglo[i]+"]");
        }
    }//Fin del metodo
    
    
    //Metodo para 
    public static String instrucciones(String cadena, int[]array)
    {
        String cadenafinal = "";
        int valid = 0, unvalid=0;
        int apuntador = 0; 
        
        if (cadena.length() != array.length)
        {
            System.out.println(">> La longitud de la cadena ingresada no coincide con el limite ingresado");
        }
        else
        {
            for (int i =0; i < cadena.length(); i++)
            {
                char letra = cadena.charAt(i);
                switch (letra)
                {
                    case 'L':
                    case 'R':
                    case 'X':
                    case 'l':
                    case 'r':
                    case 'x':
                        break; 
                        
                    default:
                    {
                        valid++;
                    }
                }
            }
            if (valid == 0)
            {
                for(int i = 0; i < cadena.length(); i++)
                {
                    
                    char letra = cadena.charAt(i);
                    switch (letra)
                    {
                        case 'L':
                        case 'l':
                            apuntador--;
                            
                            break; 
                        case 'R':
                        case 'r':
                            apuntador++;
                            break; 
                        case 'X':
                        case 'x':
                            if(apuntador < cadena.length() && apuntador>=0)
                            {
                                int j = array[apuntador];
                                cadenafinal += j; 
                            }
                            else 
                            {
                                unvalid++;
                            }
                            
                            break; 
                        default:
                            break; 
                    }
                }
            }
            else 
            {
                System.out.println("Letras ingresadas no validas");
            }
            if (unvalid != 0)
            {
                System.out.println("El apuntador sobrepaso los límites del arreglo.");
            }
        }
        
        return cadenafinal;
    }
    
    public static int Kaprekar (int num)
    {
        int Kaprekar = 0; 
        String cadena = Integer.toString(num);
        int con_c = 1; 
        //1er paso validacion de 4 digitos
        if (cadena.length() ==4)
        {
            for (int i = 0; i < cadena.length(); i++)
            {
                char a = cadena.charAt(i);
                if (i < cadena.length()-1)
                {
                    char b = cadena.charAt(i+1);
                    
                    if(a == b)
                    {
                        con_c++;
                    }
                    
                }
                    
            }
            if (con_c < 4)
            {
                int con = 0;
                do 
                {
                    //Se transforma el numero a cadena
                    System.out.print(">> Cadena: ");
                    int [] array = arreglo(num);
                    imprimir(array);
                    
                    //Se ordena la cadena de manera ascendente
                    
                    
                    //Se ordena la cadena de manera descendente
                    
                    //Se transforma ascendente a numeros
                    
                    //Se transforma descendente a numeros 
                    
                    //Se imprime y se resta ascendente y descendente

                    System.out.println("");
                    System.out.println(">> Numero: "+ numero(array));
                    System.out.println("");

                    System.out.println(">> Cadena 2: ");
                    int [] array_asc = ascendente(array);
                    imprimir(array_asc);
                    System.out.println("");

                    System.out.println(">> Cadena 3: ");
                    int [] array_des = descendente(array);
                    imprimir(array_des);
                    
                    con++;
                }while(con < 7 && num != 6174);
                
                    
                
            }
            else 
            {
                System.out.println(">> Los 4 digitos no deben ser iguales");
            }
        }
        else 
        {
            System.out.println("El numero de ser de 4 digitos");
        }
            
        
        
        return Kaprekar; 
    }//Fin del metodo Kaprekar
    
    public static int[]arreglo (int num)
    {
        int [] arreglo = new int [4];
        String cadena = Integer.toString(num);
        for (int i = 0; i < cadena.length(); i++)
        {
            char c = cadena.charAt(i);
            int numero = (int)c-48;
            arreglo[i] = numero; 
        }
        return arreglo; 
    }
    
    public static int numero(int [] arreglo)
    {
        int numero = 0; 
        String cadena = "";
        for (int i = 0; i < arreglo.length; i++)
        {
            cadena += arreglo[i];
        }
        numero = Integer.parseInt(cadena);
        
        return numero; 
    }
    
    
    /*Para ordenar los numeros en este metodo se crea el arreglo ascendente con la longitud de 4
    y se crea un contador para guardar el numero en dicho arreglo con respecto a la posicion que define el contador
    el 1er for ira contado los numeros del 0-9 y la variable h del segundo for ira buscando los numeros en el 1er for en el arreglo
    cuando el numero en el arreglo coincide con el numero del 1er for, este se guarda en la vairable ascendente,
    en la posicion que diga el contador
    */
    public static int [] ascendente(int [] arreglo)
    {
        int [] ascendente = new int [4];
        int con = 0; 
        for (int i = 0; i <= 9; i++)
        {
            for (int h = 0; h < arreglo.length; h++)
            {
                if(i == arreglo[h])
                {
                    ascendente[con]= arreglo[h];
                    con++;
                }
            }
        }
        
        return ascendente; 
    }
    //Este metodo es igual q el de ascendente solo que en el 1er for empieza con 9 y termina en 0, marcando numeros del 9-0
    
    
    public static int [] descendente (int [] arreglo)
    {
        int [] descendente = new int [4];
        int con = 0; 
        for (int i = 9; i >= 0; i--)
        {
            for (int h = 0; h < arreglo.length; h++)
            {
                if(i == arreglo[h])
                {
                    descendente[con]= arreglo[h];
                    con++;
                }
            }
        }
        
        return descendente; 
    }
    
    ////
    
    //Metodo para hacer lectura de numeros ingresados por el usario
    public static int[] lectura(int tam)
    {
        int [] temporal = new int [tam];
        System.out.println("");
        System.out.println("Ingrese los valores de a");
        for (int i = 0; i < temporal.length; i++)
        {
            System.out.print("Numero "+(i+1)+": ");
            temporal[i] = leer.nextInt();
        }
        
        return temporal; 
    }//Fin del metodo 
    
    
    
    
    
}//Fin de clase
