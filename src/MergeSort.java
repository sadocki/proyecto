/* Java program for Merge Sort */
class MergeSort
{
	// Combinar dos subcampos de arr [].
    // El primer subarreglo es arr [l..m]
    // Segundo subarreglo es arr [m + 1..r]
    void merge(int arr[], int l, int m, int r)
    {
    	// Encuentrar tamaños de dos subarreglos que se fusionarán
        int n1 = m - l + 1;
        int n2 = r - m;
 
        // Creacion de arreglos temporales */
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        /* Copia de datos a arreglos temporales */
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
 
 
        /* Fusionar los arreglos temporales */
 
     // Índices iniciales del primer y segundo subarreglos
        int i = 0, j = 0;
 
     // Índice inicial de matriz subarrendada fusionada
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copiar los elementos restantes de L [] si los hay */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copie los elementos restantes de R [] si los hay */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
     // Función principal que ordena arr [l..r] usando
    // fusionar ()
    void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
        	// Encuentrar el punto medio
            int m = (l+r)/2;
 
         // Ordenar primero y segundo mitades
            sort(arr, l, m);
            sort(arr , m+1, r);
 
         // Combina las mitades ordenadas
            merge(arr, l, m, r);
        }
    }
 
    /* Una función de utilidad para imprimir una matriz de tamaño n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
 // Método del controlador
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};
 
        System.out.println("Given Array");
        printArray(arr);
 
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length-1);
 
        System.out.println("\nSorted array");
        printArray(arr);
    }
}
