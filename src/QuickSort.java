
public class QuickSort  {

	
    private int[] numbers;
    private int number;

    public void sort(int[] values) {
    	// verificar si hay una matriz vacía o nula
        if (values ==null || values.length==0){
            return;
        }
        this.numbers = values;
        number = values.length;
        quicksort(0, number - 1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
     // Obtener el elemento pivote del centro de la lista
        int pivot = numbers[low + (high-low)/2];

     // Dividir en dos listas
        while (i <= j) {
        	// Si el valor actual de la lista de la izquierda es más pequeño que el pivote
            // elemento luego obtener el siguiente elemento de la lista de la izquierda
            while (numbers[i] < pivot) {
                i++;
            }
         // Si el valor actual de la lista de la derecha es más grande que el pivote
            // elemento luego obtener el siguiente elemento de la lista correcta
            while (numbers[j] > pivot) {
                j--;
            }

         // Si hemos encontrado un valor en la lista de la izquierda que es más grande que
            // el elemento pivote y si hemos encontrado un valor en la lista correcta
            // que es más pequeño que el elemento pivote luego intercambiamos el
            // valores.
            // Cuando terminemos, podemos aumentar i y j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
