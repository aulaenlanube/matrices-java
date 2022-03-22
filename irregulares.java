public class irregulares {
       //constantes
    public static final int ESTILO_1 = 1;
    public static final int ESTILO_2 = 2;
    public static final int ESTILO_3 = 3;
    public static final int ESTILO_4 = 4;
    

    public static void main(String[] args) {
 
        int[][] M = {{1,3,3},{9}}; mostrar_matriz(M, "matriz - m", ESTILO_2);
        int[][] N = {{1,3},{1,4},{7,3},{1,1,1,4}}; mostrar_matriz(N, "matriz - n", ESTILO_3);                
        int[][] K = suma(M, N); mostrar_matriz(K, "matriz - suma", ESTILO_4);      
        int[][] R = mayores(M, N); mostrar_matriz(R, "matriz con mayores", ESTILO_1);     
    }
    
    //creamos una matriz irregular a partir de 2 matrices irregulares
    public static int[][] crear_matriz(int[][] a, int[][]b)
    {
        int filas = (a.length > b.length) ? a.length : b.length;
        int[][] s = new int[filas][];

        //asignamos la cantidad de columnas a cada fila
        for(int i = 0; i < filas; i++)
        {
            //CASO 3 -- a tiene mas filas que b
            if(a.length > b.length)
            {
                //si en B no existe la fila
                if(i >= b.length){
                    int columnas = a[i].length;
                    s[i] = new int[columnas];  
                }
                //si en A y B existe la fila
                else{
                    int columnas = (a[i].length > b[i].length) ? a[i].length : b[i].length;             
                    s[i] = new int[columnas];
                }                
            }
            //CASOS 1 y 2 --- b tiene mas filas o son iguales
            else
            {
                //si en A no existe la fila
                if(i >= a.length){
                    int columnas = b[i].length;
                    s[i] = new int[columnas];  
                }
                //si en A y B existe la fila
                else{
                    int columnas = (a[i].length > b[i].length) ? a[i].length : b[i].length;             
                    s[i] = new int[columnas];
                }
            }
        }
        return s;
    }
  
    //obtenemos el mayor de cada posición de 2 matrices irregulares
    public static int[][] mayores(int[][] a, int[][] b)
    {       
        //creamos una matriz entre a y b
        int[][] s = crear_matriz(a, b);
        
        //OBTENEMOS EL MAYOR
        for(int i=0; i < s.length; i++)
            for(int j=0; j < s[i].length; j++)
            {
                //CASO 3 -- a tiene mas filas que b
                if(a.length > b.length)
                {
                    //si en B no existe la fila
                    if(i >= b.length)  s[i][j] = a[i][j];   
                    //si en A y B existe la fila
                    else{
                        //si en b no existe la columna
                        if(j >= b[i].length)  s[i][j] = a[i][j];                        
                        //si en a no existe la columna
                        else if(j >= a[i].length)  s[i][j] = b[i][j];                        
                        //si en a y b existe la columna
                        else  s[i][j] = (a[i][j] > b[i][j]) ? a[i][j] : b[i][j];                          
                    }                
                }
                //CASOS 1 y 2 --- b tiene mas filas o son iguales
                else
                {
                    //si en A no existe la fila
                    if(i >= a.length)  s[i][j] = b[i][j];
                    //si en A y B existe la fila
                    else
                    {
                        //si en b no existe la columna
                        if(j >= b[i].length)  s[i][j] = a[i][j];                        
                        //si en a no existe la columna
                        else if(j >= a[i].length)  s[i][j] = b[i][j];                        
                        //si en a y b existe la columna
                        else  s[i][j] = (a[i][j] > b[i][j]) ? a[i][j] : b[i][j];                           
                    }
                }
            }
        return s;  
    }
 
    //obtenemos la suma de cada posición de 2 matrices irregulares
    public static int[][] suma(int[][] a, int[][] b)
    {       
        //creamos una matriz entre a y b
        int[][] s = crear_matriz(a, b);
        
        //recorremos la matriz resultante
        for(int i=0; i < s.length; i++)
        {   //analizamos fila a fila
            for(int j=0; j < s[i].length; j++)
            {
                //CASO 3 -- a tiene mas filas que b
                if(a.length > b.length)
                {
                    //si en B no existe la fila, guardamos la fila a
                    if(i >= b.length)  s[i][j] = a[i][j];
                    //si en A y B existe la fila
                    else
                    {
                        //si en b no existe la columna, guardamos la columna a
                        if(j >= b[i].length)  s[i][j] = a[i][j];                     
                        //si en a no existe la columna, guardamos la columna b
                        else if(j >= a[i].length)  s[i][j] = b[i][j];
                        //si en a y b existe la columna, hacemos la suma
                        else  s[i][j] = a[i][j] + b[i][j];  
                    }                
                }
                //CASOS 1 y 2 --- b tiene mas filas o son iguales
                else
                {
                    //si en A no existe la fila, guardamos la fila b
                    if(i >= a.length) s[i][j] = b[i][j];
                    //si en A y B existe la fila
                    else
                    {
                        //si en b no existe la columna, guardamos la columna a
                        if(j >= b[i].length)  s[i][j] = a[i][j];                  
                        //si en a no existe la columna, guardamos la columna b
                        else if(j >= a[i].length)  s[i][j] = b[i][j];
                        //si en a y b existe la columna, hacemos la suma
                        else  s[i][j] =  a[i][j] + b[i][j];                          
                    }
                }
            }
        }
        return s;  
    }
 
    //mostramos la cantidad de celdas de cada fila de una matriz irregular 
    public static void mostrar_filas(int[][] a)
    {        
        for (int i = 0; i < a.length; i++) 
            System.out.println("La fila "+i+" tiene "+a[i].length+" celdas");    
    }

    //obtenemos la cantidad de digitos de un número
    public static int digitos(int n)    
    {
        int cont = 1;
        if(n>9)
        {
            while(n>9)
            {
                n/=10;
                cont++;
            }
        }
        return cont;
    }

    //imprimimos los datos de una matriz irregular en cuadrados de un digito n --> [ n < 10 ]
    public static void mostrar_matriz(int[][] R)
    {
        System.out.println();
        System.out.println();
        System.out.print(" ");
        //mostramos parte de arriba
        for(int i=0; i< R[0].length; i++)
        {
            int extra = digitos(R[0][i]);
            for(int k=0;k<extra;k++)
            {
                System.out.print("_");
            }
            System.out.print("__ ");
        }
        System.out.println();

        //mostramos el resultado
        for(int i=0;i<R.length;i++)
        {
            //pintamos los números
            System.out.print("| ");
            for(int j=0;j<R[i].length;j++)
            {
                System.out.print(R[i][j]+" | ");
            }
            System.out.println();


            //pintamos las líneas de bajo
            int columnas = R[i].length;
            if(i<R.length-1) //si no es la última
            {   
                //obtenemos la parte de más columnas
                columnas = (R[i].length > R[i+1].length) ? R[i].length : R[i+1].length;
            }
            System.out.print(" ");
            for(int j=0; j< columnas; j++)
            {
                System.out.print("___ ");
            }
            System.out.println();
        }
    }

    //imprimimos los datos de una matriz irregular en cuadrados de varios digitos
    public static void mostrar_matriz(int[][] R, String titulo, int estilo)
    {
        //posibles caracteres --> ▀ █ ▄ ▌ ▌▐  ■ ▬ ╔ ╗ ╝ ║ ═ ╗ ╔ ═ ╗ ╚ ═ ╝ ╦ ╩ ■ ▬ ░ ▓ ▒ 

        //caracteres por defecto 
        char caracter1 = '▄';
        char caracter2 = '█';
        char caracter3 = '▀';

        //obtenemos el estilo
        switch(estilo)
        {   
            case ESTILO_1: caracter1 = '▄'; caracter2 = '█'; caracter3 = '▀'; break;
            case ESTILO_2: caracter1 = '█'; caracter2 = '█'; caracter3 = '█'; break;
            case ESTILO_3: caracter1 = '░'; caracter2 = '░'; caracter3 = '░'; break;  
            case ESTILO_4: caracter1 = '▒'; caracter2 = '▒'; caracter3 = '▒'; break;  
        }

        System.out.println();
        System.out.println();          

        //mostramos el titulo
        mostrar_titulo(titulo);

        //imprimimos matriz, fila a fila
        for(int i=0;i<R.length;i++)
        {
            //PARTE ARRIBA FILA
            System.out.print(caracter1);            
            for(int j=0;j<R[i].length;j++)
            {                
                int extra = digitos(R[i][j]);
                for(int k=0;k<extra;k++)
                {
                    System.out.print(caracter1);
                }
                System.out.print(""+caracter1+caracter1+caracter1);                
            }
            System.out.println();    

            //PARTE NUMEROS FILA
            System.out.print(caracter2+" ");
            //pintamos los números de cada fila
            for(int j=0;j<R[i].length;j++)
            {
                System.out.print(R[i][j]+" "+caracter2+" ");                
            }
            System.out.println();  

            //PARTE BAJO FILA
            System.out.print(caracter3);   
            for(int j=0;j<R[i].length;j++)
            {                
                int extra = digitos(R[i][j]);
                for(int k=0;k<extra;k++)
                {
                    System.out.print(caracter3);
                }
                System.out.print(""+caracter3+caracter3+caracter3);
            }
            System.out.println();    
        }
    }
    
    //mostramos un string dentro de un recuadro con línea doble
    public static void mostrar_titulo(String titulo)
    {
        //posibles caracteres --> ╔ ╗ ╚ ╝ ║ ═ ╦ ╩
        
        //caracteres por defecto 
        char caracter1 = '═';
        char caracter2 = '║';
        char caracter3 = '═';

        //imprimimos el titulo
        if(titulo.length() > 0)
        {
            //linea superior
            System.out.print('╔');
            for(int i=0; i<titulo.length()*2+3; i++)
                System.out.print(caracter1);
            System.out.print('╗');

            //centro
            System.out.println();
            System.out.print(caracter2+"  ");
            for(int i=0; i<titulo.length(); i++)
                System.out.print(titulo.toUpperCase().charAt(i)+" ");
            System.out.println(" "+caracter2);

            //linea inferior
            System.out.print('╚');
            for(int i=0; i<titulo.length()*2+3; i++)
                System.out.print(caracter3);
            System.out.print('╝');            
            System.out.println();              
        }   
    }
 
}
