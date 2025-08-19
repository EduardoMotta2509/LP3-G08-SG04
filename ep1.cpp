#include <iostream>
using namespace std;

int SumaArreglo(int arreglo[]){
    int suma=0;
    for (int i=0; i<5; i++){
        suma=suma + arreglo[i];
    }
    return suma;
}
int main(){
    int arreglo[]={1,3,5,7,9};
    cout<<"Suma: "<<SumaArreglo(arreglo);
    return 0;
}
